package org.java.service;

import org.java.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User loginResult(String name,String psw);

    public List<Map> showCart(Integer sid);

    //添加购物车
    public void addCart(Integer sid,Integer spid);

    //移除商品
    public void delSp(Integer sid,Integer spid);

    //移除所有商品
    public void delAllSp(Integer sid);
}
