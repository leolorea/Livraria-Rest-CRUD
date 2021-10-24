package br.com.alura.livrariaRest.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Erro500Dto {
	
	private LocalDateTime timestamp;
	private String erro;
	private String mensagem;
	private String path;


}
