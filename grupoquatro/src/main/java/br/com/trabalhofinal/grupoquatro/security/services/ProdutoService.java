package br.com.trabalhofinal.grupoquatro.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.trabalhofinal.grupoquatro.security.dto.MessageResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestDTO;
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
	

}
