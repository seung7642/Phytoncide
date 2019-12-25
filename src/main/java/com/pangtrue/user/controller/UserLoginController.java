package com.pangtrue.user.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import com.pangtrue.user.model.LoginDTO;
import com.pangtrue.user.model.UserVO;
import com.pangtrue.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {

    private UserService userService;
    
    @Inject
    public UserLoginController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/login")
    public String loginGET(@ModelAttribute("loginDTO") LoginDTO loginDTO) {
        return "/user/login";
    }
    
    @PostMapping("/login")
    public String loginPOST(@Valid LoginDTO loginDTO, Errors errors, HttpSession httpSession, Model model) throws Exception {
        UserVO userVO = userService.login(loginDTO);
        if (userVO == null || !BCrypt.checkpw(loginDTO.getUserPassword(), userVO.getUserPassword())) {
            return null;
        }
        
        model.addAttribute("user", userVO);
        
        if (loginDTO.isUseCookie()) {
            int amount = 60 * 60 * 24 * 7;
            Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));
            userService.keepLogin(userVO.getUserEmail(), httpSession.getId(), sessionLimit); // 세션 만기날짜 설정
        }
        
        return "redirect:/erp";
    }
    
    @PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception {
        Object obj = httpSession.getAttribute("login");
        if (obj != null) {
            UserVO userVO = (UserVO) obj;
            httpSession.removeAttribute("login");
            httpSession.invalidate();
            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
            if (loginCookie != null) {
                loginCookie.setPath("/");
                loginCookie.setMaxAge(0);
                response.addCookie(loginCookie);
                userService.keepLogin(userVO.getUserEmail(), "none", new Date());
            }
        }

        return "redirect:/erp/user/login";
    }
}
