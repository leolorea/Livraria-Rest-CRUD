package br.com.alura.livrariaRest.dto;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioFormDto {

	
	@NotNull
	@NotBlank
	private String login;
	
	@NotNull
	@NotBlank
	private String nome;
	
	@NotNull
	@NotBlank
	private String senha;
	
	@NotNull
	private Long perfilId;
	
	@NotBlank
	@Email
	private String email;
}
