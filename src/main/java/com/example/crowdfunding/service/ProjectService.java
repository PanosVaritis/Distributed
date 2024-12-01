package com.example.crowdfunding.service;

import com.example.crowdfunding.entities.Project;
import com.example.crowdfunding.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Transactional
    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    @Transactional
    public void saveProject (Project project){
        projectRepository.save(project);
    }

    @Transactional
    public Project getProject(Integer projectId){
        return projectRepository.findById(projectId).get();
    }

    @Transactional
    public void updateAmount(Integer projectId, double amount){
        Project pro = projectRepository.findById(projectId).get();
        pro.addAmount(amount);
        projectRepository.save(pro);
    }

}
