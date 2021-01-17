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
    function checkValue() {
        var val1 = document.getElementById("usage").value*1
        var val2 = ${sessionScope.a.getUsage()}*1
        if (val1*1 == val2*1) {
            layer.msg('使用情况未改变',{shift: 6, time: 1200, icon: 2}, function(){
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
        var s = "'使用中' 改为 '已损坏'吗"
        //询问框
        if (${sessionScope.a.getUsage()==2}){
            s = "'已损坏' 改为 '使用中'吗"
        }
        layer.confirm('设备: '+$("#ename_").val()+"</br>型号: "+$("#sname_").val()+
            "</br>编号: "+$("#equipmentnumber").val()+"</br>&nbsp确定将使用情况从</br>"+ s, {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('修改成功', {time: 1000, icon: 1});
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
    <form class="layui-form"  id="f_auto" action="/LaboratoryAnimalHousing/updateEquip" method="post" >
<%--        <input type="hidden" value="${sessionScope.a.getId()}" name="a_id" id="a_id"/>--%>
<%--        <input type="hidden" value="${sessionScope.a.getEname()}" name="ename" id="ename"/>--%>
<%--        <input type="hidden" value="${sessionScope.a.getSname()}" name="sname" id="sname"/>--%>
        <div class="layui-form-item">
            <label for="id" class="layui-form-label">
                <span class="">设备ID</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="id" name="id"
                       autocomplete="off" value="${sessionScope.a.getId()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="loggingdate_" class="layui-form-label">
                <span class="">录入日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="loggingdate_" name="loggingdate_"
                       autocomplete="off" value="<f:formatDate value="${sessionScope.a.getLoggingdate()}"
                              type="date" dateStyle="long"/>" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="ename_" class="layui-form-label">
                <span class="">设备名称</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="ename_" name="ename_"
                       autocomplete="off" value="${sessionScope.a.getEquipmentname().getName()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="sname_" class="layui-form-label">
                <span class="">设备型号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="sname_" name="sname_"
                       autocomplete="off" value="${sessionScope.a.getSpecificationmodel().getName()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="equipmentnumber" class="layui-form-label">
                <span class="">设备编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="equipmentnumber" name="equipmentnumber"
                       autocomplete="off" value="${sessionScope.a.getEquipmentnumber()}" class="layui-input" readonly>
            </div>
        </div>

        <div class="layui-form-item">
            <label for="usage" class="layui-form-label">
                <span class="">使用情况</span>
            </label>
            <div class="layui-input-inline">
                <select id="usage" name="usage" lay-verify="required" style="width:143px;">
                        <c:if test="${sessionScope.a.getUsage() == 1}">
                            <option value="${sessionScope.a.getUsage()}" selected>使用中</option>
                            <option value="2">已损坏</option>
                        </c:if>
                        <c:if test="${sessionScope.a.getUsage() == 2}">
                            <option value="1">使用中</option>
                            <option value="${sessionScope.a.getUsage()}" selected>已损坏</option>
                        </c:if>
                </select>
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
