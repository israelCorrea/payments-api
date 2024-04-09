package br.com.bank.payments.repository;

import br.com.bank.payments.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
    boolean existsByDataPagamentoAndValorPagamentoAndDestinoChavePix(LocalDate dataPagamento, BigDecimal valorPagamento, String destinoChavePix);
}
