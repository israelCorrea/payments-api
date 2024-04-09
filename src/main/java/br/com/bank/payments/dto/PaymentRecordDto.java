package br.com.bank.payments.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record PaymentRecordDto(@NotBlank String dataPagamento, @NotBlank String destinoChavePix, @NotNull BigDecimal valorPagamento, String descricaoPagamento, String tipoRecorrencia, String dataFinalRecorrencia) {
}
