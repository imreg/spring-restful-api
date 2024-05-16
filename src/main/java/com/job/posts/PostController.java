package com.job.posts;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.posts.repository.interfaces.TypeJpaRepositoryInterface;

@RestController
@RequestMapping("/api")
public class PostController {
	
	TypeJpaRepositoryInterface jpaRepositoryInterface;
	public PostController(TypeJpaRepositoryInterface jpaRepositoryInterface) {
		// TODO Auto-generated constructor stub
		this.jpaRepositoryInterface = jpaRepositoryInterface;
	}
	@GetMapping ("/hello")
	public String home() {
		return "Hello Worldb";
	}
}
