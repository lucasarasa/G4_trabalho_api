package br.com.trabalhofinal.grupoquatro.security.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaDTO {
	@NotBlank
	private String tipo;
	@NotBlank
	private String descricao;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
