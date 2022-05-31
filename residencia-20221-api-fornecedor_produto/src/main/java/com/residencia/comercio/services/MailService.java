package com.residencia.comercio.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	JavaMailSender emailSender;

	@Value("${spring.mail.host}")
	private String mailHost;

	@Value("${spring.mail.port}")
	private String mailPort;

	@Value("${spring.mail.username}")
	private String mailUserName;

	@Value("${spring.mail.password}")
	private String mailPassword;

	public MailService(JavaMailSender javaEmailSender) {
		this.emailSender = javaEmailSender;
	}

	public void enviarEmailTexto(String destinatárioEmail, String assunto, String mensagemEmail) {
		SimpleMailMessage sMailMessage = new SimpleMailMessage();

		sMailMessage.setTo(destinatárioEmail);
		sMailMessage.setSubject(assunto);
		sMailMessage.setText(mensagemEmail);

		sMailMessage.setFrom("teste@teste.com");

		emailSender.send(sMailMessage);
	}

	public void enviarEmailHtml(String destinatárioEmail, String assunto, String mensagemEmail) {

		SimpleMailMessage sMailMessage = new SimpleMailMessage();

		sMailMessage.setTo(destinatárioEmail);
		sMailMessage.setSubject(assunto);
		sMailMessage.setText(mensagemEmail);

		sMailMessage.setFrom("teste@teste.com");

		emailSender.send(sMailMessage);

	}
}
