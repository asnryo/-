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
<title>入力情報が正しくありません。</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>
	<div class="container">
		<h3>入力情報が正しくありません。</h3>
		<%--Userがログインに失敗した場合、このjspへ遷移する --%>
		<button type="button" class="btn btn-info btn-lg" onclick="history.back()">戻る</button>
	</div>
</body>
</html>