<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>设备录入</title>
</head>
<%--<script type="text/javascript">--%>
<%--    function submitTable() {--%>

<%--        var name = document.getElementById("name").value;--%>

<%--        var identy = document.getElementById("identy").value;--%>

<%--        var number = document.getElementById("number").value;--%>

<%--        var date = document.getElementById("date").value;--%>

<%--        var way = document.getElementById("way").value;--%>


<%--        row = document.getElementById("table").insertRow();--%>

<%--        if (row != null) {--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = name;--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = identy;--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = number;--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = date;--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = date;--%>

<%--            cell = row.insertCell();--%>

<%--            cell.innerHTML = way;--%>

<%--        }--%>

<%--        return false;--%>
<%--    }--%>
<%--</script>--%>

<body>

<font size="10" color="green">设备录入</font><br><br><br><br>
<form action="BaseServlet?op=7" method="post">

    <font size="4" color="blue">设备的名称</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <input type="text" name="name">

    <font size="4" color="blue">设备特征吗</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <input type="text" name="fea"><br><br>

    <font size="4" color="blue">设备的数量</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    <input type="text" name="num">

    <font size="4" color="blue">购买的渠道</font>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

    <input type="text" name="way">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp

    <hr>

    <div>
        <br><input name="btn" style="width: 110px;height: 40px" type="submit" id="submit" value="提交">
        <input type="button" value="返回"
               style="width: 110px;height: 40px;margin-left: 40px;"
               onclick="window.location.href='devManager.jsp'">
    </div>
</form>
</body>
</html>
        <%--<table border="1" width="100%" align="center" id="table">--%>

        <%--    <tr>--%>

        <%--        <th>设备名称</th>--%>
        <%--        <th>设备特征码</th>--%>
        <%--        <th>购入数量</th>--%>
        <%--        <th>购入日期</th>--%>
        <%--        <th>购买渠道</th>--%>
        <%--        <th>管理员编号</th>--%>

        <%--    </tr>--%>

        <%--</table>--%>
