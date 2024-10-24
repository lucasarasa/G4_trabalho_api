package br.com.trabalhofinal.grupoquatro.security.dto;

public class ProdutoRequestUpdateDTO {
	
	private String descricao;
	private Double preco;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}