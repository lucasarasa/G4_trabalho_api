package br.com.trabalhofinal.grupoquatro.security.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ped_cd_id")
	private Integer id;
	
	@Column(name="ped_tx_numero")
	private String numero;
	@Column(name="ped_int_assento")
	private Integer assento;		
	@Column(name="ped_int_quantidade")
	private Integer quantidade;
	@Column(name="ped_nb_valortotal")
	private Double valorTotal;
}
