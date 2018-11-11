<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<jsp:include page="../header.jsp"/>
<title>管理者一覧</title>
</head>
<body>
<jsp:include page="../nav.jsp"/>
<div class="container">
	<h3 style="margin-top: 100px;">管理者一覧</h3><br>

	<div class="btn-toolbar" role="toolbar" style="margin-bottom: 20px;">
		<form action="AdminDetailServlet" method="post">
			<input type="submit" class="btn btn-danger btn-lg pull-right"  style="margin-top: 50px;" value="管理者ID新規登録">
		</form>

		<a href="AdminEventServlet" class="btn btn-info pull-right" style="margin-top: 50px">戻る</a>
	</div>

	<table class="table table-bordered">
		<tr>
			<th>管理者コード</th>
			<th>管理者ID</th>
			<th>パスワード</th>
			<th>ニックネーム</th>
			<th>メールアドレス</th>
			<th>登録日時</th>
			<th>詳細画面</th>
		</tr>
		<c:forEach items="${adminList}" var="adm">
			<tr>
				<td><c:out value="${adm.code}"/></td>
				<td><c:out value="${adm.id}"/></td>
				<td><c:out value="${adm.pw}"/></td>
				<td><c:out value="${adm.nick}"/></td>
				<td><c:out value="${adm.mail}"/></td>
				<td><c:out value="${adm.date }"/></td>
				<td><a href="./AdminDetailServlet?id=<c:out value="${adm.id }"/>">詳細画面へ</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>