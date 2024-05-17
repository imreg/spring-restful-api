package com.job.posts.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.posts.entity.Job;

public interface JobJpaRepositoryInterface extends JpaRepository<Job, Long> {

}
