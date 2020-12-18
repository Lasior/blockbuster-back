package com.formacion.blockbuster.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formacion.blockbuster.converters.EntityToDto;
import com.formacion.blockbuster.dto.CompanyDTO;
import com.formacion.blockbuster.repository.CompanyRepository;
import com.formacion.blockbuster.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private EntityToDto entityToDto;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> getCompanies() {
        return companyRepository.findAll().stream().map(company -> entityToDto.getCompanyDTO(company)).collect(Collectors.toList());
    }

}
