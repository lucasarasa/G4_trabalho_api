package br.com.trabalhofinal.grupoquatro.security.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_cd_id")
	private Integer id;
	
	@Column(name="cli_tx_nome")
	private String nome;
	
	@Column(name="cli_tx_cpf")
	private String cpf;
	
	@Column(name="cli_tx_cartao")
	private String cartao;
	
	@Column(name="cli_dt_dt")
	private LocalDate dataNascimento;
	
	@Column(name="cli_tx_telefone")
	private String telefone;

	@OneToMany(mappedBy="fkCliente")
	@Column(name="fk_pedido")
	private List<Pedido> fkPedido;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "fkUser")
	private User fkUser;
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String cartao, LocalDate dataNascimento, String telefone) {
		this.nome = nome; 
		this.cpf = cpf; 
		this.cartao = cartao; 
		this.dataNascimento = dataNascimento; 
		this.telefone = telefone;
	}

	public User getFkUser() {
		return fkUser;
	}

	public void setFkUser(User fkUser) {
		this.fkUser = fkUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setFkPedido(List<Pedido> fkPedido) {
		this.fkPedido = fkPedido;
	}

	
}
