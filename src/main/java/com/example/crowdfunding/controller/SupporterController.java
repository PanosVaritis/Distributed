package com.example.crowdfunding.controller;

import com.example.crowdfunding.entities.Supporter;
import com.example.crowdfunding.service.SupporterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/supporter")
public class SupporterController {


    private SupporterService supporterService;

    public SupporterController(SupporterService supporterService) {
        this.supporterService = supporterService;
    }

    @GetMapping("")
    public String showSupporters(Model model){
        model.addAttribute("supporters", supporterService.getSupporters());
        return "supporter/supporter";
    }


    @GetMapping("/new")
    public String addSupporter(Model model){
        Supporter sup = new Supporter();
        model.addAttribute("emptySup", sup);
        return "supporter/supporter_form";
    }

    @PostMapping("/new")
    public String saveSupporter(@ModelAttribute("sup") Supporter newSup, Model model){
        System.out.println ("Supporters before: "+supporterService.getSupporters());
        supporterService.saveSupporter(newSup);
        System.out.println ("Supporters after: "+supporterService.getSupporters());
        model.addAttribute("supporters", supporterService.getSupporters());
        return "supporter/supporter";
    }

}
