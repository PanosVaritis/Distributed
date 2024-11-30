package com.example.crowdfunding.controller;


import com.example.crowdfunding.entities.Project;
import com.example.crowdfunding.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("")
    public String showProjects(Model model){
        model.addAttribute("listProjects", projectService.getProjects());
        return "project/project";
    }


    @GetMapping("/new")
    public String addProject(Model model){
        Project pro = new Project();
        model.addAttribute("emptyProject", pro);
        return "project/project_form";
    }

    @PostMapping("/new")
    public String saveProject (@ModelAttribute("pro") Project project, Model model){
        System.out.println ("List of projects before: "+projectService.getProjects());
        projectService.saveProject(project);
        System.out.println ("List of projects after: "+projectService.getProjects());
        model.addAttribute("listProjects", projectService.getProjects());
        return "project/project";
    }

    @GetMapping("/details/{id}")
    public String projectDetails (@PathVariable Integer id, Model model){

        model.addAttribute("project", projectService.getProject(id));
        return "project/project_details";
    }


    @PostMapping("/support/{id}")
    public String supportProject (@PathVariable Integer id,Model model){

        model.addAttribute("project", projectService.getProject(id));
        return "project/project_support_form";
    }


}
