<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-09-01
  Time: 16:29
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
    jQuery('#reportMonthBox').click(function () {
        var s = jQuery(this).prop("checked");
        jQuery('input:checkbox').not('#reportMonthBox').prop("checked", s);
    });

    ////checkbox选中后 批量添加按钮显示
    jQuery(document).on('click','input:checkbox',function () {
        var s = 0;
        jQuery('input:checkbox').each(function () {
            if (jQuery(this).attr('checked')) {
                s = 1;
                return false;
            }
        });
        if (s == 1) {
            jQuery('#monthSpan').css('display', 'inline')
        } else {
            jQuery('#monthSpan').css('display', 'none')
        }
    });
    //导出月报表
    jQuery(document).ready(function(){
        jQuery('#monthReportToExcel').click(function (){
            $("#dyntable2").table2excel({
                // exclude CSS class
                exclude: ".noExl",
                name: "Worksheet Name",
                filename: "月考勤报表",
                //是否导出输入框中的内容。
                exclude_inputs:"false"
            });
        });
    })
</script>
<button id="monthReportToExcel">导出</button >
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable2" style="font-size:6px;">
    <colgroup>
        <col class="con0" style="width: 4%"/>
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
        <th class="head0 nosort"><input type="checkbox" id="reportMonthBox"/></th>
        <th class="head0">部门</th>
        <th class="head0">工号</th>
        <th class="head0">姓名</th>
        <th class="head0">节日(计)</th>
        <th class="head0">应勤</th>
        <th class="head0">实勤</th>
        <th class="head0">平时加班</th>
        <th class="head0">周末加班</th>
        <th class="head0">节日加班</th>
        <th class="head0">无薪假(时)</th>
        <th class="head0">旷工(时)</th>
        <th class="head0">迟到</th>
        <th class="head0">迟到(分)</th>
        <th class="head0">早退</th>
        <th class="head0">早退(分)</th>
        <th class="head0">出差(时)</th>
    </tr>
    </thead>
    <tbody>
        <c:forEach items="${reports}" var="report">
            <tr class="gradeX">
                <td align="center"><span class="center"><input type="checkbox" value="${report.empId}"/></span></td>
                <td>${report.deptName}</td>
                <td>${report.workId}</td>
                <td>${report.empName}</td>
                <td>${report.sJieRi}</td>
                <td>${report.yChuQin}</td>
                <td>${report.sChuQin}</td>
                <td>${report.ps}</td>
                <td>${report.gx}</td>
                <td>${report.jr}</td>
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