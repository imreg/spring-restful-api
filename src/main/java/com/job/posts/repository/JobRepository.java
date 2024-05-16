package com.job.posts.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.job.posts.repository.interfaces.JobRepositoryInterface;
import com.job.posts.repository.records.JobRecord;

@Repository
public class JobRepository implements JobRepositoryInterface {
	private static final Logger log = LoggerFactory.getLogger(CompanyRepository.class);
	private List<JobRecord> type = new ArrayList<>();
	private JdbcClient jdbcClient;

	public JobRepository(final JdbcClient jdbcClient) {
		this.jdbcClient = jdbcClient;
	}
	
	@Override
	public List<JobRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<JobRecord> findById(Integer id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void add(JobRecord type) {
		var created = this.jdbcClient.sql("INSERT INTO Job (title, type_id, location, description, salary, company_id) VALUES (:title, :type, :location, :description, :salary, :company)")		
				.param("title", type.title())
				.param("type", type.typeId())
				.param("location", type.location())
				.param("description", type.description())
				.param("salary", type.salary())
				.param("company", type.companyId())
				.update();
		
		Assert.state(created == 1, "Failed to create tyre " + type.title());		
	}

	@Override
	public void update(JobRecord type, Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return jdbcClient.sql("SELECT * FROM Job").query().listOfRows().size();
	}

	@Override
	public void saveAll(List<JobRecord> type) {
		// TODO Auto-generated method stub
		type.stream().forEach(this::add);
	}

}
