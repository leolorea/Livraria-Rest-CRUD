package br.com.alura.livrariaRest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.service.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping
	public List<LivroDto> listarLivros (){
		return service.listarLivros();
	}
	
	@PostMapping
	public void cadastarLivros(@RequestBody @Valid LivroFormDto dto) {
		service.cadastarLivro(dto);
		
	}
	

}
