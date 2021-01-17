<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/7/9
  Time: 14:11
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
    <title>后勤管理系统——添加设备</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(function(){
            /** 员工表单提交 */
            $("#equipForm").submit(function(){
                <%
                    Enumeration e = request.getAttributeNames();
                    while(e.hasMoreElements()){
                        out.println(e.nextElement()+"<br>");
                    }
                    out.println(request.getAttribute("names"));
                %>
                var msg = "";
                if (msg != ""){
                    $.ligerDialog.error(msg);
                    return false;
                }else{
                    return true;
                }
                $("#employeeForm").submit();
            });
        });
    </script>
    <script>
        function specFind() {
            var idJudge = $("#equipname").val();
            if (idJudge==0){
                $("#equipspec").empty()
                var ini = $("<option value=\"0\">--请选择--</option>")
                $("#equipspec").append(ini);
                return
            }
            var xmlHttp = new XMLHttpRequest();
            xmlHttp.onreadystatechange = function () {
                if (xmlHttp.readyState==4 && xmlHttp.status==200){
                    var data = xmlHttp.responseText;
                    // 转为json数组
                    var specArray = eval("("+data+")")
                    callBack(specArray)
                }
            }
            xmlHttp.open("get", "${pageContext.request.contextPath}/spec/findSpec.do?eid=" + $("#equipname").val(), true)
            xmlHttp.send()
        }
        
        function callBack(specArray) {
            // 销毁原来的
            $("#equipspec").empty()
            // alert(specArray.length)
            // 将数组种的型号加入
            var ini = $("<option value=\"0\">--请选择--</option>")
            $("#equipspec").append(ini);
            for (var i=0 ; i<specArray.length ; i++){
                var specObj = specArray[i];
                var $option = $("<option></option>");
                $option.text(specObj.name);
                $option.val(specObj.id);
                $("#equipspec").append($option);
            }
        }
    </script>
</head>
<body>
<table width="100%" border="0" cellpadding="0" cellspacing="0">
    <tr><td height="10"></td></tr>
    <tr>
        <td width="15" height="32"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/main_locleft.gif" width="15" height="32"></td>
        <td class="main_locbg font2"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/pointer.gif">&nbsp;&nbsp;&nbsp;当前位置：设备登记  &gt; 新设备登记</td>
        <td width="15" height="32"><img src="${pageContext.request.contextPath}/resources/ZLJ_resources/images/waste_images/main_locright.gif" width="15" height="32"></td>
    </tr>
</table>
<table width="100%" height="90%" border="0" cellpadding="5" cellspacing="0" class="main_tabbor">
    <tr valign="top">
        <td>
            <form action="/LaboratoryAnimalHousing/equip/addEquip" id="equipForm" method="post">
                <!-- 隐藏表单，flag表示添加标记 -->
                <input type="hidden" name="flag" value="2">
                <table width="100%" border="0" cellpadding="0" cellspacing="10" class="main_tab">
                    <tr><td class="font3 fftd">
                        <table>
                            <tr>
                                <td class="font3 fftd">设备名称：
                                    <select id="equipname" name="equipmentname_id" onchange="specFind()" style="width:143px;">
                                        <option value="0">--请选择--</option>
                                        <c:forEach items="${requestScope.names}" var="name">
                                            <option value="${name.getId()}">${name.getName()}</option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="font3 fftd">设备型号：
                                    <select id="equipspec" name="specificationmodel_id" style="width:143px;">
                                        <option value="0">--请选择--</option>
<%--                                        <c:forEach items="${requestScope.models}" var="model">--%>
<%--                                            <option value="${model.getId()}">${model.getName()}</option>--%>
<%--                                        </c:forEach>--%>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="font3 fftd">设备编号：<input name="equipmentnumber" id="equipmentnumber" size="20" /></td>
                            </tr>
                        </table>
                    </td></tr>
                    <tr><td class="main_tdbor"></td></tr>

                    <tr><td align="left" class="fftd"><input type="submit" value="添加">&nbsp;&nbsp;<input type="reset" value="取消 "></td></tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<div style="height:10px;"></div>
</body>
</html>