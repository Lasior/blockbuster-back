package com.formacion.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.blockbuster.entity.Juego;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Long>{
	
	public List<Juego> findByTitulo(String titulo);
	
}
