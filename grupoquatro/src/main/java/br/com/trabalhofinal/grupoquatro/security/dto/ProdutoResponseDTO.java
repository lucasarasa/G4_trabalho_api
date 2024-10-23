package br.com.trabalhofinal.grupoquatro.security.dto;

public class ProdutoResponseDTO {
	
	private String nome;
	private String descricao;
	private String destino;
	private Double preco;
	
	
	public ProdutoResponseDTO() {
		
	}
	
	public ProdutoResponseDTO(String nome, String descricao, String destino, Double preco) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.destino = destino;
		this.preco = preco;
	}

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
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
