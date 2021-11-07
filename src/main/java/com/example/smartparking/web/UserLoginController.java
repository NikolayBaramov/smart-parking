package com.example.smartparking.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserLoginController {

    @GetMapping("/users/login")
    public String getLogin(){
        return "login";
    }



}
