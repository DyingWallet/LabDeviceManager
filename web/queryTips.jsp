<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>借出设备</title>
    <link rel="stylesheet" type="text/css"
          href="css/bootstrap.min.css"/>
    <link href="css/bootstrap-combined.min.css"
          rel="stylesheet">
    <link href="css/layoutit.css" rel="stylesheet">
    <script src="WEB-INF/lib/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<div class="alert alert-danger fade in">
    <button type="button" class="close" data-dismiss="alert">&times;</button>
    <strong>来自系统消息</strong>库存不足
</div>

<!--模态框组件-->
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3>提示</h3>
            </div>
            <div class="modal-body">
                <p>确定要关闭警告框信息？</p>
            </div>
            <div class="modal-footer">
                <button class="btn btn-info" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--添加用户行为-->
<script type="text/javascript">
    $(function () {
        $(".close").click(function () {
            $(this).alert("close");
        });
        $(".alert").on("close.bs.alert", function (e) {
            $("#myModal").modal();
        });
    });
</script>
<button type="button" class="btn btn-primary" title="Popover title"
        data-container="body" data-toggle="popover" data-placement="top"
        data-content="库存不足">按钮
</button>
<button type="button" class="btn btn-success" title="Popover title"
        data-container="body" data-toggle="popover" data-placement="bottom"
        data-content="库存不足">按钮
</button>
<script>
    $(function () {
        $("[data-toggle='popover']").popover();
    });
</script>


<div class="alert alert-danger alert-dismissable in" role="alert">
    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
    </button>
    <strong>库存不足</strong>
</div>
</body>
</html>