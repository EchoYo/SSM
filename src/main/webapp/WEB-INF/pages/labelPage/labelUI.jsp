<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-13
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/general.js"></script>
<div class="vernav2 iconmenu">
    <ul>
        <c:forEach items="${privilege.privileges}" var="p" varStatus="s">
        <li><a href="#${p.url}" class="${p.spanClass}">${p.name}</a>
            <span class="arrow" ></span>
            <ul id="${p.url}" class="leftnav">
                <c:forEach items="${p.privileges}" var="ps">
                    <li><a href="${ps.url}">${ps.name}</a></li>
                </c:forEach>
            </ul>
        </li>
        </c:forEach>
    </ul>
    <a class="togglemenu"></a>
    <br/><br/>
</div>
<!--leftmenu-->
<div class="centercontent" id="centercontent">
<jsp:include page="/wx/list.do"/>
</div>
<!-- centercontent -->