package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

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
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.repository.ClienteRepository;
import com.formacion.blockbuster.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	ClienteRepository cR;
	
	@Autowired
	EntityToDto etd;
	
	@Autowired
	DtoToEntity dte;
	
	@Override
	public ClienteDTO getCliente(String documentacion) {
		Cliente cliente = cR.findByDocumentacion(documentacion).get(0);
		ClienteDTO c = etd.getClienteDTO(cliente);
		
		List<StockDTO> stocks = new ArrayList<StockDTO>();
		
		for (Stock stock : cliente.getStocks()) {
			StockDTO s = etd.getStockDTO(stock);
			JuegoDTO j = etd.getJuegoDTO(stock.getJuego());
			TiendaDTO t = etd.getTiendaDTO(stock.getTienda());
			
			for (Company comp : stock.getJuego().getCompanies()) {
				CompanyDTO com = etd.getCompanyDTO(comp);
				j.getCompanyDTOs().add(com);
			}
			
			s.setJuegoDTO(j);
			s.setTiendaDTO(t);
			
			stocks.add(s);
		}
		
		c.setStockDTOs(stocks);
		
		return c;
	}

	@Override
	public void postCliente(ClienteDTO clienteDTO) {
		cR.save(dte.getCliente(clienteDTO));
	}

	@Override
	public void deleteCliente(String documentacion) {
		cR.delete(cR.findByDocumentacion(documentacion).get(0));
	}

	@Override
	public void putCliente(ClienteDTO clienteDTO, String documentacion) {
		Cliente cliente = cR.findByDocumentacion(documentacion).get(0);
		cliente = dte.getCliente(clienteDTO);
		cR.save(cliente);
	}

}
