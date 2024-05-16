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
import com.job.posts.repository.JobRepository;
import com.job.posts.repository.records.JobsRecord;

@Component
@Order(3) 
public class JobJsonData implements CommandLineRunner {
private static final Logger log = LoggerFactory.getLogger(CompanyJsonData.class);
	
	private final JobRepository repository;
	private final ObjectMapper objectMapper;
	
	public JobJsonData(JobRepository repository, ObjectMapper objectMapper) {			
			this.repository = repository;
			this.objectMapper = objectMapper;			
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.repository.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/jobs.json")) {
				JobsRecord all = objectMapper.readValue(inputStream, JobsRecord.class);
                log.info("Reading {} runs from Type JSON data and saving to in-memory collection.", all.jobs().size());
                this.repository.saveAll(all.jobs());
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}
