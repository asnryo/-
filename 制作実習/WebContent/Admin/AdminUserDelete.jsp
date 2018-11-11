<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>ユーザー削除確認</title>
<jsp:include page="../header.jsp"/>
</head>
<body>
	<div class="container">
		<h2 style="line-height : 5em;">ユーザー登録内容確認</h2>
		<h4 style="line-height : 4em;">このユーザーを削除してもよろしければ、【削除】ボタンを押してください。</h4>
			<div class="btn-toolbar" role="toolbar">
				<form id="delete" action="AdminUserDeleteServlet?id=<c:out value="${user.id}"/>" method="post">
					<table style="font-size: 12pt;">
						<tr height="40"><th>ユーザーコード : </th><td><c:out value="${user.code }"></c:out></td></tr>
						<tr height="40"><th>ログインID : </th><td><c:out value="${user.id }"></c:out></td></tr>
						<tr height="40"><th>ニックネーム : </th><td><c:out value="${user.nick }"></c:out></td></tr>
						<tr height="40"><th>メールアドレス : </th><td><c:out value="${user.mail }"></c:out></td></tr>
						<tr height="40"><th>登録日時 : </th><td><c:out value="${user.date }"></c:out></td></tr>
					</table>
					<input type="submit" class="btn btn-warning btn-lg" value="削除" style="margin-top: 50px;">
				</form>
					<button type="button" class="btn btn-info btn-lg" onclick="history.back()" style="margin-top: 50px">戻る</button>
			</div>
	</div>
</body>
</html>
