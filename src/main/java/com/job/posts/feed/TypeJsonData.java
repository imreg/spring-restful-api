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
import com.job.posts.repository.TypeRepository;
import com.job.posts.repository.records.TypesRecord;

@Component
@Order(2) 
public class TypeJsonData implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(TypeJsonData.class);
	
	private final TypeRepository typeRepository;
	private final ObjectMapper objectMapper;
	
	public TypeJsonData(TypeRepository typeRepository, ObjectMapper objectMapper) {			
			this.typeRepository = typeRepository;
			this.objectMapper = objectMapper;			
	}
	
	@Override
	public void run(String... args) throws Exception {
		if(this.typeRepository.count() == 0) {
			try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/types.json")) {
				TypesRecord all = objectMapper.readValue(inputStream, TypesRecord.class);
                log.info("Reading {} runs from Type JSON data and saving to in-memory collection.", all.types().size());
                this.typeRepository.saveAll(all.types());
			} catch (IOException e) {
				throw new RuntimeException("Failed to read JSON data", e);
			}
		} else {
			log.info("Not loading Runs from JSON data because the collection contains data.");
		}
	}
}