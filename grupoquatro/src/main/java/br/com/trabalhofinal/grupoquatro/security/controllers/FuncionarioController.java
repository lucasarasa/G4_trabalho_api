package br.com.trabalhofinal.grupoquatro.security.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.FuncionarioResponseIdDTO;
import br.com.trabalhofinal.grupoquatro.security.services.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	FuncionarioService funcionarioService;
	
	@PostMapping("/inserir")
	@Operation(summary = "Adicionar um novo funcionário")
	public FuncionarioResponseDTO cadastrarFuncionario(@RequestBody FuncionarioRequestDTO funcionario) {
		return funcionarioService.cadastrarFuncionario(funcionario);
	}


}
