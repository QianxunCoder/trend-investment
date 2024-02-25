package com.github.codeqianxun.service;

import com.github.codeqianxun.model.Index;

import java.util.List;

public interface IndexCodesService {
    /**
     * 获取指数信息
     * @return 指数信息
     */
    List<Index> listIndexCodes();
}
