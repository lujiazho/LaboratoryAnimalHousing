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

<div class="x-body">
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateNewAnimal" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.newanimal.getAnimalNumber()}" name="AnimalNumber" id="AnimalNumber"/>
        <input type="hidden" value="${sessionScope.newanimal.getSowNumber()}" name="SowNumber" id="SowNumber"/>
        <div class="layui-form-item">
            <label for="RecordDate" class="layui-form-label">
                <span class="f_sp">记录时间</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="RecordDate" name="RecordDate"
                       autocomplete="off" value="${sessionScope.newanimal.getRecordDate()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="AnimalSex" class="layui-form-label">
                <span class="f_sp">性别</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="AnimalSex" name="AnimalSex"
                       autocomplete="off" value="${sessionScope.newanimal.getAnimalSex()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="IncineratorPerson" class="layui-form-label">
                <span class="f_sp">出生日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="IncineratorPerson" name="IncineratorPerson"
                       autocomplete="off" value="${sessionScope.newanimal.getIncineratorPerson()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BroodChamber" class="layui-form-label">
                <span class="f_sp">所属育幼室</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="BroodChamber" name="BroodChamber"
                       autocomplete="off" value="${sessionScope.newanimal.getBroodChamber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="HealthCondition" class="layui-form-label">
                <span class="f_sp">健康情况</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="HealthCondition" name="HealthCondition"
                       autocomplete="off" value="${sessionScope.newanimal.getHealthCondition()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">
                修改
            </button>
        </div>
    </form>
</div>
</body>
</html>
