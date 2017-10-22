<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/22
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ccw.study.Sqllink" %>
<jsp:useBean id="login" class="ccw.study.Login">
    <jsp:setProperty name="login" property="*"/>
</jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username=login.getUsername();
    String password=login.getPassword();
    Sqllink sqllink=new Sqllink();
    if(sqllink.check(username,password)){
        out.println("登陆成功");      //todo 用js的方式弹出
        response.sendRedirect("main.jsp");
    }
    else
    {
        out.println("登陆失败");    //todo 如上
        response.sendRedirect("index.jsp");
    }
%>
</body>
</html>
