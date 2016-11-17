<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-07-04
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_right" id="list_right">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
  <div class="contenttitle2">
    <h3>离职员工档案</h3>
  </div><!--contenttitle-->
  <a href="/hr/exportLaveData.do" class="stdbtn btn_lime" style="margin-left:20px">导出离职员工档案</a>
  <div id="contentwrapper" class="contentwrapper">
    <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
      <colgroup>
        <col class="con1"/>
        <col class="con0"/>
        <col class="con1"/>
        <col class="con0"/>
        <col class="con1"/>
        <col class="con0"/>
        <col class="con1"/>
        <col class="con0"/>
        <col class="con1"/>
        <col class="con0"/>
      </colgroup>
      <thead>
      <tr>
        <th class="head1">离职日期</th>
        <th class="head0">工号</th>
        <th class="head1">姓名</th>
        <th class="head0">性别</th>
        <th class="head1">用工性质</th>
        <th class="head0">所属部门</th>
        <th class="head1">身份证号</th>
        <th class="head0">岗位</th>
        <th class="head1">手机号</th>
        <th class="head0">操作</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${lists}" var="empCustom">
        <tr class="gradeX">
          <td>${empCustom.emp.leaveDate}</td>
          <td class="center">${empCustom.emp.workId}</td>
          <td class="center">${empCustom.emp.empName}</td>
          <td class="center">${empCustom.emp.sex}</td>
          <td class="center">${empCustom.natureName}</td>
          <td class="center">${empCustom.deptName}</td>
          <td>${empCustom.emp.identityId}</td>
          <td>${empCustom.emp.postName}</td>
          <td>${empCustom.emp.phone}</td>
          <td>
            <a href="/hr/empDetail.do?empId=${empCustom.emp.empId}">详细信息</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/hr/revoke.do?empId=${empCustom.emp.empId}">撤销离职</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <!--contentwrapper-->

  <br clear="all"/>

</div>
