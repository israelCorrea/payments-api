package br.com.bank.payments.repository;

import br.com.bank.payments.entity.Payment;
import br.com.bank.payments.type.StatusPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    boolean existsByDataPagamentoAndValorPagamentoAndDestinoChavePix(LocalDate dataPagamento, BigDecimal valorPagamento, String destinoChavePix);

    List<Payment> findByStatusPayment(StatusPayment statusPayment);
}
