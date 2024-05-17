package com.job.posts.feed.wrappers;

import java.util.List;
import com.job.posts.entity.Company;

public class CompaniesWrapper {
    private List<Company> companies;

    public List<Company> getCompanies() {
        return companies;
    }

    public void seCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
