<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-10
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/checkbox.js"></script>
<div class="contenttitle2">
  <h3>&nbsp;&nbsp;&nbsp;&nbsp;${month}</h3>
</div>
<div id="batch_update" style="display:none">
  起始日期：<input type="text" onclick="laydate()" name="stDate" class="smallinput laydate-icon"/>
  终止日期：<input type="text" onclick="laydate()" name="endDate" class="smallinput laydate-icon"/>
  班次: <select data-placeholder="Choose a Country..." style="width:149px;height:26px"
              class="chzn-select" tabindex="2" name="shiftId">
            <c:forEach items="${shifts}" var="shift">
                <option value="${shift.shiftId}">${shift.shiftName}</option>
            </c:forEach>
       </select>
  <button id="batch_update_button" class="stdbtn btn_lime" style="margin-left:20px;">批量排班</button>
</div>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable2" style="font-size:6px;">
  <colgroup>
    <col class="con0" style="width: 4%" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <c:forEach items="${listDay}" var="day">
      <col class="con0"/>
    </c:forEach>
  </colgroup>
  <thead>
  <tr>
    <th class="head0 nosort"><input type="checkbox" id="firstCheckBox"/></th>
    <th class="head0">工号</th>
    <th class="head0">姓名</th>
    <th class="head0">部门</th>
    <c:forEach items="${listDay}" var="day">
      <th class="head0" style="padding: 0">${day}</th>
    </c:forEach>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${customs}" var="Custom">
    <tr class="gradeX">
      <td align="center"><span class="center"><input type="checkbox" value="${Custom.empId}"/></span></td>
      <td>${Custom.workId}</td>
      <td>${Custom.empName}</td>
      <td>${Custom.deptName}</td>
      <c:forEach items="${Custom.shiftIds}" var="shiftId">
        <td class="center" style="padding: 0">${shiftId}</td>
      </c:forEach>
    </tr>
  </c:forEach>
  </tbody>
</table>

