<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-12
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>登录页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" type="text/css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/general.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/index.js"></script>
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
</head>

<body class="loginpage">
<script language=”JavaScript”>
if (window != top)
top.location.href = location.href;
</script>
<div class="loginbox">
    <div class="loginboxinner">
        <div class="logo">
            <h1 class="logo">JT.<span>OA</span></h1>
        </div>
        <!--logo-->
        <form id="login" action="/toLogin.do" method="post">
            <div class="username">
                <div class="usernameinner">
                    <input type="text" id="username" name="username" value="${accountId}"/>
                </div>
            </div>

            <div class="password">
                <div class="passwordinner">
                    <input type="password" id="password" name="password"/>
                </div>
            </div>
            <span class="message" style="text-align:center;margin-left:110px;color:#F4A852">${message}</span>
            <button class="button">登录</button>
        </form>
    </div>
    <!--loginboxinner-->
</div>
<!--loginbox-->
</body>
</html>

