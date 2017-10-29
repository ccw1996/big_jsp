<%@ page import="java.io.File" %>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileReader" %><%--
  Created by IntelliJ IDEA.
  User: caroot
  Date: 2017/10/28
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
</head>
<%--<body>--%>
<%--<%--%>
    <%--String a=(String)session.getAttribute("username");--%>
    <%--String savePath="D:/jsp/big/web/netdisk/"+a;--%>
    <%--File file=new File(savePath);--%>
    <%--if(!file.exists()&&!file.isDirectory()){--%>
        <%--System.out.println("目录不存在");--%>
        <%--file.mkdir();--%>
    <%--}--%>
    <%--try{--%>
        <%--String saveRecord="/record.txt";--%>
        <%--File file2=new File(savePath+saveRecord);   // 用文件方式追加列表，但尚未添加删除功能--%>
        <%--BufferedReader reader=null;--%>
        <%--String temp=null;--%>
        <%--int flag=0;--%>
        <%--reader=new BufferedReader(new FileReader(file2));--%>
        <%--while((temp=reader.readLine())!=null){--%>
            <%--System.out.println(temp);--%>
        <%--}--%>
    <%--}catch (Exception e)--%>
        <%--{--%>
            <%--e.printStackTrace();--%>
        <%--}--%>
<%--%>--%>
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
                个人网盘
            </h3>
            <table class="table">
                <tbody>
<c:forEach var="me" items="${fileNameMap}">
    <c:url value="/DownLoadServlet" var="downurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
<tr class="success">
    <td>
            ${me.value}
    </td>
    <td>
        <a href="${downurl}">下载</a>
    </td>
    <c:url value="/DeleteServlet" var="delurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    <td>
        <a href="${delurl}">删除</a>
    </td>
</tr>
    <br/>
</c:forEach>
        </div>
    </div>
</div>
    <td>
        <button class="btn btn-warning" type="button" onclick="location.href='upload.jsp'">上传</button>
    </td>
</body>
</html>
