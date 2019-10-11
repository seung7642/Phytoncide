package com.pangtrue.article.service;

import java.util.List;

import com.pangtrue.article.model.ArticleVO;

public interface ArticleService {

    void create(ArticleVO articleVO) throws Exception;
    
    ArticleVO read(Integer articleNo) throws Exception;
    
    void update(ArticleVO articleVO) throws Exception;
    
    void delete(Integer articleNo) throws Exception;
    
    List<ArticleVO> listAll() throws Exception;
    
    int countArticles() throws Exception;
    
    List<ArticleVO> listSearch() throws Exception;
    
    int countSearchedArticles() throws Exception;
}
