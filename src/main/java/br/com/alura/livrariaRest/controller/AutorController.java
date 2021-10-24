package br.com.alura.livrariaRest.controller;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.livrariaRest.dto.AtualizacaoAutorFormDto;
import br.com.alura.livrariaRest.dto.AutorDto;
import br.com.alura.livrariaRest.dto.AutorFormDto;
import br.com.alura.livrariaRest.service.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired
	private AutorService service;
	
	@GetMapping
	public Page<AutorDto> listarAutores(@PageableDefault(size=10) Pageable pageable){
		return service.listarAutores(pageable);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AutorDto> listarAutor(@PathVariable Long id){
		
		AutorDto autorDto = service.listarAutor(id);
		return ResponseEntity.ok(autorDto);
	}
	
	
	@PostMapping
	public ResponseEntity<AutorDto> cadastrarAutor(@RequestBody @Valid AutorFormDto dto, UriComponentsBuilder uriBuilder) {
		AutorDto autorDto = service.cadastrarAutor(dto);
		URI uri = uriBuilder.path("/autores/{id}").buildAndExpand(autorDto.getId()).toUri();
		return ResponseEntity.created(uri).body(autorDto);
		
	}
	
	@PutMapping
	public ResponseEntity<AutorDto> autalizarAutor(@RequestBody @Valid AtualizacaoAutorFormDto dto) {
		AutorDto autorDto = service.atualizarAutor(dto);
				
		return ResponseEntity.ok(autorDto);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deletarAutor(@PathVariable Long id) {
		
		service.deletarAutor(id);
				
		return ResponseEntity.noContent().build();
		
	}
}
