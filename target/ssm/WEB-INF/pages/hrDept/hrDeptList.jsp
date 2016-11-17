<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-07-01
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contenttitle2">
    <h3>部门管理</h3>
</div>
<!--contenttitle-->
<button id="add_dept" class="stdbtn btn_lime" style="margin-left:20px">添加部门</button>
<div id="contentwrapper" class="contentwrapper">
    <table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
        <colgroup>
            <col class="con0"/>
            <col class="con1"/>
            <col class="con0"/>
        </colgroup>
        <thead>
        <tr>
            <th class="head0">部门编号</th>
            <th class="head1">部门名称</th>
            <th class="head0">部门电话</th>
            <th class="head0">操作</th>
        </tr>
        <tbody>
        <c:forEach items="${lists}" var="dept">
            <tr class="gradeX">
                <td class="center">${dept.deptId}</td>
                <td class="center">${dept.deptName}</td>
                <td class="center">${dept.phone}</td>
                <td><a href="/dept/updateUI.do?id=${dept.id}">修改</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!--contentwrapper-->
<br clear="all"/>