package com.Service.Microservice_2.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Service.Microservice_2.demo.entity.CompanyEntity;



@Repository
public interface CompanyEnityRepository extends JpaRepository<CompanyEntity, Long> {
}
