package com.pangtrue.commons.interceptor;

import javax.inject.Inject;

import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.pangtrue.user.service.UserService;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);
    private final UserService userService;
    
    @Inject
    public AuthInterceptor(UserService userService) {
        this.userService = userService;
    }
    
    
}
