package br.com.alura.livrariaRest.infra.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.livrariaRest.model.Usuario;
import br.com.alura.livrariaRest.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


public class VerificacaoTokenFilter extends OncePerRequestFilter{
	
	private TokenService tokenService;	
	private UsuarioRepository usuarioRepository;

	public VerificacaoTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
		this.tokenService = tokenService;
		this.usuarioRepository = usuarioRepository;
	}
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
	String token = request.getHeader("Authorization");
	
	if (token.isBlank() || token==null) {
		filterChain.doFilter(request, response);
		return;
	} 
	token = token.replace("Bearer ", "");
	
	boolean tokenValido = tokenService.isValid(token);
	
	if (tokenValido) {
		
		Long idUsuario = tokenService.extrairIdUsuario(token); 
		Usuario logado = usuarioRepository.carregarPorIdComPerfis(idUsuario).get();
		Authentication authentication = new UsernamePasswordAuthenticationToken
				(logado, null,  logado.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
	
	filterChain.doFilter(request, response);
	}



}
