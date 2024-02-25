package com.github.codeqianxun.service.impl;

import com.github.codeqianxun.api.service.DemoService;
import com.github.codeqianxun.service.IndexService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @DubboReference
    DemoService demoService;
    public String index(String indexName, String indexType, String indexContent) {
        return demoService.getIndex();
    }
}