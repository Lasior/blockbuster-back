package com.formacion.blockbuster.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public Optional<List<Stock>> findByReferencia(String referencia);
	
}
