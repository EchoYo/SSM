<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-16
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
  <colgroup>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
    <col class="con0"/>
  </colgroup>
  <thead>
  <tr>
    <th class="head0">部门</th>
    <th class="head0">工号</th>
    <th class="head0">姓名</th>
    <th class="head0">开始日期</th>
    <th class="head0">结束日期</th>
    <th class="head0">开始时间</th>
    <th class="head0">结束时间</th>
    <th class="head0">工时(小时)</th>
    <th class="head0">类型</th>
    <th class="head0">请假原因</th>
    <th class="head0">操作</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${customs}" var="rs">
  <tr class="gradeX">
    <td class="center">${rs.deptName}</td>
    <td class="center">${rs.workId}</td>
    <td class="center">${rs.empName}</td>
    <td class="center">${rs.stDate}</td>
    <td class="center">${rs.endDate}</td>
    <td class="center">${rs.stTime}</td>
    <td class="center">${rs.endTime}</td>
    <td class="center">${rs.hours}</td>
    <td class="center">${rs.resultName}</td>
    <td class="center">${rs.remark}</td>
    <td>
      <a href="/leave/updateUI.do?id=${rs.id}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
      <a href="/leave/delete.do?id=${rs.id}">删除</a>
    </td>
    </c:forEach>
  </tbody>
</table>
