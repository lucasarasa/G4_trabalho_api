//package br.com.trabalhofinal.grupoquatro.security.services;
//
//import java.text.DecimalFormat;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.Optional;
//import java.util.Properties;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//
//@Component
//public class EmailService {
//
//	@Autowired
//	public JavaMailSender javaMailSender;
//
//	@Value("${spring.mail.username}")
//	private String emailRemetente;
//
//	@Value("${spring.mail.host}")
//	private String emailServerHost;
//
//	@Value("${spring.mail.port}")
//	private Integer emailServerPort;
//
//	@Value("${spring.mail.password}")
//	private String emailPassword;
//
//	public JavaMailSender javaMailSender() {
//
//		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//
//		mailSender.setUsername(emailRemetente);
//		mailSender.setHost(emailServerHost);
//		mailSender.setPort(emailServerPort);
//		mailSender.setPassword(emailPassword);
//
//		Properties props = mailSender.getJavaMailProperties();
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");
//
//		return mailSender;
//	}
//
//	public String mailWriter(ClienteRequestDTO clienteDTO) {
//
//		LocalDateTime dateTime = LocalDateTime.now();
//		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(clienteDTO.getEmail());
//		message.setSubject("Cadastro");
//		message.setText("Cadastro realizado com sucesso!" + dateTime.format(dateForm));
//		message.setFrom("apirestgrupo4@gmail.com");
//
//		try {
//			javaMailSender.send(message);
//			return "Email enviado com sucesso";
//		} catch (Exception e) {
//			return "Erro ao enviar Email." + e.getMessage();
//		}
//	}
//	
//	public String mailWriterProfessor(Optional<Cliente> cliente) {
//
//		LocalDateTime dateTime = LocalDateTime.now();
//		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(cliente.get().getFkUser().getEmail());
//		message.setSubject("Pedido" + cliente.getFkPedido().getNumero());
//		message.setText("Pedido" + + cliente.getFkPedido().getNumero() + " realizado com sucesso!" + dateTime.format(dateForm));
//		message.setFrom("apirestgrupo4@gmail.com");
//
//		try {
//			javaMailSender.send(message);
//			return "Email enviado com sucesso";
//		} catch (Exception e) {
//			return "Erro ao enviar Email." + e.getMessage();
//		}
//	}
//}