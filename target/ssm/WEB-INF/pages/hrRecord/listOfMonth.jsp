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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<div class="contenttitle2">
    <h3>&nbsp;&nbsp;&nbsp;&nbsp;${month}</h3>
</div>
<button id="exp_record_month" class="stdbtn btn_lime" style="margin-left:20px">导出月考勤</button>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
    <colgroup>
        <c:forEach items="${listDay}" var="day" varStatus="s">
            <col class="con${s.index%2}"/>
        </c:forEach>
    </colgroup>
    <thead>
    <tr>
        <th class="head0"><div>工号</div></th>
        <th class="head1"><div>姓名</div></th>
        <th class="head0"><div>部门</div></th>
        <c:forEach items="${listDay}" var="day" varStatus="s">
            <th class="head${s.index%2+1}" style="padding: 0">${day}</th>
        </c:forEach>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customs}" var="empCustom">
        <tr class="gradeX">
            <td class="center"><div>${empCustom.emp.workId}</div></td>
            <td class="center"><div>${empCustom.emp.empName}</div></td>
            <td class="center"><div>${empCustom.deptName}</div></td>
            <c:forEach items="${empCustom.records}" var="records">
                <td class="center" style="padding: 0">
                    <c:forEach items="${records}" var="recTime" varStatus="s">
                    <div>${recTime}</div>
                    </c:forEach>
                </td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>

