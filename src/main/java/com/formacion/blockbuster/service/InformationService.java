package com.formacion.blockbuster.service;

import java.util.List;

import com.formacion.blockbuster.dto.Company;
import com.formacion.blockbuster.dto.Tienda;

public interface InformationService {
	
	public void insertCompany(List<Company> companies);
	
	public void insertStore(List<Tienda> tiendas);
	
	public List<Company> getCompanies();
	
	public List<Tienda> getStores();

}
