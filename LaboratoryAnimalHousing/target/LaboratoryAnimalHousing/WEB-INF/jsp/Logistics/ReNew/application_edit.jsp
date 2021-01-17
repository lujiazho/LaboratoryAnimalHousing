<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/11/14
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
    <title>修改信息</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/pg_btn.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
</head>

<body>
<script>
    function waiting(){
        layui.use('layer', function(){
            //加载层-风格3
            var index = layer.load(2,{
                time: 2000
            });
        });
    }
    // obj为事件源对象的形参可以任意
    function checkNum(obj){
        // keyCode表示键盘的按键源码,每个键盘的按键都由特定的编码
        // 48到57是大键盘的0-9按键96到105是小键盘的的0-9
        var keyCode=obj.keyCode
        if((keyCode<48||keyCode>57)&&(keyCode<96||keyCode>105)&&keyCode!=8){
            layer.tips('非数字输入已被阻止','#newreceived');
            // 用户按了非法的按键需要返回一个false用来阻止浏览器的默认行为
            return false
        }
        return true
    }
    function checkValue() {
        var v_demand = document.getElementById("demandnum");
        var v_demandnum = v_demand.value
        var v_received = document.getElementById("receivednum");
        var v_newreceived = document.getElementById("newreceived");

        var sum = 1*v_received.value + 1*v_newreceived.value
        if ( sum > v_demandnum) {
            layer.msg('接受数量过大',{shift: 6, time: 1200, icon: 2}, function(){
                //关闭后的操作
            });
            return false
        }
        if ( 1*v_newreceived.value == 0){
            layer.msg('接受数量不能为0',{shift: 6,time: 1200, icon: 2}, function(){
                //关闭后的操作
            });
            return false
        }
        var reg = /^[0-9]+$/
        if (!reg.test(v_newreceived.value)){
            layer.msg('输入串包含非数字',{shift: 6,time: 1200, icon: 2}, function(){
                //关闭后的操作
            });
            return false
        }
        return true
    }
    function checkForm() {
        if (!checkValue()){
            return false
        }
        //询问框
        layer.confirm('新接受设备:</br>'+$("#ename_").val()+"</br>型号:"+$("#sname_").val()+
            "</br>数量:"+document.getElementById("newreceived").value+" 个", {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('录入成功', {time: 1000, icon: 1});
            var form = document.getElementById('f_auto');
            // 代码提交
            form.submit();
            waiting()
            return true
        }, function(){
            layer.msg('已取消', {
                time: 1000, //1s后自动关闭
                icon: 0
            });
            return false
        });
        return false
    }
</script>

<div class="x-body">
    <form class="layui-form"  id="f_auto" action="/LaboratoryAnimalHousing/updateApplication" method="post" >
<%--        <input type="hidden" value="${sessionScope.a.getId()}" name="a_id" id="a_id"/>--%>
<%--        <input type="hidden" value="${sessionScope.a.getEname()}" name="ename" id="ename"/>--%>
<%--        <input type="hidden" value="${sessionScope.a.getSname()}" name="sname" id="sname"/>--%>
        <div class="layui-form-item">
            <label for="id" class="layui-form-label">
                <span class="">申购单ID</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="id" name="id"
                       autocomplete="off" value="${sessionScope.a.getId()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="applicationdate_" class="layui-form-label">
                <span class="">申请日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="applicationdate_" name="applicationdate_"
                       autocomplete="off" value="<f:formatDate value="${sessionScope.a.getApplicationdate()}"
                              type="date" dateStyle="long"/>" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="ename_" class="layui-form-label">
                <span class="">设备名称</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="ename_" name="ename_"
                       autocomplete="off" value="${sessionScope.a.getEname().getName()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="sname_" class="layui-form-label">
                <span class="">设备型号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="sname_" name="sname_"
                       autocomplete="off" value="${sessionScope.a.getSname().getName()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="demandnum" class="layui-form-label">
                <span class="">需求数量</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="demandnum" name="demandnum"
                       autocomplete="off" value="${sessionScope.a.getDemandnum()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="receivednum" class="layui-form-label">
                <span class="">已有数量</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="receivednum" name="receivednum"
                       autocomplete="off" value="${sessionScope.a.receivednum}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="newreceived" class="layui-form-label">
                <span class="">接受数量</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="newreceived" name="newreceived"
                       autocomplete="off" value="${0}" class="layui-input"
                       onkeydown="return checkNum(event)" onblur="checkValue()"
                       onfocus="this.style.imeMode='disabled'" onpaste="return false"
                       ondragstart="return false" ondragenter="return false"
                       style="ime-mode:disabled;-ms-ime-mode:disabled;">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn" id="btn_on"  lay-submit="" lay-filter="updateClass" onclick="return checkForm()">
                修改
            </button>
        </div>
    </form>
</div>

<script>

</script>
</body>
</html>
