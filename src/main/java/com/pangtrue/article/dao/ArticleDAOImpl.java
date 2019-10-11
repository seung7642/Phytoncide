package com.pangtrue.article.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.pangtrue.article.model.ArticleVO;

public class ArticleDAOImpl implements ArticleDAO {

    private static final String NAMESPACE = "com.pangtrue.erp.mappers.article.ArticleMapper";
    
    private final SqlSession sqlSession;
    
    @Autowired
    public ArticleDAOImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    @Override
    public void create(ArticleVO articleVO) throws Exception {
        sqlSession.insert(NAMESPACE + ".create", articleVO);
    }

    @Override
    public ArticleVO read(Integer articleNo) throws Exception {
        return sqlSession.selectOne(NAMESPACE + ".read", articleNo);
    }

    @Override
    public void update(ArticleVO articleVO) throws Exception {
        sqlSession.update(NAMESPACE + ".update", articleVO);
    }

    @Override
    public void delete(Integer articleNo) throws Exception {
        sqlSession.delete(NAMESPACE + ".delete", articleNo);
    }

    @Override
    public List<ArticleVO> listAll() throws Exception {
        return sqlSession.selectList(NAMESPACE + ".listAll");
    }

    @Override
    public List<ArticleVO> listPaging(int page) throws Exception {
        if (page <= 0) page = 1;
        
        page = (page - 1) * 10;
        
        return sqlSession.selectList(NAMESPACE + ".listPaging", page);
    }

//    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;
//
//    int countArticles(Criteria criteria) throws Exception;
//
//    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
//
//    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;

    @Override
    public void updateReplyCnt(Integer articleNo, int amount) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("articleNo", articleNo);
        paramMap.put("amount", amount);
        
        sqlSession.update(NAMESPACE + ".updateReplyCnt", paramMap);
    }

    @Override
    public void updateViewCnt(Integer articleNo) throws Exception {
        sqlSession.update(NAMESPACE + ".updateViewCnt", articleNo);
    }
}