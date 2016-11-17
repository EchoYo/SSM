<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-15
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<div class="contenttitle2">
    <h3>修改请假单</h3>
</div>
<!--contenttitle-->
<form class="stdform">
    <input type="hidden" name="id" value="${custom.id}">
    <p>
        <label>选择员工</label>
                            <span class="formwrapper">
                            	<select name="empId" data-placeholder="选择员工..."
                                        style="width:356px" class="chzn-select" tabindex="2">
                                    <option value="${custom.empId}">${custom.empName}</option>
                                    <c:forEach items="${empRecs}" var="empRec">
                                        <option value="${empRec.empId}">${empRec.empName}_${empRec.workId}</option>
                                    </c:forEach>
                                </select>
                            </span>
    </p>
    <p>
        <label>请假类型</label>
                            <span class="formwrapper">
                            	<select name="resultType" style="width:356px" tabindex="2">
                                    <option value="${custom.resultType}">${custom.resultName}</option>
                                    <option value="0401">事假</option>
                                    <option value="0402">病假</option>
                                    <option value="0403">年假</option>
                                    <option value="0404">婚假</option>
                                    <option value="0405">产假</option>
                                    <option value="0406">丧假</option>
                                    <option value="0407">哺乳假</option>
                                    <option value="0501">出差</option>
                                    <option value="0601">公出</option>
                                </select>
                            </span>
    </p>
    <label>开始日期</label>
    <span class="field">
        <input type="text" onclick="laydate()" name="stDate" class="smallinput laydate-icon"
               value="${custom.stDate}" style="width:130px"/>
        &nbsp;&nbsp;
        结束日期&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="text" onclick="laydate()" name="endDate" class="smallinput laydate-icon"
               value="${custom.endDate}" style="width:130px"/></span>
    </p>
    <p>
        <label>开始时间</label>
        <span class="field"><input type="text" name="stTime" style="width:130px" class="form-control clockpicker"
                                   value="${custom.stTime}" data-placement="left" data-align="top" data-autoclose="true"/>
         &nbsp;&nbsp;
    结束时间&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="text" name="endTime" style="width:130px" class="form-control clockpicker"
                   value="${custom.endTime}" data-placement="left" data-align="top" data-autoclose="true"/>
    </span>
    </p>

    <p>
        <label>请假工时</label>
        <span class="field"><input type="text" name="hours" class="smallinput" value="${custom.hours}"/>小时</span>
    </p>

    <p>
        <label>请假原因</label>
        <span class="field"><textarea cols="80" rows="5" class="longinput"
                                      style="width:348px" name="remark">${custom.remark}</textarea></span>
    </p>

    <p class="stdformbutton">
        <input type="button" id="update_recLeave" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>
    </p>
    <script>
        jQuery(".chzn-select").chosen();
        jQuery('.clockpicker').clockpicker();
        jQuery(document).on('click','#update_recLeave',function(){
            jQuery.ajax({
                url:'/leave/update.do',
                type:'post',
                async:false,
                data:{
                    id:jQuery('input[name="id"]').val(),
                    empId:jQuery('select[name="empId"]').val(),
                    resultType:jQuery('select[name="resultType"]').val(),
                    stDate:jQuery('input[name="stDate"]').val(),
                    endDate:jQuery('input[name="endDate"]').val(),
                    stTime:jQuery('input[name="stTime"]').val(),
                    endTime:jQuery('input[name="endTime"]').val(),
                    hours:jQuery('input[name="hours"]').val(),
                    remark:jQuery('textarea[name="remark"]').val()
                },
                success:function(data){
                    alert("修改成功！");
                    return false;
                }
            })
        });
    </script>
</form>
