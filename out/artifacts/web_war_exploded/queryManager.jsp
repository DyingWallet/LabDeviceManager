<%@ page import="cuit.Group9.LDM.entity.Borrow" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/layoutit.css">
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/jquery.js"></script>

    <meta charset="UTF-8">
    <title>查询</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h1>
                    查询管理
                </h1>
            </div>
            <ul class="thumbnails">
                <ul class="span4">
                    <div class="thumbnail">
                        <img alt="300x200" src="img/01.png"/>
                        <div class="caption">
                            <form class="form-search" action="BaseServlet?op=3" method="post">
                                <input class="btn" type="submit" style="width: 110px;height: 40px" value="查看借用表"
                                       onclick="window.location.href='QueryResult/borrowTable.jsp'">
                            </form>
                        </div>
                    </div>
                </ul>
                <ul class="span4">
                    <div class="thumbnail">
                        <img alt="300x200" src="img/02.jpg"/>
                        <div class="caption">
                            <form class="form-search" action="BaseServlet?op=4" method="post">
                                <input class="btn" type="submit" id="fix" name="fix" value="查看维修表"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='QueryResult/repairTable.jsp'">
                            </form>
                        </div>
                    </div>
                </ul>
                <ul class="span4">
                    <div class="thumbnail">
                        <img alt="100x50" src="img/03.jpg"/>
                        <div class="caption">
                            <form class="form-search" action="BaseServlet?op=5" method="post">
                                <input class="btn" type="submit" id="broken" name="broken" value="查看报废表"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='QueryResult/scrapTable.jsp'">
                            </form>
                        </div>
                    </div>
                </ul>
            </ul>
        </div>
    </div>
</div>


<input type="button" value="返回"
       style="width: 110px;height: 40px"
       onclick="window.location.href='mainPage.jsp'">
</body>
</html>