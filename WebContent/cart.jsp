<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<th>Image</th>
<th>名前</th>
<th>名前かな</th>
<th>価格</th>
<th>発売会社</th>
<th>発売日</th>
<th>個数</th>
<th>小計</th>
<th>削除</th>
</tr>
</table>
</s:else>
<s:form action="DeleteCartAction">
<s:iterator value="cartlist">
<table class="carttable" border="1">
<tr><td><img src='<s:property value="ImagePath"/>/<s:property value="ImageName"/>' width="100px" height="50px" /></td>
<td><s:property value="ProductName"/></td>
<td><s:property value="ProductNameKana"/></td>
<td><s:property value="Price"/>円</td>
<td><s:property value="ReleaseComp"/></td>
<td><s:property value="ReleaseDate"/></td>
<td><s:property value="ProductCount"/>個</td>
<td><s:property value="sum"/></td>
<td><input type="checkbox" name="ProductId" value="<s:property value="ProductId"/>"/></td>
<tr>
</table>
</s:iterator>
<div>カート内合計:<s:property value="totalprice"/>円</div>
<div><s:submit value="削除"/></div>
</s:form>

<s:form action="SettlementConfirmAction">
<div><input type="submit" value="決済"/></div>
</s:form>
</body>
</html>