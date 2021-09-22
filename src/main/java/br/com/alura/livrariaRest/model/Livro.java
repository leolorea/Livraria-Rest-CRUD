package br.com.alura.livrariaRest.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class Livro {
	
	private String titulo;
	private LocalDate dataLancamento;
	private BigDecimal numeroPaginas;
	private String autor;

}
