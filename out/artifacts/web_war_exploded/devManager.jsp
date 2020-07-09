<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>设备管理</title>
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
                    <em>设备管理菜单</em>
                </h3>
            </div>
            <ul class="thumbnails">
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/001.png"/>
                        <div class="caption">
                            <h4>
                                录入设备
                            </h4>

                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="javascript:window.location.href='intoInv.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/002.jpg"/>
                        <div class="caption">
                            <h4>
                                借出设备
                            </h4>

                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="javascript:window.location.href='lend.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/003.png"/>
                        <div class="caption">
                            <h4>
                                预约设备
                            </h4>

                            <h2>
                                <input type="button" value="准备中..."
                                       style="width: 110px;height: 40px">
                            </h2>
                        </div>
                    </div>
                </li>
            </ul>
            <ul class="thumbnails">
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/006.jpg"/>
                        <div class="caption">
                            <h4>
                                设备归还
                            </h4>

                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="javascript:window.location.href='return.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/004.jpg"/>
                        <div class="caption">
                            <h4>
                                设备维修登记
                            </h4>

                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="javascript:window.location.href='repair.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <div class="thumbnail"><img alt="300x200" src="img/005.jpg"/>
                        <div class="caption">
                            <h4>
                                报废录入
                            </h4>

                            <p>
                                <input type="button" value="点击进入"
                                       style="width: 110px;height: 40px"
                                       onclick="javascript:window.location.href='scrap.jsp'">
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
            <input type="button" value="返回"
                   style="width: 110px;height: 40px"
                   onclick="javascript:window.location.href='mainPage.jsp'">
        </div>
    </div>
</div>
</body>
</html>