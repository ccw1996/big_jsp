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
<c:forEach var="me" items="${fileNameMap}">
    <c:url value="/DownLoadServlet" var="downurl">
        <c:param name="filename" value="${me.key}"></c:param>
    </c:url>
    ${me.value}<a href="${downurl}">下载</a>
    <br/>
</c:forEach>
</body>
</html>
