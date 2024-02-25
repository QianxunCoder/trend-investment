package com.github.codeqianxun.service;

import com.github.codeqianxun.model.Index;

import java.util.List;

public interface IndexGatherStoreService {
    /**
     * 获取指数信息
     * @param code 代码
     * @return 指数信息
     */
    Index getIndexInfo(String code);

    List<Index> listIndexCodes();
}
