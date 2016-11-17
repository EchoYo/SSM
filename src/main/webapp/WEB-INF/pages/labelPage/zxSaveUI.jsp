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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<div class="contenttitle2">
  <h3>紫翔标签</h3>
</div><!--contenttitle-->
<form class="stdform" id="form_zx">
  <input type="hidden" name="serial_no" value="${zx.serial_no}"/>
  <p>
    <label>生产日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="st_date" class="smallinput laydate-icon"/></span>
  </p>
  <p>
    <label>内部编号</label>
    <span class="field"><input type="text" name="type_id" class="smallinput" value="${zx.type_id}"/></span>
  </p>
  <p>
    <label>保质期</label>
    <span class="field"><input type="text" name="month" class="smallinput" value="${zx.month}"/></span>
  </p>
  <p>
    <label>发货数量</label>
    <span class="field"><input type="text" name="qty" class="smallinput" value="${zx.qty}"/></span>
  </p>
  <p>
    <label>客户料号</label>
    <span class="field"><input type="text" name="mat_code" class="smallinput" value="${zx.mat_code}"/></span>
  </p>
  <p>
    <label>模具号</label>
    <span class="field"><input type="text" name="batch" class="smallinput" value="${zx.batch}"/></span>
  </p>
  <p class="stdformbutton">
    <input type="button" id="updatezx" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>&nbsp;&nbsp;&nbsp;&nbsp;
  </p>
 </form>

