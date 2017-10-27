<%@ page import="ccw.study.Sqllink" %><%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/22
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="register" class="ccw.study.Register">
    <jsp:setProperty name="register" property="*"/>
</jsp:useBean>
<jsp:useBean id="sqllink" class="ccw.study.Sqllink"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username=register.getUsername();
    String password=register.getPassword();
    int QQ=register.getQQ();
    String a;
    try{
        if(!sqllink.check(username))
        {a="insert into users(username,password,QQ) values ('"+username+"','"+password+"','"+QQ+"')";
        System.out.println(a);
        sqllink.Modify(a);
        out.println("   success");
        response.sendRedirect("index.html");}
        else
        { %>
            <script lanuage="javascript">
                alert("用户名已存在！");
                window.history.back(-1);
            </script>
            <%
        }
    }catch (Exception e){
        e.printStackTrace();
    }
%>
</body>
</html>
