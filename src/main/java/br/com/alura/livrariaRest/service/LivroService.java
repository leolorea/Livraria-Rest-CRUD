package br.com.alura.livrariaRest.service;

import java.net.URI;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.alura.livrariaRest.dto.AtualizacaoAutorFormDto;
import br.com.alura.livrariaRest.dto.AtualizacaoLivroFormDto;
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
	
	public LivroDto listarLivros(Long id) {
		Livro livro = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		LivroDto livroDto = modelMapper.map(livro, LivroDto.class);
		return livroDto;
	}

	@Transactional
	public void deletarLivro(Long id) {
		repository.deleteById(id);
		
	}
	@Transactional
	public LivroDto autalizarLivro( AtualizacaoLivroFormDto dto) {
		Livro livro = repository.getById(dto.getId());
		livro.setDataLancamento(dto.getDataLancamento());
		livro.setNumeroPaginas(dto.getNumeroPaginas());
		livro.setTitulo(dto.getTitulo());
		LivroDto livroDto = modelMapper.map(livro, LivroDto.class);
		return livroDto;
	}

}
