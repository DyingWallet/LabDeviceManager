<%@ page import="cuit.Group9.LDM.entity.Borrow" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>归还设备</title>
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css"
          href="css/layoutit.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <p>
                <span class="badge">设备归还</span>
            </p>
            <form class="form-search" action="BaseServlet?op=11" method="post">
                <p>
                    学号
                </p><label>
                <input class="input-medium search-query" type="text" name="stuNo"/>
            </label>
                <button type="submit" class="btn">查询用户归还状况</button>
                <input type="button" value="返回" class="btn"
                       onclick="window.location.href='devManager.jsp'">
            </form>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <table class="table table-condensed">
                <table class="table">
                    <thead>
                    <tr>
                        <%--表头--%>
                        <th>ID</th>
                        <th>设备编号</th>
                        <th>设备名称</th>
                        <th>借出时间</th>
                        <th>归还时间</th>
                        <th>归还状态</th>
                        <th>学号</th>
                        <th>管理员编号</th>
                    </tr>
                    </thead>
                </table>
            </table>
        </div>
    </div>
</div>
</div>
</body>
</html>