package br.com.trabalhofinal.grupoquatro.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ped_cd_id")
	private Integer id;
	
	@Column(name="ped_tx_numero")
	private String numero;
	@Column(name="ped_int_assento")
	private Integer assento;		
	@Column(name="ped_int_quantidade")
	private Integer quantidade;
	@Column(name="ped_nb_valortotal")
	private Double valorTotal;
	
	@ManyToOne
	@JoinColumn(name="fk_cliente")
	private Cliente fkCliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}
	
}
