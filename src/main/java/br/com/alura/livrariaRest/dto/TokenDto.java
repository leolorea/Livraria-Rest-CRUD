package br.com.alura.livrariaRest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data


public class TokenDto {
 private String token;
 
 public TokenDto(String token) {
	 this.token = token;
	 
 }
}
