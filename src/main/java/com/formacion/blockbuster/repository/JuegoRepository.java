package com.formacion.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Juego;

public interface JuegoRepository extends JpaRepository<Juego, Long>{
	
	public List<Juego> findByTitulo(String titulo);
	
}
