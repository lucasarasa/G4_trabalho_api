package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;
import br.com.trabalhofinal.grupoquatro.security.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@Autowired
	EnderecoRepository enderecoRepository;

//	@SecurityRequirement(name = "Bearer Auth")
//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cadastrar-endereço")
	@Operation(summary = "Cadastrar um novo endereço")
	public String cadastrarEndereco(@RequestBody EnderecoRequestDTO enderecoRequestDTO) {

		Optional<Endereco> endereco = enderecoRepository.existsByCep(enderecoRequestDTO.getCep());

		if (enderecoRequestDTO.getCep().equals("20021-340")) {
			return "Não é possível cadastrar um novo endereço do Rio de Janeiro.";
		} else {
			if (endereco.isPresent()) {
				return "Esse CEP já está cadastrado!";
			} else {
				enderecoService.cadastrarEndereco(enderecoRequestDTO);
				return "Endereço cadastrado com sucesso!";
			}
		}
	}

	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar-todos")
	@Operation(summary = "Buscar todos os endereços cadastrados")
	public List<EnderecoResponseDTO> buscarTodos() {
		return enderecoService.buscarTodos();
	}

	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	@Operation(summary = "Buscar um endereço pelo ID")
	public EnderecoResponseDTO buscarEndereco(@PathVariable Integer id) {
		return enderecoService.buscarEndereco(id);
	}

	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um endereço")
	public String atualizarEndereco(@PathVariable Integer id, @RequestBody EnderecoResponseDTO enderecoDTO) {
		return enderecoService.atualizarEndereco(id, enderecoDTO);
	}

	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um endereço pelo ID")
	public String deletarEndereco(@PathVariable Integer id) {
		enderecoService.deletarEndereco(id);
		return "Endereço deletado com sucesso!";
	}

}