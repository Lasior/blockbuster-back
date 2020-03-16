package com.formacion.blockbuster.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "CLIENTE")
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idCliente")
	@Column(name = "ID")
	private Long idCliente;

	@Column(name = "NOMBRE_CLIENTE")
	private String nombre;

	@Column(name = "DOCUMENTACION_CLIENTE")
	private String documentacion;

	@Column(name = "CORREO_CLIENTE")
	private String correo;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "FECHA_NACIMIENTO_CLIENTE")
	private LocalDate fechaNacimiento;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cliente")
	private List<Stock> stocks = new ArrayList<>();

}
