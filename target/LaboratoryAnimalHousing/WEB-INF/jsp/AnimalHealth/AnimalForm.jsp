<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/19
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Animal Move Manage</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css"  media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div id="header">
    <ul class="layui-nav">
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/homepage">Animal Move Manage</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/homepage">主页</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/select">动物查看</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/select3">动物需求查看</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/requestselect">动物需求管理</a></li>
        <li class="layui-nav-item"><a href="/LaboratoryAnimalHousing/AnimalHealthMove/entrypage">动物进入管理</a></li>
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
<table class="layui-table">
    <thead>
    <th>ID</th>
    <th>日期</th>
    <th>种类</th>
    <th>状态</th>
    <th>健康情况</th>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.animals}" var="animal">
        <tr>
            <td>${animal.getId()}</td>
            <td>
                <f:formatDate value="${animal.getDate()}"
                              type="date" dateStyle="long"/>
            </td>
            <td>${animal.getVar()}</td>
            <td>${animal.getState()}</td>
            <td>${animal.getHealth()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<form class="layui-form" method="post" action="/LaboratoryAnimalHousing/AnimalHealthMove/select2">
    <div class="layui-form-item input-item">
        <label for="id">id</label>
        <input type="text" placeholder="请输入id"  autocomplete="off" id="id" name="id" class="layui-input">
    </div>
    <div class="layui-form-item">
        <!-- lay-submit代表这个按钮一个表单提交的按钮 -->
        <button class="layui-btn layui-block" lay-submit>查询</button>
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
