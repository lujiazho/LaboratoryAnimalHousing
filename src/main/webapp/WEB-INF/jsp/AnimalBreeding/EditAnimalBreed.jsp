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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateAnimalBreed" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.animalbreed.getAnimalMatingNumber()}" name="AnimalMatingNumber" id="AnimalMatingNumber"/>
        <div class="layui-form-item">
            <label for="RecordDate" class="layui-form-label">
                <span class="f_sp">记录时间</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="RecordDate" name="RecordDate"
                       autocomplete="off" value="${sessionScope.animalbreed.getRecordDate()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="RecordDate" class="layui-form-label">
                <span class="f_sp">母猪编码</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="SowsNumber" name="SowsNumber"
                       autocomplete="off" value="${sessionScope.animalbreed.getSowsNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="SowsSituation" class="layui-form-label">
                <span class="f_sp">母猪繁育情况</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="SowsSituation" name="SowsSituation"
                       autocomplete="off" value="${sessionScope.animalbreed.getSowsSituation()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="SowsSituation" class="layui-form-label">
                <span class="f_sp">公猪编码</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="BoarsNumber" name="BoarsNumber"
                       autocomplete="off" value="${sessionScope.animalbreed.getBoarsNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="BoarsSituation" class="layui-form-label">
                <span class="f_sp">公猪繁育情况</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="BoarsSituation" name="BoarsSituation"
                       autocomplete="off" value="${sessionScope.animalbreed.getBoarsSituation()}" class="layui-input">
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
