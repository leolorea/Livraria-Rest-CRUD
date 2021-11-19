package br.com.alura.livrariaRest.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.alura.livrariaRest.infra.security.TokenService;
import br.com.alura.livrariaRest.model.Perfil;
import br.com.alura.livrariaRest.model.Usuario;
import br.com.alura.livrariaRest.repository.PerfilRepository;
import br.com.alura.livrariaRest.repository.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class AutorControllerTest {

	/*@Autowired
	private MockMvc mvc;
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Test
	void naoDeveriaCadastrarAutorComDadosIncompletos() throws Exception {
		String json = "{}";

		
		Usuario logado = new Usuario("leo", "123");
		Perfil adim = perfilRepository.findById(1l).get();
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(logado, logado.getUsername());
		String token = tokenService.gerarToken(authentication);
		logado.adicionarPerfil(adim);
		usuarioRepository.save(logado);
		
		mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("Authorization", "Bearer"))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void deveriaCadastrarAutorComDadosIncompletos() throws Exception {
		String json = "{\"nome\" : \"leonarodffffffffffff\", \"email\" : \"leo@leo.com\","
				+ " \"dataNascimento\" : \"2000-12-12\", \"miniCurriculo\" : \"George Raymond Richard Martin, nascido George Raymond Martin e mais\" }";

		mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				.andExpect(MockMvcResultMatchers.content().json(json));
	}*/

}
