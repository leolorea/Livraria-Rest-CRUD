package br.com.alura.livrariaRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.model.Autor;

@Service
public class AutorService {

	List<Autor> listaAutores = new ArrayList<>();
	ModelMapper modelMapper = new ModelMapper();

	public List<AutorDto> listarAutores() {

		return listaAutores.stream().map(t -> modelMapper.map(t, AutorDto.class)).collect(Collectors.toList());

	}

	public void cadastrarAutor(AutorFormDto dto) {
		Autor autor = modelMapper.map(dto, Autor.class);
		listaAutores.add(autor);

	}
}
