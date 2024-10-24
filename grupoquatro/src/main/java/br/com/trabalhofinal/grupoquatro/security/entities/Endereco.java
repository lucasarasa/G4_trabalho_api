package br.com.trabalhofinal.grupoquatro.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private Integer id;
		
		@Column(name="cep")
		private String cep;	
		@Column(name="regiao")
		private String regiao;
		@Column(name="bairro")
		private String bairro;
		@Column(name="complemento")
		private String complemento;
		@Column(name="estado")
		private String estado;
		@Column(name="logradouro")
		private String logradouro;
		@Column(name="localidade")
		private String localidade;
		@Column(name="uf")
		private String uf;
		@Column(name="numero")
		private Integer numero;	
		
		@OneToOne(mappedBy = "fkEndereco")
		private Aeroporto fkAeroporto;
		
		@OneToOne(mappedBy = "fkEndereco")
		private Produto fkProduto;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getRegiao() {
			return regiao;
		}
		public void setRegiao(String regiao) {
			this.regiao = regiao;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public Integer getNumero() {
			return numero;
		}
		public void setNumero(Integer numero) {
			this.numero = numero;
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
		public String getLocalidade() {
			return localidade;
		}
		public void setLocalidade(String localidade) {
			this.localidade = localidade;
		}
		public String getUf() {
			return uf;
		}
		public void setUf(String uf) {
			this.uf = uf;
		}
		
		@Override
		public String toString() {
			return "Endereco [id=" + id + ", cep=" + cep + ", bairro=" + bairro + ", complemento=" + complemento
					+ ", estado=" + estado + ", logradouro=" + logradouro + ", localidade=" + localidade + ", uf=" + uf
					+ "]";
		}			
		
		public Endereco() {
		}
		public Endereco(Integer id, String cep, String bairro, String complemento, String estado, String logradouro,
				String localidade, String uf) {
			this.id = id;
			this.cep = cep;
			this.bairro = bairro;
			this.complemento = complemento;
			this.estado = estado;
			this.logradouro = logradouro;
			this.localidade = localidade;
			this.uf = uf;
		}	
		public Endereco(String bairro, String cep, String complemento, String estado, String localidade,
				String logradouro, Integer numero, String regiao, String uf) {
			this.cep = cep;
			this.bairro = bairro;
			this.complemento = complemento;
			this.estado = estado;
			this.logradouro = logradouro;
			this.localidade = localidade;
			this.uf = uf;
		}
	
}

