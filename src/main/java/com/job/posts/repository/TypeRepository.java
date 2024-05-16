package com.job.posts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.job.posts.repository.interfaces.TypeRepositoryInterface;
import com.job.posts.repository.records.TypeRecord;

@Repository
public class TypeRepository implements TypeRepositoryInterface{
	private static final Logger log = LoggerFactory.getLogger(TypeRepository.class);
	private List<TypeRecord> type = new ArrayList<>();
	private JdbcClient jdbcClient;

	public TypeRepository(final JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}	
	
	@Override
	public List<TypeRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<TypeRecord> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void add(TypeRecord type) {
		var created = this.jdbcClient.sql("INSERT INTO Type (title) VALUES (:title)")		
				.param("title", type.title())
				.update();
		
		Assert.state(created == 1, "Failed to create tyre " + type.title());		
	}

	@Override
	public void update(TypeRecord type, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return jdbcClient.sql("SELECT * FROM Type").query().listOfRows().size();
	}

	@Override
	public void saveAll(List<TypeRecord> type) {
		// TODO Auto-generated method stub
		type.stream().forEach(this::add);
	}
}
