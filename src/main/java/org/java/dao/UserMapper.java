package org.java.dao;

import org.apache.ibatis.annotations.Param;
import org.java.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public User loginResult(@Param("name") String name, @Param("psw") String psw);

    public List<Map> showCart(@Param("sid") Integer sid);

    public Integer getCountBySidSpid(@Param("sid") Integer sid,@Param("spid") Integer spid);

    public void addCart(@Param("sid") Integer sid,@Param("spid") Integer spid);

    public void updateAmount(@Param("sid") Integer sid,@Param("spid") Integer spid);

    public void delSp(@Param("sid") Integer sid,@Param("spid") Integer spid);

    public void delAllSp(@Param("sid") Integer sid);

}
