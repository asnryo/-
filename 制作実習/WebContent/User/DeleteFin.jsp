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
<title>削除完了画面</title>
<jsp:include page="/header.jsp" />
</head>
<%-- ユーザーID削除が成功するとこのjspへ遷移 --%>
<body>
<jsp:include page="/nav.jsp" />
	<div class="container">
		<h4>ユーザーIDを削除しました。</h4><br>
		<h4>またのご登録をお待ちしております。</h4>

		<a href="UserEventServlet" class="btn btn-success">TOPへ戻る</a>
	</div>
</body>
</html>