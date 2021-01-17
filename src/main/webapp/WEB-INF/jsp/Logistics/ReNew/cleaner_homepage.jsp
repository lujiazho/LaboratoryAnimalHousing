<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/10/15
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/excel.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/fkjava_timer.js"></script>
    <style>
        .o_div{
            background: url("${pageContext.request.contextPath}/resources/WLW_resourses/images/01.jpg") no-repeat;
        }
        .o_span{
            display: block;
            text-align: center;
            font-size: 20px;
            letter-spacing:8px
        }
    </style>
    <script>
        $(function(){
            $("#nowTime").runTimer();
        })
    </script>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="">保洁管理系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav right" lay-filter="">
        <div class="layui-inline">
            <i class="layui-icon layui-icon-log" style="font-size: 35px; color: #F1F1F1;"></i>
        </div>
        <div class="layui-inline">
            <i class="layui-icon"><span id="nowTime" style="text-align: center"></span></i>
        </div>
        <li class="layui-nav-item">
            <a href="javascript:;"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/profile.jpg" class="layui-nav-img">${sessionScope.user_session.username}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('切换帐号','loginOut')">切换帐号</a></dd>
                <dd><a href="/LaboratoryAnimalHousing/login/loginOut">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/LaboratoryAnimalHousing/login/loginOut">前台首页</a></li>
    </ul>
</div>
<!-- 顶部结束 -->
<!-- 中部开始 -->
<!-- 左侧菜单开始 -->
<div class="left-nav">
    <div id="side-nav">
        <ul id="nav">
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>保洁情况管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/waste/selectWaste" onclick="waiting()">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>垃圾产生记录</cite>

                        </a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe726;</i>
                    <cite>管理员管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/404" onclick="prompt()">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理员列表</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- <div class="x-slide_left"></div> -->
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="true">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show o_div" >
                <span class="o_span">${sessionScope.user_session.username}管理员，欢迎来到后勤管理系统！</span>
                <div class="layui-col-md6" style="padding: 30px;left: 60px;background-color: #F2F2F2;">
                <div class="layui-card">
                <div class="layui-card-header">个人信息
                        </div>
                        <div class="layui-card-body">
                            <%--<div class="layui-form-label" style="text-align: left">你好</div>--%>
                           用户名：${sessionScope.user_session.loginname}
                        </div>
                        <div class="layui-card-body">
                            姓名：${sessionScope.user_session.username}
                        </div>
                        <div class="layui-card-body">
                            电话：${sessionScope.user_session.phone}
                        </div>
                        <div class="layui-card-body">
                            部门：${sessionScope.user_session.department}
                        </div>
                        <div class="layui-card-body">
                            职位：${sessionScope.user_session.position}
                        </div>
                </div>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2019-2020 版权所有</div>
</div>
<!-- 底部结束 -->

<script>

    layui.config({
        base: '${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/',
    }).extend({
        excel: 'excel',
    });
    layui.use(['jquery', 'excel','form','layer','laydate'], function() {
        layer.ready(function () {
            layer.msg('欢迎登录！',{icon: 6});
        })
    })
    function prompt(){
        layer.msg('没有访问权限',{shift: 6,time: 1200, icon: 5});
    }
    function waiting(){
        layui.use('layer', function(){
            //加载层-风格3
            var index = layer.load(2,{
                time: 2500
            });
        });
    }
</script>
</body>
</html>
