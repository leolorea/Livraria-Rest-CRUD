package br.com.alura.livrariaRest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.livrariaRest.model.Autor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto {

	private Long id;
	private String titulo;
	private LocalDate dataLancamento;
	private BigDecimal numeroPaginas;
	private Autor autor;

	
}
