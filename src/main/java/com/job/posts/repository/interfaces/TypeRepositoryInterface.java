package com.job.posts.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.job.posts.repository.records.TypeRecord;

public interface TypeRepositoryInterface {
	public List<TypeRecord> findAll();
	
	public Optional<TypeRecord> findById(Integer id);
	
	public void add(TypeRecord type);
	
	public void update(TypeRecord type, Integer id);
	
	public void delete(Integer id);

	public Integer count();
	
	public void saveAll(List<TypeRecord> type);
}
