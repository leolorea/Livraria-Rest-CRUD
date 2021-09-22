package br.com.alura.livrariaRest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LivroDto {

	private String titulo;
	private LocalDate dataLancamento;
	private BigDecimal numeroPaginas;
	private String autor;

}
