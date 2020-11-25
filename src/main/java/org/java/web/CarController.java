package org.java.web;

import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CarController {
    @Autowired
    private UserService userService;

    @Autowired
    HttpSession session;

    @RequestMapping("/showcart")
    public String showcart(){
        System.out.println("进入购物车");
//        获取当前登录的用户id
        User user = (User)session.getAttribute("user");

        List<Map> list = userService.showCart(user.getSid());
        System.out.println(list);
        session.setAttribute("Cartlist",list);

        return "cart";
    };


    @RequestMapping("/op/addcart/{spid}")
    public String addcart(@PathVariable("spid") Integer spid) {
        System.out.println("添加购物车");
//        获取当前登录的用户id
        User user = (User)session.getAttribute("user");

        userService.addCart(user.getSid(),spid);

        System.out.println(spid);

        return  "redirect:/goods.jsp";
    }

    @RequestMapping("/op/delcart/{spid}")
    public String delcart(@PathVariable("spid") Integer spid) {
        System.out.println("移除商品");
//        获取当前登录的用户id
        User user = (User)session.getAttribute("user");

        userService.delSp(user.getSid(),spid);

        System.out.println(spid);


        return  "redirect:/showcart.do";
    }
    @RequestMapping("/op/delAll")
    public String delcart() {
        System.out.println("移除所有商品");
//        获取当前登录的用户id
        User user = (User)session.getAttribute("user");

        userService.delAllSp(user.getSid());


        return  "redirect:/showcart.do";
    }

}
