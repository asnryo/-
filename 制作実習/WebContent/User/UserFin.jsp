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
<title>登録完了画面</title>
<jsp:include page="/header.jsp" />
</head>
<%-- ゲスト登録更新が成功するとこのjspへ遷移 --%>
<body>
<jsp:include page="/nav.jsp" />
	<div class="container">
		<h4>登録が完了しました！！</h4><br>

		<h3>ようこそ&emsp;<c:out value="${userse.nick}"  /> &emsp;さん。<br>
			ログイン中のIDは【　<c:out value="${userse.id}"  />　】、ニックネームは【　<c:out value="${userse.nick}"  />　】です。
		</h3><br>

		<a href="UserEventServlet" class="btn btn-success">TOPへ戻る</a>
	</div>
</body>
</html>