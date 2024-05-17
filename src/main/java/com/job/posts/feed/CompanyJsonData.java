package com.job.posts.feed;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.posts.entity.Company;
import com.job.posts.feed.wrappers.CompaniesWrapper;
import com.job.posts.repository.CompanyRepository;
import com.job.posts.repository.records.CompaniesRecord;
import com.job.posts.service.CompanyService;

@Component
@Order(1)
public class CompanyJsonData implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(CompanyJsonData.class);
	
	private final ObjectMapper objectMapper;
	private final CompanyService companyService;
	
	public CompanyJsonData(ObjectMapper objectMapper, CompanyService companyService) {			
			this.objectMapper = objectMapper;	
			this.companyService = companyService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.companyService.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/companies.json")) {
				CompaniesWrapper companiesWrapper= objectMapper.readValue(inputStream, CompaniesWrapper.class);
                List<Company> companies = companiesWrapper.getCompanies();
				log.info("Reading {} runs from Type JSON data and saving to in-memory collection.", companies.size());
                // this.companyService.saveAll(companies);
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}