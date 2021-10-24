package br.com.alura.livrariaRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query("SELECT new br.com.alura.livrariaRest.dto.RelatorioDto( li.autor.nome, count(li.id), count(li.id)/(SELECT count(liTemp.id) FROM Livro liTemp)*100.0) FROM Livro li GROUP BY li.autor.nome")

	 List<RelatorioDto> relatorioAutores();

}
