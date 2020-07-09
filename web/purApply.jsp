<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Buy</title>
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
                    <em>购买申请</em>
                </h3>
            </div>
            <form action="BaseServlet?op=6" method="post">
                <fieldset>
                    <p>
                        <font size="4" color="blue">设备名称</font>&nbsp&nbsp<input type="text" name="devName"/><br>
                    </p>

                    <p>
                        <font size="4" color="blue">设备数量</font>&nbsp&nbsp<input type="text" name="num"/><br>
                    </p>

                    <p>
                        <font size="4" color="blue">设备单价</font>&nbsp&nbsp<input type="text" name="price"/><br>
                    </p>

                    <%--                    <p>--%>
                    <%--                        <font size="4" color="blue">管理员编号</font>&nbsp&nbsp<input type="text" name=""/><br>--%>
                    <%--                    </p>--%>
                    <p><font size="4" color="blue">领导意见</font></p>
                    <p>
                        &nbsp&nbsp<input type="radio" value="1" name="Opinion"/><font size="4"
                                                                                      color="blue">通过</font><br>
                        &nbsp&nbsp<input type="radio" value="0" name="Opinion"/><font size="4"
                                                                                      color="blue">不通过</font><br>
                    </p>
                    <p>
                        <input type="submit" value="提交"
                               style="width: 110px;height: 40px">
                        <input type="button" value="返回"
                               style="width: 110px;height: 40px"
                               onclick="window.location.href='tables.jsp'">
                    </p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>