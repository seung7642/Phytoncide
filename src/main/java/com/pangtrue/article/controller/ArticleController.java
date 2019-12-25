package com.pangtrue.article.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pangtrue.article.model.ArticleVO;
import com.pangtrue.article.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
    
    private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
    private ArticleService articleService;
    
    @Inject
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }
    
    @GetMapping("/write")
    public String writeGet() {
        logger.info("Article#writeGet() 호출");
        return "article/normal/write"; // View 이름 반환
    }
    
    @PostMapping("/write")
    public String writePost(ArticleVO article) throws Exception {
        logger.info("Article#writePost() 호출"); 
        logger.info(article.toString());
        articleService.create(article);
        
        return "redirect:/article/normal/list"; // 페이지 redirect 시키는 방법 찾아보기
    }
    
    @GetMapping("/list")
    public String list(Model model) throws Exception {
        logger.info("Article#list() 호출");
        model.addAttribute("articles", articleService.listAll());
        
        return "article/normal/list";
    }
    
    @GetMapping("/read")
    public String read(@RequestParam("articleNo") int articleNo, Model model) throws Exception {
        logger.info("Article#read() 호출");
        model.addAttribute("article", articleService.read(articleNo));
        
        return "article/normal/read";
    }
}
