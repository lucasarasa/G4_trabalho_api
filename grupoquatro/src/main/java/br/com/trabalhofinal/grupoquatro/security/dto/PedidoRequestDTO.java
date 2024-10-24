package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

public class PedidoRequestDTO {
	private String numero;
	private Integer assento;		
	private Integer quantidade;
	private Double valorTotal;
	private String status;
	private Integer idCliente;
	private Set<Integer> idProduto;
	
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
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public Set<Integer> getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Set<Integer> idProduto) {
		this.idProduto = idProduto;
	}
	
}
