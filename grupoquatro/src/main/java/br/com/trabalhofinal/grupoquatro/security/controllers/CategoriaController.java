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
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/create")
	public ResponseEntity<?> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		categoriaService.createCategoria(categoriaDTO);
		return ResponseEntity.ok(new MessageResponseDTO("Categoria criada com sucesso!"));
	}
	
	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/list")
    public ResponseEntity<List<Categoria>> listCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria atualizada com sucesso!"));
    }

	@SecurityRequirement(name="Bearer Auth")
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria deletada com sucesso!"));
    }
	
}
