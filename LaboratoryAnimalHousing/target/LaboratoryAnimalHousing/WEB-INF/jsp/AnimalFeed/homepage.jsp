<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>
<%--星空样式--%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/component.css" />


    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/excel.js"></script>
<%--星空样式--%>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/js/html5.js"></script>

    <style>
        <%--.o_div{--%>
        <%--    background: url("${pageContext.request.contextPath}/resources/WLW_resourses/images/01.jpg") no-repeat;--%>
        <%--}--%>
        .o_span{
            display: block;
            text-align: center;
            font-size: 20px;
            letter-spacing:8px
        }
        #large-header{z-index: 1;}
    </style>
</head>
<body>
<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="">实验动物房动物饲养系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <ul class="layui-nav left fast-add" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><img src="${pageContext.request.contextPath}/resources/WLW_resourses/images/timg4.jpg" class="layui-nav-img"></a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="javascript:location.href='https://www.lascn.net/Category_1188/Index.aspx'"><i class="iconfont">&#xe6a7;</i>中国实验动物信息网</a></dd>
                <dd><a onclick="javascript:location.href='https://www.lascn.net/Category_1318/Index.aspx'"><i class="iconfont">&#xe6a7;</i>饲养管理资讯</a></dd>
                <dd><a onclick="javascript:location.href='https://www.lascn.net/SupplyDemand/Supply/Category.aspx?Id=38'"><i class="iconfont">&#xe6a7;</i>饲料垫料市场</a></dd>
            </dl>
        </li>
    </ul>
    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><img src="${pageContext.request.contextPath}/resources/WLW_resourses/images/wlw.jpg" class="layui-nav-img">${sessionScope.user_session.username}</a>
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
                    <i class="iconfont">&#59042;</i>
                    <cite>饲料信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findFeedClaim">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理饲料领取信息</cite>

                        </a>
                    </li >
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findFeedTest">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理饲料饮水检测信息</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findFeedFeeding">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理饲料投喂信息</cite>
                        </a>
                    </li >
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe723;</i>
                    <cite>垫料信息管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findPaddingClaim">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理垫料领取信息</cite>

                        </a>
                    </li >
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findPaddingTest">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理垫料检测信息</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findPaddingReplacement">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理垫料更换信息</cite>
                        </a>
                    </li >
                </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#59042;</i>
                    <cite>动物房间管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findRoom">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理动物房间分配信息</cite>
                        </a>
                    </li >
                </ul>

                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findRoomInfo">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>管理房间信息</cite>
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
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>



        <div class="layui-tab-content" >
<%--            <div class="container demo-1" >--%>
<%--            <div id="large-header" class="large-header">--%>
            <div class="layui-tab-item layui-show o_div" >
                    <span class="o_span">${sessionScope.ad.a_username}饲养员，欢迎来到动物饲养管理系统！</span>
                <div class="layui-col-md6" style="padding: 30px;left: 60px;background-color: #F2F2F2;opacity:80%">

<%--    <canvas id="demo-canvas" class="logo_box"></canvas>--%>
                    <div class="layui-card">

                        <div class="layui-card-header">个人信息</div>
                        <div class="layui-card-body">
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
<%--                </div>--%>

<%--                </div>--%>
                </div>
            </div>
<%--            </div>--%>
<%--            </div>--%>
        </div>
    </div>
</div>
<%--</div><!-- /container -->--%>

<div class="page-content-bg"></div>
<!-- 右侧主体结束 -->
<!-- 中部结束 -->
<!-- 底部开始 -->
<div class="footer">
    <div class="copyright">Copyright ©2020-2021 版权所有</div>
</div>
<!-- 底部结束 -->

<script>

    layui.config({
        base: 'layui_exts/',
    }).extend({
        excel: 'excel',
    });

</script>
<script src="${pageContext.request.contextPath}/resources/WLW_resourses/js/TweenLite.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/WLW_resourses/js/EasePack.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/WLW_resourses/js/rAF.js"></script>
<script src="${pageContext.request.contextPath}/resources/WLW_resourses/js/demo-1.js"></script>
</body>
</html>
