package com.qjq.demo.dto;

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;  // fastJson 自动把 json 中 avatar_url 字段映射到 类中驼峰命名的属性 avatarUrl
}
