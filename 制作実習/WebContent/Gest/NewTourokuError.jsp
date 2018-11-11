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
<jsp:include page="/header.jsp"/>
<title>ID重複エラー</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>
	<div class="container">
		<h3>申し訳ございませんが、ID【　<c:out value="${userid }"/>　】が重複しているため登録ができません。<br>
		戻るボタンを押して、再度ご登録ください。
		</h3>

		<img alt="エラー画面" src="./css/sorry.png">

		<%--入力したUserIdが既存のUserIdと重複している場合、このjspへ遷移する --%>
		<button type="button" class="btn btn-info  btn-lg" onclick="history.back()" style="margin-left: 50px">戻る</button>

	</div>
</body>
</html>