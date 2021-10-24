package br.com.alura.livrariaRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.repository.LivroRepository;

@Service
public class RelatorioService {

	@Autowired
	private LivroRepository repository;
	
	public List<RelatorioDto> getRelatorio() {
		return repository.relatorioAutores();

	}

}
