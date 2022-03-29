package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @RequestMapping("/user/login")

    public String login(@RequestParam("userEmail") String userEmail,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        if(!StringUtils.isEmpty(userEmail)&&"123".equals(password)){
            session.setAttribute("loginUser", userEmail);
            //重定向
            return "redirect:/main.html";
        }else{
            //告诉用户用户名或密码错误
            model.addAttribute("msg", "用户名或密码错误");
            return "login";
        }

    }
}
