package br.com.alura.livrariaRest.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonAlias;

import br.com.alura.livrariaRest.model.Autor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LivroFormDto {
	
	@NotBlank
	@Size(min = 10)
	private String titulo;
	
	@DateTimeFormat
	@PastOrPresent
	@NotNull
	private LocalDate dataLancamento;
	
	@Min(100)
	private BigDecimal numeroPaginas;
	
	@JsonAlias("autor_id")
	private Long autorId;
	


}
