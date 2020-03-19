package com.formacion.blockbuster.converters;

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

public interface DtoToEntity {
	
	public Cliente getCliente(ClienteDTO clienteDTO);
	public Juego getJuego(JuegoDTO juegoDTO);
	public Stock getStock(StockDTO stockDTO);
	public Tienda getTienda(TiendaDTO tiendaDTO);
	public Company getCompany(CompanyDTO companyDTO);
	public Rol getRol(RolDTO rolDTO);

}
