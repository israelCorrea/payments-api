package br.com.bank.payments.dto;

import jakarta.validation.constraints.NotBlank;

public record IntegratedSystemsDto(@NotBlank String sigla) {

}
