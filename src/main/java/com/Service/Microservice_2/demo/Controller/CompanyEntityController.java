package com.Service.Microservice_2.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Service.Microservice_2.demo.entity.CompanyEntity;
import com.Service.Microservice_2.demo.service.CompanyEntityServices;

import java.util.List;


@RestController
@RequestMapping("/api/companies")
public class CompanyEntityController {

    @Autowired
    private CompanyEntityServices companyEnityServices;

    @GetMapping
    public List<CompanyEntity> getAllCompanies() {
        return companyEnityServices.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable Long id) {
        return companyEnityServices.getCompanyById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompanyEntity createCompany(@RequestBody CompanyEntity company) {
        return companyEnityServices.saveCompany(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyEntity> updateCompany(@PathVariable Long id, @RequestBody CompanyEntity company) {
        if (companyEnityServices.getCompanyById(id).isPresent()) {
            company.setId(id);
            return ResponseEntity.ok(companyEnityServices.updateCompany(company));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        if (companyEnityServices.getCompanyById(id).isPresent()) {
        	companyEnityServices.deleteCompany(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


