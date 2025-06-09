package com.tcb.heb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }

    @RequestMapping("/sayHello")
    public String hello(){
        return "index.html";
    }
}
