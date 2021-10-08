package br.com.alura.livrariaRest.service;

import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.repository.AutorRepository;

@Service
public class AutorService {
	
	@Autowired
	AutorRepository repository;
	ModelMapper modelMapper = new ModelMapper();
	

	public Page<AutorDto> listarAutores(Pageable pageable) {
		Page<Autor> autores = repository.findAll(pageable);
		return autores.map(t -> modelMapper.map(t, AutorDto.class));

	}
	
	@Transactional
	public AutorDto cadastrarAutor(AutorFormDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		Autor autorSalvado = repository.save(autor);
		return modelMapper.map(autorSalvado, AutorDto.class);

	}
}
