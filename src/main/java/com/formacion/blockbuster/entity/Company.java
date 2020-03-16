package com.formacion.blockbuster.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "COMPANY")
@Data
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idCompany")
	@Column(name = "ID")
	private Long idCompany;
	
	@Column(name = "CIF")
	private String cif;
	
	@Column(name = "COMPANY_NOMBRE")
	private String nombre;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Juego> juegos = new ArrayList<Juego>();

}
