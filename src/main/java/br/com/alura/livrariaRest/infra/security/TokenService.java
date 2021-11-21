package br.com.alura.livrariaRest.infra.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.livrariaRest.model.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
    @Value("${jjwt.secret}")
    private String secret;

	public static String gerarToken(Authentication authentication) {
		
		Usuario logado = (Usuario) authentication.getPrincipal();
		
		  return Jwts
	                .builder()
	                .setSubject(logado.getId().toString())
	                .signWith(SignatureAlgorithm.HS256, "8gzsbrpGK4AdPFamQkfdhym4bLLzMv7dXAxQXVdRmLrpQs9HX8yt4LmkY5nvYHVngZnFbVpZ5hWbxmMfXGZUZ3zdAYf7DrtEcwJmXcyuBKjbBabG9qsKYdXWJdXaYWDGJpE9Jj49HZpERzL2FE2j9nbq3vcmZ4xNr4jyUEMexT2ymx93MsYuv8W5FmQNPykEdU3Y58LMwSGcG6ve2FS8bttYSWAtX7PXLxuaH6d9g2VK3SSSWjXR3zfQQn5yySZ5")
	                .compact();
	}
	public boolean isValid(String token) {
		
		try {
			Jwts
			.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token);
		return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public Long extrairIdUsuario(String token) {
	
	Claims claims = Jwts
			.parser()
			.setSigningKey(secret)
			.parseClaimsJws(token)
			.getBody();
		
		return Long.parseLong(claims.getSubject());
	}
	
	
}
