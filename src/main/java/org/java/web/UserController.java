package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @RequestMapping("/login")
    public String login(@RequestParam String name, @RequestParam String psw) {
        User user = userService.loginResult(name, psw);

        if (user == null) {
            session.setAttribute("err", "用户密码不正确");
            System.out.println("没有用户");
            return "redirect:/login.jsp";
        } else {
//            如果user不为null,则添加商品到购物车
            System.out.println("查询到了");
            session.setAttribute("user", user);

            return "redirect:/goods.jsp";
        }

    }

    @RequestMapping("/logout")
    public String logout() {
        session.removeAttribute("user");
        return "redirect:/login.jsp";
    }
}
