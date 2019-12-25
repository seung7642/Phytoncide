package com.pangtrue.asset.service;

import com.pangtrue.asset.model.AssetVO;

public interface AssetService {

    void register(AssetVO assetVO) throws Exception;
    
    void delete() throws Exception;
}
