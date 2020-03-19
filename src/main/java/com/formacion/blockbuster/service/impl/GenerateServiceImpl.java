package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.DtoToEntity;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.dto.JuegoDTO;
import com.formacion.blockbuster.dto.RolDTO;
import com.formacion.blockbuster.dto.TiendaDTO;
import com.formacion.blockbuster.entity.Company;
import com.formacion.blockbuster.entity.Juego;
import com.formacion.blockbuster.entity.Stock;
import com.formacion.blockbuster.entity.Tienda;
import com.formacion.blockbuster.repository.CompanyRepository;
import com.formacion.blockbuster.repository.JuegoRepository;
import com.formacion.blockbuster.repository.RolRepository;
import com.formacion.blockbuster.repository.TiendaRepository;
import com.formacion.blockbuster.service.GenerateDataService;

@Service
public class GenerateServiceImpl implements GenerateDataService{
	
	@Autowired
	CompanyRepository cR;
	
	@Autowired
	TiendaRepository tR;
	
	@Autowired
	JuegoRepository jR;
	
	@Autowired
	RolRepository rR;
	
	@Autowired
	DtoToEntity dte;
	

	@Override
	public void addCompany(CompanyDTO companyDTO) {
		Company c = new Company();
		
		c.setCif(companyDTO.getCif());
		c.setNombre(companyDTO.getNombre());
		c.setJuegos(new ArrayList<Juego>());
		
		cR.save(c);
	}

	@Override
	public void addTienda(TiendaDTO tiendaDTO) {
		Tienda t = new Tienda();
		
		t.setNombre(tiendaDTO.getNombre());
		t.setDireccion(tiendaDTO.getDireccion());
		t.setStock(new ArrayList<Stock>());
		
		tR.save(t);		
	}

	@Override
	public void addJuego(JuegoDTO juegoDTO) {
		Juego j = new Juego();
		
		j.setCategoria(juegoDTO.getCategoria());
		j.setFechaLanzamiento(juegoDTO.getFechaLanzamiento());
		j.setPegi(juegoDTO.getPegi());
		j.setPrecio(juegoDTO.getPrecio());
		j.setTitulo(juegoDTO.getTitulo());
		
		List<Company> comp = new ArrayList<Company>();
		
		for (CompanyDTO compDTO : juegoDTO.getCompanyDTOs()) {
			comp.add(cR.findByCif(compDTO.getCif()));
		}
		
		for (Company company : comp) {
			company.getJuegos().add(j);
		}
		
		j.setCompanies(comp);
		
		jR.save(j);
	}
	
	@Override
	public void addRol(RolDTO rolDTO) {
		System.out.println();
		rR.save(dte.getRol(rolDTO));
	}

}
