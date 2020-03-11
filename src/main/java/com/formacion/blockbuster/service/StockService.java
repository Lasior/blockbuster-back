package com.formacion.blockbuster.service;

import java.util.List;

import com.formacion.blockbuster.dto.Stock;
import com.formacion.blockbuster.enums.Enums;

public interface StockService {
	
	public void addStock(Stock stock);
	
	public void removeStock(Integer referencia);
	
	public void modifyStock(Stock stock, Integer referencia, Enums.estadoJuego estado);
	
	public Stock getStock(Integer referencia);
	
	public List<Stock> getStocks();

}
