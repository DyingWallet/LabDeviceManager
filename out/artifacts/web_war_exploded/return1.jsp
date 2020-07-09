<%@ page import="cuit.Group9.LDM.entity.Borrow" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    List<Borrow> list = (List<Borrow>)request.getAttribute("List");
    String stuNo = (String) request.getAttribute("No");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>归还设备</title>
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
            <p>
                <span class="badge">设备归还</span>
            </p>
            <form class="form-search" action="BaseServlet?op=11" method="post">
                <p>
                    学号
                </p><label>
                <input class="input-medium search-query" type="text" value="<%=stuNo%>" name="stuNo"/>
            </label>
                <button type="submit" class="btn">查询用户归还状况</button>
                <input type="button" value="返回" class="btn"
                       onclick="window.location.href='devManager.jsp'">
            </form>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <table class="table table-condensed">
                <table class="table">
                    <thead>
                    <tr>
                        <%--表头--%>
                        <th>ID</th>
                        <th>设备编号</th>
                        <th>设备名称</th>
                        <th>借出时间</th>
                            <th>归还时间</th>
                        <th>归还状态</th>
                        <th>学号</th>
                        <th>管理员编号</th>
                            <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        Borrow tmp = null;
                        for (int i = 0; i < list.size(); i++) {
                            tmp = list.get(i);
                            if (i % 2 == 0) {
                    %>
                    <tr class="warning">
                        <td><%=tmp.getID()%>
                        </td>
                        <td><%=tmp.getDevNo()%>
                        </td>
                        <td><%=tmp.getDevName()%>
                        </td>
                        <td><%=tmp.getBorDate()%>
                        </td>
                        <td><%=tmp.getRetDate()%>
                        </td>
                        <td><%=tmp.isRetSta()%>
                        </td>
                        <td><%=tmp.getStuNo()%>
                        </td>
                        <td><%=tmp.getAdminNo()%>
                        </td>
                        <td><form action="BaseServlet?op=12" method="post">
                            <input type="hidden" value="<%=stuNo%>" name="stuNo">
                            <input type="hidden" value="<%=tmp.getDevNo()%>" name="devNo">
                            <input type="submit" value="归还" ></form></td>
                    </tr>
                    <%
                    } else {
                    %>
                    <tr class="success">
                        <td><%=tmp.getID()%>
                        </td>
                        <td><%=tmp.getDevNo()%>
                        </td>
                        <td><%=tmp.getDevName()%>
                        </td>
                        <td><%=tmp.getBorDate()%>
                        </td>
                        <td><%=tmp.getRetDate()%>
                        </td>
                        <td><%=tmp.isRetSta()%>
                        </td>
                        <td><%=tmp.getStuNo()%>
                        </td>
                        <td><%=tmp.getAdminNo()%>
                        </td>
                        <td><form action="BaseServlet?op=12" method="post">
                            <input type="hidden" value="<%=stuNo%>" name="stuNo">
                            <input type="hidden" value="<%=tmp.getDevNo()%>" name="devNo">
                            <input type="submit" value="归还" ></form></td>
                    </tr>
                    <% }
                    }%>
                    </tbody>
                </table>
                <input type="button" value="返回"
                       style="width: 110px;height: 40px"
                       onclick="javascript:window.location.href='devManager.jsp'">
        </div>
    </div>
</div>
</body>
</html>