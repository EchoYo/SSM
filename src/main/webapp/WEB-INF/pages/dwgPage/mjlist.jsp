<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_right" id="list_right">
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
  <div class="contenttitle2">
    <h3>模具图信息</h3>
  </div><!--contenttitle-->
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
      </colgroup>
      <thead>
      <tr>
        <th class="head1">编号</th>
        <th class="head0">日期</th>
        <th class="head1">客户名称</th>
        <th class="head0">样品模具图版本</th>
        <th class="head1">样品模具图生效日期</th>
        <th class="head0">量产模具图版本</th>
        <th class="head1">量产模具图生效日期</th>
        <th class="head0">操作</th>
      </tr>
      </thead>
      <tfoot>
      <tr>
        <th class="head1">编号</th>
        <th class="head0">日期</th>
        <th class="head1">客户名称</th>
        <th class="head0">样品模具图版本</th>
        <th class="head1">样品模具图生效日期</th>
        <th class="head0">量产模具图版本</th>
        <th class="head1">量产模具图生效日期</th>
        <th class="head0">操作</th>
      </tr>
      </tfoot>
      <tbody>
      <c:forEach items="${drawings}" var="drawing">
        <tr class="gradeX">
          <td class="center">${drawing.id}</td>
          <td class="center">${drawing.date}</td>
          <td class="center">${drawing.customerName}</td>
          <td>${drawing.moldDrawingEdition}</td>
          <td>${drawing.moldDrawingDate}</td>
          <td>${drawing.formalMoldDrawingEdition}</td>
          <td>${drawing.formalMoldDrawingDate}</td>
          <td><a href="/drawing/updateUI.do?id=${drawing.id}">修改</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <!--contentwrapper-->

  <br clear="all"/>

</div>
