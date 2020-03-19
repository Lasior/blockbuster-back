package com.formacion.blockbuster.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.formacion.blockbuster.enums.Enums;

import lombok.Data;

@Data
@Entity
@Table(name = "ROL")
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "idRol")
	@Column(name = "ID")
	private Long idRol;
	
	@Column(name = "ROL")
	private Enums.rolUsuario rol;
	
	@ManyToMany
	private List<Cliente> clientes;
	

}
