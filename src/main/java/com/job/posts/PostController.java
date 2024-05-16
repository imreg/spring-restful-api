package com.job.posts;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.posts.entity.Job;
import com.job.posts.repository.interfaces.JobJpaRepositoryInterface;

@RestController
@RequestMapping("/api")
public class PostController {
		
	private JobJpaRepositoryInterface jobRepository;
	
	public PostController(JobJpaRepositoryInterface jobRepository) {
		// TODO Auto-generated constructor stub
		this.jobRepository = jobRepository;
	}
	
	@GetMapping ("/jobs")
	public List<Job> findAll() {
		return this.jobRepository.findAll();
	}
}
