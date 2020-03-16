package com.formacion.blockbuster.converters.impl;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
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

@Service
public class DtoToEntityImpl implements DtoToEntity{

	@Override
	public Cliente getCliente(ClienteDTO clienteDTO) {
		Cliente c = new Cliente();
		
		c.setCorreo(clienteDTO.getCorreo());
		c.setDocumentacion(clienteDTO.getDocumentacion());
		c.setFechaNacimiento(clienteDTO.getFechaNacimiento());
		c.setNombre(clienteDTO.getNombre());
		
		return c;
	}

	@Override
	public Juego getJuego(JuegoDTO juegoDTO) {
		Juego j = new Juego();
		
		j.setCategoria(juegoDTO.getCategoria());
		j.setFechaLanzamiento(juegoDTO.getFechaLanzamiento());
		j.setPegi(juegoDTO.getPegi());
		j.setPrecio(juegoDTO.getPrecio());
		j.setTitulo(juegoDTO.getTitulo());
		
		return j;
	}

	@Override
	public Stock getStock(StockDTO stockDTO) {
		Stock s = new Stock();
		
		s.setEstado(stockDTO.getEstado());
		s.setReferencia(stockDTO.getReferencia());
		
		return s;
	}

	@Override
	public Tienda getTienda(TiendaDTO tiendaDTO) {
		Tienda t = new Tienda();
		
		t.setDireccion(tiendaDTO.getDireccion());
		t.setNombre(tiendaDTO.getNombre());
		
		return t;
	}

	@Override
	public Company getCompany(CompanyDTO companyDTO) {
		Company c = new Company();
		
		c.setCif(companyDTO.getCif());
		c.setNombre(companyDTO.getNombre());
		
		return c;
	}

}
