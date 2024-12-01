package com.example.crowdfunding.service;

import com.example.crowdfunding.repository.ContributionRepository;
import org.springframework.stereotype.Service;

@Service
public class ContributionService {

    private ContributionRepository contributionRepository;

    public ContributionService(ContributionRepository contributionRepository) {
        this.contributionRepository = contributionRepository;
    }
}
