package br.com.alura.livrariaRest.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class UsuarioDto {
	
	@JsonIgnore
	private Long id;
	private String nome;
	private String email;
	
	
	

}
