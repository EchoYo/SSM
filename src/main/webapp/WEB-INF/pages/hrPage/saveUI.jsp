<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-29
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<div class="contenttitle2">
    <h3>员工信息</h3>
</div>
<!--contenttitle-->
<form class="stdform" id="form_hrEmp">
    <input type="hidden" name="empId" value="${empCustom.emp.empId}"/>

    <p>
        <label>工号</label>
        <span class="field"><input type="text" name="workId" class="smallinput" value="${empCustom.emp.workId}"/></span>
    </p>

    <p>
        <label>考勤号</label>
        <span class="field"><input type="text" name="cardId" class="smallinput" value="${empCustom.emp.cardId}"/></span>
    </p>
    <p>
        <label>用工性质</label>
                            <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="natureId">
                                    <option value="${empCustom.emp.natureId}">${empCustom.natureName}</option>
                                </select>
                            </span>
    </p>
    <p>
        <label>姓名</label>
        <span class="field"><input type="text" name="empName" class="smallinput"
                                   value="${empCustom.emp.empName}"/></span>
    </p>
    <p>
        <label>性别</label>
                            <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="sex">
                                    <option value="${empCustom.emp.sex}">${empCustom.emp.sex}</option>
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </span>
    </p>
    <p>
        <label>学历</label>
                            <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="education">
                                    <option value="${empCustom.emp.education}">${empCustom.educationName}</option>
                                    <option value="6">本科</option>
                                    <option value="5">大专</option>
                                    <option value="4">中专</option>
                                    <option value="3">高中</option>
                                    <option value="2">初中</option>
                                    <option value="1">小学</option>
                                </select>
                            </span>
    </p>
    <p>
        <label>公积金类型</label>
                            <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="cpfId">
                                    <option value="${empCustom.emp.cpfId}">${empCustom.cpfName}</option>
                                    <option value="002">乙类</option>
                                    <option value="003">乙类+住房</option>
                                    <option value="001">甲类</option>
                                </select>
                            </span>
    </p>
    <p>
        <label>所属部门</label>
                            <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="deptId">
                                    <option value="${empCustom.emp.deptId}">${empCustom.deptName}</option>
                                </select>
                            </span>
    </p>
    <p>
        <label>岗位名称</label>
        <span class="field"><input type="text" name="postName" class="smallinput"
                                   value="${empCustom.emp.postName}"/></span>
    </p>
    <p>
        <label>默认班次</label>
        <span class="formwrapper">
                            	<select data-placeholder="Choose a Country..." class="chzn-select" style="width:355px;"
                                        tabindex="2" name="shiftId">
                                    <c:if test="${empCustom != null}">
                                        <option value="${empCustom.emp.shiftId}">${empCustom.shiftName}</option>
                                    </c:if>
                                    <c:forEach items="${shifts}" var="shift">
                                        <option value="${shift.shiftId}">${shift.shiftName}</option>
                                    </c:forEach>
                                </select>
                            </span>
    </p>
    <p>
        <label>身份证号</label>
        <span class="field"><input type="text" name="identityId" class="smallinput"
                                   value="${empCustom.emp.identityId}"/></span>
    </p>

    <p>
        <label>入职日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="entryDate" class="smallinput laydate-icon"
                               value="${empCustom.emp.entryDate}"/></span>
    </p>

    <p>
        <label>现居住地</label>
        <span class="field"><input type="text" name="homeAddress" class="smallinput"
                                   value="${empCustom.emp.homeAddress}"/></span>
    </p>

    <p>
        <label>户籍地址</label>
        <span class="field"><input type="text" name="tmpAddress" class="smallinput"
                                   value="${empCustom.emp.tmpAddress}"/></span>
    </p>

    <p>
        <label>联系电话</label>
        <span class="field"><input type="text" name="phone" class="smallinput" value="${empCustom.emp.phone}"/></span>
    </p>

    <p>
        <label>合同生效日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="contractStart" class="smallinput aydate-icon"
                               value="${empCustom.emp.contractStart}"/></span>
    </p>

    <p>
        <label>合同到期日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="contractEnd" class="smallinput aydate-icon"
                               value="${empCustom.emp.contractEnd}"/></span>
    </p>
    <p>
        <label>备注</label>
        <span class="field"><textarea cols="80" rows="5" class="longinput"
                                      name="remarks">${empCustom.emp.remarks}</textarea></span>
    </p>

    <p class="stdformbutton">
        <input type="button" id="hrEmp" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交">&nbsp;&nbsp;&nbsp;&nbsp;
    </p>
</form>
