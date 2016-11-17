<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-09-04
  Time: 23:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
    jQuery("#changeBox").click(function () {
        var s = jQuery(this).prop("checked");
        jQuery('input:checkbox').not('#changeBox').prop("checked", s);
    });
    ////checkbox选中后 批量添加按钮显示
    jQuery(document).on('click','input:checkbox',function () {
        var s = 0;
        jQuery('input:checkbox').not('#changeBox').each(function () {
            if (jQuery(this).attr('checked')) {
                s = 1;
                return false;
            }
        });
        if (s == 1) {
            jQuery('#changeSpan').css('display', 'inline')
        } else {
            jQuery('#changeSpan').css('display', 'none')
        }
    });
</script>
<%
    SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    String curdate=f.format(new Date());
%>
<div class="contenttitle2">
    <h3>批量调班管理</h3>
</div>
<div>
            <span>
                开始日期：<input type="text" onclick="laydate()" name="stDate" value="<%=curdate%>" class="smallinput laydate-icon"/>
                终止日期：<input type="text" onclick="laydate()" name="endDate" value="<%=curdate%>" class="smallinput laydate-icon"/>
        </span>
    <span id="changeSpan" style="display:none">
        <button id="changeButton" class="stdbtn btn_lime" style="margin-left:20px">批量调班</button>
    </span>
</div>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable2" style="font-size:6px;">
    <colgroup>
        <col class="con0" style="width: 4%"/>
        <col class="con0"/>
        <col class="con0"/>
        <col class="con0"/>
    </colgroup>
    <thead>
    <tr>
        <th class="head0 nosort"><input type="checkbox" id="changeBox"/></th>
        <th class="head0">工号</th>
        <th class="head0">姓名</th>
        <th class="head0">部门</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${empRecs}" var="empRec">
        <tr class="gradeX">
            <td align="center"><span class="center"><input type="checkbox" value="${empRec.empId}"/></span></td>
            <td>${empRec.workId}</td>
            <td>${empRec.empName}</td>
            <td>${empRec.deptName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>