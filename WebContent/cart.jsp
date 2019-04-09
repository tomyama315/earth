<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src= "./js/cart.js"></script>
<title>カート画面</title>
</head>
<body>
<div class="header">
<%@include file="header.jsp"%>
</div>
<s:if test="cartlist.isEmpty()">
<div><h3><s:property value="message"/></h3></div>
</s:if>
<s:else><table class="index" border="1">
<tr>
<th></th>
<th>名前</th>
<th>名前かな</th>
<th>Image</th>
<th>価格</th>
<th>発売会社</th>
<th>発売日</th>
<th>個数</th>
<th>小計</th>
</tr>
</table>
</s:else>
<s:form action="DeleteCartAction" id="cartForm">
<s:iterator value="cartlist">
<table class="carttable" border="1">
<tr><td><input type="checkbox" name="ProductId" value="<s:property value="ProductId"/>" class="checkbox" onchange="checkValue(this)"/></td>
<td><s:property value="ProductName"/></td>
<td><s:property value="ProductNameKana"/></td>
<td><img src='<s:property value="ImagePath"/>/<s:property value="ImageName"/>' width="100px" height="50px" /></td>
<td><s:property value="Price"/>円</td>
<td><s:property value="ReleaseComp"/></td>
<td><s:property value="ReleaseDate"/></td>
<td><s:property value="ProductCount"/>個</td>
<td><s:property value="sum"/></td>
<tr>
</table>
</s:iterator>
<s:if test="totalprice!=0">
<div>カート内合計:<s:property value="totalprice"/>円</div>
</s:if>
<div><s:if test="!cartlist.isEmpty()"><s:submit value="削除" id="deleteButton" disabled="true"/></s:if></div>
</s:form>
<s:form action="SettlementConfirmAction" id="cartForm">
<div><s:if test="!cartlist.isEmpty()"><input type="submit" value="決済" class="cartForm"/></s:if></div>
</s:form>
</body>
</html>