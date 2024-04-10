package br.com.bank.payments.entity;

import br.com.bank.payments.type.StatusPayment;
import br.com.bank.payments.type.TipoChavePix;
import br.com.bank.payments.type.TipoRecorrencia;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="tb_payment")
public class Payment extends RepresentationModel<Payment> implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPayment;
    private StatusPayment statusPayment;
    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime dataInclusao;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPagamento;
    private BigDecimal valorPagamento;
    private String descricaoPagamento;
    private String observacaoPagamento;
    private TipoRecorrencia tipoRecorrencia;
    private LocalDate dataFinalRecorrencia;
    private String destinoChavePix;
    private TipoChavePix destinoTipoChavePix;

    public UUID getIdPayment() {
        return idPayment;
    }

    public StatusPayment getStatusPayment() {
        return statusPayment;
    }

    public void setStatusPayment(StatusPayment statusPayment) {
        this.statusPayment = statusPayment;
    }

    public LocalDateTime getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDateTime dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(BigDecimal valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public String getDescricaoPagamento() {
        return descricaoPagamento;
    }

    public void setDescricaoPagamento(String descricaoPagamento) {
        this.descricaoPagamento = descricaoPagamento;
    }

    public String getObservacaoPagamento() {
        return observacaoPagamento;
    }

    public void setObservacaoPagamento(String observacaoPagamento) {
        this.observacaoPagamento = observacaoPagamento;
    }

    public TipoRecorrencia getTipoRecorrencia() {
        return tipoRecorrencia;
    }

    public void setTipoRecorrencia(TipoRecorrencia tipoRecorrencia) {
        this.tipoRecorrencia = tipoRecorrencia;
    }

    public LocalDate getDataFinalRecorrencia() {
        return dataFinalRecorrencia;
    }

    public void setDataFinalRecorrencia(LocalDate dataFinalRecorrencia) {
        this.dataFinalRecorrencia = dataFinalRecorrencia;
    }

    public String getDestinoChavePix() {
        return destinoChavePix;
    }

    public void setDestinoChavePix(String destinoChavePix) {
        this.destinoChavePix = destinoChavePix;
    }

    public TipoChavePix getDestinoTipoChavePix() {
        return destinoTipoChavePix;
    }

    public void setDestinoTipoChavePix(TipoChavePix destinoTipoChavePix) {
        this.destinoTipoChavePix = destinoTipoChavePix;
    }
}
