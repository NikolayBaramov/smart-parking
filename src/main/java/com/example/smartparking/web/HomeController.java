package com.example.smartparking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/availability")
    public String availability() {
        return "availability";
    }

}
