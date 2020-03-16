package com.formacion.blockbuster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formacion.blockbuster.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	public List<Cliente> findByDocumentacion(String documentacion);
	
}
