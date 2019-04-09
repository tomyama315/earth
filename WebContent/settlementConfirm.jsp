<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/earth.css">
<title>settlementConfirm</title>
</head>
<body>
<div class="header">
<%@include file="header.jsp"%>
</div>

	<div class="maincontainer"></div>
	<s:if test="destinationInfoDTO.size() == 0">
		<h3>宛先情報がありません。</h3>
	</s:if>
	<s:else>
		<s:form action="SettlementCompleteAction">
			<h3>宛先情報を選択してください。</h3>
			<table>
				<tr>
					<th></th>
					<th>姓</th>
					<th>名</th>
					<th>ふりがな</th>
					<th>住所</th>
					<th>電話番号</th>
					<th>メールアドレス</th>
				</tr>
				<tr>
					<s:iterator value="destinationInfoDTO">
						<th><input type="radio" name="id" checked="checked" value="<s:property value="id" />"></th>
						<th><s:property value="familyName" /></th>
						<th><s:property value="firstName" /></th>
						<th><s:property value="familyNameKana" /><span>　</span><s:property value="firstNameKana" /><br></th>
						<th><s:property value="userAddress" /></th>
						<th><s:property value="telNumber" /></th>
						<th><s:property value="email" /></th>
					</s:iterator>
				</tr>
			</table>
			<s:submit value="決済" />
		</s:form>

	</s:else>
	<s:form action="CreateDestinationAction">
		<s:submit value="新規宛先登録" />
	</s:form>
</body>
</html>