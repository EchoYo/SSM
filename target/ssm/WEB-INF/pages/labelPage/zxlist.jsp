<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="list_right" id="list_right">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/custom/tables.js"></script>
    <div class="contenttitle2">
        <h3>紫翔标签</h3>
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
                <col class="con1"/>
            </colgroup>
            <thead>
            <tr>
                <th class="head0">操作日期</th>
                <th class="head1">内部编号</th>
                <th class="head0">保质期</th>
                <th class="head1">保质期至</th>
                <th class="head0">发货数量</th>
                <th class="head1">客户料号</th>
                <th class="head0">模具号</th>
                <th class="head1">有效期</th>
                <th class="head0">barcode</th>
                <th class="head1">操作</th>
            </tr>
            </thead>
            <tfoot>
            <tr>
                <th class="head0">操作日期</th>
                <th class="head1">内部编号</th>
                <th class="head0">保质期</th>
                <th class="head1">保质期至</th>
                <th class="head0">发货数量</th>
                <th class="head1">客户料号</th>
                <th class="head0">模具号</th>
                <th class="head1">有效期</th>
                <th class="head0">barcode</th>
                <th class="head1">操作</th>
            </tr>
            </tfoot>
            <tbody>
            <c:forEach items="${list}" var="zx">
                <tr class="gradeX">
                    <td class="center"><fmt:formatDate value="${zx.start_date}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td class="center">${zx.type_id}</td>
                    <td class="center">${zx.month}</td>
                    <td class="center">${zx.exp_date}</td>
                    <td class="center">${zx.qty}</td>
                    <td class="center">${zx.mat_code}</td>
                    <td class="center">${zx.batch}</td>
                    <td>${zx.exp_date}</td>
                    <td>${zx.barcode}</td>
                    <td><a href="/zx/updateUI.do?serial_no=${zx.serial_no}">修改</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!--contentwrapper-->
    <br clear="all"/>
</div>



