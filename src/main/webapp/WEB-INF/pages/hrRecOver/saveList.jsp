<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-09-13
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
    jQuery(".chzn-select").chosen();
    jQuery('.clockpicker').clockpicker();
    jQuery("#overListBox").click(function () {
        var s = jQuery(this).prop("checked");
        jQuery('input:checkbox').not('#overListBox').prop("checked", s);
    });
    ////checkbox选中后 批量添加按钮显示
    jQuery(document).on('click', 'input:checkbox', function () {
        var s = 0;
        jQuery('input:checkbox').each(function () {
            if (jQuery(this).attr('checked')) {
                s = 1;
                return false;
            }
        });
        if (s == 1) {
            jQuery('#changeSpan1').css('display', 'inline')
        } else {
            jQuery('#changeSpan1').css('display', 'none')
        }
    });
</script>
<%
    SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
    String curdate = f.format(new Date());
%>
<div class="contenttitle2">
    <h3>批量添加加班</h3>
</div>
<div>
  <span>
    <label>加班类型</label>
          <span class="formwrapper">
                            	<select name="resultType" style="width:100px;height: 26px">
                                    <option value="0201">平时加班</option>
                                    <option value="0202">公休加班</option>
                                    <option value="0203">节日加班</option>
                                </select>
                            </span>
              <label>加班日期</label>
      <input type="text" onclick="laydate()" name="recDate" class="smallinput laydate-icon" value="<%=curdate%>" style="width:100px"/>
              <label>开始时间</label>
        <span class="field"><input type="text" name="stTime" style="width:100px" class="form-control clockpicker"
                                   data-placement="left" data-align="top" data-autoclose="true"/>
              <label>结束时间</label>
            <input type="text" name="endTime" style="width:100px" class="form-control clockpicker"
                   data-placement="left" data-align="top" data-autoclose="true"/>
       <label>加班工时</label>
          <span class="field"><input type="text" name="hours" style="width:100px"/>(小时)</span>
        </span>
    <span id="changeSpan1" style="display:none">
        <button id="addOverList" class="stdbtn btn_lime" style="margin-left: 10px">添加</button>
    </span>
</div>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable4" style="font-size:6px;">
    <colgroup>
        <col class="con0" style="width: 4%"/>
        <col class="con0"/>
        <col class="con0"/>
    </colgroup>
    <thead>
    <tr>
        <th class="head0 nosort"><input type="checkbox" id="overListBox"/></th>
        <th class="head0">部门</th>
        <th class="head0">姓名</th>
        <th class="head0">工号</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${empRecs}" var="empRec">
        <tr class="gradeX">
            <td align="center"><span class="center"><input type="checkbox" value="${empRec.empId}"/></span></td>
            <td>${empRec.deptName}</td>
            <td>${empRec.empName}</td>
            <td>${empRec.workId}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
