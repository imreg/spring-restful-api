package com.job.posts.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.posts.entity.Company;

public interface CompanyJpaRepositoryInterface extends JpaRepository<Company, Long> {

}
