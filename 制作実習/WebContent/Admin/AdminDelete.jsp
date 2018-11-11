<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<jsp:include page="../header.jsp"/>
<title>管理者削除確認</title>
</head>
<body>
	<div class="container">
		<form id="delete" action="AdminAdmDeleteServlet?id=<c:out value="${admin.id}"/>" method="post">
			<h2>管理者削除確認</h2>
			<br>
			<h4><font color="red">本当に削除してもよろしいですか？</font></h4>
			<br><br>
			<table style="font-size: 12pt;">
			<tr height="40">
			<th>ユーザーコード : </th>
			<td><c:out value="${admin.code }"></c:out></td>
			</tr>
			<tr height="40">
			<th>ログインID : </th>
			<td><c:out value="${admin.id }"></c:out></td>
			</tr>
			<tr height="40">
			<th>ニックネーム : </th>
			<td><c:out value="${admin.nick }"></c:out></td>
			</tr>
			</table>

			<input type="submit" class="btn btn-warning btn-lg" style="margin-top: 50px" value="削除">
			<button type="button" class="btn btn-info btn-lg" style="margin-top: 50px" onclick="history.back()">戻る</button>
		</form>
	</div>
</body>
</html>