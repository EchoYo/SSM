<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-03
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
  jQuery('.de').click(function(){
    var url = jQuery(this).attr('href');
    jQuery(this).parent().parent().remove();
    jQuery.post(url, function(data){
      alert("删除成功！");
    });
    return false;
  });
</script>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
  <colgroup>
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
    <th class="head0">补签日期</th>
    <th class="head0">姓名</th>
    <th class="head0">工号</th>
    <th class="head0">补签时间</th>
    <th class="head0">操作员</th>
    <th class="head0">操作时间</th>
    <th class="head0">操作</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${recordCustoms}" var="rs">
  <tr class="gradeX">
    <td class="center">${rs.recDate}</td>
    <td class="center">${rs.empName}</td>
    <td class="center">${rs.workId}</td>
    <td class="center">${rs.recTime1}</td>
    <td class="center">${rs.operId}</td>
    <td class="center">${rs.operDate}</td>
    <td><a href="/record/deleteRecTime.do?id=${rs.id}" class="de">删除</a></td>
    </c:forEach>
  </tbody>
</table>