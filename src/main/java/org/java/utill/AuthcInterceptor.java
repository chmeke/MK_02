package org.java.utill;

import org.java.entity.User;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthcInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //获得session，判断session中是否存在user
        HttpSession ses = request.getSession();

        User user = (User) ses.getAttribute("user");

        if(user == null){

            //重定向到登录界面
            response.sendRedirect("/login.jsp");

            return false;//不进入控制器
        }


        return super.preHandle(request, response, handler);
    }

}
