package com.pangtrue.article.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pangtrue.article.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
    
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    
    @Autowired
    private ArticleService articleService;
    
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    @GetMapping("/write")
    public String write() {
        logger.info("normal write() called...");
        return "article/normal/write"; // View 이름 반환
    }
}
