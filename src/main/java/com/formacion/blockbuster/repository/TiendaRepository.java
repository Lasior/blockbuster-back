package com.formacion.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, Long>{
	
	public List<Tienda> findByNombre(String nombre);

}
