package com.job.posts.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.job.posts.repository.records.CompanyRecord;
import com.job.posts.repository.records.TypeRecord;

public interface CompanyRepositoryInterface {
	public List<CompanyRecord> findAll();
	
	public Optional<CompanyRecord> findById(Integer id);
	
	public void add(CompanyRecord type);
	
	public void update(CompanyRecord type, Integer id);
	
	public void delete(Integer id);

	public Integer count();
	
	public void saveAll(List<CompanyRecord> type);
}
