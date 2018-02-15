package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {
    @RequestMapping("/")
    public String application(){
        return "index";
    }
    @RequestMapping("applicant")
    public String addapplicant(){
        return  "addpalicant";
    }
    @RequestMapping("/addachivement")
    public String addachivement(){
        return "addachivement";
    }
    @RequestMapping("/addexperiance")
    public String addexperiance(){
        return "addexperiance";
    }
    @RequestMapping("/addskill")
    public String addskill(){
        return "addskill";
    }
}
