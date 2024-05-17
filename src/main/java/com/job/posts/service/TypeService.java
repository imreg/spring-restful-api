package com.job.posts.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.job.posts.entity.Type;
import com.job.posts.repository.TypeRepositoryInterface;

@Service
public class TypeService {

    private final TypeRepositoryInterface typeRepository;

    public TypeService(TypeRepositoryInterface typeRepository) {
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
