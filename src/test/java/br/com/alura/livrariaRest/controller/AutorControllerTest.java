package br.com.alura.livrariaRest.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
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

	@Autowired
	private MockMvc mvc;
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private String token;
	
	
	 @BeforeEach
	    public void gerarToken(){
	        Usuario logado = new Usuario("leolgomes", "123456", "leo");
	        Perfil admin = perfilRepository.findById(1l).get();
	        logado.adicionarPerfil(admin);
	        usuarioRepository.save(logado);
	        Authentication authentication = new UsernamePasswordAuthenticationToken(logado, logado.getLogin());
	        this.token = tokenService.gerarToken(authentication);
	    }
	
	@Test
	void naoDeveriaCadastrarAutorComDadosIncompletos() throws Exception {
		String json = "{}";

		
		mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("Authorization", token))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void deveriaCadastrarAutorComDadosIncompletos() throws Exception {
		String json = "{\"nome\" : \"George Raymond Richard Martin\", \"email\" : \"george@gmail.com\", \"dataNascimento\" : \"2000-01-01\" , \"miniCurriculo\" : \"George Raymond Richard Martin, nascido George Raymond Martin e mais conhecido como George R. R. Martin ou simplesmente GRRM, é um roteirista e escritor de ficção científica, terror e fantasia norte-americano. É mais conhecido por escrever a série de livros de fantasia épica As Crônicas de Gelo e Fogo.\" }";

		mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("Authorization", token))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				;
				
	}

}
