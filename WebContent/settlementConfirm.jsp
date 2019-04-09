<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/settlement.css">
<title>settlementConfirm</title>
</head>
<body>
	<div class="header">
		<%@include file="header.jsp"%>
	</div>


	<div class="main">
		<h1>決済確認画面</h1>
		<s:if test="destinationInfoDTO.size() == 0">
			<h3>宛先情報がありません。</h3>
		</s:if>
		<s:else>
			<s:form action="SettlementCompleteAction">
				<h3>宛先情報を選択してください。</h3>
				<table>
					<tr class = "midashi" align="center">
						<th>#</th>
						<th>姓</th>
						<th>名</th>
						<th>ふりがな</th>
						<th>住所</th>
						<th>電話番号</th>
						<th>メールアドレス</th>
					</tr>
					<s:iterator value="destinationInfoDTO">
						<tr>
							<s:if test="id == 1">
								<td><input type="radio" name="id" checked="checked"
									value="<s:property value="id" />"></td>
							</s:if>
							<s:else>
								<td><input type="radio" name="id"
									value="<s:property value="id" />"></td>
							</s:else>
							<td><s:property value="familyName" /></td>
							<td><s:property value="firstName" /></td>
							<td><s:property value="familyNameKana" /><span> </span> <s:property
									value="firstNameKana" /><br></td>
							<td><s:property value="userAddress" /></td>
							<td><s:property value="telNumber" /></td>
							<td><s:property value="email" /></td>

						</tr>
					</s:iterator>
				</table>
				<div class="submit">
					<s:submit value="決済" class ="submit_btn_box" theme = "simple"/>
				</div>
			</s:form>

		</s:else>
		<s:form action="CreateDestinationAction">
			<div class="submit">
				<s:submit value="新規宛先登録" class ="submit_btn_box" theme = "simple"/>
			</div>
		</s:form>
	</div>
</body>
</html>