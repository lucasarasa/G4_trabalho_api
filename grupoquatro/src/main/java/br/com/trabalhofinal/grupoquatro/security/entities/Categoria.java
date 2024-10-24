package br.com.trabalhofinal.grupoquatro.security.entities;

import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cat_cd_id")
	private Integer id;

	@Column(name = "cat_tx_tipo")
	private String tipo;

	@Column(name = "cat_tx_descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "fkCategoria")
    @Column(unique=true, name="fk_produto")
    private List<Produto> fkProduto;

	public Categoria() {
		
	}
	
	public Categoria(Integer id, String tipo, String descricao, List<Produto> fkProduto) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.fkProduto = fkProduto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public List<Produto> getFkProduto() {
		return fkProduto;
	}

	public void setFkProduto(List<Produto> fkProduto) {
		this.fkProduto = fkProduto;
	}
}