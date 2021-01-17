<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>实验动物房动物繁育系统</title>
    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/pg_btn.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
</head>
<style type="text/css">
    .layui-table{
        text-align: center;
    }
    .layui-form{
        width: 500px;
    }
    .layui-form-label{
        width: 130px;
    }
    .layui-input-block {
        margin-left: 130px;
        min-height: 36px
    }
    .layui-input{
        width: 230px;
    }
</style>
<body>

<div class="x-body">
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateMatingBoar" method="post"  id="f_auto" accept-charset="UTF-8">
        <div class="layui-form-item"><xblock>修改种猪配种行为记录</xblock></div>
        <div class="layui-form-item">
            <label for="ActionID" class="layui-form-label">行为记录编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="ActionID" name="ActionID"
                       autocomplete="off" value="${sessionScope.matingBoar.getActionID()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AnimalNumber" class="layui-form-label">动物编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="AnimalNumber" name="AnimalNumber"
                       autocomplete="off" value="${sessionScope.matingBoar.getAnimalNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BehaviorStartTime" class="layui-form-label">行为开始日期</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="BehaviorStartTime" name="BehaviorStartTime"
                       autocomplete="off" value="${sessionScope.matingBoar.getBehaviorStartTime()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BehaviorEndTime" class="layui-form-label">行为结束日期</label>
            <div class="layui-input-inline">
                <input type="text" id="BehaviorEndTime" name="BehaviorEndTime"
                       autocomplete="off" value="${sessionScope.matingBoar.getBehaviorEndTime()}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="BehaviorDescription" class="layui-form-label">行为描述</label>
            <div class="layui-input-inline">
                <input type="text" id="BehaviorDescription" name="BehaviorDescription"
                       autocomplete="off" value="${sessionScope.matingBoar.getBehaviorDescription()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="TreatmentPlan" class="layui-form-label">处理方案</label>
            <div class="layui-input-inline">
                <input type="text" id="TreatmentPlan" name="TreatmentPlan"
                       autocomplete="off" value="${sessionScope.matingBoar.getTreatmentPlan()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="TreatmentResult" class="layui-form-label">处理结果</label>
            <div class="layui-input-inline">
                <input type="text" id="TreatmentResult" name="TreatmentResult"
                       autocomplete="off" value="${sessionScope.matingBoar.getTreatmentResult()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">修改</button>
        </div>
    </form>
</div>

</body>
</html>
