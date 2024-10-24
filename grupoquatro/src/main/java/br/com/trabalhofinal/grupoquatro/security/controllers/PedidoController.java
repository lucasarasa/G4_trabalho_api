package br.com.trabalhofinal.grupoquatro.security.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.PedidoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.PedidoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.services.EmailService;
import br.com.trabalhofinal.grupoquatro.security.services.PedidoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	PedidoService pedidoService;
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
	@PostMapping
	public PedidoResponseDTO adicionarPedido(@RequestBody PedidoRequestDTO pedidoDto) {
		emailService.mailWriterPedido(pedidoDto);
		return pedidoService.adicionarPedido(pedidoDto);
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('USER')")
	@GetMapping("/{id}")
	public PedidoResponseDTO buscarPorId(@PathVariable Integer id) {
		return pedidoService.buscarPedido(id);
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteId/{id}")
	public ResponseEntity<String> deletarId(@PathVariable Integer id) {
		boolean resultDelete = pedidoService.pedidoDelete(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Objeto deletado com sucesso!");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Objeto não deletado!");
		}
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public String atualizarPedido(@PathVariable Integer id,@RequestBody PedidoRequestUpdateDTO pedidoDto) {
		return pedidoService.atualizarPedido(id, pedidoDto);
	}
}
