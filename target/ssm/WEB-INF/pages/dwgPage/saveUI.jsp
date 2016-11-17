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
  <h3>新员工入职</h3>
</div><!--contenttitle-->
<form class="stdform" >
  <input type="hidden" name="date" value="${drawing.date}"/>
  <p>
    <label>编号</label>
    <span class="field"><input type="text" name="id" class="smallinput" disabled="disabled" value="${drawing.id}"/></span>
    <input type="hidden" name="id" value="${drawing.id}"/>
  </p>
  <p>
    <label>制样图版本</label>
    <span class="field"><input type="text" name="sampleDrawingEdition" class="smallinput" value="${drawing.sampleDrawingEdition}"/></span>
  </p>
  <p>
    <label>客户名称</label>
    <span class="field"><input type="text" name="customerName" class="smallinput" value="${drawing.customerName}"/></span>
  </p>
  <p>
    <label>产品名称</label>
    <span class="field"><input type="text" name="customerDrawingName" class="smallinput" value="${drawing.customerDrawingName}"/></span>
  </p>
  <p>
    <label>客户图号</label>
    <span class="field"><input type="text" name="customerDrawingNumber" class="smallinput" value="${drawing.customerDrawingNumber}"/></span>
  </p>
  <p>
    <label>客户图版本</label>
    <span class="field"><input type="text" name="customerDrawingEdition" class="smallinput" value="${drawing.customerDrawingEdition}"/></span>
  </p>

  <div class="contenttitle2">
    <h3>样品模具信息</h3>
  </div><!--contenttitle-->

  <p>
    <label>样品模具图版本</label>
    <span class="field"><input type="text" name="moldDrawingEdition" class="smallinput" value="${drawing.moldDrawingEdition}"/></span>
  </p>
  <p>
    <label>样品模具图生效日期</label>
      <span class="field"><input type="text" onclick="laydate()" name="moldDrawingDate" class="smallinput laydate-icon" value="${drawing.moldDrawingDate}"/></span>
  </p>
  <div class="contenttitle2">
    <h3>量产模具信息</h3>
  </div><!--contenttitle-->

  <p>
    <label>量产模具图版本</label>
    <span class="field"><input type="text" name="formalMoldDrawingEdition" class="smallinput" value="${drawing.formalMoldDrawingEdition}"/></span>
  </p>
  <p>
    <label>量产模具图生效日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="formalMoldDrawingDate" class="smallinput laydate-icon" value="${drawing.formalMoldDrawingDate}"/></span>
  </p>

  <div class="contenttitle2">
    <h3>量产图纸信息</h3>
  </div><!--contenttitle-->

  <p>
    <label>量产图版本</label>
      <span class="field"><input type="text" name="formalDrawingEdition" class="smallinput" value="${drawing.formalDrawingEdition}"/></span>
  </p>
  <p>
    <label>量产图生效日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="formalDrawingDate" class="smallinput aydate-icon" value="${drawing.formalDrawingDate}"/></span>
  </p>
  <p>
    <label>工艺文件编号</label>
    <span class="field"><input type="text" name="craftNumber" class="smallinput" value="${drawing.craftNumber}"/></span>
  </p>
  <p>
    <label>工艺文件版本</label>
    <span class="field"><input type="text" name="craftEdition" class="smallinput" value="${drawing.craftEdition}"/></span>
  </p>
  <p>
    <label>工艺文件生效日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="craftDate" class="smallinput aydate-icon" value="${drawing.craftDate}"/></span>
  </p>
  <p>
    <label>备注</label>
    <span class="field"><textarea cols="80" rows="5" class="longinput" name="remark">${drawing.remark}</textarea></span>
  </p>

  <p class="stdformbutton">
    <input type="button" id="save_dwg" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交">
  </p>
 </form>
