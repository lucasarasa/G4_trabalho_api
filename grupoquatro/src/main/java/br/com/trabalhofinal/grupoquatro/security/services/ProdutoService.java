package br.com.trabalhofinal.grupoquatro.security.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;
import br.com.trabalhofinal.grupoquatro.security.entities.Produto;
import br.com.trabalhofinal.grupoquatro.security.repositories.CategoriaRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;
import br.com.trabalhofinal.grupoquatro.security.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;


	public ResponseEntity<?> cadastrarProduto(ProdutoRequestDTO produtoDTO) {

		Produto produto = produtoDTO.toProduto();

		Endereco endereco = enderecoRepository.buscarEndereco(produtoDTO.getCepDestino());
		produto.setFkEndereco(endereco);

//		Categoria categoria = categoriaRepository.buscarCategoria(produtoDTO.getCategoria());
//		produto.setFkCategoria(categoria);
		
		produtoRepository.save(produto);
		
		return ResponseEntity.ok(new MessageResponseDTO("Produto registrado com sucesso!"));
	}
	
	public List<ProdutoResponseDTO> buscarTodos() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoResponseDTO> produtosDTO = new ArrayList<ProdutoResponseDTO>();
		for (Produto prod : produtos) {
			produtosDTO.add(prod.toResponseDTO());
		}

		return produtosDTO;
	}
	
	public ProdutoResponseDTO buscarProduto(Integer id) {
		
		Optional<Produto> produto = produtoRepository.findById(id);
		
		ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO();
		produtoResponseDTO.setNome(produto.get().getNome());
		produtoResponseDTO.setDescricao(produto.get().getDescricao());
		produtoResponseDTO.setDestino(produto.get().getFkEndereco().getLocalidade());
		produtoResponseDTO.setPreco(produto.get().getPreco());
		return produtoResponseDTO;
	}
	
	public ResponseEntity<?> atualizarProduto(Integer id, ProdutoRequestUpdateDTO produtoDTO) {
		if (!produtoRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		} else {
			Produto produto = produtoRepository.findById(id).get();
			if (produtoDTO.getDescricao() != null) {
				produto.setDescricao(produtoDTO.getDescricao());
			}
			if (produtoDTO.getPreco() != null) {
				produto.setPreco(produtoDTO.getPreco());
			}
		
			produtoRepository.save(produto);
			return ResponseEntity.ok().build();
		}

	}

	

}
