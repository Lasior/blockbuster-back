package com.formacion.blockbuster.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Entity
@Table(name = "JUEGO")
@Data
public class Juego {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idJuego")
	@Column(name = "ID")
	private Long idJuego;

	@Column(name = "JUEGO_TITULO")
	private String titulo;

	@Column(name = "JUEGO_FECHA_LANZAMIENTO")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date fechaLanzamiento;

	@Column(name = "JUEGO_PRECIO")
	private Integer precio;
	
	@Column(name = "JUEGO_PEGI")
	private Integer pegi;

	@Column(name = "JUEGO_CATEGORIA")
	private Enums.categoriaJuego categoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "juego")
	private List<Stock> stocks = new ArrayList<Stock>();
	
	@ManyToMany(mappedBy = "juegos")
	private List<Company> companies = new ArrayList<Company>();

}
