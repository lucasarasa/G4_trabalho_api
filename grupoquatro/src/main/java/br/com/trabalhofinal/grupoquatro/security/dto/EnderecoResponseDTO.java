package br.com.trabalhofinal.grupoquatro.security.dto;

import br.com.trabalhofinal.grupoquatro.security.entities.Endereco;

public class EnderecoResponseDTO {
	private String cep;
	private String bairro;
	private String complemento;
	private String estado;
	private String logradouro;
	private String localidade;
	private String uf;
	private String regiao;
	private Integer numero;

	public EnderecoResponseDTO() {

	}

	public EnderecoResponseDTO(String cep, String logradouro, String complemento, String bairro, String localidade,
			String uf, String estado, String regiao, Integer numero) {
		this.cep = cep;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.logradouro = logradouro;
		this.localidade = localidade;
		this.uf = uf;
		this.regiao = regiao;
		this.numero = numero;

	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public Endereco toEndereco() {
		return new Endereco(this.cep, this.bairro, this.complemento, this.estado, this.logradouro, this.localidade,
				this.uf, this.regiao, this.numero);
	}
}
