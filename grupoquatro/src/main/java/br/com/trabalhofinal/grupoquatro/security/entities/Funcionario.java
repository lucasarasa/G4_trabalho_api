package br.com.trabalhofinal.grupoquatro.security.entities;

import java.time.LocalDate;
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
	@Column(name="fun_tx_cpf")
	private String cpf;
    @Column(name="fun_tx_telefone")
    private String telefone;
    @Column(name="fun_dt_nascimento")
    private LocalDate dataNascimento;
    @Column(name="fun_tx_email")
    private String email;
	@Column(name="fun_tx_cargo")
	private String cargo;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "func_prod", joinColumns = @JoinColumn(name = "func_id"), inverseJoinColumns = @JoinColumn(name = "prod_id"))
	private Set<Produto> produtos = new HashSet<>();
	
	@OneToOne(mappedBy ="fkFuncionario")
	private User fkUser;
	
	public Funcionario() {
	}

	public Funcionario(Integer id, String nome, String cpf, String telefone, LocalDate dataNascimento, String email,
			String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.email = email;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
    

}