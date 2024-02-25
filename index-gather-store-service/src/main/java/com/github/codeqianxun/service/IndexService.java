package com.github.codeqianxun.service;

import org.apache.dubbo.config.annotation.DubboService;

public interface IndexService {
    String index(String indexName, String indexType, String indexContent);
}
