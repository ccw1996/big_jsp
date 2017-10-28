<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/28
  Time: 19:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String un=(String)session.getAttribute("username");
    session.setAttribute("username",un);
    System.out.println(un);
%>
<form action="UploadHandleServlet" enctype="multipart/form-data" method="post">
    上传文件：<input type="file" name="file"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>
