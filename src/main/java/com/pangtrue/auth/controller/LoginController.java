package com.pangtrue.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public void loginPage() { // GET 요청이라면 로그인 페이지를 반환
        
    }
    
    @PostMapping("/login")
    public void login() { // POST 요청이라면 (아이디, 패스워드)를 DB값과 비교
        
    }
}
