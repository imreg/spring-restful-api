package com.job.posts.repository.interfaces;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.job.posts.entity.Type;

public interface TypeJpaRepositoryInterface extends JpaRepository<Type, Long> {
    // Define repository methods
}