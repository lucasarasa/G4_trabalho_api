package br.com.trabalhofinal.grupoquatro.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoRequestDTO;
import br.com.trabalhofinal.grupoquatro.security.services.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@PostMapping("/cadastrar-produto")
	@Operation(summary = "Cadastrar um novo produto")
	public String cadastrarProduto(@RequestBody ProdutoRequestDTO produtoDTO) {
		produtoService.cadastrarProduto(produtoDTO);
		return "Produto cadastrado com sucesso!";
	}

}
