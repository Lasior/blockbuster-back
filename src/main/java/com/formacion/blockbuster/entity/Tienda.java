package com.formacion.blockbuster.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TIENDA")
@Data
public class Tienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idTienda")
	@Column(name = "ID")
	private Long idTienda;
	
	@Column(name = "TIENDA_NOMBRE")
	private String nombre;
	
	@Column(name = "TIENDA_DIRECCION")
	private String direccion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tienda")
	private List<Stock> stock;

}
