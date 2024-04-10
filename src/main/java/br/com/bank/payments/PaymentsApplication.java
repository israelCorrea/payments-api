package br.com.bank.payments;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Payments API", version = "1.0.0", description = "API desenvolvida para administrar Pagamentos e oferecer recursos para outros sistemas Incluir, Consultar, Atualizar, Atualizar Parcialmente e Deletar os Pagamentos."))
@EnableAsync
public class PaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentsApplication.class, args);
	}

	@Bean
	public Executor taskExecutor(){
		var executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(2);
		executor.setMaxPoolSize(2);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("payments-api-");
		executor.initialize();
		return executor;
	}

}
