<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src= "./js/cart.js"></script>
<link rel="stylesheet" href="./css/cart.css">
<title>カート画面</title>
</head>
<body>
<div class="header">
<%@include file="header.jsp"%>
</div>
<div><h1>カート画面</h1></div>
<s:if test="cartlist.isEmpty()">
<div class="message"><h3><s:property value="message"/></h3></div>
</s:if>
<s:form action="DeleteCartAction" id="cartForm">
<table class="carttable" border="1">
<s:if test="!cartlist.isEmpty()">
<tr class="index">
<th id="check"></th>
<th>名前</th>
<th id="kana">ふりがな</th>
<th>Image</th>
<th>価格</th>
<th>発売会社</th>
<th>発売日</th>
<th>個数</th>
<th>小計</th>
</tr>
</s:if>
<s:iterator value="cartlist">
<tr class="contents"><td id="check"><input type="checkbox" name="ProductId" value="<s:property value="ProductId"/>" class="checkbox" onchange="checkValue(this)"/></td>
<td><s:property value="ProductName"/></td>
<td id="kana"><s:property value="ProductNameKana"/></td>
<td><img src='<s:property value="ImagePath"/>/<s:property value="ImageName"/>' width="75px" height="75px" /></td>
<td><s:property value="Price"/>円</td>
<td><s:property value="ReleaseComp"/></td>
<td><s:property value="ReleaseDate"/></td>
<td><s:property value="ProductCount"/>個</td>
<td><s:property value="sum"/></td>
<tr>
</s:iterator></table>
<s:if test="totalprice!=0">
<div class="total">カート内合計金額:<s:property value="totalprice"/>円</div>
</s:if>
<s:else></s:else>
<s:form action="SettlementConfirmAction" id="cartForm">
<s:if test="!cartlist.isEmpty()"><ul class="undermain"><li><input type="submit" value="決済" class="cartForm"/></li></s:if>
</s:form>
<s:if test="!cartlist.isEmpty()"><li><s:submit value="削除" id="deleteButton" disabled="true" theme="simple"/></li></ul></s:if>
</s:form>
</body>
</html>