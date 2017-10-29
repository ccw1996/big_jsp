<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/29
  Time: 21:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
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
                修改联系人
            </h3>
<form action="<c:url value='/ContactorServlet'/>" method="post" onsubmit="return checkForm()">
    <input type="hidden" name="method" value="6">
    <input type="hidden" name="id" value="${contactor.id }">
    <table class="table">
        <tr class="success">
            <td>姓名</td>
            <td>
                <input type="text" name="name" value="${contactor.name }" id="name"/>
                <div id="nameId"></div>
            </td>
        </tr>
        <tr class="error">
            <td>电话</td>
            <td>
                <input type="text" name="tel" value="${contactor.tel }" id="tel" />
                <div id="telId"></div>
            </td>
        </tr>
        <tr class="warning">
            <td>地址</td>
            <td>
                <input type="text" id="address" name="address" value="${contactor.address }" />
            </td>
        </tr>
    </table>
    <table>
        <td>
            <input class="btn btn-success" type="submit"  value="更改"/>
        </td>
        <td>
            <button class="btn btn-danger" type="button" onclick="location.href='/ContactorServlet?method=3&userId=${username }'">取消</button>
        </td>
    </table>
</form>
        </div>
    </div>
</div>
</body>
</html>
