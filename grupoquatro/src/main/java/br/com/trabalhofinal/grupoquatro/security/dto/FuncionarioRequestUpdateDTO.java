package br.com.trabalhofinal.grupoquatro.security.dto;


public class FuncionarioRequestUpdateDTO {
	
    private String telefone;
    private String email;
	private String cargo;
	private String username;
	private String password;
    
	public FuncionarioRequestUpdateDTO() {
	}
	
	public FuncionarioRequestUpdateDTO(String telefone, String email, String cargo, String username, String password) {
		super();
		this.telefone = telefone;
		this.email = email;
		this.cargo = cargo;
		this.username = username;
		this.password = password;
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

}
