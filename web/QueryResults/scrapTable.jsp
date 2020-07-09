<%@ page import="cuit.Group9.LDM.entity.Borrow" %>
<%@ page import="java.util.List" %>
<%@ page import="cuit.Group9.LDM.entity.tables.ScrapForm" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%List<ScrapForm> list = (List<ScrapForm>) request.getAttribute("List"); %>
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
    <title>查询</title>

</head>
<%--<%--%>
<%--    String date = request.getAttribute("result").toString();--%>
<%--%>--%>

<style>
    .dropdown {

        display: inline-block;

        position: relative;

    }

    .content number {

        display: block;

        color: grey;

        padding: 12px 16px;

        text-align: center;

    }

</style>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="span12">
            <h3>
                <em>查询信息</em>
            </h3>
            <div class="span2">

                <form action="BaseServlet?op=3" method="post">
                    <input type="submit" id="borr" name="borr" value="查看外借表"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='QueryResult/borrowTable.jsp'">
                </form>
            </div>
            <div class="span2">
                <form action="BaseServlet?op=4" method="post">
                    <input type="submit" id="fix" name="fix" value="查看维修表"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='QueryResult/repairTable.jsp'">
                </form>
            </div>
            <div class="span2">
                <form action="BaseServlet?op=5" method="post">
                    <input type="submit" id="broken" name="broken" value="查看报废表"
                           style="width: 110px;height: 40px"
                           onclick="window.location.href='QueryResult/scrapTable.jsp'">
                </form>
            </div>
        </div>
    </div>
    <div class="row-fluid">
        <div class="span12">
            <table class="table">
                <thead>
                <tr>
                    <%--表头--%>
                    <th>编号</th>
                    <th>设备编号</th>
                    <th>设备名称</th>
                    <th>报废日期</th>
                    <th>原因</th>
                    <th>管理员编号</th>
                    <th>意见</th>
                </tr>
                </thead>
                <tbody>
                <%
                    //获取行数
                    ScrapForm tmp = null;
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
                    <td><%=tmp.getScrapDate()%>
                    </td>
                    <td><%=tmp.getScrapReason()%>
                    </td>
                    <td><%=tmp.getAdminNo()%>
                    </td>
                    <td><%=tmp.isAgree()%>
                    </td>

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
                    <td><%=tmp.getScrapDate()%>
                    </td>
                    <td><%=tmp.getScrapReason()%>
                    </td>
                    <td><%=tmp.getAdminNo()%>
                    </td>
                    <td><%=tmp.isAgree()%>
                    </td>
                </tr>
                <% }
                }%>
                </tbody>
            </table>
        </div>
    </div>
    <input type="button" value="返回"
           style="width: 110px;height: 40px"
           onclick="window.location.href='/web_war_exploded/queryManager.jsp'">
</div>
</body>
</html>