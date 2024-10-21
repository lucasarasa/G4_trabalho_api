package br.com.trabalhofinal.grupoquatro.security.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Cliente {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_cd_id")
	private Integer id;
	
	@Column(name="cli_tx_nome")
	private String nome;
	
	@Column(name="cli_tx_cpf")
	private String cpf;
	
	@Column(name="cli_tx_cartao")
	private String cartao;
	
	@Column(name="cli_dt_dt")
	private LocalDate dataNascimento;
	
	@Column(name="cli_tx_telefone")
	private String telefone;
	
}
