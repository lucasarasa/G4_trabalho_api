package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

import br.com.trabalhofinal.grupoquatro.security.entities.Pedido;

public class PedidoResponseDTO {
	private String numero;
	private Integer assento;		
	private Integer quantidade;
	private Double valorTotal;
	private String status;
	private String nomeCliente;
	private Set<String> nomeProduto;	
	
	public PedidoResponseDTO(String numero, Integer assento, Integer quantidade, Double valorTotal, String status,
			String nomeCliente) {
		this.numero = numero;
		this.assento = assento;
		this.quantidade = quantidade;
		this.valorTotal = valorTotal;
		this.status = status;
		this.nomeCliente = nomeCliente;
	}
		public PedidoResponseDTO() {
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getAssento() {
		return assento;
	}
	public void setAssento(Integer assento) {
		this.assento = assento;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
		return new Pedido(this.numero, this.assento, this.quantidade, this.valorTotal, this.status);
	}
}