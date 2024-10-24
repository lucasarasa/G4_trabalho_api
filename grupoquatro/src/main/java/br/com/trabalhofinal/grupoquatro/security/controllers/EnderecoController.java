package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping("/CadastrarEndereço")
	public EnderecoResponseDTO cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
		return enderecoService.cadastrarEndereco(enderecoRequestDTO);
	}
	
	@GetMapping("/buscar-todos")
	@Operation(summary = "Buscar todos os endereços cadastrados")
	public List<EnderecoResponseDTO> buscarTodos() {
		return enderecoService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "Buscar um endereço pelo ID")
	public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {	
		return enderecoService.buscarEndereco(id);
	}
	
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um endereço")
	public String atualizarEndereco(@PathVariable Integer id,@RequestBody EnderecoResponseDTO enderecoDTO) {
		return enderecoService.atualizarEndereco(id, enderecoDTO);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um endereço pelo ID")
	public String deletarEndereco(@PathVariable Integer id) {
		enderecoService.deletarEndereco(id);
		return "Endereço deletado com sucesso!";
	}
	
}
