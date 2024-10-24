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

import br.com.trabalhofinal.grupoquatro.security.dto.AeroportoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Aeroporto;
import br.com.trabalhofinal.grupoquatro.security.repositories.AeroportoRepository;
import br.com.trabalhofinal.grupoquatro.security.services.AeroportoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/aeroporto")
public class AeroportoController {

	@Autowired
	AeroportoService aeroportoService;
	
	@Autowired
	AeroportoRepository aeroportoRepository;
	
	@GetMapping
	@Operation(summary="Listar aeroporto")
	public List<AeroportoRequestDTO> listarAeroporto(){
		return aeroportoService.listarAeroporto();
	}
	
	@PostMapping
	@Operation(summary = "Cadastrar aeroporto.")
	public ResponseEntity<?> cadastrarAeroporto(@RequestBody AeroportoRequestDTO aeroportoRequestDTO){
		List<Aeroporto> aeroportos = aeroportoRepository.findAll();
		
		if(!aeroportos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe um aeroporto cadastrado. Não é possível cadastrar outro.");
		} else {
			aeroportoService.cadastrarAeroporto(aeroportoRequestDTO);
			return ResponseEntity.ok(new MessageResponseDTO("Aeroporto cadastrado com sucesso!"));			
		}
		
	}
	
	@PutMapping
	@Operation(summary="Atualizar aeroporto.")
	public ResponseEntity<?> atualizarAeroporto(@RequestBody AeroportoRequestDTO aeroportoRequestDTO){
		aeroportoService.atualizarAeroporto(aeroportoRequestDTO);
		return ResponseEntity.ok(new MessageResponseDTO("Aeroporto atualizado com sucesso!"));
	}
	
	@DeleteMapping("/{id}")
	@Operation(summary="Deletar aeroporto")
	public ResponseEntity<String> deletarAeroporto(@PathVariable Integer id){
		boolean resultDelete = aeroportoService.deletarAeroporto(id);
		if(resultDelete) {
			return ResponseEntity.status(HttpStatus.OK).body("Aeroporto deletado com sucesso.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Err: Falha ao deletar o objeto.");
		}
	}
}
