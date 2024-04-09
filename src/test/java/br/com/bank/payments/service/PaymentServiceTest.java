package br.com.bank.payments.service;

import br.com.bank.payments.dto.PaymentRecordDto;
import br.com.bank.payments.entity.Payment;
import br.com.bank.payments.repository.PaymentRepository;
import br.com.bank.payments.type.StatusPayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PaymentServiceTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePayment() throws Exception {

        var paymentRecordDto = new PaymentRecordDto("01/05/2024", "email@email.com", new BigDecimal("123.45"), "desc pag", "Mensal", "31/12/2024");
        var payment = new Payment();
        when(paymentRepository.save(any())).thenReturn(payment);
        var createdPayment = paymentService.createPayment(paymentRecordDto);
        assertNotNull(createdPayment);
    }

    @Test
    void testDeleteLogicPayment() {
        var payment = new Payment();
        when(paymentRepository.save(any())).thenReturn(payment);
        paymentService.deleteLogicPayment(payment);
        assertEquals(StatusPayment.CANCELADO, payment.getStatusPayment());
        verify(paymentRepository, times(1)).save(payment);
    }

    @Test
    void testCreatePayment_Efetuado() throws Exception {
        var dataPagamento = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        var paymentRecordDto = new PaymentRecordDto(dataPagamento, "email@email.com", new BigDecimal("123.45"), "desc pag", "Mensal", "31/12/2024");
        Payment payment = new Payment();
        when(paymentRepository.save(any())).thenReturn(payment);
        Payment createdPayment = paymentService.createPayment(paymentRecordDto);
        assertNotNull(createdPayment);
    }

    @Test
    void testCreatePayment_Agendado() throws Exception {

        var paymentRecordDto = new PaymentRecordDto("01/06/2024", "email@email.com", new BigDecimal("123.45"), "desc pag", "Mensal", "31/12/2024");

        var payment = new Payment();
        when(paymentRepository.save(any())).thenReturn(payment);
        var createdPayment = paymentService.createPayment(paymentRecordDto);
        assertNotNull(createdPayment);
    }

    @Test
    void testCreatePayment_DataInvalida_ExceptionThrown() {
        var paymentRecordDto = new PaymentRecordDto("01/04/2024", "email@email.com", new BigDecimal("123.45"), "desc pag", "Mensal", "31/12/2024");
        assertThrows(Exception.class, () -> paymentService.createPayment(paymentRecordDto));
    }

    @Test
    void testCreatePaymentWithRecurrence() throws Exception {

        var paymentRecordDto = new PaymentRecordDto("01/05/2024", "email@email.com", new BigDecimal("123.45"), "desc pag", "Mensal", "31/12/2024");
        var payment = new Payment();
        when(paymentRepository.save(any())).thenReturn(payment);
        var createdPayment = paymentService.createPayment(paymentRecordDto);
        assertNotNull(createdPayment);
    }
}
