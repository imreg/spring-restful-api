package com.job.posts.repository.records;

public record CompanyRecord(
		Integer id,
		String name,
		String description,
		String email,
		String phone
		) {
}
