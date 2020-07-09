<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String num = request.getAttribute("deviceNum").toString();
    String devName = (String) request.getAttribute("deviceName");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>借出设备</title>
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
            <div class="control-group">
                <label class="control-label">设备名称：<%=devName%>
                </label><br>
            </div>
            <div class="control-group">
                <label class="control-label">借用数量：<%=num%>
                </label><br>
            </div>

            <form action="BaseServlet?op=9" method="post">
                <div class="controls">
                    请确认要借用的设备<label for="Name"></label><input type="text" id="Name" name="devName"/><br>
                    请确认要借用的数量<label for="Num"></label><input type="text" id="Num" name="num"/><br>
                    请输入学号：<label for="stuNO"></label><input type="text" id="stuNO" name="stuNo"/><br>
                    <input type="submit" value="确认借出"
                           style="width: 110px;height: 40px">
                    <input type="button" value="返回"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='devManager.jsp'">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>