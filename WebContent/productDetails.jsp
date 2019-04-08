<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<%@include file="header.jsp"%>
	</div>
	<div id="maincontainer">
		<h1>商品詳細画面</h1>
		<s:form action="AddCartAction">
		<s:iterator value="productInfoDTO">
			<tr>
				<td>
				<img src='<s:property value="productInfoDTO.ImageFilePath"/>/<s:property value="ImageFileName"/>' width="300px" height="300px"/>
				</td>
			</tr>
			<tr>
				<td>
				<s:property value="productInfoDTO.getProductName()" />
				</td>
			</tr>

			<table>
				<tr>
					<td>商品名</td>
					<td><s:property value="productInfoDTO.getProductName()" /></td>
				</tr>
				<tr>
					<td>商品名ふりがな</td>
					<td><s:property value="productInfoDTO.getProductNameKana()" /></td>
				</tr>
				<tr>
					<td>値段</td>
					<td><s:property value="productInfoDTO.getPrice()" /></td>
				</tr>
				<tr>
					<td>販売個数</td>
					<td><select name="count">
							<option value="1" selected="selected">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
					</select></td>
				</tr>
				<tr>
					<td>販売会社名</td>
					<td><s:property value="productInfoDTO.getReleaseCompany()" /></td>
				</tr>
				<tr>
					<td>発売年月日</td>
					<td><s:property value="productInfoDTO.getReleaseDate()" /></td>
				</tr>
				<tr>
					<td>商品詳細情報</td>
					<td><s:property value="productInfoDTO.getProductDescription()" /></td>
				</tr>
			</table>
			</s:iterator>
		</s:form>
	</div>
	<div id = "sub">
	<h2>関連商品</h2>
		<s:iterator value = "selectRelativeList">
		<a href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}"/>
					</s:url>'><img src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>' width="300px" height="300px"/></a>
					<s:property value="productName"/><br>
			</s:iterator>
		</div>


</body>
</html>