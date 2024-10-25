package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import br.com.trabalhofinal.grupoquatro.security.dto.CategoriaDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Categoria;
import br.com.trabalhofinal.grupoquatro.security.services.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/cadastrar-categoria")
	@Operation(summary = "Cadastrar categoria")
	public ResponseEntity<?> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		categoriaService.createCategoria(categoriaDTO);
		return ResponseEntity.ok(new MessageResponseDTO("Categoria criada com sucesso!"));
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/buscar-todas")
	@Operation(summary = "Buscar todos as categorias cadastradas")
    public ResponseEntity<List<Categoria>> listCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }
	
	@SecurityRequirement(name = "Bearer Auth")
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/{id}")
	@Operation(summary = "Buscar uma categoria pelo ID")
	public CategoriaDTO buscarCategoria(@PathVariable Integer id) {
		return categoriaService.buscarCategoria(id);
	}


	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
	@Operation(summary = "Atualizar categoria")
    public ResponseEntity<?> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria atualizada com sucesso!"));
    }

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
	@Operation(summary = "Deletar categoria")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria deletada com sucesso!"));
    }
	
}
