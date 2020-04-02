package com.qjq.demo.Controller;

import com.qjq.demo.Model.User;
import com.qjq.demo.dto.AccessTokenDTO;
import com.qjq.demo.dto.GithubUser;
import com.qjq.demo.mapper.UserMapper;
import com.qjq.demo.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserMapper UserMapper;

    // @Value 注解作用：会去配置文件中读取github.client.id，然后赋值到变量里面
    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.url}")
    private String redirectUrl;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) { // HttpServletRequest request 写在方法的参数时，Spring 会把上下文中的 Request 放到这里面让我们去使用。

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(clientSecret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url(redirectUrl);
        accessTokenDTO.setState(state);

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);

        if (githubUser != null) {

            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(System.currentTimeMillis());
            UserMapper.insert(user);

            response.addCookie(new Cookie("token", token));

//            // 登陆成功，写 Cookie 和 Session
//            request.getSession().setAttribute("user", githubUser); // 把 githubUser 对象写到 session 里面。
                                                                      // 这个时候相当于在银行账户中创建成功了一个账户，但是并没有给前端一个银行卡（会自动创建一个Cookie）。
            return "redirect:/";     // 跳转到 根目录 页面。并且地址框内为 http://localhost:8999
                                     // 如果不写 redirect 跳转，效果是：地址（http://localhost:8999/callback?code=3fa98a4f6662b9b986b2&state=1）不变，但是把页面渲染成index。
                                     // 但是用了 redirect 前缀，他就会把地址全部去掉，重定向到 index 页面中去。
        } else {
            // 登陆失败，重新登陆
            return "redirect:/";
        }
    }
}
