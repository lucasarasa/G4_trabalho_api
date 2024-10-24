package br.com.trabalhofinal.grupoquatro.security.dto;

public class EnderecoRequestDTO {
	private String cep;
	private String complemento;	
		
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}