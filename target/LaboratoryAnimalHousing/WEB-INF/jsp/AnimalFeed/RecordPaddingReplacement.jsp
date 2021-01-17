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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updatePaddingReplacement" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getPaddingReplacementNumber()}" name="PaddingReplacementNumber" id="PaddingReplacementNumber"/>
        <div class="layui-form-item">
            <label for="ReplacementDate" class="layui-form-label">
                <span class="f_sp">更换日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="ReplacementDate" name="ReplacementDate_"
                       autocomplete="off" value="${sessionScope.s.getReplacementDate()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="RoomNumber" class="layui-form-label">
                <span class="f_sp">房间编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="RoomNumber" name="RoomNumber"
                       autocomplete="off" value="${sessionScope.s.getRoomNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
        <label for="PersonnelNumber" class="layui-form-label">
            <span class="f_sp">更换人员编号</span>
        </label>
        <div class="layui-input-inline">
            <input type="text" id="PersonnelNumber" name="PersonnelNumber"
                   autocomplete="off" value="${sessionScope.s.getPersonnelNumber()}" class="layui-input">
        </div>
        </div>
        <div class="layui-form-item">
            <label for="PaddingAmount" class="layui-form-label">
                <span class="f_sp">垫料数量</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="PaddingAmount" name="PaddingAmount"
                       autocomplete="off" value="${sessionScope.s.getPaddingAmount()}" class="layui-input">
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
