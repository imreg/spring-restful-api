package com.job.posts.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.job.posts.entity.Type;
import com.job.posts.repository.interfaces.TypeJpaRepositoryInterface;

@Service
public class TypeService {

    private final TypeJpaRepositoryInterface typeRepository;

    public TypeService(TypeJpaRepositoryInterface typeRepository) {
        this.typeRepository = typeRepository;
    }
    
	public Long count() {
		return this.typeRepository.count();
	}
   
    public void save(Type type) {
    	typeRepository.save(type);
	}
       
	public void saveAll(List<Type> type) {
		type.stream().forEach(this::save);
	}
}
