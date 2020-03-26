package com.qjq.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 添加注解的作用，自动识别扫描当前的类作为Spring的Bean去管理。Controller注解 允许这个类接受前端的请求。
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";  // 自动去 template 目录找 index.html
    }
}

