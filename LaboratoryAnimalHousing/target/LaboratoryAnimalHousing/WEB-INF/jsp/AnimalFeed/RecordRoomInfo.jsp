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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateRoomInfo" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getRoomNumber()}" name="RoomNumber" id="RoomNumber"/>
        <div class="layui-form-item">
            <label for="RoomType" class="layui-form-label">
                <span class="f_sp">房间类型</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="RoomType" name="RoomType"
                       autocomplete="off" value="${sessionScope.s.getRoomType()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AccommodateNumber" class="layui-form-label">
                <span class="f_sp">可容纳</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="AccommodateNumber" name="AccommodateNumber"
                       autocomplete="off" value="${sessionScope.s.getAccommodateNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="AccommodatedNumber" class="layui-form-label">
                <span class="f_sp">已容纳</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="AccommodatedNumber" name="AccommodatedNumber"
                       autocomplete="off" value="${sessionScope.s.getAccommodatedNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="RoomAnomaly" class="layui-form-label">
                <span class="f_sp">房间异常</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="RoomAnomaly" name="RoomAnomaly"
                       autocomplete="off" value="${sessionScope.s.getRoomAnomaly()}" class="layui-input">
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
