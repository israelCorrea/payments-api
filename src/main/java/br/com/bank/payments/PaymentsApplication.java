package br.com.bank.payments;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Payments API", version = "1.0.0", description = "API desenvolvida para administrar Pagamentos e oferecer recursos para outros sistemas Incluir, Consultar, Atualizar, Atualizar Parcialmente e Deletar os Pagamentos."))
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

}
