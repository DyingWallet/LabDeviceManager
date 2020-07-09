<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册用户</title>
    <script src="lib/jquery.js"></script>
    <link rel="stylesheet" type="text/css"
          href="lib/css/bootstrap.css">
</head>
<body>
<style>
    .container-fluid {
        text-align: center;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
</style>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">


            <fieldset style="width:400px;height:480px;background-color: #b1dfbb">
                <legend>实验室设备管理系统管理员注册</legend>
                <br><br><br>
                <form action="BaseServlet?op=1" method="post">
                    姓名：<label for="adminName"></label><input type="text" id="adminName" name="adminName"/>
                    <br><br><br><br>
                    账号：<label for="username"></label><input type="text" id="username" name="username"/>
                    <br><br><br><br>
                    密码：<label for="password"></label><input type="password" id="password" name="password">
                    <br><br><br>
                    <input type="submit" value="提交"
                           style="width: 110px;height: 40px">
                    <input type="button" value="返回"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='logIn.jsp'">
                </form>
            </fieldset>


        </div>
    </div>
</div>
</body>
</html>