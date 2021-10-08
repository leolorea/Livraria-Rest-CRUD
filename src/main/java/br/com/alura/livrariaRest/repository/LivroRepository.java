package br.com.alura.livrariaRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{
	
	
	@Query("select new br.com.alura.livrariaRest.dto.RelatorioDto (l.titulo , l.titulo, l.titulo) from Livro l")
	List<RelatorioDto> relatorioAutores();
	

}
