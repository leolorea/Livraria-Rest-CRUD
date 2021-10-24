package br.com.alura.livrariaRest.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AutorFormDto {

	public AutorFormDto(String string, String string2, LocalDate now, String string3) {
		// TODO Auto-generated constructor stub
	}

	@NotBlank
	private String nome;

	@NotBlank
	@Email
	private String email;

	@PastOrPresent

	private LocalDate dataNascimento;

	private Long id;

	@NotBlank
	private String miniCurriculo;

}
