<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-20
  Time: 23:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>禁止访问提示页面</title>
    <link rel="stylesheet" href="css/style.default.css" type="text/css"/>
    <script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/custom/general.js"></script>
    <!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
    <![endif]-->
    <!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
    <![endif]-->
    <!--[if lt IE 9]>
    <script src="js/plugins/css3-mediaqueries.js"></script>
    <![endif]-->
</head>
<body>
<div class="bodywrapper" id="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">JT.<span>OA</span></h1>
            <span class="slogan">后台管理系统</span>
            <br clear="all"/>
        </div>
        <div class="right">
            <div class="userinfo">
                <img src="${pageContext.request.contextPath}/images/thumbs/avatar.png" alt=""/>
                <span>${sessionScope.username}</span>
            </div>
            <!--userinfo-->

            <div class="userinfodrop">
                <div class="avatar">
                    <a href=""><img src="${pageContext.request.contextPath}/images/thumbs/avatarbig.png" alt=""/></a>
                </div>
                <!--avatar-->
                <div class="userdata">
                    <h4>${sessionScope.accountId}</h4>
                    <ul>
                        <li><a href="">编辑资料</a></li>
                        <li><a href="/logout.do">退出</a></li>
                    </ul>
                </div>
                <!--userdata-->
            </div>
            <!--userinfodrop-->
        </div>
        <!--right-->
    </div>
    <!--topheader-->

    <div class="contentwrapper padding10">
        <div class="errorwrapper error403">
            <div class="errorcontent">
                <h1>403 Forbidden Access</h1>

                <h3>Your dont' have permission to access this page.</h3>

                <p>This is likely to be caused by one of the following</p>
                <ul>
                    <li>The author of the page has intentionally limited access to it.</li>
                    <li>The computer on which the page is stored is unreachable.</li>
                    <li>You like this page.</li>
                </ul>
                <br/>
                <button class="stdbtn btn_black" onclick="history.back()">Go Back to Previous Page</button>
                &nbsp;
                <button onclick="location.href='dashboard.html'" class="stdbtn btn_orange">Go Back to Dashboard</button>
            </div>
            <!--errorcontent-->
        </div>
        <!--errorwrapper-->
    </div>


</div>
<!--bodywrapper-->

</body>
</html>
