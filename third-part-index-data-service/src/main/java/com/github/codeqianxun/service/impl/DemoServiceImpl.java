package com.github.codeqianxun.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.github.codeqianxun.api.service.DemoService;
import com.github.codeqianxun.exception.GlobalExceptionHandler;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {
    @SentinelResource(value = "getIndex",
            blockHandler = "handleBlock",
            blockHandlerClass = GlobalExceptionHandler.class,
            fallback = "fallbackMethod",
            fallbackClass = GlobalExceptionHandler.class)
    public String getIndex() {
        return "请求成功";
    }
}