package com.job.posts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.job.posts.repository.interfaces.CompanyRepositoryInterface;
import com.job.posts.repository.records.CompanyRecord;

@Repository
public class CompanyRepository implements CompanyRepositoryInterface{
	private static final Logger log = LoggerFactory.getLogger(CompanyRepository.class);
	private List<CompanyRecord> type = new ArrayList<>();
	private JdbcClient jdbcClient;

	public CompanyRepository(final JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}	

	@Override
	public List<CompanyRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<CompanyRecord> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void add(CompanyRecord type) {
		var created = this.jdbcClient.sql("INSERT INTO Company (name,description,email,phone) VALUES (:name,:description,:email,:phone)")		
				.param("name", type.name())
				.param("description", type.description())
				.param("email", type.email())
				.param("phone", type.phone())
				.update();
		
		Assert.state(created == 1, "Failed to create tyre " + type.name());
	}

	@Override
	public void update(CompanyRecord type, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return jdbcClient.sql("SELECT * FROM Company").query().listOfRows().size();
	}

	@Override
	public void saveAll(List<CompanyRecord> type) {
		// TODO Auto-generated method stub
		type.stream().forEach(this::add);		
	}

}
