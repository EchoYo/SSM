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
<script>
    jQuery.ajax({
        type: 'POST',
        url: '/dept/getDeptForHr.do',
        dataType: 'json',
        success: function (data) {
            jQuery.each(data, function (k, v) {
                jQuery('select[name="deptId"]').append("<option value='" + v.deptId + "'>" + v.deptName + "</option>");
            })
        },
        error: function () {
            alert("链接服务器出错！！:");
        }
    });
</script>
<div>
            <span>
                起始日期：<input type="text" onclick="laydate()" name="stDate" class="smallinput laydate-icon"/>
                终止日期：<input type="text" onclick="laydate()" name="endDate" class="smallinput laydate-icon"/>
                    部门: <select data-placeholder="Choose a Country..." style="width:149px;height:26px"
                                class="chzn-select" tabindex="2" name="deptId">
                <option value="">所有部门</option>
            </select>
                员工姓名：<input type="text" name="empName"/>
            <input type="button" value="查询" id="reportOfDays">
        </span>
</div>
<div id="listReportDate">

</div>