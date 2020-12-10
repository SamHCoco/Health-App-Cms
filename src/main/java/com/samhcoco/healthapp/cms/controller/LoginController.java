package com.samhcoco.healthapp.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller("login")
public class LoginController {

    @GetMapping
    public String getLogin(Model model) {
        return "login";
    }

    @PostMapping
    public String login(Model model) {
        return "index";
    }

}
