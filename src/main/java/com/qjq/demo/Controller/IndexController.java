package com.qjq.demo.Controller;

import com.qjq.demo.Model.User;
import com.qjq.demo.Service.QuestionService;
import com.qjq.demo.dto.PaginationDto;
import com.qjq.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
// 添加注解的作用，自动识别扫描当前的类作为Spring的Bean去管理。Controller注解 允许这个类接受前端的请求。
// Controller 注解作用：类作为路由 api 的承受者
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("token")) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if(user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }

        PaginationDto pagination = questionService.list(page, size);

        model.addAttribute("pagination", pagination);

        return "index";  // 自动去 template 目录找 index.html
    }
}

