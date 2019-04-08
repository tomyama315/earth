<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<title>マイページ</title>
</head>
<body>
<div class="header">
<%@include file ="header.jsp" %>
</div>
     <div id ="main">
       <h1>マイページ画面</h1>
         <s:if test="familyName!=null && !famiryName.isEmpty()">
         <s:form action="PurchaseHistoryAction">
           <table>
             <tr>
               <td><label>姓</label></td>
               <td><s:property value="familyName"/></td>
             </tr>

             <tr>
               <td><label>名</label></td>
               <td><s:property value="firstName"/></td>
             </tr>

             <tr>
               <td><label>ふりがな</label></td>
               <td><s:property value="familyNameKana"/><span>　</span><s:property value="firstNamaKana"/></td>
             </tr>

             <tr>
               <td><label>性別</label></td>
               <td><s:if test="sex==1">女性</s:if><s:else>男性</s:else></td>
             </tr>

             <tr>
               <td><label>メールアドレス</label></td>
               <td><s:property value="email"/></td>
             </tr>
           </table>

               <s:submit value="購入履歴"/>
          </s:form>
          </s:if>

           <s:else>
           <h3>ユーザー情報がありません。</h3>
           </s:else>
      </div>
</body>
</html>