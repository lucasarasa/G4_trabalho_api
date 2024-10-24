package br.com.trabalhofinal.grupoquatro.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;
import br.com.trabalhofinal.grupoquatro.security.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping("/CadastrarEndereço")
	public EnderecoResponseDTO cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {
		return enderecoService.cadastrarEndereco(enderecoRequestDTO);
	}
	
	@DeleteMapping("/{id}")
	public void deletarEndereco(@PathVariable Integer id) {
		enderecoService.deletarEndereco(id);
	
	}
	
	@GetMapping("/{id}")
	public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {	
		return enderecoService.buscarEndereco(id);
	}
}
