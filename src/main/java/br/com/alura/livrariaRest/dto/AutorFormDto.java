package br.com.alura.livrariaRest.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AutorFormDto {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	private String email;
	
	@PastOrPresent
	@NotNull
	private LocalDate dataNascimento;
	
	@JsonAlias("autor_id")
	private Long autorId;
	
	@NotBlank
	private String miniCurriculo;

}
