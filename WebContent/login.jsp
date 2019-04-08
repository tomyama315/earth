<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>ログイン</title>
</head>
<body>
<script type="text/javascript" src= "./js/login.js"></script>
<div class="header">
<%@include file="header.jsp"%>
</div>

<div id="contents">
<h1>ログイン画面</h1>

<s:form id="loginForm">
<!-- 	エラーメッセージを表示する -->
	<s:if test="userIdErrorMessageList!=null && userIdErrorMessageList.size()>0">
		<div class="error">
			<div class="error-message">
				<s:iterator value="userIdErrorMessageList"><s:property /><br></s:iterator>
			</div>
		</div>
	</s:if>
	<s:if test="passwordErrorMessageList!=null && passwordErrorMessageList.size()>0">
	<div class="error">
		<div class="error-message">
			<s:iterator value="passwordErrorMessageList"><s:property /><br></s:iterator>
		</div>
	</div>
	</s:if>
	<s:if test="isNotUserInfoMessage!=null && !isNotUserInfoMessage.isEmpty()">
	<div class="error">
		<div class="error-message">
			<s:property value="isNotUserInfoMessage"/>
		</div>
	</div>
	</s:if>

	<table class="vertical-list-table">
	<tr>
		<th scope="row"><s:label value="ユーザーID"/></th>
		<s:if test="#session.saveduseridflag==true">
		<td><s:textfield name="userId" class="txt" placeholder="ユーザーID" value='%{#session.saveduserid}' autocomplete="off"/></td>
		</s:if>
		<s:else>
		<td><s:textfield name="userId" class="txt" placeholder="ユーザーID" value='%{userId}' autocomplete="off"/></td>
		</s:else>
	</tr>
	<tr>
		<th scope="row"><s:label value="パスワード"/></th>
		<td><s:password name="password" class="txt" placeholder="パスワード" autocomplete="off"/></td>
	</tr>
	</table>
	<div class="box">

		<s:if test="#session.saveduseridflag==true
		&& #session.saveduserid!=null
		&& !#session.saveduserid.isEmpty()">
		<s:checkbox name="saveduseridflag" checked="checked"/>
		</s:if>
		<s:else>
			<s:checkbox name="saveduseridflag"/>
		</s:else>
		<s:label value="ユーザーID保存"/><br>
	</div>
	<div class="submit_btn_box">
		<!-- 	ヘッダーのログインボタンを押下した場合は、ホーム画面に推移する。 -->
		<s:submit value="ログイン" class="submit_btn" onclick="goLoginAction()" />
	</div>
	<br>
	<div class="submit_btn_box">
		<div id="contents-btn-set">
		<!-- 	新規ユーザー登録ボタンを押下した場合は、ユーザー情報入力画面に推移する。 -->
			<s:submit value="新規ユーザー登録" class="submit_btn" onclick="goCreateUserAction()" />
		</div>
	</div>
	<div class="submit_btn_box">
		<div id="contents-btn-set">
		<!-- 	パスワード再設定ボタンを押下した場合は、パスワード再設定画面に推移する。 -->
			<s:submit value="パスワード再設定" class="submit_btn" onclick="goResetPasswordAction()" />
		</div>
	</div>
</s:form>
</div>
</body>
</html>
