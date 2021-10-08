package br.com.alura.livrariaRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.livrariaRest.dto.RelatorioDto;
import br.com.alura.livrariaRest.service.RelatorioService;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {
	
	@Autowired
	private RelatorioService service;
	
	@GetMapping("/relata")
	public List<RelatorioDto> relatorioLivros(){
		return service.getRelatorio();
	}
	

}
