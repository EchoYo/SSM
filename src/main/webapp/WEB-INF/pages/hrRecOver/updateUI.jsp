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
    <h3>加班调休管理</h3>
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
        <label>考勤项目</label>
                            <span class="formwrapper">
                            	<select name="resultType" style="width:356px" tabindex="2">
                                    <option value="${custom.resultType}">${custom.resultName}</option>
                                    <option value="0201">平时加班</option>
                                    <option value="0202">公休加班</option>
                                    <option value="0203">节日加班</option>
                                    <option value="0184">调休</option>
                                </select>
                            </span>
    </p>
    <label>日期</label>
    <span class="field">
        <input type="text" onclick="laydate()" name="recDate" class="smallinput laydate-icon"
               value="${custom.recDate}"/>
    </span>
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
        <label>工时</label>
        <span class="field"><input type="text" name="hours" class="smallinput" value="${custom.hours}"/>小时</span>
    </p>

    <p>
        <label>备注</label>
        <span class="field"><textarea cols="80" rows="5" class="longinput"
                                      style="width:348px" name="remark">${custom.remark}</textarea></span>
    </p>

    <p class="stdformbutton">
        <input type="button" id="update_recOver" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>
    </p>
    <script>
        jQuery(".chzn-select").chosen();
        jQuery('.clockpicker').clockpicker();
        jQuery(document).on('click','#update_recOver',function(){
            jQuery.ajax({
                url:'/over/update.do',
                type:'post',
                async:false,
                data:{
                    id:jQuery('input[name="id"]').val(),
                    empId:jQuery('select[name="empId"]').val(),
                    resultType:jQuery('select[name="resultType"]').val(),
                    recDate:jQuery('input[name="recDate"]').val(),
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
