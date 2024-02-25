package com.github.codeqianxun.controller;

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
    public String index(){
        return indexService.index("index","index","index");
    }
}