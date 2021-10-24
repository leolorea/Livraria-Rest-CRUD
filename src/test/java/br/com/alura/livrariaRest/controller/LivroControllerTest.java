package br.com.alura.livrariaRest.controller;

import javax.transaction.Transactional;

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

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class LivroControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void naoDeveriaCadastrarLivroComDadosIncompletos() throws Exception {
		String json = "{}";

		mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void deveriaCadastrarAutorComDadosIncompletos() throws Exception {
		String json = "{\"titulo\":\"aeeeeeeeeeee\",\"numeroPaginas\":\"768\",\"dataLancamento\":\"2020-11-10\",\"autor\":{\"id\":\"1\",\"nome\":\"leonarodffffffffffff\",\"email\":\"george@gmail.com\",\"dataNascimento\":\"2000-01-01\",\"miniCurriculo\":\"GeorgeRaymondRichardMartin,nascidoGeorgeRaymondMartinemaisconhecidocomoGeorgeR.R.MartinousimplesmenteGRRM,éumroteiristaeescritordeficçãocientífica,terrorefantasianorte-americano.ÉmaisconhecidoporescreverasériedelivrosdefantasiaépicaAsCrônicasdeGeloeFogo.\"}}";

		mvc.perform(MockMvcRequestBuilders.post("/livros").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.header().exists("Location"))
				.andExpect(MockMvcResultMatchers.content().json(json));
	}
}
