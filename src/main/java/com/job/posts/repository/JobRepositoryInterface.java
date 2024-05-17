package com.job.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.posts.entity.Job;

public interface JobRepositoryInterface extends JpaRepository<Job, Long> {

}
