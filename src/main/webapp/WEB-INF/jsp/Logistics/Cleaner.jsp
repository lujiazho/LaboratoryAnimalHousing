<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/7
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>实验动物房后勤管理系统</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/ZLJ_resources/css/style.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/ZLJ_resources/css/css.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
    <div class="logo">实验动物房后勤管理系统</div>
    <div class="navigation">
        <ul>
            <li>欢迎您！[${sessionScope.user_session.username }]</li>
            <li><a href="">修改密码</a></li>
            <li><a href="">设置</a></li>
            <li><a href="">退出</a></li>
        </ul>
    </div>
</div>
<div id="content">
    <div class="left_menu">
        <ul id="nav_dot">
            <li>
                <h4 class="M1"><span></span>个人信息</h4>
                <div class="list-item none">
                    <a href='/LaboratoryAnimalHousing/Personal'>个人信息</a>
                </div>
            </li>
            <li>
                <h4 class="M2"><span></span>记录保洁情况</h4>
                <div class="list-item none">
                    <a href="/LaboratoryAnimalHousing/waste/addWaste?flag=1" target="main">垃圾信息记录</a>
                </div>
            </li>
            <li>
                <h4 class="M3"><span></span>查看历史记录</h4>
                <div class="list-item none">
                    <a href="/LaboratoryAnimalHousing/waste/selectWaste" target="main">垃圾信息查看</a>
                </div>
            </li>
        </ul>
    </div>
    <div class="m-right">
        <div class="main">
            <iframe src="${pageContext.request.contextPath}/rightDefault" name="main" align="right" width="100%" height="100%" scrolling="auto" frameborder="0" marginwidth="0" marginheight="0" noresize="noresize">
            </iframe>>
        </div>
    </div>
</div>
<div class="bottom"></div>
<div id="footer"><p>联系我们 QQ:937371423 telephone:18810332219 email:zljdanceholic@cau.edu.cn</p></div>
<script>navList(12);</script>
</body>
</html>
