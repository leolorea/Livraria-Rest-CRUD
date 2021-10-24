package br.com.alura.livrariaRest.service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.model.Autor;
import br.com.alura.livrariaRest.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository repository;



	public Page<AutorDto> listarAutores(Pageable pageable) {
		ModelMapper modelMapper = new ModelMapper();
		Page<Autor> autores = repository.findAll(pageable);
		return autores.map(t -> modelMapper.map(t, AutorDto.class));

	}

	@Transactional
	public AutorDto cadastrarAutor(AutorFormDto formDto) {
		ModelMapper modelMapper = new ModelMapper();
		
	
		try {
			
			Autor autor = modelMapper.map(formDto, Autor.class);
			Autor autorSalvado = repository.save(autor);
			return modelMapper.map(autorSalvado,AutorDto.class);
			
			
		} catch (EntityNotFoundException e) {
			throw new IllegalArgumentException("Usuario inexistente");
		}
		

	}

	@Transactional
	public AutorDto atualizarAutor(@Valid AutorFormDto dto) {
		ModelMapper modelMapper = new ModelMapper();
		Autor autor = repository.getById(dto.getId());
		autor.setDataNascimento(dto.getDataNascimento());
		autor.setEmail(dto.getEmail());
		autor.setMiniCurriculo(dto.getMiniCurriculo());
		autor.setNome(dto.getNome());

		return modelMapper.map(autor, AutorDto.class);
	}

	@Transactional
	public void deletarAutor(Long id) {

			repository.deleteById(id);

	}
	
	public AutorDto listarAutor(Long id) {
		ModelMapper modelMapper = new ModelMapper();
		Autor autor = repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
		AutorDto autorListado = modelMapper.map(autor, AutorDto.class);
		return autorListado;
	}
}
