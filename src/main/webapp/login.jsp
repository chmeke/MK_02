<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/24
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="margin-top: 10% " align="center">
<form action="/login.do" method="post" style="line-height: 35px">
    用户：<input type="text" name="name"><br/>
    密码：<input type="password" name="psw"><br/>
    <input type="submit" value="点击登录"><span style="color: red">${sessionScope.err}</span>
</form>
</div>
</body>
</html>
