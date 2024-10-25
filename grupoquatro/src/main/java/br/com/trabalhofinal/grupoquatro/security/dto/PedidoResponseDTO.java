package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

import br.com.trabalhofinal.grupoquatro.security.entities.Pedido;

public class PedidoResponseDTO {
	private String numero;
	private Double valorTotal;
	private String status;
	private String nomeCliente;
	private Set<String> nomeProduto;	
	
	public PedidoResponseDTO() {
	}
	
	public PedidoResponseDTO(String numero, Double valorTotal, String status,
			String nomeCliente, Set<String> nomeProduto) {
		super();
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.status = status;
		this.nomeCliente = nomeCliente;
		this.nomeProduto = nomeProduto;
	}

	public PedidoResponseDTO(String numero, Double valorTotal, String status,
			String nomeCliente) {
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.status = status;
		this.nomeCliente = nomeCliente;
	}

	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Set<String> getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(Set<String> nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public Pedido toPedido() {
		return new Pedido(this.numero, this.valorTotal, this.status);
	}
}	
