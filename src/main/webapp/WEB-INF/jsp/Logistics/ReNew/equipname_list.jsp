<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/10/31
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.Logistics.domain.Equip" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
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
<script>
    function existed(nameValue) {
        var options = document.getElementById("select_equipname");
        var optionElements = options.getElementsByTagName("option");

        for(var j = 0; j<optionElements.length; j++){
            // console.log(optionElements[j].firstChild.nodeValue.toString() + " " + nameValue.toString());
            if (optionElements[j].firstChild.nodeValue.toString() == nameValue.toString()){
                console.log("找到相同");
                return true
            }
        }
        console.log("未找到相同");
        return false
    }
    function checkForm() {
        var v_name = document.getElementById("name");
        if (existed(v_name.value)){
            layer.msg('该设备名称已存在',{shift: 6,time: 800, icon: 2});
            return false
        }
        if (v_name.value!=null && v_name.value!="")
        //询问框
        layer.confirm('您将扩展设备名称: '+v_name.value+"</br>添加后将不可删除!", {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('扩展成功', {time: 1000, icon: 1});
            var form = document.getElementById('addEmployeeForm');
            // 代码提交
            form.submit();
            waiting()
            return true
        }, function(){
            layer.msg('已取消', {
                time: 1000, //1s后自动关闭
                icon: 0
            });
            return false
        });
        return false
    }
</script>
<div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a href="/LaboratoryAnimalHousing/equip/selectEquipName">设备信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/equip/selectEquipName" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/equip/selectEquipName" >
            <div class="layui-input-inline">
                <select id="select_equipname" name="id" lay-search="" autocomplete="off" style="width:143px;">
                    <option value="">请选择设备名</option>
                    <c:forEach items="${requestScope.allnames}" var="name">
                        <option value="${name.getId()}">${name.getName()}</option>
                    </c:forEach>
                </select>
            </div>

            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="4">
            <button class="layui-btn"  lay-submit="" lay-filter="search"><i class="layui-icon">&#xe615;</i></button>
        </form>
    </div>
    <xblock>
        <button id="addStudnetBtn" class="layui-btn layui-btn-normal"> <i class="layui-icon">&#xe654;</i>添加 </button>
        <button class="layui-btn layui-btn-warm" lay-filter="toolbarDemo" lay-submit=""><i class="layui-icon">&#xe67c;</i>导出</button>
        <span class="x-right" style="line-height:40px">共有数据：${pageInfo.totalCount} 条</span>
    </xblock>

    <%--添加模态框--%>
    <div class="layui-row" id="test" style="display: none;">
        <div class="layui-col-md10">
            <form class="layui-form" id="addEmployeeForm" action="/LaboratoryAnimalHousing/equip/extendEquipName" method="post">
                <input type="hidden" name="flag" value="2">

                <div class="layui-form-item">
                    <label class="layui-form-label">设备名称：</label>
                    <div class="layui-input-block">
                        <input type="text" id="name" name="name" class="layui-input" lay-verify="required" placeholder="请输入设备名称">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="submit" class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo" onclick="return checkForm()">提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div style="display: none">
        <table id="table">

        </table>
    </div>
    <%--表格数据--%>
    <table class="layui-table">
        <thead>
            <th>ID</th>
            <th>设备名称</th>
            <th>操作</th>
        </thead>
        <tbody>
    <c:forEach items="${requestScope.names}" var="name">
        <tr>
            <td>${name.getId()}</td>
            <td>${name.getName()}</td>
            <td>
                <a title="编辑" id= "updateEdit" onclick="member_upd(this,'${application.getId()}')" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${name.getId()}')" href="javascript:;">
                    <i class="layui-icon">&#xe640;</i>
                </a>
            </td>
        </tr>
    </c:forEach>
        </tbody>
    </table>

<div class="" >
    <input type="hidden" id="totalPageCount" value="${pageInfo.pageTotalCount}"/>
    <c:import url="pageBtn.jsp">
        <c:param name="totalCount" value="${pageInfo.totalCount}"/>
        <c:param name="currentPageNo" value="${pageInfo.pageIndex}"/>
        <c:param name="totalPageCount" value="${pageInfo.pageTotalCount}"/>
    </c:import>
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

        // 导出表格配置
        layui.table.render({
            elem: '#table',
            id: 'exportTable',
            cellMinWidth: 100,
            title: '设备名称信息',
            cols: [[ //表头
                {
                    field: 'id',
                    width: 60,
                    title: 'id',
                }, {
                    field: 'name',
                    width: 100,
                    title: '设备名称',
                }
            ]]
        });
        form.on('submit(toolbarDemo)', function(){
            $.ajax({
                url: '/LaboratoryAnimalHousing/exportnamelist',
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    console.log(data);
                    var timestart = Date.now();
                    layui.table.exportFile('exportTable', data, 'xls');
                    var timeend = Date.now();
                    var spent = (timeend - timestart) / 1000;
                    layer.alert('导出耗时 '+spent+' s');
                },
                error: function () {
                    //console.log(data);
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/equip/selectEquipName';},2000);
                }
            });
        });

        /*添加弹出框*/
        $("#addStudnetBtn").click(function () {
            layer.open({
                type:1,
                title:"添加设备",
                skin:"myclass",
                area:["50%"],
                anim:2,
                content:$("#test")
            });
            $("#addEmployeeForm")[0].reset();
            form.on('select(mmp)', function(data){
                var idJudge = data.value;
                // alert(idJudge)
                if (idJudge==0){
                    $("#equipspec").empty()
                    $('#equipspec option:selected').empty()
                    var ini = $("<option value=\"0\">--请选择--</option>")
                    $("#equipspec").append(ini);
                    form.render('select');
                    form.render();
                    return
                }
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState==4 && xmlHttp.status==200){
                        var datax = xmlHttp.responseText;
                        // 转为json数组
                        var specArray = eval("("+datax+")")
                        // callBack(specArray)
                        // 销毁原来的
                        $("#equipspec").empty()
                        // $('#equipspec option:selected').empty()
                        // alert(specArray.length)
                        // 将数组种的型号加入
                        // var ini = $("<option value=\"0\">--请选择--</option>")
                        // $("#equipspec").append(ini);
                        $('#equipspec').html('<option value="0">--请选择--</option>')
                        for (var i=0 ; i<specArray.length ; i++){
                            var specObj = specArray[i];
                            $('#equipspec').append(new Option(specObj.name,specObj.id));
                        }
                        form.render("select");
                    }
                }
                xmlHttp.open("get", "${pageContext.request.contextPath}/spec/findSpec.do?eid=" + data.value, true)
                xmlHttp.send()
            });
        })

    });


    /*删除*/
    function member_del(obj,c_id){
        layer.msg('没有删除权限',{shift: 6,time: 800, icon: 5});
    }
    /*编辑*/
    function member_upd(obj,c_id){
        layer.msg('没有编辑权限',{shift: 6,time: 800, icon: 5});
    }
    function waiting(){
        layui.use('layer', function(){
            //加载层-风格3
            var index = layer.load(2,{
                time: 2000
            });
        });
    }

</script>


</body>


</html>
