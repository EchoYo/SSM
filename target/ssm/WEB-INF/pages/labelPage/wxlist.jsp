<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="list_right" id="list_right">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
    <div class="contenttitle2">
        <h3>维信标签</h3>
    </div><!--contenttitle-->
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
            </colgroup>
            <thead>
            <tr>
                <th class="head0">发货日期</th>
                <th class="head1">订单号</th>
                <th class="head0">内部编号</th>
                <th class="head1">版本号</th>
                <th class="head0">保质期</th>
                <th class="head1">保质期至</th>
                <th class="head0">项次</th>
                <th class="head1">数量</th>
                <th class="head0">操作</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th class="head0">发货日期</th>
                <th class="head1">订单号</th>
                <th class="head0">内部编号</th>
                <th class="head1">版本号</th>
                <th class="head0">保质期</th>
                <th class="head1">保质期至</th>
                <th class="head0">项次</th>
                <th class="head1">数量</th>
                <th class="head0">操作</th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${list}" var="wx">
                <tr class="gradeX">
                    <td class="center"><fmt:formatDate value="${wx.start_date}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td class="center">${wx.order_id}</td>
                    <td class="center">${wx.type_id}</td>
                    <td class="center">${wx.build_no}</td>
                    <td class="center">${wx.month}</td>
                    <td class="center">${wx.exp_date}</td>
                    <td>${wx.item_no}</td>
                    <td>${wx.qyt}</td>
                    <td><a href="/wx/updateUI.do?id=${wx.id}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--contentwrapper-->
    <br clear="all"/>
</div>



