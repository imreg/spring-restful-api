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
import com.job.posts.entity.Job;
import com.job.posts.feed.wrappers.JobWrapper;
import com.job.posts.service.JobService;

@Component
@Order(3) 
public class JobJsonData implements CommandLineRunner {
private static final Logger log = LoggerFactory.getLogger(CompanyJsonData.class);
	
	private final JobService jobService;
	private final ObjectMapper objectMapper;
	
	public JobJsonData(ObjectMapper objectMapper, JobService jobService) {					
			this.objectMapper = objectMapper;
			this.jobService = jobService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.jobService.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/jobs.json")) {
				JobWrapper jobWrapper = objectMapper.readValue(inputStream, JobWrapper.class);
				List<Job> jobs = jobWrapper.getJobs();
                log.info("Reading {} runs from Type JSON data and saving to in-memory collection.", jobs.size());
                this.jobService.saveAll(jobs);
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}
