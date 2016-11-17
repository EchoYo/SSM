<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-05
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contenttitle2">
  <h3>员工信息</h3>
</div>
<!--contenttitle-->
<form class="stdform" id="form_hrEmp">
  <input type="hidden" name="empId" value="${empCustom.emp.empId}"/>

  <p>
    <label>工号</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.emp.workId}"/></span>
  </p>
  <p>
    <label>用工性质</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.natureName}"/></span>
  </p>
  <p>
    <label>姓名</label>
        <span class="field"><input type="text" disabled="disabled" class="smallinput"
                                   value="${empCustom.emp.empName}"/></span>
  </p>
  <p>
    <label>性别</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.emp.sex}"/></span>
  </p>
  <p>
    <label>学历</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.educationName}"/></span>
  </p>
  <p>
    <label>公积金类型</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.cpfName}"/></span>
  </p>
  <p>
    <label>所属部门</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.deptName}"/></span>
  </p>
  <p>
    <label>岗位名称</label>
        <span class="field"><input type="text" disabled="disabled" class="smallinput"
                                   value="${empCustom.emp.postName}"/></span>
  </p>
  <p>
    <label>身份证号</label>
        <span class="field"><input type="text" disabled="disabled" class="smallinput"
                                   value="${empCustom.emp.identityId}"/></span>
  </p>

  <p>
    <label>入职日期</label>
    <span class="field"><input type="text" onclick="laydate()" disabled="disabled" class="smallinput laydate-icon"
                               value="${empCustom.emp.entryDate}"/></span>
  </p>

  <p>
    <label>现居住地</label>
        <span class="field"><input type="text" disabled="disabled" class="smallinput"
                                   value="${empCustom.emp.homeAddress}"/></span>
  </p>

  <p>
    <label>户籍地址</label>
        <span class="field"><input type="text" disabled="disabled" class="smallinput"
                                   value="${empCustom.emp.tmpAddress}"/></span>
  </p>
  <p>
    <label>联系电话</label>
    <span class="field"><input type="text" disabled="disabled" class="smallinput" value="${empCustom.emp.phone}"/></span>
  </p>

  <p>
    <label>离职日期</label>
    <span class="field"><input type="text" onclick="laydate()" disabled="disabled" class="smallinput aydate-icon"
                               value="${empCustom.emp.leaveDate}"/></span>
  </p>

  <p>
    <label>合同生效日期</label>
    <span class="field"><input type="text" onclick="laydate()" disabled="disabled" class="smallinput aydate-icon"
                               value="${empCustom.emp.contractStart}"/></span>
  </p>

  <p>
    <label>合同到期日期</label>
    <span class="field"><input type="text" onclick="laydate()" disabled="disabled" class="smallinput aydate-icon"
                               value="${empCustom.emp.contractEnd}"/></span>
  </p>
  <p>
    <label>备注</label>
        <span class="field"><textarea disabled="disabled" cols="80" rows="5" class="longinput"
                                      name="remarks">${empCustom.emp.remarks}</textarea></span>
  </p>
</form>
