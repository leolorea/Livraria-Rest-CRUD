package br.com.alura.livrariaRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableAsync
@SpringBootApplication
@EnableSwagger2
public class LivrariaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrariaRestApplication.class, args);
	}
}
