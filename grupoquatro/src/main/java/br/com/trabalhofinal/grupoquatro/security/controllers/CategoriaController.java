package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.trabalhofinal.grupoquatro.security.dto.CategoriaDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Categoria;
import br.com.trabalhofinal.grupoquatro.security.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@PostMapping("/create")
	public ResponseEntity<?> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
		categoriaService.createCategoria(categoriaDTO);
		return ResponseEntity.ok(new MessageResponseDTO("Categoria criada com sucesso!"));
	}
	
	@GetMapping("/list")
    public ResponseEntity<List<Categoria>> listCategorias() {
        List<Categoria> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCategoria(@PathVariable Integer id, @RequestBody CategoriaDTO categoriaDTO) {
        categoriaService.updateCategoria(id, categoriaDTO);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria atualizada com sucesso!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.ok(new MessageResponseDTO("Categoria deletada com sucesso!"));
    }
	
}
