package br.com.trabalhofinal.grupoquatro.security.entities;

import br.com.trabalhofinal.grupoquatro.security.dto.EnderecoResponseDTO;
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
		@Column(name="logradouro")
		private String logradouro;
		@Column(name="bairro")
		private String bairro;
		@Column(name="localidade")
		private String localidade;
		@Column(name="uf")
		private String uf;
		@Column(name="estado")
		private String estado;
		@Column(name="regiao")
		private String regiao;
		@Column(name="complemento")
		private String complemento;	
		
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
		
		public Endereco(String cep, String logradouro, String bairro, String localidade, String uf,
				String estado, String regiao, String complemento) {
			super();
			this.cep = cep;
			this.logradouro = logradouro;
			this.bairro = bairro;
			this.localidade = localidade;
			this.uf = uf;
			this.estado = estado;
			this.regiao = regiao;
			this.complemento = complemento;
		}
		public EnderecoResponseDTO toResponseDTO() {
			return new EnderecoResponseDTO(this.cep,
					this.logradouro, this.complemento, this.bairro, this.localidade,
					this.uf, this.estado, this.regiao);
		}
	
}