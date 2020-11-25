package org.java.service.impl;

import org.java.dao.UserMapper;
import org.java.entity.User;
import org.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper user;

    @Override
    public User loginResult(String name, String psw) {

        return user.loginResult(name, psw);
    }


    //    显示购物车
    @Override
    public List<Map> showCart(Integer sid) {

       return user.showCart(sid);

    }

    @Override
    public void addCart(Integer sid, Integer spid) {

        //根据用户id和商品id判断是否为第一次购买
        Integer count = user.getCountBySidSpid(sid, spid);
        if (count > 0) {
            user.updateAmount(sid, spid);
        } else {
            user.addCart(sid, spid);
        }

    }

    @Override
    public void delSp(Integer sid, Integer spid) {

        user.delSp(sid, spid);

    }

    @Override
    public void delAllSp(Integer sid) {
        user.delAllSp(sid);
    }
}
