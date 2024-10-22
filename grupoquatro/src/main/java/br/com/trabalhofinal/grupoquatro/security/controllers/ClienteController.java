package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.Optional;

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


import br.com.trabalhofinal.grupoquatro.security.dto.ClienteRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ClienteResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;
import br.com.trabalhofinal.grupoquatro.security.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ClienteResponseDTO adicionarCliente(@RequestBody ClienteRequestDTO clienteDto) {
		return clienteService.adicionarCliente(clienteDto);
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> buscarPorId(@PathVariable Integer id) {
		return clienteService.buscarPorId(id);
	}
	
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<String> deletarId(@PathVariable Integer id) {
		boolean resultDelete = clienteService.clienteDelete(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Objeto deletado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Objeto não deletado!");
		}
	}
	
	@PutMapping("/{id}")
	public String atualizarCliente(@PathVariable Integer id,@RequestBody ClienteRequestDTO clienteDto) {
		return clienteService.atualizarCliente(id, clienteDto);
	}
}
