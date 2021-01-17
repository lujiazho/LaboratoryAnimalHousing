<%--
  Created by IntelliJ IDEA.
  User: 13209
  Date: 2020/7/14
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Animal Health Manage</title>
</head>
<body>
<form action="/LaboratoryAnimalHousing/AnimalHealthlog/Page" method="post">
       选择界面<br/>
       <select name="pagename">
         <option value="EntryPage">Entry Manage</option>
         <option value="MovePage">Move Manage</option>
       </select>
       <br/>
    <button class="layui-btn layui-block" lay-filter="login" lay-submit>确定</button>
     </form>
</body>
</html>
