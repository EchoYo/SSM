<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-03
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="contenttitle2">
  <h3>新增补签单</h3>
</div><!--contenttitle-->
<form class="stdform" >
  <p>
    <label>选择员工</label>
                            <span class="formwrapper">
                            	<select name="empId" data-placeholder="选择员工..." class="chzn-select"  tabindex="2">
                                  <option value=""></option>
                                  <c:forEach items="${empRecs}" var="empRec">
                                    <option value="${empRec.empId}">${empRec.empName}_${empRec.workId}</option>
                                  </c:forEach>
                                </select>
                            </span>
  </p>
    <label>补签日期</label>
    <span class="field"><input type="text" onclick="laydate()" name="recDate" class="smallinput laydate-icon"/></span>
  </p>
  <p>
    <label>补签时间</label>
    <span class="field"><input type="text" name="recTime" class="form-control clockpicker"
                               style="width:356px" data-placement="left" data-align="top" data-autoclose="true"/>
    </span>
  </p>
  <p class="stdformbutton">
    <input type="button" id="save_recTime" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交">
  </p>
    <script>
        jQuery(".chzn-select").chosen();
        jQuery('.clockpicker').clockpicker();
        jQuery('#save_recTime').click(function(){
            jQuery.ajax({
                url:'/record/addRecTime.do',
                type:'post',
                async:false,
                data:{
                    empId:jQuery('select[name="empId"]').val(),
                    recDate:jQuery('input[name="recDate"]').val(),
                    recTime:jQuery('input[name="recTime"]').val()
                },
                success: function (data) {
                    if(data.result == 'true'){
                        alert("添加成功");
                    }else{
                        alert("记录已存在！");
                    }

                }
            });
            return false;
        });
    </script>
</form>