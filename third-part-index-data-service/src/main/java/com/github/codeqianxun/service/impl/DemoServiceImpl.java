package com.github.codeqianxun.service.impl;

import com.github.codeqianxun.api.service.DemoService;
import org.apache.dubbo.config.annotation.DubboService;

@DubboService
public class DemoServiceImpl implements DemoService {
    public String getIndex() {
        return "请求成功";
    }
}