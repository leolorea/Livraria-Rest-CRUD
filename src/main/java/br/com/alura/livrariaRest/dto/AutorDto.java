package br.com.alura.livrariaRest.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AutorDto {
	
	private String nome;	
	private LocalDate dataNascimento;
	private String email;
	

}
