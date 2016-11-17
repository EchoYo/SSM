<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-28
  Time: 23:22
  To change this template use File | Settings | File Templates.
  报表主页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="hornav">
    <li class="current"><a id="nonFully" href="javascript:">报表处理</a></li>
    <li><a id="report_month" href="javascript:">月报表</a></li>
    <li><a id="report_dates" href="javascript:">日报表</a></li>
</ul>
<div id="listNonFullyPage" class="contentwrapper">
    <jsp:include page="/report/reportFully.do"/>
</div>
