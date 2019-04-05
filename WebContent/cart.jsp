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
<s:property value="message"/>
</s:if>

<s:form action="DeleteCartAction">
<s:iterator value="cartlist">
<img src='<s:property value="ImagePath"/>/<s:property value="ImageName"/>' width="50px" height="50px" />
<s:property value="ProductName"/>
<s:property value="ProductNameKana"/>
<s:property value="Price"/>
<s:property value="ReleaseComp"/>
<s:property value="ReleaseDate"/>
<s:property value="ProductCount"/>
<s:property value="sum"/>
<input type="checkbox" name="ProductId" value="<s:property value="ProductId"/>"/>
</s:iterator>
totalprice:<s:property value="totalprice"/>
<s:submit value="削除"/>
</s:form>

<s:form action="SettlementConfirmAction">
<input type="submit" value="決済"/>
</s:form>
</body>
</html>