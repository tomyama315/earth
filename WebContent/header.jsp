<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/earth.css">
<title>header</title>
</head>
<body>
<ul style="list-style-type: none">
<li><img src="./images/earth.jpg" width="200px" height="40px"/></li>
<li><s:form action="SearchItemAction">
<input type="text" name="keyword" value="" placeholder="検索ワード"/>
<input type="submit" value="検索"/>
</s:form></li>


<s:if test="#session.LoginFlg==true">
<li>
<a href='<s:url action="LogoutAction"/>'>ログアウト</a>
</li>
</s:if>

<s:else>
<li>
<a href="login.jsp">ログイン</a>
</li>
</s:else>

<li>
<a href='<s:url action="CartAction"/>'>カート</a>
</li>

<li>
<a href='<s:url action="ProductListAction"/>'>商品一覧</a>
</li>

<s:if test="session.LoginFlg==true">
<li>
<a href='<s:url action="MyPageAction"/>'>マイページ</a>
</li>
</s:if>

</ul>
</body>
</html>