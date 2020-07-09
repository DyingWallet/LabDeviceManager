<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>表单管理</title>
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
            <div class="page-header">
                <h3>
                    <em>表单管理菜单</em>
                </h3>
            </div>
            <ul class="thumbnails">
                <li class="span4">
                    <div class="thumbnail"><img src="img/01.png">
                        <div class="caption">
                            <h3>
                                购买申请
                            </h3>
                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='purApply.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
                <li class="span4">
                    <div class="thumbnail"><img src="img/02.jpg">
                        <div class="caption">
                            <h3>
                                帐目表
                            </h3>
                            <form action="BaseServlet?op=10" method="post">
                            <p>
                                <input type="submit" value="点击进入"
                                       style="width: 110px;height: 40px">
                            </p>
                            </form>
                        </div>
                    </div>
                </li>
                <li class="span4">
                    <div class="thumbnail"><img src="img/03.jpg">
                        <div class="caption">
                            <h3>
                                报废申请
                            </h3>
                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="window.location.href='scrap.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<input type="button" value="返回"
       style="width: 110px;height: 40px"
       onclick="javascript:window.location.href='mainPage.jsp'">
</body>
</html>