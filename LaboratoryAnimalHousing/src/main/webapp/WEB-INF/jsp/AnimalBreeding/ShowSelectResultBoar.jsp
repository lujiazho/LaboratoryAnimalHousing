<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.AnimalBreeding.domain.SelectResultBoar" %>
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
        <a href="/LaboratoryAnimalHousing/findSelectResultBoar">种猪档案</a>
      </span>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/findSelectResultBoar" >
            <span>&nbsp&nbsp动物编码:</span>
            <input class="layui-input" name="AnimalNumber" id="AnimalNumber" value="${AnimalNumber}">
            <span>&nbsp&nbsp&nbsp&nbsp动物年龄:</span>
            <input class="layui-input" name="PigAge" id="PigAge" value="${PigAge}">
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="8">&nbsp&nbsp&nbsp&nbsp
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>&nbsp&nbsp&nbsp&nbsp
        </form>

    </div>
    <xblock>
<%--        <button id="addSelectResultBoarBtn" class="layui-btn"> <i class="layui-icon">&#xe654;</i>添加</button>--%>
        <a class="layui-btn" href="/LaboratoryAnimalHousing/findSelectResultBoar" title="刷新"><i class="layui-icon">&#xe669;</i>刷新</a>
        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>
    </xblock>

    <%--表格数据--%>
    <table class="layui-table">
        <thead>
            <%--<th>--%>
                <%--<div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>--%>
            <%--</th>--%>
            <th>动物编码</th>
            <th>动物年龄</th>
            <th>健康情况</th>
            <th>生活情况</th>
            <th>终选</th>
        </thead>
        <tbody>
        <c:forEach items="${pi.list}" var="SelectResultBoar">
        <tr>
            <td>${SelectResultBoar.getAnimalNumber()}</td>
            <td>${SelectResultBoar.getPigAge()}</td>
            <td>${SelectResultBoar.getHealthCondition()}</td>
            <td>${SelectResultBoar.getLifeCondition()}</td>
            <td>
                <a title="设置为选种对象" onclick="member_del(this,'${SelectResultBoar.getAnimalNumber()}')" href="javascript:;">
                    <i class="layui-icon">&#xe605;</i>
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
    /*终选*/
    function member_del(obj,AnimalNumber){
        layer.confirm('确认要设置为选种对象吗？',function(index){
            //发异步修改数据
           $.get("/LaboratoryAnimalHousing/updateSelectResultBoar",{"AnimalNumber":AnimalNumber},function (data) {
                if(data =true){
                    layer.msg('终选成功!下一步请进行动物辅助配种！',{icon:1,time:2000});
                  setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findSelectResultBoar';},2000);

                }else {
                    layer.msg('终选失败!',{icon:1,time:3000});
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findSelectResultBoar';},2000);
                }
            });
        });
    }

</script>
</body>
</html>
