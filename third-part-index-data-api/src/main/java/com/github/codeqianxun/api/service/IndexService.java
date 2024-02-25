package com.github.codeqianxun.api.service;

import java.io.IOException;

public interface IndexService {
    /**
     * 获取第三方指数数据
     * @param code 指数编号
     * @return 第三方指数数据
     */
    String getIndex(String code) throws IOException;
}
