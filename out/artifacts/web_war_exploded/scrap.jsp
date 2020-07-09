<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>报废</title>

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
            <span class="badge">报废录入</span>
            <form action="BaseServlet?op=14" method="post">
                <fieldset>
                    <p>
                        <label>设备编号</label>
                    </p>
                    <p>
                        <input type="text" name="num"/>
                    </p>
                    <p>
                        <label>设备名称</label>
                    </p>
                    <p>
                        <input type="text" name="name"/>
                    </p>
                    <p>
                        <label>报废日期</label>
                    </p>
                    <p>
                        <input type="text" name="date"/>
                    </p>
                    <p>
                        <label>原因</label>
                    </p>
                    <p>
                        <input type="text" name="rea"/>
                    </p>
                    <p>
                        <label>领导意见</label>
                    </p>
                    <p>
                        &nbsp&nbsp<input type="radio" value="1" name="Opinion"/>通过<br>
                        &nbsp&nbsp<input type="radio" value="0" name="Opinion"/>不通过<br>
                    </p>
                    <p>
                        <input type="submit" value="提交" >
                        <input type="button" value="返回"
                               onclick="window.location.href='tables.jsp'">
                    </p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>
</html>