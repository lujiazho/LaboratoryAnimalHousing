<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/15
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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


<div class="layui-carousel" id="test10">
    <div carousel-item="">
        <div><img src="${pageContext.request.contextPath }/resources/AH_resource/image/himg4.png" style="height:100%; weight:100%;"></div>
        <div><img src="${pageContext.request.contextPath }/resources/AH_resource/image/himg2.png" style="height:100%; weight:100%;"></div>
        <div><img src="${pageContext.request.contextPath }/resources/AH_resource/image/himg3.png" style="height:100%; weight:100%;"></div>
    </div>
</div>


<script src="${pageContext.request.contextPath }/resources/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['carousel', 'form'], function(){
        var carousel = layui.carousel
            ,form = layui.form;

        //常规轮播
        carousel.render({
            elem: '#test1'
            ,arrow: 'always'
        });

        //改变下时间间隔、动画类型、高度
        carousel.render({
            elem: '#test2'
            ,interval: 3000
            ,anim: 'fade'
            ,height: '120px'
        });

        //设定各种参数
        var ins3 = carousel.render({
            elem: '#test3'
        });
        //图片轮播

        carousel.render({
            elem: '#test10'
            ,width: '100%'
            ,height: '550px'
            ,interval: 3000
        });


        //事件
        carousel.on('change(test4)', function(res){
            console.log(res)
        });

        var $ = layui.$, active = {
            set: function(othis){
                var THIS = 'layui-bg-normal'
                    ,key = othis.data('key')
                    ,options = {};

                othis.css('background-color', '#5FB878').siblings().removeAttr('style');
                options[key] = othis.data('value');
                ins3.reload(options);
            }
        };

        //监听开关
        form.on('switch(autoplay)', function(){
            ins3.reload({
                autoplay: this.checked
            });
        });

        $('.demoSet').on('keyup', function(){
            var value = this.value
                ,options = {};
            if(!/^\d+$/.test(value)) return;

            options[this.name] = value;
            ins3.reload(options);
        });

        //其它示例
        $('.demoTest .layui-btn').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });
    });
</script>

</body>

</html>
