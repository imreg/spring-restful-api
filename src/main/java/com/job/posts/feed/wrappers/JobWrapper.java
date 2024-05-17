package com.job.posts.feed.wrappers;

import java.util.List;

import com.job.posts.entity.Job;

public class JobWrapper {
    private List<Job> jobs;

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
}
