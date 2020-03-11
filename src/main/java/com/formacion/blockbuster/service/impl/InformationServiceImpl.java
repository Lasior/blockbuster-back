package com.formacion.blockbuster.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.formacion.blockbuster.dto.Company;
import com.formacion.blockbuster.dto.Tienda;
import com.formacion.blockbuster.service.InformationService;

@Service
public class InformationServiceImpl implements InformationService{
	
	private List<Company> comps = new ArrayList<Company>();
	private List<Tienda> stores = new ArrayList<Tienda>();

	@Override
	public void insertCompany(List<Company> companies) {
		comps.addAll(companies);
	}

	@Override
	public void insertStore(List<Tienda> tiendas) {
		for (Tienda tienda : tiendas) {
			System.out.println(tienda.toString());
		}
		stores.addAll(tiendas);
	}
	
	public List<Company> getCompanies(){
		return comps;
	}
	
	public List<Tienda> getStores(){
		for (Tienda store : stores) {
			System.out.println(store.toString());
		}
		return stores;
	}

}
