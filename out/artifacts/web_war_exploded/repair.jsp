<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>维修录入</title>
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
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <form action="BaseServlet?op=13" method="post">
                <fieldset>
                    <p>
                        <label>设备名称</label>
                    </p>
                    <p>
                        <input type="text" name="devName"/>
                    </p>
                    <p>
                        <label>设备编号</label>
                    </p>
                    <p>
                        <input type="text" name="devNo"/>
                    </p>
                    <p>
                        <label>送修原因</label>
                    </p>
                    <p>
                        <input type="text" name="rea"/>
                    </p>
                    <p>
                        <label>维修方</label>
                    </p>
                    <p>
                        <input type="text" name="repairer"/>
                    </p>
                    <p>
                        <input class="btn" type="submit" value="提交">
                        <input type="button" value="返回"
                               onclick="window.location.href='devManager.jsp'">
                    </p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>