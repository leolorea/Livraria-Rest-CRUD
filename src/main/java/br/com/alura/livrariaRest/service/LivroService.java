package br.com.alura.livrariaRest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.model.Livro;

@Service
public class LivroService {

	private List<Livro> listaLivros = new ArrayList<>();
	ModelMapper modelMapper = new ModelMapper();

	public List<LivroDto> listarLivros() {

		return listaLivros.stream().map(t -> modelMapper.map(t, LivroDto.class)).collect(Collectors.toList());
	}

	public void cadastarLivro(LivroFormDto dto) {
		Livro livro = modelMapper.map(dto, Livro.class);
		listaLivros.add(livro);
	}

}
