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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateBoarRecord" method="post"  id="f_auto" accept-charset="UTF-8">
        <div class="layui-form-item"><xblock>维护种猪档案</xblock></div>
        <div class="layui-form-item">
            <label for="AnimalNumber" class="layui-form-label">动物编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="AnimalNumber" name="AnimalNumber"
                       autocomplete="off" value="${sessionScope.boarRecord.getAnimalNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="Fertility" class="layui-form-label">繁育能力</label>
            <div class="layui-input-inline">
                <input type="text" id="Fertility" name="Fertility"
                       autocomplete="off" value="${sessionScope.boarRecord.getFertility()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="BreedingHistory" class="layui-form-label">繁育历史</label>
            <div class="layui-input-inline">
                <input type="text" id="BreedingHistory" name="BreedingHistory"
                       autocomplete="off" value="${sessionScope.boarRecord.getBreedingHistory()}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">保存</button>
        </div>
    </form>
</div>

</body>
</html>
