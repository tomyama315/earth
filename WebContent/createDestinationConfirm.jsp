<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>宛先情報入力画面</title>
</head>
<body>

<div class="header">
<%@include file="header.jsp"%>
</div>

<div id="contents">
<h1>宛先情報入力画面</h1>

<s:form id="createDestinationForm">
<table class="vertical-list-table">
<tr>
	<th scope="row"><s:label value="姓"/></th>
	<td><s:property value="familyName"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="名"/></th>
	<td><s:property value="firstName"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="姓ふりがな"/></th>
	<td><s:property value="familyNameKana"/></td>

</tr>

<tr>
	<th scope="row"><s:label value="名ふりがな"/></th>
	<td><s:property value="firstNameKana"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="住所"/></th>
	<td><s:property value="userAddress"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="電話番号"/></th>
	<td><s:property value="telNumber"/></td>
</tr>

<tr>
	<th scope="row"><s:label value="メールアドレス"/></th>
	<td><s:property value="email"/></td>
</tr>
</table>
</s:form>
<div class="submit_btn_box">
<s:form action="CreateDestinationCompleteAction">
<s:submit value="宛先情報登録" class="submit_btn"/>
</s:form>
</div>
<s:form action="CreateDestinationAction">
<div class="submit_btn_box">
<s:submit value="戻る" class="submit_btn"/>
</div>
</s:form>
</div>
</body>

</html>
