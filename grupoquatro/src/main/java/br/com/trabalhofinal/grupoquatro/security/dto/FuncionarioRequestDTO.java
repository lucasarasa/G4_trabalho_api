package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;


public class FuncionarioRequestDTO {
	
	private String nome;
	private String cpf;
    private String telefone;
    private String email;
	private String cargo;
	private String username;
	private String password;
    private Set<String> role;
    
	public FuncionarioRequestDTO() {
	}

	public FuncionarioRequestDTO(String nome, String cpf, String telefone, String email,
			String cargo, String username, String password, Set<String> role) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.username = username;
		this.password = password;
		this.role = role;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<String> getRole() {
		return role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}
    

}
