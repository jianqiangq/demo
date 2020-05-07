package com.qjq.demo.provider;

import com.alibaba.fastjson.JSON;
import com.qjq.demo.dto.AccessTokenDTO;
import com.qjq.demo.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

// Provider：提供对第三方支持的能力（变成习惯）

@Component
// Component 注解作用：把当前类初始化到 Spring 容器的上下文
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {

        // Post to a Server
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string(); // access_token=887debfbf977d4862f39b3be8a4b90ec484f8e1a&scope=user&token_type=bearer
            String token = string.split("&")[0].split("=")[1];
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token=" + accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            // json string 对象，自动转换解析为 Java 类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            return null;
        }

    }
}
