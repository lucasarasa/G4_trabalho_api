package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

import br.com.trabalhofinal.grupoquatro.security.entities.Role;

public class FuncionarioResponseIdDTO {
	
	private Integer id;
	private String nome;
	private String cpf;
    private String telefone;
    private String email;
	private String cargo;
	private String username;
    private Set<Role> role;
    
	public FuncionarioResponseIdDTO() {
	}

	public FuncionarioResponseIdDTO(Integer id, String nome, String cpf, String telefone, String email, String cargo,
			String username, Set<Role> role) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.username = username;
		this.role = role;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}
    
    

}
