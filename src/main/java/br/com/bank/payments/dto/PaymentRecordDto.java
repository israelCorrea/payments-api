package br.com.bank.payments.dto;

import br.com.bank.payments.type.StatusPayment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record PaymentRecordDto(@NotNull String dataPagamento, @NotBlank String destinoChavePix, @NotNull BigDecimal valorPagamento, String descricaoPagamento, String tipoRecorrencia, String dataFinalRecorrencia) {
}
