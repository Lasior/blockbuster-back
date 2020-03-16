package com.formacion.blockbuster.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Entity
@Data
@Table(name = "STOCK")
public class Stock {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idStock")
	@Column(name = "ID")
	private Long idStock;
	
	@Column(name = "STOCK_REF")
	private String referencia;
	
	@Column(name = "STOCK_ESTADO")
	private Enums.estadoJuego estado;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	private Juego juego;
	
	@ManyToOne
	private Tienda tienda;

}
