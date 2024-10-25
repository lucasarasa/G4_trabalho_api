package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

public class PedidoRequestDTO {
	private String numero;
	private Integer idCliente;
	private Set<Integer> idProduto;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
