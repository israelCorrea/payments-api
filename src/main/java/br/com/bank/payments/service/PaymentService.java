package br.com.bank.payments.service;

import br.com.bank.payments.dto.PaymentRecordDto;
import br.com.bank.payments.entity.Payment;
import br.com.bank.payments.repository.PaymentRepository;
import br.com.bank.payments.type.StatusPayment;
import br.com.bank.payments.type.TipoChavePix;
import br.com.bank.payments.type.TipoRecorrencia;
import br.com.bank.payments.util.CpfValidate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Payment createPayment(PaymentRecordDto paymentRecordDto) throws Exception {
        var payment = new Payment();
        BeanUtils.copyProperties(paymentRecordDto, payment);
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        payment.setDataInclusao(LocalDateTime.now());
        payment.setDataPagamento(LocalDate.parse(paymentRecordDto.dataPagamento(), formatter));
        payment.setStatusPayment(defineStatusPayment(payment.getDataPagamento()));

        if(paymentRecordDto.tipoRecorrencia() != null && !paymentRecordDto.tipoRecorrencia().isBlank() &&
                paymentRecordDto.dataFinalRecorrencia() != null && !paymentRecordDto.dataFinalRecorrencia().isBlank()) {
            payment.setTipoRecorrencia(TipoRecorrencia.parsear(paymentRecordDto.tipoRecorrencia()));
            payment.setDataFinalRecorrencia(LocalDate.parse(paymentRecordDto.dataFinalRecorrencia(), formatter));
        }

        payment.setDestinoTipoChavePix(defineTipoChavePix(payment.getDestinoChavePix()));
        payment.setObservacaoPagamento(defineObservacaoPagamento(payment));

        return paymentRepository.save(payment);
    }

    public void deleteLogicPayment(Payment payment) {
        payment.setStatusPayment(StatusPayment.CANCELADO);
        paymentRepository.save(payment);
    }

    private StatusPayment defineStatusPayment(LocalDate dataPagamento) throws Exception {
        if (dataPagamento.equals(LocalDate.now())){
            return StatusPayment.EFETUADO;
        }
        else if(dataPagamento.isAfter(LocalDate.now())) {
            return StatusPayment.AGENDADO;
        }
        else {
            throw new Exception("A data do pagamento não é valida");
        }
    }

    private TipoChavePix defineTipoChavePix(String chavePix) throws Exception {
        if(chavePix.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){
            return TipoChavePix.EMAIL;
        }
        else if (chavePix.matches("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")){
            return TipoChavePix.CHAVE_ALEATORIA;
        }
        else if(CpfValidate.isValidCPF(chavePix)){
            return TipoChavePix.CPF;
        }
        else{
            throw new Exception("A chave PIX é inválida");
        }
    }

    private String defineObservacaoPagamento(Payment payment) {
        if(paymentRepository.existsByDataPagamentoAndValorPagamentoAndDestinoChavePix(payment.getDataPagamento(), payment.getValorPagamento(), payment.getDestinoChavePix())){
            return "Já existe um pagamento para data " + payment.getDataPagamento() + " com valor R$" + payment.getValorPagamento() + " para a chave PIX " + payment.getDestinoChavePix() + ".";
        }
        return null;
    }
}
