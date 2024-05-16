package com.job.posts.repository.records;

import jakarta.validation.constraints.NotEmpty;

public record JobRecord(
		Integer id,
		@NotEmpty
		String title,
		@NotEmpty
		Integer typeId,
		String location,
		String description,
		String salary,
		@NotEmpty
		Integer companyId
		) {
}