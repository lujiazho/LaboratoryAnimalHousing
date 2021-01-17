<%--
  Created by IntelliJ IDEA.
  User: hkw
  Date: 2018/10/31
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="org.lah.Logistics.domain.Waste" %>
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
    // obj为事件源对象的形参可以任意
    function checkNum(obj){
        // keyCode表示键盘的按键源码,每个键盘的按键都由特定的编码
        // 48到57是大键盘的0-9按键96到105是小键盘的的0-9
        var keyCode=obj.keyCode
        if((keyCode<48||keyCode>57)&&(keyCode<96||keyCode>105)&&keyCode!=8&&keyCode!=190){
            layer.tips('非数字输入已被阻止','#genWeight');
            // 用户按了非法的按键需要返回一个false用来阻止浏览器的默认行为
            return false
        }
        return true
    }
    function checkValue() {
        var v_weight = document.getElementById("genWeight");

        if (wastetype.value == 0 || recycable.value == 0){
            layer.msg('垃圾类型无效，重新选择',{shift: 6,time: 800, icon: 2});
            return false
        }
        if (wastetype.value == 1 && recycable.value == 1){
            layer.msg('生物垃圾不可回收，重新选择',{shift: 6,time: 800, icon: 2});
            return false
        }
        if ( 1*v_weight.value == 0){
            layer.msg('产生重量不能为0',{shift: 6,time: 800, icon: 2});
            return false
        }
        // 纯数字
        var reg1 = /^[0-9]+$/
        // 小数
        var reg2 = /^[0-9]{1,3}(\.[0-9]{1,3})?$/
        if (!reg2.test(v_weight.value)){
            layer.msg('输入串非法，重新输入',{shift: 6,time: 800, icon: 2});
            return false
        }
        return true
    }
    function checkForm() {
        if (!checkValue()){
            return false
        }
        var v_genWeight = document.getElementById("genWeight");
        //询问框
        layer.confirm('您将录入垃圾产生信息</br>类型: '+$("#wastetype").find("option:selected").text()+"</br>可否回收: "+
            $("#recycable").find("option:selected").text()+"</br>产生重量: "+v_genWeight.value+" 吨", {
            btn: ['确定','取消'] //按钮
        }, function(){
            layer.msg('录入成功', {time: 1000, icon: 1});
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
        <a href="/LaboratoryAnimalHousing/waste/selectWaste">设备信息</a>
      </span>
    <a class="layui-btn layui-btn-small" style="line-height:1.6em;margin-top:3px;float:right" href="/LaboratoryAnimalHousing/waste/selectWaste" title="刷新">
        <i class="layui-icon" style="line-height:30px">ဂ</i></a>
</div>

<div class="x-body">
    <div class="layui-row">
        <form class="layui-form layui-col-md12 x-so" action="/LaboratoryAnimalHousing/waste/selectWaste" >
            <div class="layui-input-inline">
                <input type="text" name="string_wastedate" id="select_loggingdate" placeholder="请选择录入日期" autocomplete="off" class="layui-input" value="${requestScope.string_wastedate}">
            </div>
            <div class="layui-input-inline">
                <select id="recyc" name="recycable" lay-verify="required" style="width:143px;">
                    <option value="0">请选择回收类型</option>
                    <option value="1">可回收</option>
                    <option value="2">不可回收</option>
                </select>
                <c:if test="${requestScope.recyc!=null && requestScope.recyc!=0}">
                    <script>
                        var val = ${requestScope.recyc}
                        $('#recyc').find('option[value='+val+']').attr('selected','selected');
                    </script>
                </c:if>
            </div>
            <div class="layui-input-inline">
                <select id="type" name="wastetype" lay-verify="required" style="width:143px;">
                    <option value="0">请选择垃圾类型</option>
                    <option value="1">生物垃圾</option>
                    <option value="2">普通垃圾</option>
                </select>
                <c:if test="${requestScope.type!=null && requestScope.type!=0}">
                    <script>
                        var val = ${requestScope.type}
                        $('#type').find('option[value='+val+']').attr('selected','selected');
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
            <form class="layui-form" id="addEmployeeForm" action="/LaboratoryAnimalHousing/waste/addWaste" method="post">
                <input type="hidden" name="flag" value="2">

                <div class="layui-form-item">
                    <label class="layui-form-label">回收类型：</label>
                    <div class="layui-input-block">
                        <select id="recycable" name="recycable" lay-verify="required" style="width:143px;">
                            <option value="0">请选择回收类型</option>
                            <option value="1">可回收</option>
                            <option value="2">不可回收</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">垃圾类型：</label>
                    <div class="layui-input-block">
                        <select id="wastetype" name="wastetype" lay-verify="required" style="width:143px;">
                            <option value="0">请选择垃圾类型</option>
                            <option value="1">生物垃圾</option>
                            <option value="2">普通垃圾</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">产生重量(吨)：</label>
                    <div class="layui-input-block">
                        <input type="text" id="genWeight" name="wasteweight" class="layui-input" placeholder="产生重量"
                               autocomplete="off" onkeydown="return checkNum(event)" onblur="checkValue()"
                               onfocus="this.style.imeMode='disabled'" onpaste="return false"
                               ondragstart="return false" ondragenter="return false">
                    </div>
                    <div class="layui-form-mid layui-word-aux">整数/小数位数最大均为3</div>
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
            <th>录入日期</th>
            <th>产生重量(吨)</th>
            <th>可否回收</th>
            <th>类型</th>
            <th>操作</th>
        </thead>
        <tbody>
    <c:forEach items="${requestScope.wastes}" var="waste">
        <tr>
            <td>${waste.getId()}</td>
            <td>
                <f:formatDate value="${waste.getLoggingdate()}" type="date" dateStyle="long"/>
            </td>
            <td>${waste.getWasteweight()}</td>
            <td>
                <c:choose>
                    <c:when test="${waste.getRecycable() == 1}">可回收</c:when>
                    <c:otherwise>不可回收</c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:choose>
                    <c:when test="${waste.getWastetype() == 1}">生物垃圾</c:when>
                    <c:otherwise>普通垃圾</c:otherwise>
                </c:choose>
            </td>
            <td>
                <a title="编辑" id= "updateEdit" onclick="member_upd(this,'${waste.getId()}')" href="javascript:;">
                    <i class="layui-icon">&#xe642;</i>
                </a>
                <a title="删除" onclick="member_del(this,'${waste.getId()}')" href="javascript:;">
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
            elem: '#select_loggingdate' //指定元素
        });

        // 导出表格配置
        layui.table.render({
            elem: '#table',
            id: 'exportTable',
            cellMinWidth: 100,
            title: '垃圾记录信息',
            cols: [[ //表头
                {
                    field: 'id',
                    width: 60,
                    title: 'id',
                }, {
                    field: 'loggingdate',
                    width: 160,
                    title: '录入日期',
                }, {
                    field: 'wasteweight',
                    width: 100,
                    title: '垃圾重量',
                }, {
                    field: 'recycable',
                    width: 100,
                    title: '可否回收',
                }, {
                    field: 'wastetype',
                    width: 100,
                    title: '垃圾类型',
                }
            ]]
        });
        form.on('submit(toolbarDemo)', function(){
            $.ajax({
                url: '/LaboratoryAnimalHousing/exportwastelist',
                type: 'post',
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    for(let i in data){
                        data[i]['loggingdate'] = formatDate(data[i]['loggingdate'])
                        if (data[i]['recycable'] == 1){
                            data[i]['recycable'] = "可回收"
                        }else{
                            data[i]['recycable'] = "不可回收"
                        }
                        if (data[i]['wastetype'] == 1){
                            data[i]['wastetype'] = "生物垃圾"
                        }else{
                            data[i]['wastetype'] = "普通垃圾"
                        }
                    }
                    console.log(data);
                    var timestart = Date.now();
                    layui.table.exportFile('exportTable', data, 'xls');
                    var timeend = Date.now();
                    var spent = (timeend - timestart) / 1000;
                    layer.alert('导出耗时 '+spent+' s');
                },
                error: function (data) {
                    console.log(data);
                    setTimeout(function () {window.location.href='/LaboratoryAnimalHousing/waste/selectWaste';},2000);
                }
            });
        });

        /*添加弹出框*/
        $("#addStudnetBtn").click(function () {
            layer.open({
                type:1,
                title:"添加垃圾产生信息",
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
