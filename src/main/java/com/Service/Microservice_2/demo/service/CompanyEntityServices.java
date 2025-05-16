package com.Service.Microservice_2.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Service.Microservice_2.demo.entity.CompanyEntity;
import com.Service.Microservice_2.demo.repo.CompanyEnityRepository;


@Service
public class CompanyEntityServices {

    @Autowired
    private CompanyEnityRepository companyRepository;

    public List<CompanyEntity> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<CompanyEntity> getCompanyById(Long id) {
        return companyRepository.findById(id);
    }

    public CompanyEntity saveCompany(CompanyEntity company) {
        return companyRepository.save(company);
    }

    public CompanyEntity updateCompany(CompanyEntity company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}

