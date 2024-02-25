package com.github.codeqianxun.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class GlobalExceptionHandler {
    // Sentinel 规则阻塞处理方法
    public static String handleBlock(BlockException ex) {
        return "请求过于频繁，请稍后再试。";
    }

    // 全局异常 fallback 处理方法
    public static String fallbackMethod(Throwable throwable) {
        return "系统异常，请稍后再试。";
    }
}