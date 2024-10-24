package br.com.trabalhofinal.grupoquatro.security.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fun_cd_id")
	private Integer id;
	@Column(name="fun_tx_nome")
	private String nome;
	@CPF(message="Cpf deve ser válido")
	@Column(name="fun_tx_cpf")
	private String cpf;
    @Column(name="fun_tx_telefone")
    private String telefone;
	@Column(name="fun_tx_cargo")
	private String cargo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "func_prod", joinColumns = @JoinColumn(name = "func_id"), inverseJoinColumns = @JoinColumn(name = "prod_id"))
	private Set<Produto> produtos = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique=true, name = "fkUser")
	private User fkUser;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String cpf, String telefone,
			String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;
	}

	public Funcionario(String nome, String cpf, String telefone,
			String cargo) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.cargo = cargo;

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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Set<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

	public User getFkUser() {
		return fkUser;
	}

	public void setFkUser(User fkUser) {
		this.fkUser = fkUser;
	}
    

}