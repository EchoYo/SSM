<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-29
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
<script>
  jQuery('#reportCheckBox').click(function () {
    var s = jQuery(this).prop("checked");
    jQuery('input:checkbox').not('#reportCheckBox').prop("checked",s);
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
      jQuery('#reportButton').css('display', 'inline')
    } else {
      jQuery('#reportButton').css('display', 'none')
    }
  });
</script>
<table cellpadding="0" cellspacing="0" border="0" class="stdtable stdtablecb" id="dyntable2" style="font-size:6px;">
  <colgroup>
    <col class="con0" style="width: 4%" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
    <col class="con0" />
  </colgroup>
  <thead>
  <tr>
    <th class="head0 nosort"><input type="checkbox" id="reportCheckBox"/></th>
    <th class="head0">工号</th>
    <th class="head0">姓名</th>
    <th class="head0">节日(计)</th>
    <th class="head0">应勤</th>
    <th class="head0">实勤</th>
    <th class="head0">平时加班</th>
    <th class="head0">周末加班</th>
    <th class="head0">节日加班</th>
    <th class="head0">请假</th>
    <th class="head0">请假(时)</th>
    <th class="head0">旷工(时)</th>
    <th class="head0">迟到</th>
    <th class="head0">迟到(分)</th>
    <th class="head0">早退</th>
    <th class="head0">早退(分)</th>
    <th class="head0">出差</th>
    <th class="head0">出差(时)</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${empRecs}" var="empRec">
    <tr class="gradeX">
      <td align="center"><span class="center"><input type="checkbox" value="${empRec.empId}"/></span></td>
      <td>${empRec.workId}</td>
      <td>${empRec.empName}</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
      <td>-</td>
    </tr>
  </c:forEach>
  </tbody>
</table>