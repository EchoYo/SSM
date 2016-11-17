<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-28
  Time: 23:22
  To change this template use File | Settings | File Templates.
  报表主页
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/tableExport.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/jquery.base64.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/jquery.table2excel.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
    //导出日报表
    jQuery(document).ready(function(){
        jQuery('#dayReportToExcel').click(function (){
            $("#dyntable2").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Worksheet Name",
                filename: "日考勤报表" //do not include extension
            });
        });
    })
</script>
<button id="dayReportToExcel">导出</button >
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable2" style="font-size:6px;">
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
        <th class="head0">姓名</th>
        <th class="head0">日期</th>
        <th class="head0">班次名</th>
        <th class="head0">上班/下班</th>
        <th class="head0">节日(计)</th>
        <th class="head0">应出勤</th>
        <th class="head0">实出勤</th>
        <th class="head0">平时加班</th>
        <th class="head0">周末加班</th>
        <th class="head0">节日加班</th>
        <th class="head0">请假类型</th>
        <th class="head0">请假工时</th>
        <th class="head0">旷工(时)</th>
        <th class="head0">迟到</th>
        <th class="head0">迟到(分)</th>
        <th class="head0">早退</th>
        <th class="head0">早退(分)</th>
        <th class="head0">出差(时)</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${reports}" var="report" varStatus="s">
        <tr class="gradeX">
            <td>${report.empName}</td>
            <td>${report.recDate}</td>
            <td>${report.shiftName}</td>
            <td>${report.stAtdTime}&nbsp;&nbsp;${report.endAtdTime}</td>
            <td>${report.sJieRi}</td>
            <td>${report.yChuQin}</td>
            <td>${report.sChuQin}</td>
            <td>${report.ps}</td>
            <td>${report.gx}</td>
            <td>${report.jr}</td>
            <td>${report.resultName}</td>
            <td>${report.leaveHours}</td>
            <td>${report.kuangGong}</td>
            <td>${report.late}</td>
            <td>${report.lateMinutes}</td>
            <td>${report.early}</td>
            <td>${report.earlyMinutes}</td>
            <td>${report.tripHours}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
