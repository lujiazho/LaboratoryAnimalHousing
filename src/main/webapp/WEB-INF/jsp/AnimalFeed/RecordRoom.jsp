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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateRoom" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getAnimalNumber()}" name="AnimalNumber" id="AnimalNumber"/>
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
            <label for="IfLeave" class="layui-form-label">
                <span class="f_sp">是否暂离</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="IfLeave" name="IfLeave"
                       autocomplete="off" value="${sessionScope.s.isIfLeave()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="LeaveReason" class="layui-form-label">
                <span class="f_sp">暂离原因</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="LeaveReason" name="LeaveReason"
                       autocomplete="off" value="${sessionScope.s.getLeaveReason()}" class="layui-input">
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
