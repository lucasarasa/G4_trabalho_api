package br.com.trabalhofinal.grupoquatro.security.entities;

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
@Table(name="aeroporto")
public class Aeroporto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aer_cd_int")
	private Integer id;
	
	@Column(name="are_tx_nome")
	private String nome;
	
	@Column(name="are_tx_email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "fk_endereco")
	private Endereco fkEndereco;
	
	@OneToMany(mappedBy = "fkAeroporto")
	@Column(name="aer_fk_user")
	private List<User> fkUser;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getFkEndereco() {
		return fkEndereco;
	}

	public void setFkEndereco(Endereco fkEndereco) {
		this.fkEndereco = fkEndereco;
	}


	public List<User> getFkUser() {
		return fkUser;
	}

	public void setFkUser(List<User> fkUser) {
		this.fkUser = fkUser;
	}

	
}