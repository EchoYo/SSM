<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-28
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_right" id="list_right">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
    <ul class="hornav">
        <li><a id="record_days" href="javascript:">日视图</a></li>
        <li class="current"><a id="record_month" href="javascript:">月考勤</a></li>
        <li>
            <button id="add_raw_data" class="stdbtn btn_lime" style="height:40px">导入刷卡记录</button>
        </li>
    </ul>
    <div id="contentwrapper" class="contentwrapper">
        <div id="rec_top">
            <span>
                考勤月份:<select data-placeholder="Choose a Country..." style="width:149px;height:26px"
                             class="chzn-select" tabindex="2" name="month">
                <option value="">考勤月份</option>
            </select>
                    部门:<select data-placeholder="Choose a Country..." style="width:149px;height:26px"
                               class="chzn-select" tabindex="2" name="deptId">
                <option value="">所有部门</option>
            </select>
                员工姓名：<input type="text" name="empName"/>
            <input type="button" value="查询" id="rec_dataOfMonth"/>
        </span>
        </div>
    </div>
    <!--contentwrapper-->

    <br clear="all"/>
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

        jQuery.ajax({
            type: 'POST',
            url: '/record/getMonths.do',
            dataType: 'json',
            success: function (data) {
                var list = data.months;
                var length = list.length;
                for (var i = 0; i < length; i++)
                    jQuery('select[name="month"]').append("<option value='" + list[i] + "'>" +
                            list[i] + "</option>");
            }
        });
    </script>
</div>
