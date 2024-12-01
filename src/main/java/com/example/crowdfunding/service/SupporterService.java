package com.example.crowdfunding.service;

import com.example.crowdfunding.entities.Project;
import com.example.crowdfunding.entities.Supporter;
import com.example.crowdfunding.repository.ProjectRepository;
import com.example.crowdfunding.repository.SupporterRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupporterService {

    private SupporterRepository supporterRepository;
//    private ProjectService projectService;

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

    @Transactional
    public Supporter getSupporter(Integer supporterId){
        return supporterRepository.findById(supporterId).get();
    }

//    @Transactional
//    public void updateProjectList(Integer project_id, Integer supporter_id){
//        Project pro = projectService.getProject(project_id);
//        Supporter sup = getSupporter(supporter_id);
//        sup.addProject(pro);
//        pro.addSupporter(sup);
//        saveSupporter(sup);
//        projectService.saveProject(pro);
//    }


}
