package com.pangtrue.user.service;

import com.pangtrue.user.model.LoginDTO;
import com.pangtrue.user.model.User;

public interface UserService {

    User login(LoginDTO loginDTO) throws Exception;
    
    
}
