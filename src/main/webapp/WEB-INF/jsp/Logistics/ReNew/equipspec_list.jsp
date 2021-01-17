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
    function existed(specValue) {
        var options = document.getElementById("storeSpecs");
        var optionElements = options.getElementsByTagName("option");

        for(var j = 0; j<optionElements.length; j++){
            console.log(optionElements[j].firstChild.nodeValue.toString() + " " + specValue.toString());
            if (optionElements[j].firstChild.nodeValue.toString() == specValue.toString()){
                console.log("找到相同");
                return true
            }
        }
        console.log("未找到相同");
        return false
    }
    function checkForm() {
        var v_spec = document.getElementById("name");
        if (eid.value==0){
            layer.msg('添加设备无效，重新选择',{shift: 6,time: 800, icon: 2});
            return false
        }
        if (v_spec.value==0){
            layer.msg('请输入设备型号',{shift: 6,time: 800, icon: 2});
            return false
        }
        if (existed(v_spec.value)){
            layer.msg('该设备型号已存在',{shift: 6,time: 800, icon: 2});
            return false
        }
        //询问框
        layer.confirm('您将扩展设备型号: '+v_spec.value+"</br>所属设备: "+$("#eid").find("option:selected").text()+"</br>添加后将不可删除!", {
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
        <a href="/LaboratoryAnimalHousing/equip/selectEquipSpec">设备信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/equip/selectEquipSpec" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/equip/selectEquipSpec" >
            <div class="layui-input-inline">
                <select id="select_equipspec" name="eid" lay-search="" autocomplete="off" style="width:143px;">
                    <option value="0">请选择设备名称</option>
                    <c:forEach items="${requestScope.names}" var="name">
                        <option value="${name.getId()}">${name.getName()}</option>
                    </c:forEach>
                </select>
                <c:if test="${requestScope.eid!=null && requestScope.eid!=0}">
                    <script>
                        var val = ${requestScope.eid}
                            $('#select_equipspec').find('option[value='+val+']').attr('selected','selected');
                    </script>
                </c:if>
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
            <form class="layui-form" id="addEmployeeForm" action="/LaboratoryAnimalHousing/equip/extendEquipSpec" method="post">
                <input type="hidden" name="flag" value="2">

                <div class="layui-form-item">
                    <label class="layui-form-label">设备名称：</label>
                    <div class="layui-input-block">
                        <select id="eid" name="eid" lay-search="" lay-verify="required" style="width:143px;">
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
                        <input type="text" id="name" name="name" class="layui-input" placeholder="请输入设备型号">
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
        <select id="storeSpecs" name="eid" lay-search="" autocomplete="off" style="width:143px;">
            <option value="0">用于取出值</option>
            <c:forEach items="${requestScope.allspecs}" var="spec">
                <option value="${spec.getId()}">${spec.getName()}</option>
            </c:forEach>
        </select>
    </div>
    <%--表格数据--%>
    <table class="layui-table">
        <thead>
            <th>ID</th>
            <th>设备型号</th>
            <th>所属设备</th>
            <th>操作</th>
        </thead>
        <tbody>
    <c:forEach items="${requestScope.specs}" var="spec">
        <tr>
            <td>${spec.getId()}</td>
            <td>${spec.getName()}</td>
            <td>
                <div id="you${spec.getId()}"></div>
                <c:forEach items="${requestScope.names}" var="name">
                    <c:if test="${name.getId() == spec.getEid()}">
                        <script>
                            document.getElementById('you'+${spec.getId()}).innerHTML = "${name.getName()}";
                        </script>
                    </c:if>
                </c:forEach>
            </td>
            <td>
                <a title="编辑" id= "updateEdit" onclick="member_upd(this,'${application.getId()}')" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${spec.getId()}')" href="javascript:;">
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
            title: '设备型号信息',
            cols: [[ //表头
                {
                    field: 'id',
                    width: 60,
                    title: 'id',
                }, {
                    field: 'name',
                    width: 100,
                    title: '设备型号',
                }, {
                    field: 'eid',
                    width: 100,
                    title: '所属设备',
                }
            ]]
        });
        form.on('submit(toolbarDemo)', function(){
            $.ajax({
                url: '/LaboratoryAnimalHousing/exportspeclist',
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    var options = document.getElementById("select_equipspec");
                    var optionElements = options.getElementsByTagName("option");
                    console.log(options);
                    for(let i in data){
                        for(var j = 0; j<optionElements.length; j++){
                            if (data[i]['eid'] == j){
                                var optionElement = optionElements[j].firstChild;
                                data[i]['eid'] = optionElement.nodeValue;
                                break
                            }
                        }
                    }
                    console.log(data);
                    var timestart = Date.now();
                    layui.table.exportFile('exportTable', data, 'xls');
                    var timeend = Date.now();
                    var spent = (timeend - timestart) / 1000;
                    layer.alert('导出耗时 '+spent+' s');
                },
                error: function () {
                    //console.log(data);
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/equip/selectEquip';},2000);
                }
            });
        });

        /*添加弹出框*/
        $("#addStudnetBtn").click(function () {
            layer.open({
                type:1,
                title:"添加设备型号",
                skin:"myclass",
                area:["50%"],
                anim:2,
                content:$("#test")
            });
            $("#addEmployeeForm")[0].reset();
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

</script>


</body>


</html>
