<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品一覧</title>
</head>
<body>
<div class="header">
</div>

<div class="header">
</div>

<div id="main">
		<div class="pageback">
		<a href='<s:url action="GoHomeAction"/>'>TOP</a> &nbsp;>&nbsp; <a>商品一覧</a>
		</div>
		<h2 class="title">商品一覧</h2>
		<br>
<s:if test="productInfoDTOList==null || productInfoDTOList.isEmpty()">
		<div class="error">
		<div class="error-message">
			<h3>検索結果がありません。</h3>
			<h3>正しく入力してください</h3>
			</div>
			</div>
		</s:if>

		<div class="array">
			<s:else>
				<s:iterator value="productInfoDTOList">
					<div class="image_box">
						<a href='<s:url action="ProductInfoDetailAction"><s:param name="productId" value="%{productId}"/></s:url>'>
							<img src='<s:property value="imageFilePath" />/<s:property value="imageFileName"/>' class ="item-image-box-200" width="100px" height="100px"/>

						</a><br>
						<div class="product_name">
							<a href='<s:url action="ProductInfoDetailAction"><s:param name="productId" value="%{productId}"/></s:url>'>
								<s:property value="productName" />
							</a><br>
						</div>
						<div class="product_name_kana">
							<a href='<s:url action="ProductInfoDetailAction"><s:param name="productId" value="%{productId}"/></s:url>'>
								<s:property value="productNameKana" />
							</a><br>
						</div>
	                     <s:property value="price"/>円<br>
						<div class="product_name">
							<div class="product-list-box">
</div>
	</div>
			</div>
				</s:iterator>
			</s:else>
		</div>
	</div>
</body>
</html>