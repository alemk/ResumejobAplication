package com.example.demo;

import com.example.demo.repository.ApplicantRepository;
import com.example.demo.repository.EducationRepository;
import com.example.demo.repository.ExperianceRepository;
import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ApplicationController {
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperianceRepository experianceRepository;

    @Autowired
    SkillRepository skillRepository;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping("/")
    public String application(Model model){
        model.addAttribute("applicant", new Applicant());
        return  "addapplicant";
    }
    @PostMapping("/addapplicant")
    public String addapplicant(@Valid Applicant applicant, BindingResult result){
        if(result.hasErrors()){
            return "addapplicant";
        }
        applicantRepository.save(applicant);
        return "redirect:/addachivement";
    }
    @RequestMapping("/addachivement")
    public String addachivement(Model model){
        model.addAttribute("achivement", new EducationAchivement());
        return "addachivement";
    }
    @PostMapping("/addachivement")
    public String addachivement(@Valid EducationAchivement educationAchivement, BindingResult result){
        if(result.hasErrors()){
            return "addachivement";
        }
        educationRepository.save(educationAchivement);
        return "redirect:/addexperiance";
    }
    @RequestMapping("/addexperiance")
    public String addexperiance(Model model){
        model.addAttribute("experiance" , new Experiance());
        return "addexperiance";
    }
    @PostMapping("/addexperiance")
    public String addexperiance(@Valid Experiance experiance, BindingResult result){
        if(result.hasErrors()){
            return "addexperiance";
        }
        experianceRepository.save(experiance);
        return "redirect:/addskill";
    }
    @RequestMapping("/addskill")
    public String addskill(Model model){
        model.addAttribute("skills", new Skill());
        return "addskill";
    }

    @PostMapping("/addskill")
    public String addskill(@Valid Skill skill , BindingResult result){

        if(result.hasErrors()){
            return "addskill";
        }
        skillRepository.save(skill);
        return "redirect:/resumesummary";
    }

    @RequestMapping("/resumesummary")
    public String displayresume(Model model){
        model.addAttribute("applicants", applicantRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("experiences",experianceRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        return "resumesummary";
    }
}

