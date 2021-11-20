package br.com.alura.livrariaRest.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@SpringBootTest
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
