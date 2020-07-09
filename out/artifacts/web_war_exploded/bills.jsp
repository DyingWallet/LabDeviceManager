<%@ page import="java.util.List" %>
<%@ page import="cuit.Group9.LDM.entity.Bill" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<Bill> list = (List<Bill>)request.getAttribute("List"); %>
<!DOCTYPE html>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/bootstrap-combined.min.css">
    <link rel="stylesheet" type="text/css"
          href="<%=basePath%>/css/layoutit.css">
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/jquery.js"></script>
    <meta charset="UTF-8">
    <title>账单查询</title>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <div class="page-header">
                <h3>
                    <em>账目表</em>
                </h3>
            </div>
            <table class="table">
                <thead>
                <tr>
                    <%--表头--%>
                    <th>编号</th>
                    <th>开支事件</th>
                    <th>金额</th>
                    <th>详细描述</th>
                    <th>日期</th>
                    <th>管理员编号</th>
                </tr>
                </thead>
                <tbody>
                <%
                    //获取行数
                    Bill tmp;
                    for (int i = 0; i < list.size(); i++) {
                        tmp = list.get(i);
                        if (i % 2 == 0) {
                %>
                <tr class="warning">
                    <td><%=tmp.getID()%></td>
                    <td><%=tmp.getIssue()%></td>
                    <td><%=tmp.getCost()%></td>
                    <td><%=tmp.getDescy()%></td>
                    <td><%=tmp.getDate()%></td>
                    <td><%=tmp.getAdminNo()%></td>
                </tr>
                <%
                } else {
                %>
                <tr class="success">
                    <td><%=tmp.getID()%></td>
                    <td><%=tmp.getIssue()%></td>
                    <td><%=tmp.getCost()%></td>
                    <td><%=tmp.getDescy()%></td>
                    <td><%=tmp.getDate()%></td>
                    <td><%=tmp.getAdminNo()%></td>
                </tr>
                <% }
                }%>
                </tbody>
            </table>
            <input type="button" value="返回"
                   style="width: 110px;height: 40px"
                   onclick="window.location.href='tables.jsp'">
        </div>
    </div>
</div>
</body>
</html>