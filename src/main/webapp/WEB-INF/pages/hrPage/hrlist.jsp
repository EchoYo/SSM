<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
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
<%
  SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
  String curdate = f.format(new Date());
%>
  <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
  <div class="contenttitle2">
    <h3>在职员工档案</h3>
  </div><!--contenttitle-->
  <%--<button id="import_excel" class="stdbtn btn_lime" style="margin-left:20px">导入花名册</button>&nbsp;&nbsp;--%>
  <a href="/hr/exportData.do" class="stdbtn btn_lime" style="margin-left:20px">导出在职员工档案</a>
  <div id="contentwrapper" class="contentwrapper">
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
        <col class="con1"/>
        <col class="con0"/>
        <col class="con1"/>
        <col class="con0"/>
      </colgroup>
      <thead>
      <tr>
        <th class="head0">工号</th>
        <th class="head1">姓名</th>
        <th class="head0">性别</th>
        <th class="head1">学历</th>
        <th class="head0">用工性质</th>
        <th class="head1">参保类型</th>
        <th class="head0">所属部门</th>
        <th class="head1">入职日期</th>
        <th class="head0">登记号</th>
        <th class="head1">身份证号</th>
        <th class="head0">岗位</th>
        <th class="head1">手机号</th>
        <th class="head0">操作</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${lists}" var="empCustom">
        <tr class="gradeX">
          <td class="center">${empCustom.emp.workId}</td>
          <td class="center">${empCustom.emp.empName}</td>
          <td class="center">${empCustom.emp.sex}</td>
          <td class="center">${empCustom.educationName}</td>
          <td class="center">${empCustom.natureName}</td>
          <td class="center">${empCustom.cpfName}</td>
          <td class="center">${empCustom.deptName}</td>
          <td>${empCustom.emp.entryDate}</td>
          <td>${empCustom.emp.cardId}</td>
          <td>${empCustom.emp.identityId}</td>
          <td>${empCustom.emp.postName}</td>
          <td>${empCustom.emp.phone}</td>
          <td>
            <a href="/hr/updateUI.do?empId=${empCustom.emp.empId}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a id="${empCustom.emp.empId}" href="javascript:void(0);" onclick="return false;" class="doLeave">离职</a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <!--contentwrapper-->

  <br clear="all"/>
<div id="leave_date" style="margin: 0 auto;overflow: hidden;position: fixed;z-index: 9999;top: 50%;left: 50%;width: 220px;
height: 100px;margin-top:-50px;margin-left:-110px;border: 1px solid #f41819;background: #f1e0f4;display:none">
  <p style="margin-top: 10px;margin-left: 10px">
    <label>离职日期:</label>
    <span class="field" style="margin-left: 5px"><input type="text" onclick="laydate()" name="empLeaveDate"
                                                        class="smallinput aydate-icon" value="<%=curdate%>"/></span>
  </p>
  <br/>
  <span style="margin-left: 20px"> <button id="LY" class="submit radius2">确定</button></span>
  <span style="margin-left: 80px"> <button id="LN" class="submit radius2">取消</button></span>
</div>
<script>
  ///// 显示日期栏 /////
  jQuery(document).off('click','.stdtable a.doLeave').on('click','.stdtable a.doLeave',function(){
    var empId = $(this).attr("id");
    jQuery('#leave_date').show();
    jQuery('#LY').click(function(){
      var leaveDate = jQuery('input[name="empLeaveDate"]').val();
      jQuery('#leave_date').hide();
      jQuery.ajax({
        url:"/hr/leave.do",
        type:'post',
        data:{
          empId: empId,
          leaveDate: leaveDate
        },
        success: function (data){
          jQuery('#list_right').html(data);
        }
      })
    });
    jQuery('#LN').click(function(){
      jQuery('#leave_date').hide();
      jQuery.ajax({
        url:"/hr/list.do",
        type:'post',
        success: function (data){
          jQuery('#list_right').html(data);
        }
      })
    });
  });

</script>

