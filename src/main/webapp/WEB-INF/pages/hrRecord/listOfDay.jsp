<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-07-27
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/tableExport.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/jquery.base64.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/jquery.table2excel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
    jQuery(document).ready(function(){
        jQuery('#tableToExcel').click(function (){
            $("#dyntable").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Worksheet Name",
                filename: "天刷卡记录表" //do not include extension
            });
        });
    })
</script>
<button id="tableToExcel">导出</button >
<table cellpadding="0" cellspacing="0" border="0" class="stdtable" id="dyntable">
    <colgroup>
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
        <th class="head0">部门</th>
        <th class="head1">工号</th>
        <th class="head0">姓名</th>
        <th class="head1">刷卡日期</th>
        <th class="head0">星期</th>
        <th class="head1">1</th>
        <th class="head0">2</th>
        <th class="head1">3</th>
        <th class="head0">4</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${recordCustoms}" var="rs">
    <tr class="gradeX">
        <td class="center">${rs.deptName}</td>
        <td class="center">${rs.workId}</td>
        <td class="center">${rs.empName}</td>
        <td class="center">${rs.recDate}</td>
        <td class="center">${rs.dayOfWeek}</td>
        <td class="center">${rs.recTime1}</td>
        <td class="center">${rs.recTime2}</td>
        <td class="center">${rs.recTime3}</td>
        <td class="center">${rs.recTime4}</td>
        </c:forEach>
    </tbody>
</table>
