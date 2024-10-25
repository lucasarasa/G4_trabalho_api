package br.com.trabalhofinal.grupoquatro.security.entities;

import br.com.trabalhofinal.grupoquatro.security.dto.ProdutoResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pro_cd_id")
	private Integer id;
	
	@Column(name="pro_tx_nome")
	private String nome;
	
	@Column(name="pro_tx_descricao")
	private String descricao;
	
	@Column(name="pro_nb_preco")
	private Double preco;
	
	@OneToOne
	@JoinColumn(unique = true, name = "fk_endereco")
	private Endereco fkEndereco;
	
	@ManyToOne
    @JoinColumn(name="fk_categoria")
    private Categoria fkCategoria;

	
	public Produto() {
	}

	public Produto(String nome, String descricao, Double preco) {
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Endereco getFkEndereco() {
		return fkEndereco;
	}

	public void setFkEndereco(Endereco fkEndereco) {
		this.fkEndereco = fkEndereco;
	}

	public Categoria getFkCategoria() {
		return fkCategoria;
	}

	public void setFkCategoria(Categoria fkCategoria) {
		this.fkCategoria = fkCategoria;
	}
	
	public ProdutoResponseDTO toResponseDTO() {
		return new ProdutoResponseDTO(this.nome, this.descricao, this.fkEndereco.getLocalidade(), this.preco);
	}
	
}