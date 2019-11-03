package com.pangtrue.article.dao;

import java.util.List;

import com.pangtrue.article.model.ArticleVO;
import com.pangtrue.commons.paging.Criteria;
import com.pangtrue.commons.paging.SearchCriteria;

public interface ArticleDAO {

    void create(ArticleVO articleVO) throws Exception;

    ArticleVO read(Integer articleNo) throws Exception;

    void update(ArticleVO articleVO) throws Exception;

    void delete(Integer articleNo) throws Exception;

    List<ArticleVO> listAll() throws Exception;

    List<ArticleVO> listPaging(int page) throws Exception;

    List<ArticleVO> listCriteria(Criteria criteria) throws Exception;

    int countArticles(Criteria criteria) throws Exception;

    List<ArticleVO> listSearch(SearchCriteria searchCriteria) throws Exception;

    int countSearchedArticles(SearchCriteria searchCriteria) throws Exception;

    void updateReplyCnt(Integer articleNo, int amount) throws Exception;

    void updateViewCnt(Integer articleNo) throws Exception;
}
