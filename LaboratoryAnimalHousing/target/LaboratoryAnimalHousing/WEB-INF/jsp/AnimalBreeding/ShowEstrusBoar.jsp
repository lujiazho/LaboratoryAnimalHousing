<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.AnimalBreeding.domain.EstrusBoar" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>实验动物房动物繁育系统</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
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
        .layui-form-label{
             width: 130px;
         }
        .layui-input-block {
            margin-left: 130px;
            min-height: 36px
        }
        .layui-input{
            width: 330px;
        }

    </style>
</head>

<body>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/LaboratoryAnimalHousing/findEstrusBoar">种猪发情行为记录</a>
      </span>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/findEstrusBoar" >
            <span>&nbsp&nbsp行为记录编号:</span>
            <input class="layui-input" name="ActionID" id="ActionID" value="${ActionID}">
            <span>&nbsp&nbsp&nbsp&nbsp动物编号:</span>
            <input class="layui-input" name="AnimalNumber" id="AnimalNumber" value="${AnimalNumber}">
            <span>&nbsp&nbsp行为开始时间:</span>
            <input class="layui-input" name="BehaviorStartTime" id="BehaviorStartTime" value="${BehaviorStartTime}">
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="8">&nbsp&nbsp&nbsp&nbsp
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>&nbsp&nbsp&nbsp&nbsp
        </form>

    </div>
    <xblock>
        <button id="addEstrusBoarBtn" class="layui-btn"> <i class="layui-icon">&#xe654;</i>添加</button>
        <a class="layui-btn" href="/LaboratoryAnimalHousing/findEstrusBoar" title="刷新"><i class="layui-icon">&#xe669;</i>刷新</a>
        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEstrusBoar" action="/LaboratoryAnimalHousing/addEstrusBoar" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">行为记录编号</label>
                    <div class="layui-input-block layui-disabled">
                        <input type="text" lay-verify="required" name="ActionID" class="layui-input" placeholder="请输入行为记录编号">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">动物编号</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="AnimalNumber" class="layui-input" placeholder="请输入动物编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">行为开始时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="BehaviorStartTime"  class="layui-input" placeholder="请输入行为开始时间">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">行为结束时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="BehaviorEndTime"  class="layui-input" placeholder="请输入行为结束时间">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">行为描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="BehaviorDescription" lay-verify="required" class="layui-input"  placeholder="请输入行为描述">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">处理方案</label>
                    <div class="layui-input-block">
                        <input type="text" name="TreatmentPlan" lay-verify="required" class="layui-input"  placeholder="请输入处理方案">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">处理结果</label>
                    <div class="layui-input-block">
                        <input type="text"  name="TreatmentResult" lay-verify="required" class="layui-input" placeholder="请输入处理结果">
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
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>行为记录编号</th>
            <th>动物编号</th>
            <th>行为开始时间</th>
            <th>行为结束时间</th>
            <th>行为描述</th>
            <th>处理方案</th>
            <th>处理结果</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${pi.list}" var="estrusBoar">
        <tr>
            <td>${estrusBoar.getActionID()}</td>
            <td>${estrusBoar.getAnimalNumber()}</td>
            <td>${estrusBoar.getBehaviorStartTime()}</td>
            <td>${estrusBoar.getBehaviorEndTime()}</td>
            <td>${estrusBoar.getBehaviorDescription()}</td>
            <td>${estrusBoar.getTreatmentPlan()}</td>
            <td>${estrusBoar.getTreatmentResult()}</td>
            <td>
                <a title="编辑"    id= "updateEdit"    href="/LaboratoryAnimalHousing/findEstrusBoarById?ActionID=${estrusBoar.getActionID()}">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${estrusBoar.getActionID()}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>

<div class="">
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

    layui.use(['jquery', 'excel','form','layer','laydate'], function(){
        var form = layui.form,
            $ = layui.jquery,
            laydate = layui.laydate;
        var excel = parent.layui.excel;

        //执行一个laydate实例
        laydate.render({
            elem: '#start' //指定元素
        });

        /*添加弹出框*/
        $("#addEstrusBoarBtn").click(function () {
            layer.open({
                type:1,
                title:"添加种猪发情行为记录",
                skin:"myclass",
                area:["45%"],
                anim:2,
                content:$("#test").html()
            });
            $("#addEstrusBoar")[0].reset();
        });
    });

    /*删除*/
    function member_del(obj,ActionID){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
           $.get("/LaboratoryAnimalHousing/deleteEstrusBoar",{"ActionID":ActionID},function (data) {
                if(data =true){
                    layer.msg('删除成功!',{icon:1,time:2000});
                  setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findEstrusBoar';},2000);

                }else {
                    layer.msg('删除失败!',{icon:1,time:3000});
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findEstrusBoar';},2000);
                }
            });
        });
    }

</script>
</body>
</html>
