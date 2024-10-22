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
	private Long id;

	@Column(name = "cat_tx_nome")
	private String nome;

	@Column(name = "cat_tx_descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "fkCategoria")
    @Column(unique=true, name="fk_produto")
    private List<Produto> fkProduto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public List<Produto> getFkProduto() {
		return fkProduto;
	}

	public void setFkProduto(List<Produto> fkProduto) {
		this.fkProduto = fkProduto;
	}
	
	
}
