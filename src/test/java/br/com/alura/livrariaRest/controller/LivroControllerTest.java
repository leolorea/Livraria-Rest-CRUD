package br.com.alura.livrariaRest.controller;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.alura.livrariaRest.infra.security.TokenService;
import br.com.alura.livrariaRest.repository.PerfilRepository;
import br.com.alura.livrariaRest.repository.UsuarioRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class LivroControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	private String token="eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIn0.UsI42wW3JmcUccgupIf3PL1I0UpaSpNrJllf6Oz1r0c";
	

	@Test
	void naoDeveriaCadastrarLivroComDadosIncompletos() throws Exception {
		String json = "{}";

		mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON).content(json).header("Authorization", token))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void deveriaCadastrarAutorComDadosCompletos() throws Exception {
		
		
		String jsonAutor = "{\"nome\" : \"George Raymond Richard Martin\", \"email\" : \"george@gmail.com\", \"dataNascimento\" : \"2000-01-01\" , \"miniCurriculo\" : \"George Raymond Richard Martin, nascido George Raymond Martin e mais conhecido como George R. R. Martin ou simplesmente GRRM, é um roteirista e escritor de ficção científica, terror e fantasia norte-americano. É mais conhecido por escrever a série de livros de fantasia épica As Crônicas de Gelo e Fogo.\" }";

		String jsonLivro = "{\"titulo\":\"GameOfThrones\",\"numeroPaginas\":\"768\",\"dataLancamento\":\"2020-11-10\",\"autor\":{\"id\":\"1\"}}";
		
		mvc.perform(MockMvcRequestBuilders.post("/autores").contentType(MediaType.APPLICATION_JSON).content(jsonAutor)
				.header("Authorization", token));
		
		
		mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON).content(jsonLivro).header("Authorization", token))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				;
	}
}
