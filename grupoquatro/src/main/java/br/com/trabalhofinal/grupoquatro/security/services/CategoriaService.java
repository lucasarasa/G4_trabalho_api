package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.trabalhofinal.grupoquatro.security.dto.CategoriaDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Categoria;
import br.com.trabalhofinal.grupoquatro.security.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;
	

	public void createCategoria(CategoriaDTO categoriaDTO) {
		Categoria categoria = new Categoria();
		categoria.setTipo(categoriaDTO.getTipo());
		categoria.setDescricao(categoriaDTO.getDescricao());

		categoriaRepository.save(categoria);
	}
	
	public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }
	
	public CategoriaDTO buscarCategoria(Integer id) {

		Optional<Categoria> categoria = categoriaRepository.findById(id);

		CategoriaDTO categoriaDTO = new CategoriaDTO();
		categoriaDTO.setTipo(categoria.get().getTipo());
		categoriaDTO.setDescricao(categoria.get().getDescricao());
		return categoriaDTO;
	}

    public void updateCategoria(Integer id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        categoria.setTipo(categoriaDTO.getTipo());
        categoria.setDescricao(categoriaDTO.getDescricao());
        categoriaRepository.save(categoria);
    }

    public void deleteCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

}
