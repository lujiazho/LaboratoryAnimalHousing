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
        .layui-form-select dl {
            max-height: 175px;
        }
    </style>
</head>

<body>
<script>
    function checkValue() {
        var v_result = document.getElementById("result");
        var text = v_result.value
        if (equipspec.value == 0 || equipname.value == 0 || enumber.value == 0 || maintainer.value == 0){
            layer.msg('每项均为必填项！',{shift: 6,time: 800, icon: 2});
            return false
        }
        if ( text == "" || text == null){
            layer.msg('检修结果不能为空',{shift: 6,time: 800, icon: 2});
            return false
        }
        if (text.length > 120){
            layer.msg('输入字符过多，不超过120字',{shift: 6,time: 800, icon: 2});
            return false
        }
        return true
    }
    function checkForm() {
        if (!checkValue()){
            return false
        }
        var v_result = document.getElementById("result");
        //询问框
        layer.confirm('您将录入检修信息</br>设备: '+$("#equipname").find("option:selected").text()+"</br>型号: "+
            $("#equipspec").find("option:selected").text()+"</br>编号: "+$("#enumber").find("option:selected").text()
            +"</br>检修人: "+$("#maintainer").find("option:selected").text()+"</br>检修结果: "+
            v_result.value, {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('录入成功', {time: 1000, icon: 1});
            var form = document.getElementById('addMaintenForm');
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
        <a href="/LaboratoryAnimalHousing/equip/selectMaintenance">检修信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/equip/selectMaintenance" title="刷新" onclick="waiting()">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/equip/selectMaintenance" >
            <div class="layui-input-inline">
                <input type="text" name="string_maintenancedate" id="select_maintenancedate" placeholder="请选择检修日期" autocomplete="off" class="layui-input" value="${requestScope.string_maintenancedate}">
            </div>
            <div class="layui-input-inline">
                <select id="select_equipname" name="ename_id" lay-search="" autocomplete="off" lay-filter="selectSpec" style="width:143px;">
                    <option value="">请选择设备名</option>
                    <c:forEach items="${requestScope.names}" var="name">
                        <option value="${name.getId()}">${name.getName()}</option>
                    </c:forEach>
                </select>
                <c:if test="${requestScope.ename_id!=null && requestScope.ename_id!=0}">
                    <script>
                        var val = ${requestScope.ename_id}
                            $('#select_equipname').find('option[value='+val+']').attr('selected','selected');
                    </script>
                </c:if>
            </div>
            <div class="layui-input-inline">
                <select id="select_equipspec" name="sname_id" lay-search="" lay-filter="select_equipspec" style="width:143px;">
                    <option value="">请选择设备型号</option>
                    <c:if test="${requestScope.sname_id!=null && requestScope.sname_id!=0}">
                        <option value="${requestScope.sname_id}"></option>
                    </c:if>
                </select>
                <c:if test="${requestScope.sname_id!=null && requestScope.sname_id!=0}">
                    <c:forEach items="${requestScope.models}" var="model">
                        <c:if test="${requestScope.sname_id==model.getId()}">
                            <script>
                                $('#select_equipspec').find('option[value='+"${requestScope.sname_id}"+']').text("${model.getName()}")
                                var valx = ${requestScope.sname_id};
                                $('#select_equipspec').find('option[value='+valx+']').attr('selected','selected');
                            </script>
                        </c:if>
                    </c:forEach>
                </c:if>
            </div>

            <input class="layui-input" type="hidden" name="pageIndex" value="1">
            <input class="layui-input" type="hidden" name="pageSize" value="4">
            <button class="layui-btn"  lay-submit="" lay-filter="search" onclick="waiting()"><i class="layui-icon">&#xe615;</i></button>
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
            <form class="layui-form" id="addMaintenForm" action="/LaboratoryAnimalHousing/equip/addMaintenance" method="post">
                <input type="hidden" name="flag" value="2">
                <div class="layui-form-item">
                    <label class="layui-form-label">设备名称：</label>
                    <div class="layui-input-block">
                        <select id="equipname" name="ename_id" lay-search="" lay-verify="required" lay-filter="mmp" style="width:143px;">
                            <option value="0">请选择设备名称</option>
                            <c:forEach items="${requestScope.names}" var="name">
                                <option value="${name.getId()}">${name.getName()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">设备型号：</label>
                    <div class="layui-input-block">
                        <select id="equipspec" name="sname_id" lay-search="" lay-verify="required" lay-filter="equipspec" style="width:143px;">
                            <option value="0">请选择设备型号</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">设备编号：</label>
                    <div class="layui-input-block">
                        <select id="enumber" name="enumber" lay-search="" lay-verify="required" lay-filter="enumber" style="width:143px;">
                            <option value="0">请选择设备编号</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">检修人：</label>
                    <div class="layui-input-block">
                        <select id="maintainer" name="maintainer_id" lay-search="" lay-verify="required" lay-filter="maintainer_id" style="width:143px;">
                            <option value="0">请选择检修人</option>
                            <c:forEach items="${requestScope.maintainers}" var="maintainer">
                                <option value="${maintainer.getId()}">${maintainer.getUsername()}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item layui-form-text">
                    <label class="layui-form-label">检修结果</label>
                    <div class="layui-input-block">
                        <textarea id="result" name="maintenanceresult" placeholder="请输入检修结果" lay-verify="required" class="layui-textarea"></textarea>
                    </div>
                </div>
<%--                <input type="text" id="employee_id" name="employee_id" class="layui-input" style="display:none" placeholder="申请人id" value="${sessionScope.user_session.id}">--%>

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
            <th>检修日期</th>
            <th>设备名称</th>
            <th>设备型号</th>
            <th>设备编号</th>
            <th>检修人</th>
            <th>检修人编号</th>
            <th>检修结果</th>
            <th>操作</th>
        </thead>
        <tbody>
    <c:forEach items="${requestScope.maintenances}" var="maintenance">
        <tr>
            <td>${maintenance.getId()}</td>
            <td>
                <f:formatDate value="${maintenance.getMaintenancedate()}"
                              type="date" dateStyle="long"/>
            </td>
            <td>${maintenance.getEname().getName()}</td>
            <td>${maintenance.getSname().getName()}</td>
            <td>${maintenance.getEnumber()}</td>
            <td>${maintenance.getMaintainer().getUsername()}</td>
            <td>${maintenance.getMaintainer().getNumber()}</td>
            <td>${maintenance.getMaintenanceresult()}</td>
            <td>
                <a title="编辑" id="updateEdit" onclick="member_upd(this,'${application.getId()}')" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${maintenance.getId()}')" href="javascript:;">
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

        //执行一个laydate实例
        laydate.render({
            elem: '#select_maintenancedate' //指定元素
        });
        // 根据设备名找设备型号
        form.on('select(selectSpec)', function(data){
            var idJudge = data.value
            // alert(idJudge)
            if (idJudge==0){
                $("#select_equipspec").empty()
                $('#select_equipspec option:selected').empty()
                var ini = $("<option value=\"0\">请选择设备型号</option>")
                $("#select_equipspec").append(ini);
                form.render("select");
                return
            }
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState==4 && xmlHttp.status==200){
                    var datax = xmlHttp.responseText;
                    // 转为json数组
                    var specArray = eval("("+datax+")")
                    // 销毁原来的
                    $("#select_equipspec").empty()
                    // 将数组种的型号加入
                    $('#select_equipspec').html('<option value="0">请选择设备型号</option>')
                    for (var i=0 ; i<specArray.length ; i++){
                        var specObj = specArray[i];
                        // alert(specObj)
                        $('#select_equipspec').append(new Option(specObj.name,specObj.id));
                    }
                    form.render("select");
                }
            }
            xmlHttp.open("get", "${pageContext.request.contextPath}/spec/findSpec.do?eid=" + idJudge, true)
            xmlHttp.send()
        })
        //导出表格配置
        layui.table.render({
            elem: '#table',
            id: 'exportTable',
            cellMinWidth: 100,
            title: '检修信息',
            cols: [[ //表头
                {
                    field: 'id',
                    width: 60,
                    title: 'id',
                }, {
                    field: 'ename',
                    width: 100,
                    title: '设备名称',
                }, {
                    field: 'sname',
                    width: 120,
                    title: '设备型号',
                }, {
                    field: 'enumber',
                    width: 100,
                    title: '设备编号',
                }, {
                    field: 'maintainer',
                    width: 100,
                    title: '检修人',
                }, {
                    field: 'maintenancedate',
                    width: 100,
                    title: '检修日期',
                }, {
                    field: 'maintenanceresult',
                    width: 300,
                    title: '检修结果',
                }
            ]]
        });
        form.on('submit(toolbarDemo)', function(){
            $.ajax({
                url: '/LaboratoryAnimalHousing/exportmaintenancelist',
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    for(let i in data){
                        data[i]['ename'] = data[i]['ename']['name']
                        data[i]['sname'] = data[i]['sname']['name']
                        data[i]['maintainer'] = data[i]['maintainer']['username']
                        data[i]['maintenancedate'] = formatDate(data[i]['maintenancedate'])
                    }
                    console.log(data);
                    var timestart = Date.now();
                    layui.table.exportFile('exportTable', data, 'xls');
                    var timeend = Date.now();

                    var spent = (timeend - timestart) / 1000;
                    layer.alert('导出耗时 '+spent+' s');
                },
                error: function () {
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/equip/selectMaintenance';},2000);
                }
            });
        });

        /*添加弹出框*/
        $("#addStudnetBtn").click(function () {
            layer.open({
                type:1,
                title:"添加检修信息",
                skin:"myclass",
                area:["50%"],
                anim:2,
                content:$("#test")
            });
            $("#addMaintenForm")[0].reset();
            form.on('select(mmp)', function(data){
                var idJudge = data.value;
                // alert(idJudge)
                if (idJudge==0){
                    $("#equipspec").empty()
                    $('#equipspec option:selected').empty()
                    var ini = $("<option value=\"0\">请选择设备型号</option>")
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
                        // 销毁原来的
                        $("#equipspec").empty()

                        $('#equipspec').html('<option value="0">请选择设备型号</option>')
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
            form.on('select(equipspec)', function(data){
                form.render("select");
            })
            // onchange的layui实现
            form.on('select(equipspec)', function(data){
                var idJudge = data.value;
                // alert(idJudge)
                if (idJudge==0){
                    $("#enumber").empty()
                    $('#enumber option:selected').empty()
                    var ini = $("<option value=\"0\">请选择设备编号</option>")
                    $("#enumber").append(ini);
                    form.render('select');
                    form.render();
                    return
                }
                var xmlHttp = new XMLHttpRequest();
                xmlHttp.onreadystatechange = function () {
                    if (xmlHttp.readyState==4 && xmlHttp.status==200){
                        var datax = xmlHttp.responseText;
                        // 转为json数组
                        var numberArray = eval("("+datax+")")
                        // 销毁原来的
                        $("#enumber").empty()

                        $('#enumber').html('<option value="0">请选择设备编号</option>')
                        for (var i=0 ; i<numberArray.length ; i++){
                            var specObj = numberArray[i];
                            $('#enumber').append(new Option(specObj.equipmentnumber,specObj.equipmentnumber));
                        }
                        form.render("select");
                    }
                }

                xmlHttp.open("get", "${pageContext.request.contextPath}/spec/findNumber.do?eid="+$("#equipname").val()+"&sid="+data.value, true)
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
