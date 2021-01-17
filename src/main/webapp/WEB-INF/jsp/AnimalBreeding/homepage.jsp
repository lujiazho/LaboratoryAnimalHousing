<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>实验动物房动物繁育系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />

    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/excel.js"></script>

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
</head>
<body>

<!-- 顶部开始 -->
<div class="container">
    <div class="logo"><a href="">实验动物房动物繁育系统</a></div>
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>

    <ul class="layui-nav right" lay-filter="">
        <li class="layui-nav-item">
            <a href="javascript:;"><img src="${pageContext.request.contextPath}/resources/WLW_resourses/images/lzlhead.jpg" class="layui-nav-img">${sessionScope.user_session.loginname}</a>
            <dl class="layui-nav-child"> <!-- 二级菜单 -->
                <dd><a onclick="x_admin_show('切换帐号','loginOut')">切换帐号</a></dd>
                <dd><a href="/loginOut">退出</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item to-index"><a href="/loginOut">前台首页</a></li>
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
                    <i class="iconfont">&#xe705;</i>
                    <cite>动物繁育行为记录</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findEstrusBoar">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>种猪发情行为记录</cite>

                        </a>
                    </li >
                </ul>
                    <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findEstrusSow">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>母猪发情行为记录</cite>

                        </a>
                    </li >
                    </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findMatingBoar">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>种猪配种行为记录</cite>
                        </a>
                    </li >
                </ul>

                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findMatingSow">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>母猪配种行为记录</cite>
                        </a>
                    </li >
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b2;</i>
                    <cite>动物选种管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findSelectObserveBoar">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>初选待配种猪</cite>
                        </a>
                    </li >
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findSelectObserveSow">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>初选待配母猪</cite>
                        </a>
                    </li >
                </ul>
                    <ul class="sub-menu">
                        <li>
                            <a _href="/LaboratoryAnimalHousing/findSelectSituationBoar">
                                <%--点击在右侧出现动态的Tab--%>
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>种猪观察评估</cite>
                            </a>
                        </li >
                        <li>
                            <a _href="/LaboratoryAnimalHousing/findSelectSituationSow">
                                <%--点击在右侧出现动态的Tab--%>
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>母猪观察评估</cite>
                            </a>
                        </li >
                    </ul>
                    <ul class="sub-menu">
                        <li>
                            <a _href="/LaboratoryAnimalHousing/findSelectResultBoar">
                                <%--点击在右侧出现动态的Tab--%>
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>种猪选种结果记录</cite>
                            </a>
                        </li>
                        <li>
                            <a _href="/LaboratoryAnimalHousing/findSelectResultSow">
                                <%--点击在右侧出现动态的Tab--%>
                                <i class="iconfont">&#xe6a7;</i>
                                <cite>母猪选种结果记录</cite>
                            </a>
                        </li>
                    </ul>
            </li>
            <li>
                <a href="javascript:;">
                    <i class="iconfont">&#xe6b8;</i>
                    <cite>动物配种管理</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findAnimalMating">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>动物配种档案录入</cite>
                        </a>
                    </li >
                </ul>
            </li>

            <li>
                <a href="javascript:;">
                    <i class="layui-icon">&#xe62a;</i>
                    <cite>种猪母猪档案维护</cite>
                    <i class="iconfont nav_right">&#xe697;</i>
                </a>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findBoarRecord">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>种猪档案维护</cite>
                        </a>
                    </li >
                </ul>
                <ul class="sub-menu">
                    <li>
                        <a _href="/LaboratoryAnimalHousing/findSowRecord">
                            <%--点击在右侧出现动态的Tab--%>
                            <i class="iconfont">&#xe6a7;</i>
                            <cite>母猪档案维护</cite>
                        </a>
                    </li >
                </ul>
            </li>
        </ul>
    </div>
</div>
<!-- 左侧菜单结束 -->

<!-- 右侧主体开始 -->
<div class="page-content">
    <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
        <ul class="layui-tab-title">
            <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
        </ul>
        <div class="layui-tab-content" >
            <div class="layui-tab-item layui-show o_div" >
                <span class="o_span">${sessionScope.user_session.username}动物选种员，欢迎来到动物繁育管理系统！</span>
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
        base: 'layui_exts/',
    }).extend({
        excel: 'excel',
    });

</script>
</body>
</html>
