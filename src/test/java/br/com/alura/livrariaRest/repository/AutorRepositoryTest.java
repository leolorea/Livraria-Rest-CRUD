package br.com.alura.livrariaRest.repository;

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

import br.com.alura.livrariaRest.model.Autor;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ActiveProfiles("test")
class AutorRepositoryTest {

	@Autowired
	private AutorRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	/*@Test
	void deveriaCadastrarAutorComDadosCompletos() {
		Autor autor1 = new Autor("leo", "leo@gmail.com", LocalDate.of(2000, 12, 12), "autor muito conhecido");
		Autor autor2 = new Autor("rogerio", "rogerio@gmail.com", LocalDate.of(2000, 12, 12), "autor muito conhecido");
		Autor autor3 = new Autor("matheus", "matheus@gmail.com", LocalDate.of(2000, 12, 12), "autor muito conhecido");
		entityManager.persist(autor1);
		entityManager.persist(autor2);
		entityManager.persist(autor3);

		List<Autor> autores = repository.findAll();

		
		Assertions.assertThat(autores).hasSize(3)
				.extracting(Autor::getEmail, Autor::getDataNascimento, Autor::getNome, Autor::getMiniCurriculo)
				.containsExactlyInAnyOrder(
						Assertions.tuple("leo@gmail.com", LocalDate.of(2000, 12, 12), "leo", "autor muito conhecido"),
						Assertions.tuple("rogerio@gmail.com", LocalDate.of(2000, 12, 12), "rogerio","autor muito conhecido"),
						Assertions.tuple("matheus@gmail.com", LocalDate.of(2000, 12, 12), "matheus",
								"autor muito conhecido"));

	}*/

}
