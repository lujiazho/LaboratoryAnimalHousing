<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
    // function checkForm() {
    //     if (!checkValue()) {
    //         return false
    //     }
    // }
</script>
<div class="x-body">
    <form class="layui-form" action="/LaboratoryAnimalHousing/updatePaddingClaim" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getPaddingGetNumber()}" name="PaddingGetNumber" id="PaddingGetNumber"/>
        <div class="layui-form-item">
            <label for="GetDate" class="layui-form-label">
                <span class="f_sp">领取日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="GetDate" name="GetDate_"
                       autocomplete="off" value="${sessionScope.s.getGetDate()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="PaddingType" class="layui-form-label">
                <span class="f_sp">垫料类型</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="PaddingType" name="PaddingType"
                       autocomplete="off" value="${sessionScope.s.getPaddingType()}" class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label for="PersonnelNumber" class="layui-form-label">
                <span class="f_sp">领取人员编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="PersonnelNumber" name="PersonnelNumber"
                       autocomplete="off" value="${sessionScope.s.getPersonnelNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="PaddingNumber" class="layui-form-label">
                <span class="f_sp">垫料袋数</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="PaddingNumber" name="PaddingNumber"
                       autocomplete="off" value="${sessionScope.s.getPaddingNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="AbnormalCondition" class="layui-form-label">
                <span class="f_sp">异常情况记录</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="AbnormalCondition" name="AbnormalCondition"
                       autocomplete="off" value="${sessionScope.s.getAbnormalCondition()}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  type="submit" class="layui-btn"  id="btn_on" lay-filter="updateClass" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>

<script>
</script>
</body>
</html>
