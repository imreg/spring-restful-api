package com.job.posts.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.job.posts.entity.Job;
import com.job.posts.service.JobService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

	private final JobService jobService;
	
	public PostController(
			JobService jobService
			) {
		this.jobService = jobService;
	}
	
	@GetMapping ("/jobs")
	public List<Job> findAll() {
		return this.jobService.findAll();
	}

	@GetMapping ("/jobs/{id}")
	public Optional<Job> findById(@PathVariable Long id) {
		return this.jobService.findById(id);
	}
		
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping ("/jobs")
	public Job add(@RequestBody Job job) {
		return this.jobService.saveNewJob(job);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT) 
	@PutMapping ("/jobs/{id}")
	public ResponseEntity<Map<String, String>> update(@RequestBody Job job, @PathVariable Long id) {
		return this.jobService.update(job, id);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT) 
	@DeleteMapping ("/jobs/{id}")
	public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        return this.jobService.delete(id);
    }
}
