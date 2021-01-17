<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/18
  Time: 10:23
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
<div style="margin-bottom: 5px;">

    <!-- 示例-970 -->
    <ins class="adsbygoogle" style="display:inline-block;width:970px;height:90px" data-ad-slot="3820120620" data-ad-client="ca-pub-6111334333458862"></ins>

</div>
<table class="layui-table" lay-filter="demo" lay-data="{height:430, url:'/LaboratoryAnimalHousing/AnimalHealthLogin/getjson', page:true, id:'idTest'}">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'id',, sort: true}">ID</th>
        <th lay-data="{field:'id', edit: 'text'}">ID</th>
        <th lay-data="{field:'var', edit: 'text'}">种类</th>
        <th lay-data="{field:'state', edit: 'text'}">状态</th>
        <th lay-data="{field:'health', edit: 'text'}">健康状态</th>
        <th lay-data="{fixed: 'right', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<script id="barDemo" type="text/html">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


<script src="${pageContext.request.contextPath }/resources/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use('table', function(){
        var table = layui.table;
        //监听表格复选框选择
        table.on('checkbox(demo)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.msg('ID：'+ data.id + ' 的查看操作');
            } else if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                });
            } else if(obj.event === 'edit'){
                layer.alert('编辑行：<br>'+ JSON.stringify(data))
            }
        });

        var $ = layui.$, active = {
            getCheckData: function(){ //获取选中数据
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.alert(JSON.stringify(data));
            }
            ,getCheckLength: function(){ //获取选中数目
                var checkStatus = table.checkStatus('idTest')
                    ,data = checkStatus.data;
                layer.msg('选中了：'+ data.length + ' 个');
            }
            ,isAll: function(){ //验证是否全选
                var checkStatus = table.checkStatus('idTest');
                layer.msg(checkStatus.isAll ? '全选': '未全选')
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>
</body>
</html>
