package com.github.codeqianxun.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.codeqianxun.api.service.IndexService;
import com.github.codeqianxun.exception.GlobalExceptionHandler;
import com.github.codeqianxun.util.OkHttpUtils;
import org.apache.dubbo.config.annotation.DubboService;

import java.io.IOException;

@DubboService(timeout = 5000)
public class IndexServiceImpl implements IndexService {
    /**
     * 获取第三方指数数据
     * @param code 指数编号
     * @return 第三方指数数据
     */
    @SentinelResource(value = "getIndex",
            blockHandler = "handleBlock",
            blockHandlerClass = GlobalExceptionHandler.class,
            fallback = "fallbackMethod",
            fallbackClass = GlobalExceptionHandler.class)
    public String getIndex(String code) throws IOException {
        return OkHttpUtils.get("http://127.0.0.1:8080/api/public/stock_zh_index_daily_em?symbol=" + code);
    }
}