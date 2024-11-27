package com.example.crowdfunding.service;

import com.example.crowdfunding.entities.Supporter;
import com.example.crowdfunding.repository.SupporterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupporterService {

    private SupporterRepository supporterRepository;

    public SupporterService(SupporterRepository supporterRepository) {
        this.supporterRepository = supporterRepository;
    }


    @Transactional
    public List<Supporter> getSupporters(){
        return supporterRepository.findAll();
    }

    @Transactional
    public void saveSupporter (Supporter supporter){
        supporterRepository.save(supporter);
    }


}
