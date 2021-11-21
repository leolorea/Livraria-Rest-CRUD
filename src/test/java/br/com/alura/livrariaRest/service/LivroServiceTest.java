package br.com.alura.livrariaRest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.model.Livro;
import br.com.alura.livrariaRest.repository.AutorRepository;
import br.com.alura.livrariaRest.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class LivroServiceTest {

	 @Mock
	    private LivroRepository livroRepository;

	    @Mock
	    private AutorRepository autorRepository;

	    @Mock
	    private ModelMapper modelMapper;

	    @InjectMocks
	    private LivroService service;

	    @Test
	    void deveriaCadastrarUmLivro() {

	        LivroFormDto formDto = criarLivroFormDto();

	        Autor autor = new Autor("teste", "teste", LocalDate.now(), "teste");

	        Livro livro = new Livro(formDto.getTitulo(), formDto.getDataLancamento(),
	                formDto.getNumeroPaginas(), autor);

	        Mockito.when(modelMapper.map(formDto, Livro.class)).thenReturn(livro);


	        Mockito.when(modelMapper.map(livro, LivroDto.class)).thenReturn(new LivroDto(
	                null,
	                livro.getTitulo(),
	                livro.getDataLancamento(),
	                livro.getNumeroPaginas(),
	                livro.getAutor()
	        ));


	        LivroDto dto = service.cadastarLivro(formDto);

	        Mockito.verify(livroRepository).save(Mockito.any());

	        assertEquals(formDto.getTitulo(), dto.getTitulo());
	        assertEquals(formDto.getDataLancamento(), dto.getDataLancamento());
	        assertEquals(formDto.getNumeroPaginas(), dto.getNumeroPaginas());

	    }


	    @Test
	    void naoDeveriaCadastrarUmLivroComAutorInexistente() {

	        LivroFormDto formDto = criarLivroFormDto();

	        Mockito.when(autorRepository.getById(formDto.getAutorId()))
	                .thenThrow(EntityNotFoundException.class);

	        assertThrows(IllegalArgumentException.class, () -> service.cadastarLivro(formDto));

	    }

	    private LivroFormDto criarLivroFormDto() {
	        return new LivroFormDto(
	                "titulolivro",
	                LocalDate.now(),
	                new BigDecimal("150"),
	                1l
	        );
	    }


	}	