<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>实验器材管理系统</title>
    <script src="js/jquery.js"></script>
    <%--    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">--%>
</head>
<body class=bgn>
<style>
    .container-fluid {
        text-align: center;
        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }

    .bgn {
        /*background-image: url("img/ScreenProt.jpg");*/
    }
</style>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <fieldset style="width:400px;height: 480px">

                <legend>实验设备管理系统</legend>
                <br><br><br>
                <form action="BaseServlet?op=2" method="post"><br><br>
                    帐号:<input type="text" name="username" value="xrh666"><br><br>
                    <p>密码:<input type="password" name="password" value="123456"/></p><br><br><br>
                    <input type="submit" value="登录"
                           style="width: 110px;height: 40px">
                    <input type="button" value="注册"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='signIn.jsp'">
                </form>
                <br><br>

            </fieldset>

        </div>
    </div>
</div>

</body>

</body>
</html>