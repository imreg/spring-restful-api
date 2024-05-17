package com.job.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.posts.entity.Type;

public interface TypeRepositoryInterface extends JpaRepository<Type, Long> {
    // Define repository methods
}