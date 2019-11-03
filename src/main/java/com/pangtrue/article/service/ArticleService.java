package com.pangtrue.article.service;

import java.util.List;

import com.pangtrue.article.model.ArticleVO;
import com.pangtrue.commons.paging.Criteria;
import com.pangtrue.commons.paging.SearchCriteria;

public interface ArticleService {

    void create(ArticleVO articleVO) throws Exception;
    
    ArticleVO read(Integer articleNo) throws Exception;
    
    void update(ArticleVO articleVO) throws Exception;
    
    void delete(Integer articleNo) throws Exception;
    
    List<ArticleVO> listAll() throws Exception;
    
    int countArticles(Criteria criteria) throws Exception;
    
    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;
    
    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;
}
