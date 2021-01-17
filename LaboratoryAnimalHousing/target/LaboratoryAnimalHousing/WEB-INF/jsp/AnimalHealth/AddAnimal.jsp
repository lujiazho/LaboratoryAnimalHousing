<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div id="header">
    <ul class="layui-nav">
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/homepage">
            <font size="50px">Animal Entry Manage</font>
        </a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/homepage">主页</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/login">动物注册</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/select">动物查看</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/select3">编辑动物信息</a></li>
        <li class="layui-nav-item layui-this">
            <a href="javascript:;">动物检疫管理</a>
            <dl class="layui-nav-child">
                <dd><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/qualogin">检疫信息登录</a></dd>
                <dd><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/qselect">检疫信息查询</a></dd>
            </dl>
        </li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthLogin/movepage">动物移动管理</a></li>
    </ul>
</div>
<script src="${pageContext.request.contextPath }/resources/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('element', function(){
        var element = layui.element; //导航的hover效果、二级菜单等功能，需要依赖element模块

        //监听导航点击
        element.on('nav(demo)', function(elem){
            //console.log(elem)
            layer.msg(elem.text());
        });
    });
</script>
<form class="layui-form" method="post" action="/LaboratoryAnimalHousing/AnimalHealthLogin/login">
    <div class="layui-form-item input-item">
        <label for="id">id</label>
        <input type="text" placeholder="请输入id"  autocomplete="off" id="id" name="id" class="layui-input">
    </div>
    <div class="layui-form-item input-item">
        <label for="var">动物种类</label>
        <input type="text" placeholder="请输入动物种类"  autocomplete="off" id="var" name="var" class="layui-input" >
    </div>
    <div class="layui-form-item input-item">
        <label for="state">动物状态</label>
        <input type="text" placeholder="请输入动物状态"  autocomplete="off" id="state" name="state" class="layui-input">
    </div>
    <div class="layui-form-item input-item">
        <label for="health">健康状态</label>
        <input type="text" placeholder="请输入动物健康状态"  autocomplete="off" id="health" name="health" class="layui-input" >
    </div>
    <div class="layui-form-item input-item">
        <label for="date">接收日期</label>
        <input type="text" placeholder="请输入动物接收日期"  autocomplete="off" id="date" name="date" class="layui-input" >
    </div>
    <div class="layui-form-item">
        <!-- lay-submit代表这个按钮一个表单提交的按钮 -->
        <button class="layui-btn layui-block" lay-submit>确认</button>
        <font color="red">${error }</font>
    </div>
    <!--  <div class="layui-form-item layui-row">
        <a href="javascript:;" class="seraph icon-qq layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-wechat layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-sina layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
    </div>  -->
</form>
</body>
</html>
