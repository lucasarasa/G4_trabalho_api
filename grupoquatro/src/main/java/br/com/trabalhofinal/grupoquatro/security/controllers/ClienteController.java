package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.trabalhofinal.grupoquatro.security.dto.ClienteRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ClienteResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.repositories.UserRepository;
import br.com.trabalhofinal.grupoquatro.security.services.ClienteService;
import br.com.trabalhofinal.grupoquatro.security.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ClienteService clienteService;

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
	@GetMapping("/{id}")
	@Operation(summary = "Buscas cliente por id")
	public ClienteResponseDTO buscarCliente(@PathVariable Integer id) {
	return clienteService.buscarPorId(id);
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar-todos")
	@Operation(summary = "Listar todos os clientes")
	public List<ClienteResponseDTO> listarCliente() {
		return clienteService.clienteList();
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar cliente por id")
	public ResponseEntity<String> deletarId(@PathVariable Integer id) {
		boolean resultDelete = clienteService.clienteDelete(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Objeto deletado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Objeto não deletado!");
		}
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
	@PutMapping("/{id}")
	@Operation(summary = "Alterar cliente por id")
	public String atualizarCliente(@PathVariable Integer id,@RequestBody ClienteRequestDTO clienteDto) {
		return clienteService.atualizarCliente(id, clienteDto);
	}
	
	@PostMapping("/cadastrar-cliente")
	@Operation(summary = "Adicionar um novo cliente")
	public ResponseEntity<?> cadastrarCliente(@Valid @RequestPart ClienteRequestDTO cliente, @RequestPart MultipartFile foto) throws IOException {
		if (userRepository.existsByUsername(cliente.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
		}
		if (userRepository.existsByEmail(cliente.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
		}
		clienteService.adicionarCliente(cliente, foto);
		emailService.mailWriterCliente(cliente);
		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
	
	}
	
	
	
}