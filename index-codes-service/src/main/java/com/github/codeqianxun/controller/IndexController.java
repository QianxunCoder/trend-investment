package com.github.codeqianxun.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.github.codeqianxun.exception.GlobalExceptionHandler;
import com.github.codeqianxun.service.IndexCodesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final IndexCodesService indexCodesService;

    @GetMapping("/index/{code}")
    @SentinelResource(value = "index",
                      blockHandler = "handleBlock",
                      blockHandlerClass = GlobalExceptionHandler.class,
                      fallback = "fallbackMethod",
                      fallbackClass = GlobalExceptionHandler.class)
    public String index(@PathVariable("code") String code) throws IOException {
        return indexCodesService.getIndex(code);
    }
}