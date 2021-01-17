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
        <a href="">母猪待产行为记录</a>
        <a href="/LaboratoryAnimalHousing/seeExpectantSow">母猪待产行为操作页面</a>
      </span>
    <a class="layui-btn layui-btn-primary " style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/seeAnimalBreed" title="刷新"><i class="layui-icon">&#x1002;</i>刷新</a>
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/seeExpectantSow" >
            <input class="layui-input" placeholder="品种编码" name="AnimalNumber" id="AnimalNumber" value="${AnimalNumber}">

            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="10">
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>
        </form>
    </div>
    <xblock>
        <button id="addExpectantSowBtn" class="layui-btn layui-btn-warm"> <i class="layui-icon">&#xe608;</i>添加 </button>
        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEEquip" action="/LaboratoryAnimalHousing/addExpectantSow" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">品种编码：</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="AnimalNumber" class="layui-input"  placeholder="请输入品种编码">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">行为开始时间：</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="BehaviorStartTime" class="layui-input"  placeholder="请输入行为开始时间 格式为xxxx-xx-xx">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">行为结束时间：</label>
                    <div class="layui-input-block">
                        <input type="text" name="BehaviorEndTime"  class="layui-input"  placeholder="请输入行为结束时间 格式为xxxx-xx-xx">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">行为描述：</label>
                    <div class="layui-input-block">
                        <input type="text"  name="BehaviorDescription" class="layui-input" placeholder="请输入行为描述">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">处理方案：</label>
                    <div class="layui-input-block">
                        <input type="text" name="TreatmentPlan" class="layui-input" placeholder="请输入处理方案">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">处理结果：</label>
                    <div class="layui-input-block">
                        <input type="text" name="TreatmentResult" class="layui-input" placeholder="请输入处理结果">
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


    <%--表格数据--%>
    <table class="layui-table">
        <thead>
        <th>ID</th>
        <th>品种编码</th>
        <th>行为开始时间</th>
        <th>行为结束时间</th>
        <th>行为描述</th>
        <th>处理方案</th>
        <th>处理结果</th>
        <th>操作</th>
        </thead>
        <tbody>

        <c:forEach items="${pi.list}" var="expectantsow">
            <tr>
                    <%--<td>--%>
                    <%--<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='2'><i class="layui-icon">&#xe605;</i></div>--%>
                    <%--</td>--%>
                <td>${expectantsow.getActionID()}</td>
                <td>${expectantsow.getAnimalNumber()}</td>
                <td>${expectantsow.getBehaviorStartTime()}</td>
                <td>${expectantsow.getBehaviorEndTime()}</td>
                <td>${expectantsow.getBehaviorDescription()}</td>
                <td>${expectantsow.getTreatmentPlan()}</td>
                <td>${expectantsow.getTreatmentResult()}</td>
                <td>
                    <a title="编辑"    id= "updateEdit"    href="/LaboratoryAnimalHousing/findExpectantSowByAI?ActionID=${expectantsow.getActionID()}">
                        <i class="layui-icon">&#xe639;</i>
                    </a>
                    <a title="删除" onclick="member_del(this,'${expectantsow.getActionID()}')" href="javascript:;">
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

    layui.config({
        base: '${pageContext.request.contextPath}/resources/WLW_resourses/layui_exts/',
    }).extend({
        excel: 'excel',
    });


    layui.use(['jquery', 'excel','form','layer','laydate','table'], function(){
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;
        var excel = parent.layui.excel;

        //执行一个laydate实例
        laydate.render({
            elem: '#select_loggingdate' //指定元素
        });

        /*添加弹出框*/
        $("#addExpectantSowBtn").click(function () {
            layer.open({
                type:1,
                title:"添加母猪待产信息",
                skin:"myclass",
                area:["50%"],
                anim:2,
                content:$("#test")
            });
            $("#addExpectantSow")[0].reset();
        })

    });

    /*删除*/
    function member_del(obj,ActionID){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
            $.get("/LaboratoryAnimalHousing/deleteExpectantSow",{"ActionID":ActionID},function (data) {
                if(data =true){
                    layer.msg('删除成功!',{icon:1,time:2000});
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/seeExpectantSow';},2000);

                }else {
                    layer.msg('删除失败!',{icon:1,time:3000});
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/seeExpectantSow';},2000);
                }
            });
        });
    }

</script>
</body>
</html>
