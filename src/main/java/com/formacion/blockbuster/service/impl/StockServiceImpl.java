package com.formacion.blockbuster.service.impl;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.entity.Tienda;
import com.formacion.blockbuster.enums.Enums;
import com.formacion.blockbuster.exceptions.ClienteConStockAlquiladoException;
import com.formacion.blockbuster.exceptions.EdadInsuficienteException;
import com.formacion.blockbuster.repository.ClienteRepository;
import com.formacion.blockbuster.repository.JuegoRepository;
import com.formacion.blockbuster.repository.StockRepository;
import com.formacion.blockbuster.repository.TiendaRepository;
import com.formacion.blockbuster.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	EntityToDto etd;

	@Autowired
	DtoToEntity dte;

	@Autowired
	StockRepository sR;

	@Autowired
	ClienteRepository cR;

	@Autowired
	TiendaRepository tR;

	@Autowired
	JuegoRepository jR;

	@Override
	public StockDTO getStock(String reference) {
		Stock stock = sR.findByReferencia(reference).get(0);
		StockDTO s = etd.getStockDTO(stock);

		JuegoDTO j = etd.getJuegoDTO(stock.getJuego());
		TiendaDTO t = etd.getTiendaDTO(stock.getTienda());
		ClienteDTO c = etd.getClienteDTO(stock.getCliente());

		for (Company comp : stock.getJuego().getCompanies()) {
			CompanyDTO com = etd.getCompanyDTO(comp);
			j.getCompanyDTOs().add(com);
		}

		s.setClienteDTO(c);
		s.setJuegoDTO(j);
		s.setTiendaDTO(t);

		return s;
	}

	@Override
	public void postStock(StockDTO stockDTO, String documentacion, String nombreTienda, String nombreJuego) {
		Stock stock = dte.getStock(stockDTO);
		Cliente cliente = cR.findByDocumentacion(documentacion).get(0);
		Tienda tienda = tR.findByNombre(nombreTienda).get(0);
		Juego juego = jR.findByTitulo(nombreJuego).get(0);

		for (Stock st : cliente.getStocks()) {
			if(st.getEstado() == Enums.estadoJuego.ALQUILADO) {
				throw new ClienteConStockAlquiladoException();
			}
		}
		
		if (juego.getPegi() < Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears()) {
		stock.setCliente(cliente);
		stock.setJuego(juego);
		stock.setTienda(tienda);

		cliente.getStocks().add(stock);
		tienda.getStock().add(stock);
		juego.getStocks().add(stock);
		
		sR.save(stock);
		}
		else {
			throw new EdadInsuficienteException();
		}
	}

	@Override
	public void deleteStock(String reference) {
		sR.delete(sR.findByReferencia(reference).get(0));
	}

	@Override
	public void putStock(StockDTO stockDTO, String reference) {
		Stock s = sR.findByReferencia(reference).get(0);
		s = dte.getStock(stockDTO);
		sR.save(s);
	}

}
