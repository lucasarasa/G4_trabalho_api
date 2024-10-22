package br.com.trabalhofinal.grupoquatro.security.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="aeroporto")
public class Aeroporto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aer_cd_int")
	private Integer id;
	
	@Column(name="are_tx_nome")
	private String nome;
	
	@Column(name="are_tx_email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "fk_aeroporto")
	private Endereco fkEndereco;
	
	@OneToMany(mappedBy = "fk_aeroporto")
	@Column(name="aer_fk_produto")
	private List<Produto> fk_produto;
	
	@OneToMany(mappedBy = "fk_aeroporto")
	@Column(name="aer_fk_user")
	private List<User> fk_user;
}