package br.com.alura.livrariaRest.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.model.Livro;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class LivroRepositoryTest {

	@Autowired
	private LivroRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	void deveriaCadastrarAutorComDadosCompletos() {

		Autor autor = new Autor("Matheus", "matheus@gmail.com", LocalDate.of(2000, 12, 12), "autor muito conhecido");
		entityManager.persist(autor);
		Livro livro1 = new Livro("leo", LocalDate.now(), new BigDecimal("390"), autor);
		Livro livro2 = new Livro("rogerio", LocalDate.now(), new BigDecimal("390"), autor);
		Livro livro3 = new Livro("matheus", LocalDate.now(), new BigDecimal("390"), autor);
		entityManager.persist(livro1);
		entityManager.persist(livro2);
		entityManager.persist(livro3);

		List<Livro> livros = repository.findAll();

		Assertions.assertThat(livros)
				.extracting(Livro::getTitulo, Livro::getDataLancamento, Livro::getNumeroPaginas, Livro::getAutor)
				.containsExactlyInAnyOrder(Assertions.tuple("leo", LocalDate.now(), new BigDecimal("390"), autor),
						Assertions.tuple("rogerio", LocalDate.now(), new BigDecimal("390"), autor),
						Assertions.tuple("matheus", LocalDate.now(), new BigDecimal("390"), autor));

	}

}
