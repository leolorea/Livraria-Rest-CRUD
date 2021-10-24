package br.com.alura.livrariaRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Erro404Dto {
	
	private String mensagem;
	private String campo;
	private String path;

}
