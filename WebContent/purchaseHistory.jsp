<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>商品購入履歴</title>
</head>
<body>
<div class="header">
<%@include file ="header.jsp" %>
</div>
     <div id="main">
       <h1>商品購入履歴画面</h1>
       <s:if test="purchaseHistoryInfoDTOList!=null && purchaseHistoryInfoDTOList.size()>0">
       <table>
       <tr>
         <td><label>商品名</label></td>
         <td><label>ふりがな</label></td>
         <td><label>商品画像</label></td>
         <td><label>発売会社名</label></td>
         <td><label>発売年月日</label></td>
         <td><label>値段</label></td>
         <td><label>個数</label></td>
         <td><label>合計金額</label></td>
       </tr>
     <s:iterator value ="purchaseHistoryInfoDTOList">
       <tr>
         <td><s:property value="productName"/></td>
         <td><s:property value="productNameKana"/></td>
         <td><s:property value="imageFilePath"/></td>
         <td><s:property value="releaseCompany"/></td>
         <td><s:property value="releaseDate"/></td>
         <td><s:property value="price"/>円</td>
         <td><s:property value="product_count"/>個</td>
         <td><s:property value="subtotal"/>円</td>
       </tr>
     </s:iterator>
       </table>

       <s:form action = "DeletePurchaseHistoryAction">
         <s:submit value="削除"/>
       </s:form>
       </s:if>

       <s:else>
         <p>商品購入履歴情報はありません。</p>
       </s:else>
       </div>
</body>
</html>