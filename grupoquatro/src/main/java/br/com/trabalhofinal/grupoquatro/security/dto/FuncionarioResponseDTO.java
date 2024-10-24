package br.com.trabalhofinal.grupoquatro.security.dto;

import java.util.Set;

import br.com.trabalhofinal.grupoquatro.security.entities.Funcionario;
import br.com.trabalhofinal.grupoquatro.security.entities.Role;

public class FuncionarioResponseDTO {
	
	private String nome;
	private String cpf;
    private String telefone;
    private String email;
	private String cargo;
	private String username;
    private Set<Role> role;
	
	public FuncionarioResponseDTO() {
	}
	
	

	public FuncionarioResponseDTO(String nome, String cpf, String telefone, String email, String cargo, String username,
			Set<Role> role) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.username = username;
		this.role = role;
	}
	public FuncionarioResponseDTO(Funcionario funcionario) {
		this.nome = funcionario.getNome();
		this.cpf = funcionario.getCpf();
		this.telefone = funcionario.getTelefone();
		this.email = funcionario.getFkUser().getEmail();
		this.cargo = funcionario.getCargo();
		this.username = funcionario.getFkUser().getUsername();
		this.role = funcionario.getFkUser().getRoles();
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

	public Funcionario toFuncionario() {
		return new Funcionario(this.nome, this.cpf, this.telefone, this.cargo);
	}
	
	

}
