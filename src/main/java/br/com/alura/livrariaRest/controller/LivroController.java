package br.com.alura.livrariaRest.controller;

import java.net.URI;

import javax.validation.Valid;

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

import br.com.alura.livrariaRest.dto.AtualizacaoLivroFormDto;
import br.com.alura.livrariaRest.dto.LivroDto;
import br.com.alura.livrariaRest.dto.LivroFormDto;
import br.com.alura.livrariaRest.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService service;

	@GetMapping
	public Page<LivroDto> listarLivros(@PageableDefault(size = 10) Pageable pageable) {
		return service.listarLivros(pageable);
	}

	@GetMapping("/{id}")
	public ResponseEntity<LivroDto> listarLivro(@PathVariable Long id) {
		LivroDto livroDto = service.listarLivros(id);
		return ResponseEntity.ok(livroDto);

	}

	@PostMapping
	public ResponseEntity<LivroDto> cadastarLivros(@RequestBody @Valid LivroFormDto dto, UriComponentsBuilder builder) {
		LivroDto livroDto = service.cadastarLivro(dto);

		URI uri = builder.path("/livros/{id}").buildAndExpand(livroDto.getId()).toUri();
		return ResponseEntity.created(uri).body(livroDto);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletarLivro(@PathVariable Long id) {
		service.deletarLivro(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<LivroDto> atualizarLivro(@RequestBody @Valid AtualizacaoLivroFormDto dto) {
		LivroDto livroDto = service.autalizarLivro(dto);
		return ResponseEntity.ok(livroDto);

	}

}
