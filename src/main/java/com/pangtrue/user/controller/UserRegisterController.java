package com.pangtrue.user.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;
import javax.validation.Valid;

import com.pangtrue.user.model.UserVO;
import com.pangtrue.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegisterController {

    private final UserService userService;
    
    @Inject
    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }
    
    // 회원가입 페이지
    @GetMapping("/register")
    public String registerGET() throws Exception {
        return "/user/register";
    }
    
    // 회원가입 처리
    @PostMapping("/register")
    public String registerPOST(@Valid UserVO userVO, Errors errors, RedirectAttributes redirectAttributes) throws Exception {
        String hashedPassword = BCrypt.hashpw(userVO.getUserPassword(), BCrypt.gensalt()); // 비밀번호 해싱
        userVO.setUserPassword(hashedPassword);
        
        userService.register(userVO);
        redirectAttributes.addFlashAttribute("msg", "REGISTERED");
        
        return "redirect:/user/login";
    }
    
    // 회원 탈퇴 처리
    @PostMapping("/withdrawal")
    public String userWithdraw(String userId, String userPw, RedirectAttributes redirectAttributes) throws Exception {
        // TODO
        
        return "redirect:/user/login";
    }
}
