package br.com.alura.livrariaRest.service;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.model.Livro;
import br.com.alura.livrariaRest.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	ModelMapper modelMapper = new ModelMapper();

	public Page<LivroDto> listarLivros(Pageable pageable) {
		 Page<Livro> livros = repository .findAll(pageable);

		return livros.map(t -> modelMapper.map(t, LivroDto.class));
	}
	
	@Transactional
	public LivroDto cadastarLivro(LivroFormDto dto) {
		Livro livro = modelMapper.map(dto, Livro.class);
		livro.setId(null);
		Livro livroSalvo = repository.save(livro);
		
	
		return modelMapper.map(livroSalvo, LivroDto.class);
	}

}
