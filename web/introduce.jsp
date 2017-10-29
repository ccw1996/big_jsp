<%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/27
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li>
                    <a href="ListFileServlet">个人网盘</a><span class="divider"></span>
                </li>
            </ul>
            <h3>
                个人信息
            </h3>
            <table class="table">
                <tbody>
                <tr class="success">
                    <td>
                        用户名：
                    </td>
                    <td>
                            <%=showmyself.getUn()%>
                    </td>
                </tr>
                <tr class="error">
                    <td>
                        性别：
                    </td>
                    <td>
                        <%=showmyself.getSex()%>
                    </td>
                </tr>
                <tr class="warning">
                    <td>
                        生日：
                    </td>
                    <td>
                        <%=showmyself.getBirthday()%>
                    </td>
                </tr>
                <tr class="info">
                    <td>
                        民族：
                    </td>
                    <td>
                        <%=showmyself.getNational()%>
                    </td>
                </tr>
                <tr class="success">
                    <td>
                        姓名：
                    </td>
                    <td>
                        <%=showmyself.getXm()%>
                    </td>
                </tr>
            </table> <button class="btn" type="button" onclick="location.href='change.jsp'">修改</button>
        </div>
    </div>
</div>
</body>
</html>
