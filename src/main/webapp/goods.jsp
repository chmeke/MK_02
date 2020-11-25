<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/24
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <style>
        table, tr, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            text-align: center;
        }

    </style>
</head>
<body>
<table align="center" width="50%">
    <tr>
        <td colspan="5">
            <c:if test="${sessionScope.user==null}">
                <a href="login.jsp">请登录</a>
            </c:if>
            <c:if test="${sessionScope.user!=null}">
                ${user.sname}
                <a href="${pageContext.request.contextPath}/showcart.do">购物车</a>
                <a href="${pageContext.request.contextPath}/logout.do">退出登录</a>
            </c:if>
        </td>
    </tr>
    <tr>
        <th>编号</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品描述</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${goodsinfo}" var="k">
        <tr>
            <td>${k.spid}</td>
            <td>${k.spname}</td>
            <td>${k.spprice}</td>
            <td>${k.spdesc}</td>
            <td><a href="/op/addcart/${k.spid}.do">加入购物车</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
