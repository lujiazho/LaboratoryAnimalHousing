<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>登入 - 实验动物房管理系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ZLJ_resources/style/admin.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ZLJ_resources/style/login.css" media="all">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/excel.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script>
        window.onload = function(){
            var but = document.getElementById("but")
            but.onclick = function () {
                if (username.value == 0 || username.value == null){
                    layer.msg('用户名不能为空',{shift: 6,time: 800, icon: 2});
                    return false
                }
                if (password.value == 0 || password.value == null){
                    layer.msg('密码不能为空',{shift: 6,time: 800, icon: 2});
                    return false
                }
                return true
            }
        }
    </script>
    <style>
        html{
            /*覆盖其它样式表中设定的颜色，否则下面的登录栏无法正常显示*/
            background-color: unset;
        }
        body{
            width:100%;
            height:100%;
            overflow-y: hidden;
            background-image: url("${pageContext.request.contextPath }/resources/images/pig1080.jpg");
            background-repeat: no-repeat;
            background-size:cover;
            /*背景图片居中*/
            background-position: center top;
        }
        .layadmin-user-login-main{
            width: 375px;
            box-sizing: border-box;
            margin: 0 auto;
            z-index: 1;
            overflow: hidden;
            /*添加边缘阴影*/
            box-shadow: -5px 5px 20px #22222222;
        }
        /*设定字体为白色*/
        .layadmin-user-login-header h1{
            color: white;
        }
        .layadmin-user-login-header p{
            color: white;
        }
        /*添加玻璃效果*/
        .layadmin-user-login-main::after{
            content: '';
            position: absolute;
            width: 375px;
            height: 404px;
            top: 110px;
            z-index: -1;
            background-image: url("${pageContext.request.contextPath}/resources/images/pig1080.jpg");
            background-position: center top;
            background-size: cover;
            background-attachment: fixed;
            -webkit-filter: blur(10px);
            -moz-filter: blur(10px);
            -ms-filter: blur(10px);
            -o-filter: blur(10px);
            filter: blur(10px);
            margin: 0;
        }
    </style>
</head>
<body >
<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h1>实验动物房管理系统</h1>
            <br>
            <p>Welcome to LaboratoryAnimalHousing Management System!</p>
            <br>
            <br>
            <p>Please login to deal!</p>
        </div>
        <form id="loginForm" class="layadmin-user-login-box layadmin-user-login-body layui-form" action="/LaboratoryAnimalHousing/login/toLogin" method="post">
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="username"></label>
                <input type="text" name="loginname" id="username" autocomplete="off" lay-verify="required" placeholder="用户名" class="layui-input">
            </div>
            <div class="layui-form-item">
                <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="password"></label>
                <input type="password" name="password" id="password" lay-verify="required" placeholder="密码" class="layui-input">
            </div>
            <br><br>
            <div class="layui-form-item">
                <button id="but" class="layui-btn layui-btn-fluid">登 入</button>
            </div>
        </form>
    </div>
</div>


</body>
</html>