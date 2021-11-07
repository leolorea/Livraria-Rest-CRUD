package br.com.alura.livrariaRest.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class LoginFormDto {
	
    @NotBlank
    private String login;
    @NotBlank
    private  String senha;

}
