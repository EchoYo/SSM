<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-07-01
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<div class="contenttitle2">
  <h3>部门管理</h3>
</div><!--contenttitle-->
<form class="stdform" id="form_hrDept">
  <input type="hidden" name="id" value="${dept.id}"/>
  <p>
    <label>部门编号</label>
    <span class="field"><input type="text" name="deptId" class="smallinput" value="${dept.deptId}"/></span>
  </p>
  <p>
    <label>部门名称</label>
    <span class="field"><input type="text" name="deptName" class="smallinput" value="${dept.deptName}"/></span>
  </p>
  <p>
    <label>部门电话</label>
    <span class="field"><input type="text" name="phone" class="smallinput" value="${dept.phone}"/></span>
  </p>
  <p class="stdformbutton">
    <input type="button" id="updateDept" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>&nbsp;&nbsp;&nbsp;&nbsp;
  </p>
</form>

