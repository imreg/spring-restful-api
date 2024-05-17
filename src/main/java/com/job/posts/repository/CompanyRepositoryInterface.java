package com.job.posts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.posts.entity.Company;

public interface CompanyRepositoryInterface extends JpaRepository<Company, Long> {

}
