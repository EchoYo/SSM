<%--
  Created by IntelliJ IDEA.
  User: Echoj
  Date: 2016-06-08
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/myJs/saveUI.js"></script>
<div class="contenttitle2">
  <h3>微信标签</h3>
</div><!--contenttitle-->
<form class="stdform" id="form_wx">
  <input type="hidden" name="id" value="${wx.id}"/>
  <p>
    <label>订单号</label>
    <span class="field"><input type="text" name="order_id" class="smallinput" value="${wx.order_id}"/></span>
  </p>
  <p>
    <label>内部编号</label>
    <span class="field"><input type="text" name="type_id" class="smallinput" value="${wx.type_id}"/></span>
  </p>
  <p>
    <label>版本号</label>
    <span class="field"><input type="text" name="build_no" class="smallinput" value="${wx.build_no}"/></span>
  </p>
  <p>
    <label>保质期</label>
    <span class="field"><input type="text" name="month" class="smallinput" value="${wx.month}"/></span>
  </p>
  <p>
    <label>项次</label>
    <span class="field"><input type="text" name="item_no" class="smallinput" value="${wx.item_no}"/></span>
  </p>
  <p>
    <label>数量</label>
    <span class="field"><input type="text" name="qyt" class="smallinput" value="${wx.qyt}"/></span>
  </p>
  <p class="stdformbutton">
    <input type="button" id="updatewx" class="submit radius2" value="提&nbsp;&nbsp;&nbsp;&nbsp;交"/>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="reset" class="reset radius2" value="重&nbsp;&nbsp;&nbsp;&nbsp;置" />
  </p>
 </form>


