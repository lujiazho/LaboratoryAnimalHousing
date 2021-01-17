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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateExpectantSow" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.expectantsow.getActionID()}" name="ActionID" id="ActionID"/>
        <div class="layui-form-item">
            <label for="AnimalNumber" class="layui-form-label">
                <span class="f_sp">动物编码</span>
            </label>
            <div class="layui-input-inline">
                <input type="text"  id="AnimalNumber" name="AnimalNumber"
                       autocomplete="off" value="${sessionScope.expectantsow.getAnimalNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BehaviorStartTime" class="layui-form-label">
                <span class="f_sp">行为开始时间</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="BehaviorStartTime" name="BehaviorStartTime"
                       autocomplete="off" value="${sessionScope.expectantsow.getBehaviorStartTime()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="BehaviorEndTime" class="layui-form-label">
                <span class="f_sp">行为结束时间</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="BehaviorEndTime" name="BehaviorEndTime"
                       autocomplete="off" value="${sessionScope.expectantsow.getBehaviorEndTime()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BehaviorDescription" class="layui-form-label">
                <span class="f_sp">行为描述</span>
            </label>
            <div class="layui-input-inline">
                <input type="text"  id="BehaviorDescription" name="BehaviorDescription"
                       autocomplete="off" value="${sessionScope.expectantsow.getBehaviorDescription()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="TreatmentPlan" class="layui-form-label">
                <span class="f_sp">处理方案</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="TreatmentPlan" name="TreatmentPlan"
                       autocomplete="off" value="${sessionScope.expectantsow.getTreatmentPlan()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="TreatmentResult" class="layui-form-label">
                <span class="f_sp">处理结果</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="TreatmentResult" name="TreatmentResult"
                       autocomplete="off" value="${sessionScope.expectantsow.getTreatmentResult()}" class="layui-input">
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
