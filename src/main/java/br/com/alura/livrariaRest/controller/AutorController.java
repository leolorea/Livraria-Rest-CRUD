package br.com.alura.livrariaRest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService service;
	
	@GetMapping
	public List<AutorDto> listarAutores(){
		return service.listarAutores();
	}
	
	
	@PostMapping
	public void cadastrarAutor(@RequestBody @Valid AutorFormDto dto) {
		service.cadastrarAutor(dto);
		
	}

}
