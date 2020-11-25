package org.java.web;

import org.java.service.ShowGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class SpController {
    @Autowired
    private ShowGoodsService service;

    @RequestMapping("/first")
    public String goodsshow(HttpSession session){
        List<Map> showgoods = service.showgoods();
      session.setAttribute("goodsinfo",showgoods);
      return "goods";
    }
}
