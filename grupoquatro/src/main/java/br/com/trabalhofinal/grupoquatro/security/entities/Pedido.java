package br.com.trabalhofinal.grupoquatro.security.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_cd_id")
	private Integer id;

	@Column(name = "ped_tx_numero")
	private String numero;

	@Column(name = "ped_nb_valortotal")
	private Double valorTotal;

	@Column(name = "ped_tx_status")
	private String status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "pedido_produto", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
	private Set<Produto> produtos = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "fk_cliente")
	private Cliente fkCliente;

	public Pedido() {
	}

	public Pedido(Integer id, String numero, Double valorTotal, String status, Set<Produto> produtos,
			Cliente fkCliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.status = status;
		this.produtos = produtos;
		this.fkCliente = fkCliente;
	}

	public Pedido(String numero, Double valorTotal, String status) {
		super();
		this.numero = numero;
		this.valorTotal = valorTotal;
		this.status = status;
	}

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

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

}