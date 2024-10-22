package br.com.trabalhofinal.grupoquatro.security.entities;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@Column(name="pro_hr_descricao")
	private LocalTime horario;
	
	@Column(name="pro_nb_preco")
	private Double preco;
	
	@ManyToMany(fetch = FetchType.LAZY) 
	@JoinTable(name = "produto_pedido", joinColumns = @JoinColumn(name = "produto_id"), inverseJoinColumns = @JoinColumn(name = "pedido_id"))
	private Set<Pedido> pedidos = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(unique = true, name = "fk_produto")
	private Endereco fkEndereco;
}
