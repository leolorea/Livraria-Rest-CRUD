package br.com.alura.livrariaRest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AutorServiceTest {

	@Mock
	private AutorRepository repository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private AutorService service;

	@Test
	void deveriaCadastarAutor() {
		
		AutorFormDto formDto = new AutorFormDto("leo", "leo@gmail.com", LocalDate.now(), "autor muito conhecido");
		
		Autor autor = new Autor(formDto.getNome(), formDto.getEmail(), formDto.getDataNascimento(), formDto.getMiniCurriculo());

	
		Mockito.when(modelMapper.map(formDto, Autor.class)).thenReturn(autor);


        Mockito.when(modelMapper.map(autor, AutorDto.class)).thenReturn(new AutorDto(
                autor.getId(),
                autor.getNome(),
                autor.getDataNascimento(),
                autor.getEmail()
                ));

        AutorDto dto = service.cadastrarAutor(formDto);
        
		Mockito.verify(repository).save(Mockito.any());

		assertEquals(autor.getNome(), dto.getNome());
		assertEquals(autor.getDataNascimento(), dto.getDataNascimento());
		assertEquals(autor.getEmail(), dto.getEmail());

	}

}
