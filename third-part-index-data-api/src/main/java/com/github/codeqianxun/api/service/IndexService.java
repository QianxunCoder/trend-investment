package com.github.codeqianxun.api.service;

import java.io.IOException;

public interface IndexService {
    /**
     * 获取第三方指数数据
     * @return 第三方指数数据
     */
    String getIndexCodes() throws IOException;
}
