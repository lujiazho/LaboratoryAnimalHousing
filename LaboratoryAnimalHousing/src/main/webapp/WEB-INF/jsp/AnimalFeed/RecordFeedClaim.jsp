<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateFeedClaim" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getFeedReceiveNumber()}" name="FeedReceiveNumber" id="FeedReceiveNumber"/>
        <div class="layui-form-item">
            <label for="GetDate" class="layui-form-label">
                <span class="f_sp">领取日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="GetDate" name="GetDate_"
                       autocomplete="off" value="<f:formatDate value="${sessionScope.s.getGetDate()}"
                                                               type="date" dateStyle="long"/>" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="FeedType" class="layui-form-label">
                <span class="f_sp">饲料类型</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedType" name="FeedType"
                       autocomplete="off" value="${sessionScope.s.getFeedType()}" class="layui-input">
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
            <label for="FeedNumber" class="layui-form-label">
                <span class="f_sp">饲料袋数</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedNumber" name="FeedNumber"
                       autocomplete="off" value="${sessionScope.s.getFeedNumber()}" class="layui-input">
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
