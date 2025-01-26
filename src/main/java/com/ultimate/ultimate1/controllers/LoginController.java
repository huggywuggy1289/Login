package com.ultimate.ultimate1.controllers;

import com.ultimate.ultimate1.model.LoginProcessor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor;

    public LoginController(LoginProcessor loginProcessor) {
        this.loginProcessor = loginProcessor;
    }
    @GetMapping("/")
    public String loginGet(){
        return "login";
    }
    @PostMapping
    public String loginPost(@RequestParam String username, @RequestParam String password, Model model){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login(); // 나중에 로그인 로직을 구현할때 이 변수에 로그인 결과가 저장됨

        if(loggedIn){
            model.addAttribute("message", "You are now logged in");
        }else {
            model.addAttribute("message", "Login failed!");
        }

        return "login";
    }
}
