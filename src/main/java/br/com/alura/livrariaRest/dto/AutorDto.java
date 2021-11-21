package br.com.alura.livrariaRest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDto {

	private Long id;
	private String nome;
	private LocalDate dataNascimento;
	private String email;

	
}
