package com.formacion.blockbuster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formacion.blockbuster.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Long>{
	
	public Company findByCif(String cif);

}
