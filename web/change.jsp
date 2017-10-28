<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/28
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<%response.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="showmyself" class="ccw.study.Showmyself"/>
<html>
<head>
    <title>Title</title>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<body>
<%
    String a=(String)session.getAttribute("username");
    showmyself.getInformation(a);
%>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <ul class="breadcrumb">
                <li class="active">
                    主页
                </li>
                <li>
                    <a href="#">通讯录</a> <span class="divider">/</span>
                </li>
            </ul>
            <h3>
                个人信息
            </h3>
            <form action="ChangeSql" accept-charset="utf-8" id="login_form" class="loginForm" method="post">
            <table class="table">
                <tbody>
                <tr class="success">
                    <td>
                        用户名：
                    </td>
                    <td>
                        <input type="text" name="username" value="<%=showmyself.getUn()%>" readonly=true>
                    </td>
                </tr>
                <tr class="error">
                    <td>
                        性别：
                    </td>
                    <td>
                        <input type="text" name="sex" value="<%=showmyself.getSex()%>">
                    </td>
                </tr>
                <tr class="warning">
                    <td>
                        生日：
                    </td>
                    <td>
                        <input type="text" name="birthday" value="<%=showmyself.getBirthday()%>">
                    </td>
                </tr>
                <tr class="info">
                    <td>
                        民族：
                    </td>
                    <td>
                        <input type="text" name="national" value="<%=showmyself.getNational()%>">
                    </td>
                </tr>
                <tr class="success">
                    <td>
                        姓名：
                    </td>
                    <td>
                        <input type="text" name="xm" value="<%=showmyself.getXm()%>">
                    </td>
                </tr>
                <tr class="error">
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="text" name="password" value="<%=showmyself.getPw()%>">
                    </td>
                </tr>
            </table>
            <table>
                <td>
            <input class="btn btn-success" type="submit"></input>
                </td>
                <td>
            <button class="btn btn-danger" type="button" onclick="location.href='introduce.jsp'">取消</button>
                </td>
        </table>
        </form>
        </div>
    </div>
</div>
</body>
</html>
