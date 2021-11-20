package br.com.alura.livrariaRest.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ExtendWith(MockitoExtension.class)
@ActiveProfiles("test")
@SpringBootTest
class LivroServiceTest {

	/*@Mock
	private LivroRepository repository;

	@InjectMocks
	private LivroService service;

	@Test
	void deveriaCadastrarLivro() {
		Autor autor = new Autor("leo", "leo@leo", LocalDate.now(), "texxxxxxxxxxxxxxxxxxxxxto");
		LivroFormDto livro = new LivroFormDto("titulo", LocalDate.now(), new BigDecimal("340"), autor);

		LivroDto livroDto = service.cadastarLivro(livro);

		assertEquals(livro.getTitulo(), livroDto.getTitulo());

	}*/

}
