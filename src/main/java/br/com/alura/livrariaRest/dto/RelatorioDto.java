package br.com.alura.livrariaRest.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RelatorioDto {
	
	private String autor;
	private Long quantidadeLivros;
	private Double percentual;
	

}
