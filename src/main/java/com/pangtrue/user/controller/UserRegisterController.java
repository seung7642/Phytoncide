package com.pangtrue.user.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.inject.Inject;

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
    public String registerPOST(UserVO userVO, RedirectAttributes redirectAttributes) throws Exception {
        String hashedPw = BCrypt.hashpw(userVO.getUserPw(), BCrypt.gensalt());
        userVO.setUserPw(hashedPw);
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
