package com.job.posts.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.posts.entity.Company;
import com.job.posts.entity.Job;
import com.job.posts.entity.Type;
import com.job.posts.repository.CompanyRepositoryInterface;
import com.job.posts.repository.JobRepositoryInterface;
import com.job.posts.repository.TypeRepositoryInterface;

@Service
public class JobService {

    private final JobRepositoryInterface jobRepository;
    private final CompanyRepositoryInterface companyRepository;
    private final TypeRepositoryInterface typeRepository;

    public JobService(
    		JobRepositoryInterface jobRepository, 
    		CompanyRepositoryInterface companyRepository,
    		TypeRepositoryInterface typeRepository
    		) {
        this.jobRepository = jobRepository;
        this.companyRepository = companyRepository;
        this.typeRepository = typeRepository;
    }

    public List<Job> findAll() {
		return this.jobRepository.findAll();
    }
    
    public Optional<Job> findById(Long id) {
		return this.jobRepository.findById(id);
	}
        
    public Job saveNewJob(Job job) {
        Optional<Type> optionalType = this.typeRepository.findById(job.getType().getId());
        
        Type type = optionalType.orElse(null);
        
        Company company = null;        
        company = companyRepository.save(job.getCompany());
        
        job.setType(type);
        job.setCompany(company);

        // Save the job entity
        return jobRepository.save(job);
    }
    
	public ResponseEntity<Map<String, String>> update(Job job, Long id) {
		// Retrieve the existing job entity from the database
        Optional<Job> optionalJob = jobRepository.findById(id);
        if (optionalJob.isPresent()) {
            Job existingJob = optionalJob.get();

            // Update the fields of the existing job entity with the values from the updated job
            existingJob.setTitle(job.getTitle());
            existingJob.setLocation(job.getLocation());
            existingJob.setDescription(job.getDescription());
            existingJob.setSalary(job.getSalary());

            if (job.getType() != null) {
                Optional<Type> optionalType = typeRepository.findById(job.getType().getId());
                optionalType.ifPresent(existingJob::setType);
            }
            if (job.getCompany() != null) {
                Optional<Company> optionalCompany = companyRepository.findById(job.getCompany().getId());
                optionalCompany.ifPresent(existingJob::setCompany);
            }

            jobRepository.save(existingJob);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Job with id " + id + " updated successfully");
            return ResponseEntity.ok(response);
        } else {
        	Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Job with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
	}
	
	public ResponseEntity<Map<String, String>> delete(Long id) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job = jobOptional.get();
            jobRepository.delete(job);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Job with id " + id + " deleted successfully");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Job with id " + id + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
	
	public Long count() {
		return this.jobRepository.count();
	}
   
    public void save(Job job) {
        Optional<Type> optionalType = this.typeRepository.findById(job.getType().getId());
        Optional<Company> optionalCompany = this.companyRepository.findById(job.getType().getId());
        
        Type type = optionalType.orElse(null);       
        Company company = optionalCompany.orElse(null);        
        
        job.setType(type);
        job.setCompany(company);
    	this.jobRepository.save(job);
	}
       
	public void saveAll(List<Job> job) {
		job.stream().forEach(this::save);
	}
}