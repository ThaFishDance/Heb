package com.tcb.homedepot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        String n = "home";
        n = "home";
        n = "Christmas";
        n = "Christmas";
        return "index.html";
    }
}
