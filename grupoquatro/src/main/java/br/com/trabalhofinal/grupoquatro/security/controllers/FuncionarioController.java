package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseIdDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.SignupRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.repositories.UserRepository;
import br.com.trabalhofinal.grupoquatro.security.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/inserir")
	@Operation(summary = "Adicionar um novo funcionário")
	public ResponseEntity<?> cadastrarFuncionario(@Valid @RequestPart FuncionarioRequestDTO funcionario, @RequestPart MultipartFile foto) throws IOException {
		if (userRepository.existsByUsername(funcionario.getUsername())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
		}
		if (userRepository.existsByEmail(funcionario.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
		}
		funcionarioService.cadastrarFuncionario(funcionario, foto);
		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
//		return funcionarioService.cadastrarFuncionario(funcionario);
	}
	
//	@PostMapping("/signup")
//	public ResponseEntity<?> registerUser(@Valid @RequestPart SignupRequestDTO signUpRequest, @RequestPart MultipartFile foto) throws IOException {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Username já utilizado!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponseDTO("Erro: Email já utilizado!"));
//		}
//		return ResponseEntity.ok(new MessageResponseDTO("Usuário registrado com sucesso!"));
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um funcionário existente")
	public ResponseEntity<FuncionarioResponseDTO> atualizarFuncionario(@PathVariable Integer id,@RequestBody FuncionarioRequestUpdateDTO funcionarioDTO) {
		FuncionarioResponseDTO funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionarioDTO);
		return ResponseEntity.ok(funcionarioAtualizado);
	}
	
	@GetMapping
	@Operation(summary = "Buscar todos os funcionários")
	public List<FuncionarioResponseIdDTO> listarFuncionario() {
		return funcionarioService.buscarTodos();
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um funcionário pelo ID")
    public ResponseEntity<String> deletarId(@PathVariable Integer id) {
        boolean resultDelete = funcionarioService.funcionarioDelete(id);
        if(resultDelete) {
            return ResponseEntity.status(HttpStatus.OK).body("Objeto deletado com sucesso!");
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Objeto não deletado!");
        }
    }
	
	@GetMapping("/{id}")
	@Operation(summary = "Pesquisar funcionário pelo ID")
	public FuncionarioResponseDTO buscarFuncionario(@PathVariable Integer id) {
	return funcionarioService.buscarFuncionario(id);
	}
}
