package br.com.trabalhofinal.grupoquatro.security.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestUpdateDTO;
import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoResponseDTO;
import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;
import br.com.trabalhofinal.grupoquatro.security.repositories.EnderecoRepository;
import br.com.trabalhofinal.grupoquatro.security.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@Autowired
	EnderecoRepository enderecoRepository;

	@PostMapping("/cadastrar-produto")
	@Operation(summary = "Cadastrar um novo produto")
	public String cadastrarProduto(@RequestBody ProdutoRequestDTO produtoDTO) {
		Optional<Endereco> endereco = enderecoRepository.existsByCep(produtoDTO.getCepDestino());

		if (endereco.isPresent()) {
			produtoService.cadastrarProduto(produtoDTO);
			return "Produto cadastrado com sucesso!";
		} else {
			return "Erro ao cadastrar o produto. Cep não cadastrado.";
		}
	}

	@GetMapping("/buscar-todos")
	@Operation(summary = "Buscar todos os produtos cadastrados")
	public List<ProdutoResponseDTO> buscarTodos() {
		return produtoService.buscarTodos();
	}

	@GetMapping("/{id}")
	@Operation(summary = "Buscar um produto pelo ID")
	public ProdutoResponseDTO buscarProduto(@PathVariable Integer id) {
		return produtoService.buscarProduto(id);
	}

	@PutMapping("/{id}")
	@Operation(summary = "Atualizar um produto")
	public ResponseEntity<?> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoRequestUpdateDTO produto) {
		return produtoService.atualizarProduto(id, produto);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Deletar um produto pelo ID")
	public String deletarProduto(@PathVariable Integer id) {
		produtoService.deletarProduto(id);
		return "Produto deletado com sucesso!";
	}

}
