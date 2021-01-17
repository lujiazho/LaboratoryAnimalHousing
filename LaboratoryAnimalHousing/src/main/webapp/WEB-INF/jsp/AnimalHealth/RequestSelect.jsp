<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/19
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Animal Entry Manage</title>
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
<!-- 示例-970 -->

</div>


<table class="layui-table" lay-filter="demo" lay-data="{ url:'/LaboratoryAnimalHousing/AnimalHealthMove/getjson', page:true, id:'idTest'}">
    <thead>
    <tr>
        <th lay-data="{type:'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'var', sort: true, fixed: true}">种类</th>
        <th lay-data="{field:'info'}">备注</th>
        <th lay-data="{field:'num', sort: true}">数量</th>
        <th lay-data="{fixed: 'right', align:'center', toolbar: '#barDemo'}"></th>
    </tr>
    </thead>
</table>

<div class="layui-btn-group demoTable">
    <button class="layui-btn" data-type="getCheckData">筛选动物</button>
</div>

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
                //layer.alert(JSON.stringify(data));
                //window.location.href = ("/LaboratoryAnimalHousing/AnimalHealthMove/select4?cid="+"猪");
                $.ajax(
                    {
                        url: '/LaboratoryAnimalHousing/AnimalHealthMove/select4',     // 请求地址, 就是你的控制器, 如 test.com/home/index/index
                        data: JSON.stringify(data),   // 需要传送的参数
                        type: 'POST',   // 请求方式
                        dataType: 'json', // 返回数据的格式, 通常为JSON
                        async:true,
                        contentType: 'application/json',
                        success: function (result) {
                            console.log('Send Request succeed'); // 请求失败时的回调函数

                        },
                        error: function () {
                            console.log('Send Request Fail..'); // 请求失败时的回调函数
                        }
                    }
                );
                location.href="/LaboratoryAnimalHousing/AnimalHealthMove/requestselect2";
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
</body>
</html>
