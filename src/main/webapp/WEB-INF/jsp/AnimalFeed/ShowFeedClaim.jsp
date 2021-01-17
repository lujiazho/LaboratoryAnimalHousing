<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.AnimalFeed.domain.FeedClaim" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <%--<meta http-equiv="Cache-Control" content="no-siteapp" />--%>

    <link rel="icon" href="${pageContext.request.contextPath}/resources/WLW_resourses/images/favicon.ico" sizes="32x32" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/WLW_resourses/css/xadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/jquery-1.3.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui/layui.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/WLW_resourses/js/xadmin.js"></script>
    <script src="${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/excel.js"></script>

    <style type="text/css">
        .layui-table{
                text-align: center;
            }
        .layui-table th{
            text-align: center;
        }
    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/LaboratoryAnimalHousing/findFeedClaim">查询饲料领取信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/findFeedClaim" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/findFeedClaim" method="post">
            <input class="layui-input" placeholder="请输入领取编号" name="FeedReceiveNumber" id="FeedReceiveNumber" value="${FeedReceiveNumber}">

<%--            <input class="layui-input" placeholder="请输入领取日期" name="GetDate" id="GetDate">--%>
            <input type="text" name="string_Date" id="select_Date" placeholder="请选择申请日期" autocomplete="off" class="layui-input" value="${requestScope.string_GetDate}">
            <input class="layui-input" placeholder="请输入饲料类型" name="FeedType" id="FeedType" value="${FeedType}">
            <input class="layui-input" placeholder="请输入人员编号" name="PersonnelNumber" id="PersonnelNumber" value="${PersonnelNumber}">

            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="3">
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button id="addFeedClaimBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>添加 </button>
        <button class="layui-btn layui-btn-warm" lay-filter="toolbarDemo" lay-submit=""><i class="layui-icon">&#xe67c;</i>导出</button>
        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addFeedClaim" action="/LaboratoryAnimalHousing/addFeedClaim" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">领取日期：</label>
                    <div class="layui-input-block">
                        <input type="text" name="GetDate"  class="layui-input" placeholder="请输入领取日期:格式2020-07-21">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">饲料类型</label>
                    <div class="layui-input-block">
                        <input type="text" name="FeedType" lay-verify="required" class="layui-input"  placeholder="请输入饲料类型">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">领取人员编号：</label>
                    <div class="layui-input-block">
                        <input type="text" name="PersonnelNumber" lay-verify="required" class="layui-input"  placeholder="请输入人员编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">饲料袋数：</label>
                    <div class="layui-input-block">
                        <input type="text"  name="FeedNumber" lay-verify="required" class="layui-input" placeholder="请输入饲料袋数">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">异常情况记录：</label>
                    <div class="layui-input-block">
                        <input type="text" name="AbnormalCondition" class="layui-input" placeholder="请输入异常情况">
                    </div>
                </div>


                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div style="display: none">
        <input type="text" id="mycurrentposition" class="layui-input" value="${sessionScope.user_session.position}">
    </div>
    <%--表格数据--%>
    <table class="layui-table">
        <thead>
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>饲料领取编号</th>
            <th>领取日期</th>
            <th>饲料类型</th>
            <th>领取人员编号</th>
            <th>饲料袋数</th>
            <th>异常情况记录</th>
            <th>操作</th>
        </thead>
        <tbody>
<c:forEach items="${pi.list}" var="feedclaim">
        <tr>
            <%--<td>--%>
                <%--<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</td>--%>
            <td>${feedclaim.getFeedReceiveNumber()}</td>
            <td>
                <f:formatDate value="${feedclaim.getGetDate()}" type="date" dateStyle="long"/>
            </td>
            <td>${feedclaim.getFeedType()}</td>
            <td>${feedclaim.getPersonnelNumber()}</td>
            <td>${feedclaim.getFeedNumber()}</td>
            <td>${feedclaim.getAbnormalCondition()}</td>
            <td>
                <a title="编辑" onclick="return editpermission('${sessionScope.user_session.position}')" id="updateEdit" href="/LaboratoryAnimalHousing/findFeedClaimById?FeedReceiveNumber=${feedclaim.getFeedReceiveNumber()}">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${feedclaim.getFeedReceiveNumber()}','${sessionScope.user_session.position}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
</c:forEach>
        </tbody>
    </table>

<div class="" >
    <input type="hidden" id="totalPageCount" value="${pi.pageTotalCount}"/>
    <c:import url="pageBtn.jsp">
        <c:param name="totalCount" value="${pi.totalCount}"/>
        <c:param name="currentPageNo" value="${pi.pageIndex}"/>
        <c:param name="totalPageCount" value="${pi.pageTotalCount}"/>
    </c:import>
</div>
</div>
<script>
    /*删除*/
    function member_del(obj,FeedReceiveNumber,myposition){
        if(myposition != "AFManager"){
            layer.alert("对不起，您没有权限:(");
        }
            // else if(power == 1 && id == a_id){
            //     layer.alert("对不起，您没有权限:(");
        // }
        else {
            layer.alert("无删除权限:(");
        }
    }
    function editpermission(myposition){
        if(myposition != "FeedWorker" && myposition != "AFManager"){
            layer.alert("对不起，您没有权限:(");
            return false
        }
        return true
    }

    layui.config({
        base: '${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/',
    }).extend({
        excel: 'excel',
    });

    layui.use(['jquery', 'excel','form','layer','laydate'], function(){
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;
        var excel = parent.layui.excel;

        //执行一个laydate实例
        laydate.render({
            elem: '#select_Date' //指定元素
        });

        form.on('submit(toolbarDemo)', function(){
            var url="${pageContext.request.contextPath}/excelData.html?fromTime="+encodeURI(starttime)+"&toTime="+encodeURI(endtime);
            window.location.href=url;

        });

        /*添加弹出框*/
        $("#addFeedClaimBtn").click(function () {
             var v_position = document.getElementById("mycurrentposition");
            if(v_position.value != "FeedWorker" && v_position.value != "AFManager"){
                layer.alert("对不起，您没有权限:(");
                return
            }

                layer.open({
                    type: 1,
                    title: "添加领取记录",
                    skin: "myclass",
                    area: ["50%"],
                    anim: 2,
                    content: $("#test").html()
                });

            $("#addFeedClaim")[0].reset();

        });


    });




    function formatDate(date) {
        var date = new Date(date);
        var YY = date.getFullYear() + '-';
        var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate());
        return YY + MM + DD;
    }
</script>


</body>


</html>
