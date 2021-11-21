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

import br.com.alura.livrariaRest.infra.security.TokenService;
import br.com.alura.livrariaRest.model.Perfil;
import br.com.alura.livrariaRest.model.Usuario;
import br.com.alura.livrariaRest.repository.UsuarioRepository;
import br.com.alura.livrariaRest.repository.PerfilRepository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class UsuarioControllerTest {

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
        Usuario logado = new Usuario("leolgomes","123", "leo");
        Perfil admin = perfilRepository.findById(1l).get();
        logado.adicionarPerfil(admin);
        usuarioRepository.save(logado);
        Authentication authentication = new UsernamePasswordAuthenticationToken(logado, logado.getUsername());
        this.token = tokenService.gerarToken(authentication);
    }

    @Test
    void naoDeveriaCadastrarUsuarioComDadosIncompletos() throws Exception {
        String json = "{}";


        mvc
                .perform(
                        post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .header("Authorization", "Bearer " + token))

                .andExpect(status().isBadRequest());

    }

   
    @Test
    void deveriaCadastrarUsuarioComDadosCompletos() throws Exception {
        String json = "{\"nome\":\"leonardo\",\"login\":\"leolgomes\", \"email\":\"leolgomes@gmail.com\", \"senha\":\"123456\", \"perfilId\":1}";
        String jsonEsperado = "{\"nome\":\"leonardo\",\"email\":\"leolgomes@gmail.com\"}";

        
       
        mvc
                .perform(
                        post("/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                                .header("Authorization", "Bearer " + token))

                .andExpect(status().isCreated())
                .andExpect(header().exists("Location"))
                .andExpect(content().json(jsonEsperado));

    }

}