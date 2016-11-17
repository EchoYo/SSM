<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-08
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>控制台页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.default.css" type="text/css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/laydate/skins/molv/laydate.css"/>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/laydate/need/laydate.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-1.7.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.uniform.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.cookie.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.flot.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.flot.resize.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/jquery.slimscroll.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/plugins/chosen.jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/laydate/laydate.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/general.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/clockpicker.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/myJs/clockpicker.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/myJs/standalone.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/reportPage.js"></script>

    <!--[if lte IE 8]>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/js/plugins/excanvas.min.js"></script><![endif]-->
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

<body class="withvernav">
<div class="bodywrapper" id="bodywrapper">
    <div class="topheader">
        <div class="left">
            <h1 class="logo">JT.<span>OA</span></h1>
            <span class="slogan">后台管理系统</span>
            <br clear="all"/>
        </div>
        <div class="right">
            <div class="userinfo">
                <img src="${pageContext.request.contextPath}/images/thumbs/avatar.png" alt="" />
                <span>${sessionScope.username}</span>
            </div><!--userinfo-->

            <div class="userinfodrop">
                <div class="avatar">
                    <a href=""><img src="${pageContext.request.contextPath}/images/thumbs/avatarbig.png" alt="" /></a>
                </div><!--avatar-->
                <div class="userdata">
                    <h4>${sessionScope.accountId}</h4>
                    <ul>
                        <li><a href="">编辑资料</a></li>
                        <li><a href="/logout.do">退出</a></li>
                    </ul>
                </div><!--userdata-->
            </div><!--userinfodrop-->
        </div><!--right-->

    </div>
    <!--topheader-->

    <div class="header">
        <ul class="headermenu">
            <c:forEach items="${list}" var="p" varStatus="s">
                <li <c:if test="${s.index == 0}">class="current"</c:if> ><a href="${p.url}">
                    <span class="${p.spanClass}"></span>${p.name}</a></li>
            </c:forEach>
        </ul>
    </div>
    <!--header-->
    <div id="load">
        <c:choose>
            <c:when test="${sessionScope.roleId == 'R001'}"><jsp:include page="/drawing/dwgUI.do"/></c:when>
            <c:when test="${sessionScope.roleId == 'R002'}"><jsp:include page="/labelUI.do"/></c:when>
            <c:when test="${sessionScope.roleId == 'R003'}"><jsp:include page="/hrUI.do"/></c:when>
        </c:choose>
    </div>
</div>
<!--bodywrapper-->
</body>
</html>
