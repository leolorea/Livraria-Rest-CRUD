package br.com.alura.livrariaRest.controller;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaRest.dto.UsuarioDto;
import br.com.alura.livrariaRest.dto.UsuarioFormDto;
import br.com.alura.livrariaRest.repository.PerfilRespository;
import br.com.alura.livrariaRest.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	

	@GetMapping("/usuarios")
	public Page<UsuarioDto> listarUsuarios(@PageableDefault(size=10) Pageable pageable) {
		return service.listarUsuarios(pageable);

	}

	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDto> listarUsuario(@PathVariable Long id) {
		UsuarioDto dto = service.listarUsuarios(id);
		return ResponseEntity.ok(dto);

	}

	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDto> cadastarUsuario(@RequestBody @Valid UsuarioFormDto usuario) {
		UsuarioDto dto = service.cadastrarUsuario(usuario);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDto> deletarUsuario(@PathVariable Long id){
		UsuarioDto dto = service.deletarUsuario(id);
		return ResponseEntity.ok(dto);
		
		
	}
}
