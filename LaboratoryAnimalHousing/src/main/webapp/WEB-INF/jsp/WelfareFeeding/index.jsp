<%@ page import="org.lah.Commons.domain.User" %>
<%@ page import="org.lah.Commons.LahConstants" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>福利喂养登录界面</title>
</head>
<body>
<%
    // 二层路由
    String url = "404.html";
    User user = (User)session.getAttribute(LahConstants.USER_SESSION);
    if(user.getDepartment().equals("WelfareFeeding")){
        String position = user.getPosition();
        if(position.equals("FeedingPlanner")){
            url = "/resources/YT_resources/WelfareFeeding/html/feeding-planner.html";
        }
        else if(position.equals("SecurityOfficer")){
            url = "/resources/YT_resources/WelfareFeeding/html/security-officer.html";
        }
    }
    // 重定向至静态资源
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", pageContext.getServletContext().getContextPath() + url);
%>
</body>
</html>