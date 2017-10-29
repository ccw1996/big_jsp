<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/29
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                <li>
                    <a href="introduce.jsp">主页</a><span class="divider"></span>
                </li>
                <li class="active">
                    通讯录
                </li>
                <li>
                    <a href="ListFileServlet">个人网盘</a><span class="divider"></span>
                </li>
            </ul>
            <h3>
                通讯录
            </h3>

            <table class="table">
                <thead>
                <tr>
                    <th>
                        姓名
                    </th>
                    <th>
                        电话
                    </th>
                    <th>
                        地址
                    </th>
                    <th>
                        操作1
                    </th>
                    <th>
                        操作2
                    </th>
                </tr>
                </thead>
                <tbody>
    <c:forEach items="${contactorList }" var="c">
        <tr>
            <td>${c.name }</td>
            <td>${c.tel }</td>
            <td>${c.address }</td>

            <td><a href="<c:url value='/ContactorServlet?method=5&id=${c.id }'/>">编辑</a>
            </td>
            <td>
                <a href="<c:url value='/ContactorServlet?method=7&id=${c.id }'/>" >删除</a>
            </td>
        </tr>
    </c:forEach>
                </tbody>
</table><button class="btn btn-info" type="button" onclick="location.href='<c:url value='add.jsp'/>'">添加联系人</button>
        </div>
    </div>
</div>
</body>
</html>
