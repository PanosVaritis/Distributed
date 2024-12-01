package com.example.crowdfunding.controller;


import com.example.crowdfunding.entities.Project;
import com.example.crowdfunding.entities.Supporter;
import com.example.crowdfunding.service.ProjectService;
import com.example.crowdfunding.service.SupporterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private ProjectService projectService;
    private SupporterService supporterService;

    public ProjectController(ProjectService projectService, SupporterService supporterService) {
        this.projectService = projectService;
        this.supporterService = supporterService;
    }

    @GetMapping("")
    public String showProjects(Model model) {
        model.addAttribute("listProjects", projectService.getProjects());
        return "project/project";
    }


    @GetMapping("/new")
    public String addProject(Model model) {
        Project pro = new Project();
        model.addAttribute("emptyProject", pro);
        return "project/project_form";
    }

    @PostMapping("/new")
    public String saveProject(@ModelAttribute("pro") Project project, Model model) {
        System.out.println("List of projects before: " + projectService.getProjects());
        projectService.saveProject(project);
        System.out.println("List of projects after: " + projectService.getProjects());
        model.addAttribute("listProjects", projectService.getProjects());
        return "project/project";
    }

    @GetMapping("/details/{id}")
    public String projectDetails(@PathVariable Integer id, Model model) {
        model.addAttribute("supList", supporterService.getSupporters());
        model.addAttribute("project", projectService.getProject(id));
        return "project/project_details";
    }


    @PostMapping("/support/{id}")
    public String supportProject(@PathVariable Integer id, @RequestParam("amount") double amount, @RequestParam("supId") Integer supId
            , Model model) {

        System.out.println ("The amount is: "+amount);
        System.out.println ("The project id is: "+id);
        System.out.println ("The supporter id is: "+supId);
        //adding the amount to the total
        projectService.updateAmount(id, amount);
        //adding the project to the supporter list
        Supporter sup = supporterService.getSupporter(supId);
        sup.addProject(projectService.getProject(id));
        supporterService.saveSupporter(sup);
        //adding the supporter to the project list
        Project pro = projectService.getProject(id);
        pro.addSupporter(sup);
        projectService.saveProject(pro);
//        supporterService.updateProjectList(id, supId);
//        model.addAttribute("listProjects", projectService.getProjects());
        return "project/project";
    }





}
