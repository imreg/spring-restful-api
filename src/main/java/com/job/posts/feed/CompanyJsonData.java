package com.job.posts.feed;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.posts.repository.CompanyRepository;
import com.job.posts.repository.records.CompaniesRecord;

@Component
@Order(1)
public class CompanyJsonData implements CommandLineRunner {
	
	private static final Logger log = LoggerFactory.getLogger(CompanyJsonData.class);
	
	private final CompanyRepository repository;
	private final ObjectMapper objectMapper;
	
	public CompanyJsonData(CompanyRepository repository, ObjectMapper objectMapper) {			
			this.repository = repository;
			this.objectMapper = objectMapper;			
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.repository.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/companies.json")) {
				CompaniesRecord all = objectMapper.readValue(inputStream, CompaniesRecord.class);
                log.info("Reading {} runs from Type JSON data and saving to in-memory collection.", all.companies().size());
                this.repository.saveAll(all.companies());
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}