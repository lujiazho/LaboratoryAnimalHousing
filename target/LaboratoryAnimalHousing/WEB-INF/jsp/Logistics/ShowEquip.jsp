<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/9
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib prefix="fkjava" uri="/pager-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>后勤管理系统 —— 设备管理</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="pragma" content="no-cache" />
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="expires" content="0" />
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
    <meta http-equiv="description" content="This is my page" />
    <link href="${pageContext.request.contextPath}/resources/ZLJ_resources/css/css.css" type="text/css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/skins/Aqua/css/ligerui-dialog.css"/>
    <link href="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/jquery-1.11.0.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/jquery-migrate-1.2.1.js"></script>
    <script src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/ZLJ_resources/js/ligerUI/js/plugins/ligerResizable.jss" type="text/javascript"></script>
    <link href="${pageContext.request.contextPath}/resources/ZLJ_resources/css/pager.css" type="text/css" rel="stylesheet" />

    <script type="text/javascript">
        $(function(){
            /** 获取上一次选中的部门数据 */
            var boxs = $("input[type='checkbox'][id^='box_']");

            /** 给数据行绑定鼠标覆盖以及鼠标移开事件  */
            $("tr[id^='data_']").hover(function(){
                $(this).css("backgroundColor","#eeccff");
            },function(){
                $(this).css("backgroundColor","#ffffff");
            })

            /** 删除员工绑定点击事件 */
            $("#delete").click(function(){
                /** 获取到用户选中的复选框  */
                var checkedBoxs = boxs.filter(":checked");
                if(checkedBoxs.length < 1){
                    $.ligerDialog.error("请选择一个需要删除的用户！");
                }else{
                    /** 得到用户选中的所有的需要删除的ids */
                    var ids = checkedBoxs.map(function(){
                        return this.value;
                    })

                    $.ligerDialog.confirm("确认要删除吗?","删除用户",function(r){
                        if(r){
                            // alert("删除："+ids.get());
                            // 发送请求
                            window.location = "${pageContext.request.contextPath}/resources/ZLJ_resources/user/removeUser?ids=" + ids.get();
                        }
                    });
                }
            })
        })
    </script>
</head>
<body>
<!-- 导航 -->
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td height="10"></td></tr>
    <tr>
        <td width="15" height="32"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/main_locleft.gif" width="15" height="32"></td>
        <td class="main_locbg font2"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：设备 &gt; 设备查询</td>
        <td width="15" height="32"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/main_locright.gif" width="15" height="32"></td>
    </tr>
</table>

<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
    <!-- 查询区  -->
    <tr valign="top">
        <td height="30">
            <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
                <tr>
                    <td class="fftd">
                        <form name="empform" method="post" id="empform" action="${pageContext.request.contextPath}/resources/ZLJ_resources/user/selectUser">
                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                <tr>
                                    <td class="font3">
                                        用户名：<input type="text" name="username">
                                        用户状态：<input type="text" name="status">
                                        <input type="submit" value="搜索"/>
                                        <input id="delete" type="button" value="删除"/>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </td>
                </tr>
            </table>
        </td>
    </tr>

    <!-- 数据展示区 -->
    <tr valign="top">
        <td height="20">
            <table width="100%" border="1" cellpadding="5" cellspacing="0" style="border:#c2c6cc 1px solid; border-collapse:collapse;">
                <tr class="main_trbg_tit" align="center">
                    <td><input type="checkbox" name="checkAll" id="checkAll"></td>
                    <td>录入日期</td>
                    <td>设备名称</td>
                    <td>设备型号</td>
                    <td>设备编号</td>
                    <td>使用情况</td>
                    <td align="center">操作</td>
                </tr>
                <c:forEach items="${requestScope.equips}" var="equip" varStatus="stat">
                    <tr id="data_${stat.index}" align="center" class="main_trbg" onMouseOver="move(this);" onMouseOut="out(this);">
                        <td><input type="checkbox" id="box_${stat.index}" value="${equip.id}"></td>
                        <td>
                            <f:formatDate value="${equip.getLoggingdate()}"
                                          type="date" dateStyle="long"/>
                        </td>
                        <td>${equip.getEquipmentname().getName()}</td>
                        <td>${equip.getSpecificationmodel().getName()}</td>
                        <td>${equip.getEquipmentnumber()}</td>
                        <td>
                            <c:choose>
                                <c:when test="${equip.getUsage() == 1 }">使用中</c:when>
                                <c:otherwise>已损坏</c:otherwise>
                            </c:choose>
                        </td>

                        <td align="center" width="40px;"><a href="${pageContext.request.contextPath}/resources/ZLJ_resources/user/updateUser?flag=1&id=${waste.id}">
                            <img title="修改" src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/update.gif"/></a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
    <!-- 分页标签 -->
    <tr valign="top"><td align="center" class="font3">
        <fkjava:pager
                pageIndex="${requestScope.pageModel.pageIndex}"
                pageSize="${requestScope.pageModel.pageSize}"
                recordCount="${requestScope.pageModel.recordCount}"
                style="digg"
                submitUrl="${pageContext.request.contextPath}/waste/selectWaste?pageIndex={0}"/>
    </td></tr>
</table>
<div style="height:10px;"></div>
</body>
</html>