package com.pangtrue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pangtrue.spring.DuplicateMemberException;
import com.pangtrue.spring.MemberRegisterService;
import com.pangtrue.spring.RegisterRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {
    
    private MemberRegisterService memberRegisterService;
    
    public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
        this.memberRegisterService = memberRegisterService;
    }

    @RequestMapping("/step1")
    public String handleStep1() {
        return "register/step1"; // 컨트롤러가 리턴하는건 해당 컨트롤러와 대응되는 뷰 객체
    }

    // @RequestParam 애노테이션을 이용해 요청 파라미터에 접근할 수 있다.
    // 아래 코드는 agree 요청 파라미터의 값을 읽어와 agree 매개변수에 할당한다.
    @PostMapping("/step2")
    public String handleStep2(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
        if (!agree) {
            return "register/step1";
        }
        return "register/step2";
    }
    
    @PostMapping("/step3")
    public String handleStep3(RegisterRequest regReq) {
        try {
            memberRegisterService.regist(regReq);
            return "register/step3";
        } catch (DuplicateMemberException ex) {
            return "register/step2";
        }
    }
}
