package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "Hello World";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
