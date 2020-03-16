package com.formacion.blockbuster.service;

import com.formacion.blockbuster.dto.StockDTO;

public interface StockService {
	
	public StockDTO getStock(String reference);
	
	public void postStock(StockDTO stockDTO, String documentacion, String nombreTienda, String nombreJuego);
	
	public void deleteStock(String reference);
	
	public void putStock(StockDTO stockDTO, String reference);

}
