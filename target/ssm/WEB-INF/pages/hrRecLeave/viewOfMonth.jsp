<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-08-15
  Time: 8:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="list_right" id="list_right">
    <div class="contenttitle2">
        <h3>请假单明细</h3>
    </div>
    <button id="add_rec_leave" class="stdbtn btn_lime" style="height:30px">新增请假单</button>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
    <div id="contentwrapper" class="contentwrapper">
        <div id="recLeave_top">
            <span>
                考勤月份:<select data-placeholder="Choose a Country..." style="width:149px;height:26px"
                             class="chzn-select" tabindex="2" name="month">
            </select>
                    部门:<select data-placeholder="Choose a Country..." style="width:149px;height:26px"
                               class="chzn-select" tabindex="2" name="deptId">
                <option value="">所有部门</option>
            </select>
                员工姓名：<input type="text" name="empName"/>
            <input type="button" value="查询" id="findRecLeaveOfMonth"/>
            </span>
        </div>

        <div id="recLeave_detail" class="contentwrapper">

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
                jQuery('select[name="shiftMonth"]').append("<option value='" + list[i] + "'>" +
                        list[i] + "</option>");
            }
        });

        jQuery('#add_rec_leave').click(function () {
            jQuery.ajax({
                type: 'post',
                url: '/leave/addUI.do',
                success: function (data) {
                    jQuery('#list_right').empty().html(data);
                }
            })
        });
        jQuery('#findRecLeaveOfMonth').click(function () {
            jQuery.ajax({
                type: 'post',
                url: '/leave/listOfPo.do',
                data:{
                    month:jQuery('select[name="month"]').val(),
                    deptId:jQuery('select[name="deptId"]').val(),
                    empName:jQuery('input[name="empName"]').val()
                },
                success: function (data) {
                    jQuery('#recLeave_detail').empty().html(data);
                }
            })
        });

        jQuery(document).ready(function(){
            jQuery.ajax({
                type: 'post',
                url: '/leave/listOfPo.do',
                data:{
                    month:jQuery('select[name="month"]').val(),
                    deptId:jQuery('select[name="deptId"]').val(),
                    empName:jQuery('input[name="empName"]').val()
                },
                success: function (data) {
                    jQuery('#recLeave_detail').empty().html(data);
                }
            })
        });
    </script>
</div>
