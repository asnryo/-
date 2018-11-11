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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/header.jsp"/>
<title>管理者登録編集完了画面</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>
	<div class="container">
		<c:choose>
			<c:when test="${hensyu != null }">
				<c:out value="${hensyu }"/>
			</c:when>
			<c:otherwise>
			<h4>登録が完了しました！！</h4><br>
			<h3>
			新しい管理者ID&emsp;<c:out value="${newadmnick}"  /> &emsp;さんを追加しました。
			</h3><br>
			</c:otherwise>
		</c:choose>
		<a href="AdminEventServlet" class="btn btn-success">TOPへ戻る</a>
	</div>
</body>
</html>