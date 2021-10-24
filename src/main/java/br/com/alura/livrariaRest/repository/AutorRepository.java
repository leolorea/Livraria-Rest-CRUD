package br.com.alura.livrariaRest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
