package com.pangtrue.article.service;

import java.util.List;

import com.pangtrue.article.model.Article;

public interface ArticleService {

    void create(Article article) throws Exception;
    
    Article read(Integer articleNo) throws Exception;
    
    void update(Article article) throws Exception;
    
    void delete(Integer articleNo) throws Exception;
    
    List<Article> listAll() throws Exception;
    
    int countArticles() throws Exception;
    
    List<Article> listSearch() throws Exception;
    
    int countSearchedArticles() throws Exception;
}
