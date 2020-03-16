package com.formacion.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long>{
	
	public List<Stock> findByReferencia(String referencia);
	
}
