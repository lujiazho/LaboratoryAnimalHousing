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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateAnimalMating" method="post"  id="f_auto" accept-charset="UTF-8">
        <div class="layui-form-item"><xblock>修改动物配种记录</xblock></div>
        <div class="layui-form-item">
            <label for="AnimalMatingNumber" class="layui-form-label">配种编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="AnimalMatingNumber" name="AnimalMatingNumber"
                       autocomplete="off" value="${sessionScope.animalMating.getAnimalMatingNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="BoarNumber" class="layui-form-label">公猪编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="BoarNumber" name="BoarNumber"
                       autocomplete="off" value="${sessionScope.animalMating.getBoarNumber()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="SowNumber" class="layui-form-label">母猪编码</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="SowNumber" name="SowNumber"
                       autocomplete="off" value="${sessionScope.animalMating.getSowNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="RoomNumber" class="layui-form-label">房间编码</label>
            <div class="layui-input-inline">
                <input type="text" id="RoomNumber" name="RoomNumber"
                       autocomplete="off" value="${sessionScope.animalMating.getRoomNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="MatingStartTime" class="layui-form-label">配种开始时间</label>
            <div class="layui-input-inline">
                <input type="text" readonly="readonly" id="MatingStartTime" name="MatingStartTime"
                       autocomplete="off" value="${sessionScope.animalMating.getMatingStartTime()}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="MatingEndTime" class="layui-form-label">配种结束时间</label>
            <div class="layui-input-inline">
                <input type="text" id="MatingEndTime" name="MatingEndTime"
                       autocomplete="off" value="${sessionScope.animalMating.getMatingEndTime()}" class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label for="Note" class="layui-form-label">备注</label>
            <div class="layui-input-inline">
                <input type="text" id="Note" name="Note"
                       autocomplete="off" value="${sessionScope.animalMating.getNote()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" id="btn_xg">
            <button  class="layui-btn"  id="btn_on" lay-filter="updateForm" lay-submit="">修改</button>
        </div>
    </form>
</div>

</body>
</html>
