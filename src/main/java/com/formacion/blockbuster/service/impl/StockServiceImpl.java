package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.dto.Stock;
import com.formacion.blockbuster.enums.Enums;
import com.formacion.blockbuster.service.StockService;

@Service
public class StockServiceImpl implements StockService{
	
	private List<Stock> stocks = new ArrayList<Stock>();

	@Override
	public void addStock(Stock stock) {
		stocks.add(stock);
	}

	@Override
	public void removeStock(Integer referencia) {
		stocks.removeIf(s -> s.getReferencia() == referencia);
	}

	@Override
	public void modifyStock(Stock stock, Integer referencia, Enums.estadoJuego estado) {
		Stock stck = stocks.stream().filter(s -> s.getReferencia() == referencia).findFirst().get();
		stck.setEstado(estado);
	}

	@Override
	public Stock getStock(Integer referencia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> getStocks() {
		// TODO Auto-generated method stub
		return null;
	}

}
