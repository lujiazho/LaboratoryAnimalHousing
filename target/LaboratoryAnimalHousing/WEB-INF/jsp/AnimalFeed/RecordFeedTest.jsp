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
    <form class="layui-form" action="/LaboratoryAnimalHousing/updateFeedTest" method="post"  id="f_auto" accept-charset="UTF-8">
        <input type="hidden" value="${sessionScope.s.getFeedWaterTestNumber()}" name="FeedWaterTestNumber" id="FeedWaterTestNumber"/>
        <div class="layui-form-item">
            <label for="TestDate" class="layui-form-label">
                <span class="f_sp">检测日期</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="TestDate" name="TestDate_"
                       autocomplete="off" value="${sessionScope.s.getTestDate()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="FeedReceiveNumber" class="layui-form-label">
                <span class="f_sp">饲料接收编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedReceiveNumber" name="FeedReceiveNumber"
                       autocomplete="off" value="${sessionScope.s.getFeedReceiveNumber()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="IfFeedStandard" class="layui-form-label">
                <span class="f_sp">饲料是否达标</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="IfFeedStandard" name="IfFeedStandard"
                       autocomplete="off" value="${sessionScope.s.isIfFeedStandard()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="PersonnelNumber" class="layui-form-label">
                <span class="f_sp">检测人员编号</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="PersonnelNumber" name="PersonnelNumber"
                       autocomplete="off" value="${sessionScope.s.getPersonnelNumber()}" class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="PersonnelNumber" class="layui-form-label">
                <span class="f_sp">饲料外观检测</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedAppearanceTest" name="FeedAppearanceTest"
                       autocomplete="off" value="${sessionScope.s.getFeedAppearanceTest()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="FeedMyeteTest" class="layui-form-label">
                <span class="f_sp">饲料霉菌检测结果</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedMyeteTest" name="FeedMyeteTest"
                       autocomplete="off" value="${sessionScope.s.getFeedMyeteTest()}" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="FeedToxinTest" class="layui-form-label">
                <span class="f_sp">饲料毒素检测结果</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="FeedToxinTest" name="FeedToxinTest"
                       autocomplete="off" value="${sessionScope.s.getFeedToxinTest()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="WaterBacterialCount" class="layui-form-label">
                <span class="f_sp">单位体积饮水中细菌总数</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="WaterBacterialCount" name="WaterBacterialCount"
                       autocomplete="off" value="${sessionScope.s.getWaterBacterialCount()}" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="WaterColiformCount" class="layui-form-label">
                <span class="f_sp">单位体积饮水中大肠菌群</span>
            </label>
            <div class="layui-input-inline">
                <input type="text" id="WaterColiformCount" name="WaterColiformCount"
                       autocomplete="off" value="${sessionScope.s.getWaterColiformCount()}" class="layui-input">
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
