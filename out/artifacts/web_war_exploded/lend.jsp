<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
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

    <style>
        .form-horizontal {
            text-align: center;
            position: absolute;
            left: 45%;
            top: 30%;
            transform: translate(-50%, -50%);
        }

        .bgn {
            /*background-image: url("img/ScreenProt.jpg");*/
        }
    </style>

</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">

            <form class="form-horizontal" action="BaseServlet?op=8" method="post">
                <div class="control-group">
                    <label class="control-label" for="inputDevName">设备名称</label>
                    <div class="controls">
                        <input id="inputDevName" name="devName" type="text"/>
                    </div>
                </div>
                <div class="control-group">
                    <label class="control-label" for="inputNum">数量</label>
                    <div class="controls">
                        <input id="inputNum" name="num" type="text"/>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <input type="submit" value="查询"
                               style="width: 110px;height: 40px">
                        <input type="button" value="返回"
                               style="width: 110px;height: 40px"
                               onclick="window.location.href='devManager.jsp'">
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>