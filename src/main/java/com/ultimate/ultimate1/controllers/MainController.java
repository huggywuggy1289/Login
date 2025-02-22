package com.ultimate.ultimate1.controllers;

import com.ultimate.ultimate1.services.LoggedUserManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
// 로그인 성공하였을 경우 뜨는 페이지 반환
@Controller
 class MainController {
    private final LoggedUserManagementService loggedUserManagementService;

    public MainController(LoggedUserManagementService loggedUserManagementService){
        this.loggedUserManagementService = loggedUserManagementService;
    }
    @GetMapping("/main")
    public String home(@RequestParam(required = false) String logout, Model model){
        // logout 매개변수가 있다면 LoggedUserManagementService 빈에서 username을 삭제한다.
        if(logout != null){
            loggedUserManagementService.setUsername(null);
        }
        String username = loggedUserManagementService.getUsername();

        if(username == null){
            return "redirect:/";
        }

        model.addAttribute("username", username);
        return "main.html";
    }

}
