package com.job.posts.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.job.posts.repository.records.JobRecord;

public interface JobRepositoryInterface {
	public List<JobRecord> findAll();
	
	public Optional<JobRecord> findById(Integer id);
	
	public void add(JobRecord type);
	
	public void update(JobRecord type, Integer id);
	
	public void delete(Integer id);

	public Integer count();
	
	public void saveAll(List<JobRecord> type);
}
