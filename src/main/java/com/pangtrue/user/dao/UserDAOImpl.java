package com.pangtrue.user.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pangtrue.user.model.LoginDTO;
import com.pangtrue.user.model.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String NAMESPACE = "com.pangtrue.mappers.user.UserMapper";
    private final SqlSession sqlSession;
    
    @Autowired
    public UserDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    @Override
    public UserVO read(String id) {
        UserVO user = sqlSession.selectOne(NAMESPACE + ".selectUserById", id);
        return user;
    }
    
    @Override
    public UserVO insert(UserVO user) {
        sqlSession.update(NAMESPACE + ".insertUser", user);
        return user;
    }
    
    // 로그인 처리
    @Override
    public UserVO login(LoginDTO loginDTO) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".login", loginDTO);
    }
    
    // 로그인 유지 처리
    @Override
    public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("sessionId", sessionId);
        paramMap.put("sessionLimit", sessionLimit);

        sqlSession.update(NAMESPACE + ".keepLogin", paramMap);
    }
    
    // 세션키 검증
    @Override
    public UserVO checkUserWithSessionKey(String value) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey", value);
    }
    
    @Override
    public void register(UserVO userVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".register", userVO);
    }
    
    @Override
    public String getUserPw(String userId) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".getUserPw", userId);
    }
    
    @Override
    public void userInfoUpdate(UserVO userVO) throws Exception {
        sqlSession.update(NAMESPACE + ".userInfoUpdate", userVO);
    }
    
    @Override
    public void userPwUpdate(String userId, String newUserPw) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("newUserPw", newUserPw);
        sqlSession.update(NAMESPACE + ".userPwUpdate", paramMap);
    }
    
    @Override
    public void userImgUpdate(String userId, String userImg) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("userImg", userImg);
        sqlSession.update(NAMESPACE + ".userImgUpdate", paramMap);
    }
}
