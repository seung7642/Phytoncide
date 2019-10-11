package com.pangtrue.article.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.pangtrue.article.dao.ArticleDAO;
import com.pangtrue.article.model.ArticleVO;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDAO articleDAO;
//    private fianl ArticleFileDAO articleFileDAO;
    
    @Autowired
    public ArticleServiceImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }
    
    @Transactional
    @Override
    public void create(ArticleVO articleVO) throws Exception {
        articleDAO.create(articleVO);
        
        // TODO: 파일업로드 처리 로직
    }
    
    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public ArticleVO read(Integer articleNo) throws Exception {
        articleDAO.updateViewCnt(articleNo);
        return articleDAO.read(articleNo);
    }
    
    @Transactional
    @Override
    public void update(ArticleVO articleVO) throws Exception {
        articleDAO.update(articleVO);
        
        // TODO: 파일업로드 처리 로직
    }
    
    @Transactional
    @Override
    public void delete(Integer articleNo) throws Exception {
        articleDAO.delete(articleNo);
    }
    
    @Override
    public List<ArticleVO> listAll() throws Exception {
        return articleDAO.listAll();
    }
    
    @Override
    public int countArticles() throws Exception {

    }
    
    @Override
    public List<ArticleVO> listSearch() throws Exception {
        
    }
    
    @Override
    public int countSearchedArticles() throws Exception {
        
    }
}
