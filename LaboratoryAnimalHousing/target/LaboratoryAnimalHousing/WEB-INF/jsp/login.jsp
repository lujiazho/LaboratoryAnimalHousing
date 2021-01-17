<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>登录系统</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${pageContext.request.contextPath }/resources/images/car.jpg">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/public.css" media="all" />
</head>
<body class="loginBody">
<img class="img-responsive" src="${pageContext.request.contextPath }/resources/images/clown.jpeg" height="auto" width="100%">
<form class="layui-form" id="frm" method="post" action="/LaboratoryAnimalHousing/login/toLogin">
    <div class="login_face"><img src="${pageContext.request.contextPath }/resources/images/face1.jpg" class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label for="userName">用户名</label>
        <input type="text" placeholder="请输入用户名"  autocomplete="off" id="userName" name="loginname" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item">
        <label for="password">密码</label>
        <input type="password" placeholder="请输入密码"  autocomplete="off" id="password" name="password" class="layui-input" lay-verify="required">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" value="jgmxj" autocomplete="off" id="code" class="layui-input">
        <img src="${pageContext.request.contextPath }/resources/images/code.jpg">
    </div>
    <div class="layui-form-item">
        <!-- lay-submit代表这个按钮一个表单提交的按钮 -->
        <button class="layui-btn layui-block" lay-filter="login" lay-submit>登录</button>
        <font color="red">${error }</font>
    </div>
    <!--  <div class="layui-form-item layui-row">
        <a href="javascript:;" class="seraph icon-qq layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-wechat layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
        <a href="javascript:;" class="seraph icon-sina layui-col-xs4 layui-col-sm4 layui-col-md4 layui-col-lg4"></a>
    </div>  -->
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/layui/layui.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/cache.js"></script> --%>
</body>
<script type="text/javascript">
    layui.use(['form','layer','jquery'],function(){
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;
        //登录按钮
        form.on("submit(login)",function(data){
            $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
            setTimeout(function(){
                //window.location.href = "/layuicms2.0";
                $("#frm")[0].submit();//提交表单
            },1000);
            return false;
        })

        //表单输入效果
        $(".loginBody .input-item").click(function(e){
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        })
        $(".loginBody .layui-form-item .layui-input").focus(function(){
            $(this).parent().addClass("layui-input-focus");
        })
        $(".loginBody .layui-form-item .layui-input").blur(function(){
            $(this).parent().removeClass("layui-input-focus");
            if($(this).val() != ''){
                $(this).parent().addClass("layui-input-active");
            }else{
                $(this).parent().removeClass("layui-input-active");
            }
        })
    })
</script>

</html>