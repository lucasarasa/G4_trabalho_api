package br.com.trabalhofinal.grupoquatro.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cat_cd_id")
	private Long id;

	@Column(name = "cat_tx_nome")
	private String nome;

	@Column(name = "cat_tx_descricao")
	private String descricao;

}
	
