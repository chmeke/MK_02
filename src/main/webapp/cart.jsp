<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2020/11/24
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"  contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
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
<table align="center" width="80%">
    <tr>
        <td colspan="7">
            ${user.sname}的购物车
        </td>
    </tr>
    <tr>
        <th>编号</th>
        <th>商品名称</th>
        <th>单价</th>
        <th>数量</th>
        <th>商品描述</th>
        <th>小计</th>
        <th>移除</th>
    </tr>
    <c:forEach items="${sessionScope.Cartlist}" var="k">
        <tr>
            <td>${k.spid}</td>
            <td>${k.spname}</td>
            <td><fmt:formatNumber value="${k.spprice}" type="currency"/></td>
            <td>${k.amount}</td>
            <td>${k.spdesc}</td>
            <td><fmt:formatNumber value="${k.spprice*k.amount}" type="currency"/></td>
            <td><a href="${pageContext.request.contextPath}/op/delcart/${k.spid}.do">移除购物车</a></td>
            <c:set var="total" value="${k.spprice*k.amount+total}"></c:set>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="7">
            应付总金额:<fmt:formatNumber value="${total}" type="currency"/>
            <a href="${pageContext.request.contextPath}/first.do">继续购物</a>
            <a href="${pageContext.request.contextPath}/op/delAll.do">清空购物车</a>

        </td>
    </tr>
</table>
</body>
</html>
