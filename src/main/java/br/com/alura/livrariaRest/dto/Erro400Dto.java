package br.com.alura.livrariaRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro400Dto {

	private String mensagem;
	private String campo;
}
