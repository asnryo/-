<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>管理者登録内容確認</title>
<jsp:include page="/header.jsp"/>
</head>

<body>
	<div class="container">
		<h2 style="line-height : 5em;">管理者登録内容確認</h2>
			<h4 style="line-height : 4em;"><c:choose>
				<c:when test="${adm.code == 1 }">
					表示の新規登録内容でよろしければ、【決定】ボタンを押してください。
				</c:when>
				<c:otherwise>
					表示の登録内容でよろしければ、【決定】ボタンを押してください。
				</c:otherwise>
			</c:choose>
			</h4>

			<form id="conf" action="AdminAdmRegisterServlet" method="post">
				<table style="font-size: 12pt;">
				<tr height="40"><th>ログインID : </th><td><c:out value="${adm.id }"></c:out></td></tr>
				<tr height="40"><th>ニックネーム : </th><td><c:out value="${adm.nick }"></c:out></td></tr>
				<tr height="40"><th>パスワード : </th><td><c:out value="${adm.pw }"></c:out></td></tr>
				<tr height="40"><th>メールアドレス : </th><td><c:out value="${adm.mail }"></c:out></td></tr>
				<tr height="40"><th>登録日時 : </th><td><c:out value="${adm.date }"></c:out></td></tr>
				</table>
				<input type="submit" value="決定" class="btn btn-danger  btn-lg" style="margin-top: 50px;">
				<button type="button" class="btn btn-info  btn-lg" onclick="history.back()" style="margin-top: 50px;">戻る</button>
			</form>
	</div>
</body>
</html>
