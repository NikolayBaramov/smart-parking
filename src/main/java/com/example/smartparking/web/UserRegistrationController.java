package com.example.smartparking.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRegistrationController {



    @GetMapping("/users/register")
    public String registerUser() {
        return "register";
    }

}
