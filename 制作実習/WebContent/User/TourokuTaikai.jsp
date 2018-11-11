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
<title>ユーザー退会確認</title>
<jsp:include page="/header.jsp" />
</head>

<body>
<jsp:include page="/nav.jsp" />
	<div class="container">
		<form id="delete" action="UserDeleteServlet" method="POST">
			<h2>退会確認</h2>
			<br>
			<h4><font color="red">本当に退会してもよろしいですか？</font></h4>
			<br><br>
				<table style="font-size: 12pt;">
					<tr height="40">
						<th>ユーザーID : </th>
						<td><c:out value="${userse.id }"></c:out></td>
					</tr>
					<tr height="40">
						<th>ニックネーム : </th>
						<td><c:out value="${userse.nick }"></c:out></td>
					</tr>
				</table>

				<input type="hidden" name="id" value="<c:out value="${ userse.id }" />" />
				<input type="submit" class="btn btn-warning btn-lg" style="margin-top: 50px" value="退会する" />

				<span style="margin-right: 2em;"></span>

				<button type="button" class="btn btn-info btn-lg" style="margin-top: 50px" onclick="history.back()">戻る</button>
		</form>
	</div>
</body>
</html>