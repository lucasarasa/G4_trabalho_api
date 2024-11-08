package br.com.trabalhofinal.grupoquatro.security.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") 
	})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;

	@OneToOne(mappedBy = "fkUser")
	private Cliente fkCliente;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToOne(mappedBy ="fkUser")
	private Funcionario fkFuncionario;
	
	@ManyToOne
	@JoinColumn(name="fk_aeroporto")
	private Aeroporto fkAeroporto;
	
	@OneToOne(mappedBy= "fkUser", cascade = CascadeType.ALL, orphanRemoval = true)
	private Foto fkFoto;

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Cliente getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Cliente fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Funcionario getFkFuncionario() {
		return fkFuncionario;
	}

	public void setFkFuncionario(Funcionario fkFuncionario) {
		this.fkFuncionario = fkFuncionario;
	}

	public Aeroporto getFkAeroporto() {
		return fkAeroporto;
	}

	public void setFkAeroporto(Aeroporto fkAeroporto) {
		this.fkAeroporto = fkAeroporto;
	}
	
}