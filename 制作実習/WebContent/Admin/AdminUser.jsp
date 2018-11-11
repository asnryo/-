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

<title>ユーザー 一覧</title>
</head>
<body>
<jsp:include page="../nav.jsp"/>
	<div class="container">
	<h3 style="margin-top: 100px;">ユーザー 一覧</h3>
		<div class="btn-toolbar" role="toolbar" style="margin-bottom: 20px;">
			<a href="AdminEventServlet" class="btn btn-info pull-right" style="margin-top: 50px">戻る</a>
		</div>
	<table class="table table-bordered">
		<tr>
			<th>ユーザーコード</th>
			<th>ID</th>
			<th>ニックネーム</th>
			<th>メール</th>
			<th>登録日時</th>
			<th>削除</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td><c:out value="${user.code}"/></td>
				<td><c:out value="${user.id}"/></td>
				<td><c:out value="${user.nick}"/></td>
				<td><c:out value="${user.mail}"/></td>
				<td><c:out value="${user.date }"/></td>

				<td><a href="AdminUserKakuninServlet?id=<c:out value="${user.id}"/>">削除</a></td>

			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>