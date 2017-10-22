<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/22
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

%>
</body>
</html>
