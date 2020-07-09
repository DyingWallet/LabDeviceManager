<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>主界面</title>
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css"
          href="css/layoutit.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="WEB-INF/lib/jquery.js"></script>
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
                            <h3>
                                信息查询
                            </h3>
                            <p>
                                设备的相关信息
                            </p>
                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='queryManager.jsp'">
                            </p>
                        </div>
                    </div>
                </ul>
                <ul class="span4">
                    <div class="thumbnail">
                        <img alt="300x200" src="img/02.jpg"/>
                        <div class="caption">
                            <h3>
                                设备管理
                            </h3>
                            <p>
                                录入设备，借出设备，归还设备等
                            </p>
                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='devManager.jsp'">
                            </p>
                        </div>
                    </div>
                </ul>
                <ul class="span4">
                    <div class="thumbnail">
                        <img alt="100x50" src="img/03.jpg"/>
                        <div class="caption">
                            <h3>
                                表单管理
                            </h3>
                            <p>
                                包含了各种表单信息
                            </p>
                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='tables.jsp'">
                            </p>
                        </div>
                    </div>
                </ul>
            </ul>
            <input type="button" value="注销"
                   style="width: 110px;height: 40px"
                   onclick="window.location.href='logIn.jsp'">
        </div>
    </div>
</div>
</body>
</html>