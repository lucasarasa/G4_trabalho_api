package br.com.trabalhofinal.grupoquatro.security.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import br.com.trabalhofinal.grupoquatro.security.dto.ClienteRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Aeroporto;
import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;
import br.com.trabalhofinal.grupoquatro.security.entities.Pedido;
import br.com.trabalhofinal.grupoquatro.security.entities.Produto;
import br.com.trabalhofinal.grupoquatro.security.repositories.AeroportoRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.ClienteRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.PedidoRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.ProdutoRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailService {

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	AeroportoRepository aeroportoRepository;

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	public JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String emailRemetente;

	@Value("${spring.mail.host}")
	private String emailServerHost;

	@Value("${spring.mail.port}")
	private Integer emailServerPort;

	@Value("${spring.mail.password}")
	private String emailPassword;

	public JavaMailSender javaMailSender() {

		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

		mailSender.setUsername(emailRemetente);
		mailSender.setHost(emailServerHost);
		mailSender.setPort(emailServerPort);
		mailSender.setPassword(emailPassword);

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		return mailSender;
	}

	public String mailWriterCliente(ClienteRequestDTO clienteDTO) {

		Optional<Aeroporto> aeroporto = aeroportoRepository.findById(1);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Cadastro realizado.");
			helper.setTo(clienteDTO.getEmail());
			message.setFrom("apirestgrupo4@gmail.com");

			String emailText = "<h1>Bem-vindo(a), " + clienteDTO.getNome() + "!</h1>"
					+ "<p>É um grande prazer tê-lo(a) como cliente em nosso Aeroporto.</p>"
					+ "<p>Estamos prontos para oferecer o melhor atendimento e garantir que você tenha uma excelente experiência conosco.</p>"
					+ "<p>Se precisar de qualquer suporte, nossa equipe estará sempre à disposição para ajudar.</p>"
					+ "<p>Este e-mail foi enviado em: " + dateTime.format(dateForm) + "</p>" + "<br>"
					+ "<p>Atenciosamente,</p>" + "<p><strong>Equipe " + aeroporto.get().getNome() + "</strong></p>"
					+ "<p><i>Aguardamos sua visita em breve!</i></p>";

			helper.setText(emailText, true);
			javaMailSender.send(message);
			return "Email enviado com sucesso";
		} catch (MessagingException e) {
			return "Erro ao enviar o email" + e.getMessage();
		}
	}

	public String mailWriterPedido(PedidoRequestDTO pedidoDto) {

		Optional<Cliente> cliente = clienteRepository.findById(pedidoDto.getIdCliente());
		Optional<Aeroporto> aeroporto = aeroportoRepository.findById(1);
		PedidoResponseDTO pedido = new PedidoResponseDTO();

		Set<String> nomesProdutos = new HashSet<>();
		Set<Produto> produtos = produtoRepository.retornaLista(pedidoDto.getIdProduto());
		for (Produto prod : produtos) {
			nomesProdutos.add(prod.getNome());
		}

		Double valorTotal = produtos.stream().mapToDouble(Produto::getPreco).sum();

		pedido.setValorTotal(valorTotal);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Pedido " + pedidoDto.getNumero());
			helper.setTo(cliente.get().getFkUser().getEmail());
			message.setFrom("apirestgrupo4@gmail.com");

			String emailText = "<h1>Olá, " + cliente.get().getNome() + "!</h1>"
					+ "<p>Seu pedido foi realizado.</p>"
					+ "<p><strong>Detalhes da sua compra:</strong></p>" + "<ul>"
					+ "<li><strong>Data do pedido:</strong> " + dateTime.format(dateForm) + "</li>"
					+ "<li><strong>Produto(s):</strong> " + nomesProdutos + "</li>"
					+ "<li><strong>Valor Total:</strong> R$" + valorTotal + "</li>" 
					+ "<li><strong>Status:</strong> " + "Em processamento." + "</li>" + "</ul>"
					+ "<p>Se precisar de qualquer suporte, nossa equipe está disponível para ajudá-lo(a) com o que precisar.</p>"
					+ "<br>" + "<p>Atenciosamente,</p>" + "<p><strong>Equipe " + aeroporto.get().getNome()
					+ "</strong></p>" + "<p><i>Desejamos uma ótima viagem!</i></p>";

			helper.setText(emailText, true);
			javaMailSender.send(message);
			return "Email enviado com sucesso";
		} catch (MessagingException e) {
			return "Erro ao enviar o email" + e.getMessage();
		}
	}
	
	public String mailWriterAtualizacaoStatus(Integer id) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		Optional<Cliente> cliente = clienteRepository.findById(pedido.get().getFkCliente().getId());
		Optional<Aeroporto> aeroporto = aeroportoRepository.findById(1);

		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateForm = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setSubject("Seu pedido " + pedido.get().getNumero() + " mudou!");
			helper.setTo(cliente.get().getFkUser().getEmail());
			message.setFrom("apirestgrupo4@gmail.com");

			String emailText = "<h1>Olá, " + cliente.get().getNome() + "!</h1>"
					+ "<p>O status do seu pedido mudou!</p>"
					+ "<li><strong>Data da atualização:</strong> " + dateTime.format(dateForm) + "</li>"
					+ "<li><strong>Status:</strong> " + pedido.get().getStatus() + "</li>" + "</ul>"
					+ "<p>Se precisar de qualquer suporte, nossa equipe está disponível para ajudá-lo(a) com o que precisar.</p>"
					+ "<br>" + "<p>Atenciosamente,</p>" + "<p><strong>Equipe " + aeroporto.get().getNome();

			helper.setText(emailText, true);
			javaMailSender.send(message);
			return "Email enviado com sucesso";
		} catch (MessagingException e) {
			return "Erro ao enviar o email" + e.getMessage();
		}
	}
}