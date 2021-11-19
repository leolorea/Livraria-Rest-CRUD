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

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
class AutorServiceTest {

	/*@Mock
	private AutorRepository repository;

	ModelMapper modelMapper = new ModelMapper();

	@InjectMocks
	private AutorService service;

	@Test
	void deveriaCadastarAutor() {
		AutorFormDto autor = new AutorFormDto("leo", "leo@gmail.com", LocalDate.now(), "autor muito conhecido");

		AutorDto dto = service.cadastrarAutor(autor);

		Mockito.verify(repository).save(Mockito.any());

		assertEquals(autor.getNome(), dto.getNome());
		assertEquals(autor.getDataNascimento(), dto.getDataNascimento());
		assertEquals(autor.getEmail(), dto.getEmail());

	}*/

}
