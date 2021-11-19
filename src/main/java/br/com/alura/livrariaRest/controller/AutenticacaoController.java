package br.com.alura.livrariaRest.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaRest.dto.LoginFormDto;
import br.com.alura.livrariaRest.dto.TokenDto;
import br.com.alura.livrariaRest.infra.security.AutenticacaoService;

@RestController
@RequestMapping("/auth")

public class AutenticacaoController {
	
	
	@Autowired
	private AutenticacaoService service;
	
	@PostMapping
	public TokenDto autenticar(@RequestBody @Valid LoginFormDto dto) {
		return new TokenDto(service.autenticar(dto));
		
	}

}