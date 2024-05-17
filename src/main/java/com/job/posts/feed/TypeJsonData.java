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
import com.job.posts.entity.Type;
import com.job.posts.feed.wrappers.TypesWrapper;
import com.job.posts.repository.TypeRepository;
import com.job.posts.repository.records.TypesRecord;
import com.job.posts.service.TypeService;

@Component
@Order(2) 
public class TypeJsonData implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(TypeJsonData.class);
	
	private final TypeService typeService;
	private final ObjectMapper objectMapper;
	
	public TypeJsonData(TypeService typeService, ObjectMapper objectMapper) {	
			this.objectMapper = objectMapper;
			this.typeService = typeService;
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.typeService.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/types.json")) {
				TypesWrapper typesWrapper = objectMapper.readValue(inputStream, TypesWrapper.class);
	            List<Type> types = typesWrapper.getTypes();
	            log.info("Reading {} types from JSON data and saving to the database.", types.size());
	            this.typeService.saveAll(types);
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}