package br.com.alura.livrariaRest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizacaoUsuarioFormDto {

		@NotNull
		private Long id;
		
		@NotNull
		@NotBlank
		private String username;
		
		@NotNull
		@NotBlank
		private String senha;
		
		@NotNull
		private Long perfilId;
		
	}

