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
<title>ログアウト画面</title>
<jsp:include page="/header.jsp" />
</head>
<body>
	<div class="container">
	<h3 style="margin-bottom: 100px;">ログアウト完了</h3>
	<h4 style="margin-top: 50px; margin-bottom: 50px;">ログアウトしました。【TOPへ戻る】ボタンを押して、トップへお戻りください。</h4>

		<a href="EventServlet" class="btn btn-success">TOPへ戻る</a>
	</div>
</body>
</html>