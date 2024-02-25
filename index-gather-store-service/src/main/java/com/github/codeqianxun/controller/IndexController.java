package com.github.codeqianxun.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.codeqianxun.exception.GlobalExceptionHandler;
import com.github.codeqianxun.service.IndexService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    @SentinelResource(value = "index",
                      blockHandler = "handleBlock",
                      blockHandlerClass = GlobalExceptionHandler.class,
                      fallback = "fallbackMethod",
                      fallbackClass = GlobalExceptionHandler.class)
    public String index(){
        return indexService.index("index","index","index");
    }
}