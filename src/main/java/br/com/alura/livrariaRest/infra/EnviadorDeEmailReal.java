package br.com.alura.livrariaRest.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class EnviadorDeEmailReal implements EnviadorDeEmail {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	@Async
	public void enviarEmail(String destinatario, String assunto, String mensagem) {
		
		System.out.println("ENVIANDO EMAIL");
		System.out.println("PARA " + destinatario);
		System.out.println("ASSUNTO" + assunto);
		System.out.println("MENSAGEM" + mensagem);
	}
}
