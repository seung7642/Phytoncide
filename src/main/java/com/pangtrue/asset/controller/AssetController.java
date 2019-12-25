package com.pangtrue.asset.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.pangtrue.asset.model.AssetVO;
import com.pangtrue.asset.service.AssetService;

@Controller
public class AssetController {
    
    private static final Logger logger = LoggerFactory.getLogger(AssetController.class);
    private AssetService assetService;

    @Inject
    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }
    
    @GetMapping("/asset")
    public String assetGET() throws Exception {
        logger.info("assetGET() 호출됨");
        return "asset/asset";
    }
    
    @PostMapping("/asset")
    public String assetPOST(AssetVO assetVO) throws Exception { // 첫 번째 파라미터 assetVO는 커맨드 객체
        logger.info("assetPOST 호출됨");
        assetService.register(assetVO);
        
        return "redirect:/asset/asset";
    }
}
