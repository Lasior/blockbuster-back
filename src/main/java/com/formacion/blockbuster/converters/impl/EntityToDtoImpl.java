package com.formacion.blockbuster.converters.impl;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.ClienteDTO;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.RolDTO;
import com.formacion.blockbuster.dto.StockDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Cliente;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.entity.Rol;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.entity.Tienda;

@Service
public class EntityToDtoImpl implements EntityToDto{

	@Override
	public ClienteDTO getClienteDTO(Cliente cliente) { 
		ClienteDTO c = new ClienteDTO();
		
		c.setCorreo(cliente.getCorreo());
		c.setDocumentacion(cliente.getDocumentacion());
		c.setFechaNacimiento(cliente.getFechaNacimiento());
		c.setNombre(cliente.getNombre());
		
		return c;
	}

	@Override
	public JuegoDTO getJuegoDTO(Juego juego) {
		JuegoDTO j = new JuegoDTO();
		
		j.setCategoria(juego.getCategoria());
		j.setFechaLanzamiento(juego.getFechaLanzamiento());
		j.setPegi(juego.getPegi());
		j.setPrecio(juego.getPrecio());
		j.setTitulo(juego.getTitulo());
		
		return j;
	}

	@Override
	public TiendaDTO getTiendaDTO(Tienda tienda) {
		TiendaDTO t = new TiendaDTO();
		
		t.setDireccion(tienda.getDireccion());
		t.setNombre(tienda.getNombre());
		
		return t;
	}

	@Override
	public CompanyDTO getCompanyDTO(Company company) {
		CompanyDTO comp = new 	CompanyDTO();
		
		comp.setCif(company.getCif());
		comp.setNombre(company.getNombre());
		
		return comp;
	}

	@Override
	public StockDTO getStockDTO(Stock stock) {
		
		StockDTO s = new StockDTO();
		
		s.setEstado(stock.getEstado());
		s.setReferencia(stock.getReferencia());
		
		return s;
	}

	@Override
	public RolDTO getRolDTO(Rol rol) {
		
		RolDTO r = new RolDTO();
		
		r.setRolUsuario(rol.getRol());
		
		return r;
	}

}
