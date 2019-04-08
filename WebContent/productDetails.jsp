<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品詳細</title>
</head>
<body>
<div class="header">
<%@include file="header.jsp"%>
</div>
<div id="contents">
<h1>商品詳細画面</h1>
<s:if test="!productName!=null && !productName.isEmpty()">
	<s:form action="AddCartAction">
	<div class="box">
	<%-- 画面二つに分ける  --%>
	<div class="2column-container">
	<%--  右 --%>
	<div class="right">
	<%-- 画像挿入  --%>
		<img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-320"/><br>
	</div>
	<%--  左 --%>
	<div class="left">
	<table class="vertical-list-table-mini">
		<tr>
		<th scope="row"><s:label value="商品名"/></th>
		<td><s:property value="productName"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="商品名ふりがな"/></th>
		<td><s:property value="productNameKana"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="値段"/></th>
		<td><s:property value="price"/>円</td>
		</tr>
		<tr>
		<th scope="row"><s:label value="購入個数"/></th>
		<td><s:select name="productCount" list="%{countList}"/>個</td>
		</tr>
		<tr>
		<th scope="row"><s:label value="発売会社名"/></th>
		<td><s:property value="releaseCompany"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="発売年月日"/></th>
		<td><s:property value="releaseDate"/></td>
		</tr>
		<tr>
		<th scope="row"><s:label value="商品詳細情報"/></th>
		<td><s:property value="productDescription"/></td>
		</tr>
		</table>
	</div>
	</div>
	<s:hidden name="productId" value="%{productId}"/>
	</div>
	<div class="submit_btn_box">
	<s:submit value="カートに追加" class="submit_btn" />
	</div>
	</s:form>
	<s:if test="productList!=null && productList.size()>0">
		<div class="box">
			<div class="product-details-recomｍend-box">
			<h2>関連商品</h2>
			<s:iterator value="selectRelativeList">
					<div class="recommend-box">
					<a href='<s:url action="ProductDetailsAction">
					<s:param name="productId" value="%{productId}"/>
					</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' class="item-image-box-100"/></a>
					<s:property value="productName"/><br>
					</div>
			</s:iterator>
			</div>
		</div>
	</s:if>
</s:if>
<s:else>
	<div class="info">
		商品の詳細情報がありません。
	</div>
</s:else>
</div>
</body>
</html>