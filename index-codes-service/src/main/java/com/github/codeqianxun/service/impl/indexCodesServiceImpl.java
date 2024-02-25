package com.github.codeqianxun.service.impl;

import com.github.codeqianxun.service.IndexCodesService;
import com.github.codeqianxun.service.IndexGatherStoreService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

@Service
public class indexCodesServiceImpl implements IndexCodesService {
    @DubboReference
    private IndexGatherStoreService indexGatherStoreService;

    /**
     * 获取指数信息
     * @param code 代码
     * @return 指数信息
     */
    public String getIndex(String code) {
        return indexGatherStoreService.getIndexInfo(code);
    }
}