package br.com.trabalhofinal.grupoquatro.security.dto;

import java.time.LocalDate;

import br.com.trabalhofinal.grupoquatro.security.entities.Cliente;

public class ClienteResponseDTO {

private String nome; 
	private String cpf; 
	private String cartao; 
	private LocalDate dataNascimento; 
	private String telefone;
	

	public ClienteResponseDTO() {
	}
	
	public ClienteResponseDTO(String nome, String cpf, String cartao, LocalDate dataNascimento, String telefone) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.cartao = cartao;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
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
	
	public Cliente toCliente() {
		return new Cliente(this.nome, this.cpf, this.cartao, this.dataNascimento, this.telefone);
	}
}
