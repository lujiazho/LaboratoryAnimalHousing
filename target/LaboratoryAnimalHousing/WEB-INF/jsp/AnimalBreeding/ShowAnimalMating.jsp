<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.AnimalBreeding.domain.AnimalMating" %>
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
        <a href="/LaboratoryAnimalHousing/findAnimalMating">动物配种记录</a>
      </span>
</div>
<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/findAnimalMating" >
            <span>&nbsp&nbsp配种编号:</span>
            <input class="layui-input" name="AnimalMatingNumber" id="AnimalMatingNumber" value="${AnimalMatingNumber}">
            <span>&nbsp&nbsp公猪编号:</span>
            <input class="layui-input" name="BoarNumber" id="BoarNumber" value="${BoarNumber}">
            <span>&nbsp&nbsp母猪编号:</span>
            <input class="layui-input" name="SowNumber" id="SowNumber" value="${SowNumber}">
            <span>&nbsp&nbsp房间编号:</span>
            <input class="layui-input" name="RoomNumber" id="RoomNumber" value="${RoomNumber}">
            <span>&nbsp&nbsp配种开始时间:</span>
            <input class="layui-input" name="MatingStartTime" id="MatingStartTime" value="${MatingStartTime}">
            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="8">&nbsp&nbsp&nbsp&nbsp
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i>搜索</button>&nbsp&nbsp&nbsp&nbsp
        </form>

    </div>
    <xblock>
        <button id="addAnimalMatingBtn" class="layui-btn"> <i class="layui-icon">&#xe654;</i>添加</button>
        <a class="layui-btn" href="/LaboratoryAnimalHousing/findAnimalMating" title="刷新"><i class="layui-icon">&#xe669;</i>刷新</a>
        <span class="x-right" style="line-height:40px">共有数据：${pi.totalCount} 条</span>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addAnimalMating" action="/LaboratoryAnimalHousing/addAnimalMating" method="post">
                <div class="layui-form-item">
                    <label class="layui-form-label">配种编号</label>
                    <div class="layui-input-block layui-disabled">
                        <input type="text" lay-verify="required" name="AnimalMatingNumber" class="layui-input" placeholder="请输入配种编号">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">公猪编号</label>
                    <div class="layui-input-block">
                        <input type="text" lay-verify="required" name="BoarNumber" class="layui-input" placeholder="请输入公猪编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">母猪编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="SowNumber"  class="layui-input" placeholder="请输入母猪编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">房间编号</label>
                    <div class="layui-input-block">
                        <input type="text" name="RoomNumber"  class="layui-input" placeholder="请输入房间编号">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">配种开始时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="MatingStartTime" lay-verify="required" class="layui-input"  placeholder="请输入配种开始时间">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">配种结束时间</label>
                    <div class="layui-input-block">
                        <input type="text" name="MatingEndTime" lay-verify="required" class="layui-input"  placeholder="请输入配种结束时间">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">备注</label>
                    <div class="layui-input-block">
                        <input type="text"  name="Note" lay-verify="required" class="layui-input" placeholder="请输入备注">
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
            <th>配种编号</th>
            <th>公猪编号</th>
            <th>母猪编号</th>
            <th>房间编号</th>
            <th>配种开始时间</th>
            <th>配种结束时间</th>
            <th>备注</th>
            <th>操作</th>
        </thead>
        <tbody>
        <c:forEach items="${pi.list}" var="animalMating">
        <tr>
            <td>${animalMating.getAnimalMatingNumber()}</td>
            <td>${animalMating.getBoarNumber()}</td>
            <td>${animalMating.getSowNumber()}</td>
            <td>${animalMating.getRoomNumber()}</td>
            <td>${animalMating.getMatingStartTime()}</td>
            <td>${animalMating.getMatingEndTime()}</td>
            <td>${animalMating.getNote()}</td>
            <td>
                <a title="编辑"    id= "updateEdit"    href="/LaboratoryAnimalHousing/findAnimalMatingById?AnimalMatingNumber=${animalMating.getAnimalMatingNumber()}">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${animalMating.getAnimalMatingNumber()}')" href="javascript:;">
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
        $("#addAnimalMatingBtn").click(function () {
            layer.open({
                type:1,
                title:"添加动物配种记录",
                skin:"myclass",
                area:["45%"],
                anim:2,
                content:$("#test").html()
            });
            $("#addAnimalMating")[0].reset();
        });
    });

    /*删除*/
    function member_del(obj,AnimalMatingNumber){
        layer.confirm('确认要删除吗？',function(index){
            //发异步删除数据
           $.get("/LaboratoryAnimalHousing/deleteAnimalMating",{"AnimalMatingNumber":AnimalMatingNumber},function (data) {
                if(data =true){
                    layer.msg('删除成功!',{icon:1,time:2000});
                  setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findAnimalMating';},2000);

                }else {
                    layer.msg('删除失败!',{icon:1,time:3000});
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/findAnimalMating';},2000);
                }
            });
        });
    }

</script>
</body>
</html>
