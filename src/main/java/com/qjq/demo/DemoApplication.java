package com.qjq.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}


// Notes：
// Spring用容器管理Bean
// 带有注解的文件，只要在Application的同一级或者下一级目录，都会自动加载进来