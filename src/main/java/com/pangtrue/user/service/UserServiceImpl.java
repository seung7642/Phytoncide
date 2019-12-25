package com.pangtrue.user.service;

import java.util.Date;

import org.mindrot.jbcrypt.BCrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pangtrue.user.dao.UserDAO;
import com.pangtrue.user.model.LoginDTO;
import com.pangtrue.user.model.UserVO;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        logger.info("==로그인 요청==");
        return userDAO.login(loginDTO);
    }

    @Override
    public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
        userDAO.keepLogin(userId, sessionId, sessionLimit);
    }

    @Override
    public UserVO checkLoginBefore(String value) throws Exception {
        return userDAO.checkUserWithSessionKey(value);
    }

    @Override
    public void register(UserVO userVO) throws Exception {
        userDAO.register(userVO);
    }

    @Override
    public boolean isValidUserPw(String userId, String userPw) throws Exception {
        String hashedUserPw = userDAO.getUserPw(userId);

        return BCrypt.checkpw(userPw, hashedUserPw);
    }

    @Override
    public void userInfoModify(UserVO userVO) throws Exception {
        userDAO.userInfoUpdate(userVO);
    }

    @Override
    public void userPwModify(String userId, String newUserPw) throws Exception {
        userDAO.userPwUpdate(userId, newUserPw);
    }

    @Override
    public void userImgModify(String userId, String userImg) throws Exception {
        userDAO.userImgUpdate(userId, userImg);
    }
}
