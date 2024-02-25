package com.github.codeqianxun.service.impl;

import com.github.codeqianxun.model.Index;
import com.github.codeqianxun.service.IndexCodesService;
import com.github.codeqianxun.service.IndexGatherStoreService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class indexCodesServiceImpl implements IndexCodesService {
    @DubboReference
    private IndexGatherStoreService indexGatherStoreService;

    /**
     * 获取指数信息
     * @return 指数信息
     */
    public List<Index> listIndexCodes() {
        return indexGatherStoreService.listIndexCodes();
    }
}