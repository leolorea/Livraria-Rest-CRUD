package br.com.alura.livrariaRest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
class LivroServiceTest {
    
	@Mock
	private LivroRepository repository;
	
	@InjectMocks
	private LivroService service;
	
	@Test
	void deveriaCadastrarLivro() {
		Autor autor = new Autor("leo", "leo@leo", LocalDate.now(), "texxxxxxxxxxxxxxxxxxxxxto");
	 LivroFormDto livro= new LivroFormDto("titulo", LocalDate.now(), new BigDecimal("340"), autor);
	 
	 LivroDto livroDto = service.cadastarLivro(livro);
	 
	 assertEquals(livro.getTitulo(), livroDto.getTitulo());
	 
	 
	 
	 
	}

}
