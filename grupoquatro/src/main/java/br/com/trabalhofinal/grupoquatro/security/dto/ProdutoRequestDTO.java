package br.com.trabalhofinal.grupoquatro.security.dto;


import br.com.trabalhofinal.grupoquatro.security.entities.Produto;

public class ProdutoRequestDTO {

	private String nome;
	private String descricao;
//	private String Categoria;
	private String CepDestino;
	private Double preco;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
//	public String getCategoria() {
//		return Categoria;
//	}
//	public void setCategoria(String categoria) {
//		Categoria = categoria;
//	}
	
	public String getCepDestino() {
		return CepDestino;
	}
	public void setCepDestino(String cepDestino) {
		CepDestino = cepDestino;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
    public Produto toProduto() {
    	return new Produto(this.nome, this.descricao, this.preco);
    }
}
