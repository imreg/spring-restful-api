package com.job.posts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.job.posts.entity.Company;
import com.job.posts.repository.interfaces.CompanyJpaRepositoryInterface;

@Service
public class CompanyService {
    private final CompanyJpaRepositoryInterface companyRepository;

    public CompanyService(CompanyJpaRepositoryInterface companyRepository) {
        this.companyRepository = companyRepository;
    }
    
	public Long count() {
		return this.companyRepository.count();
	}
   
    public void save(Company company) {
    	companyRepository.save(company);
	}
       
	public void saveAll(List<Company> company) {
		company.stream().forEach(this::save);
	}
}
