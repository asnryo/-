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
<title>口コミ内容編集確認</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>
<div class="container">
	<h4>この内容に変更しますか？</h4>
	<c:choose>
		<c:when test="${kuchi.hoshi >= 5 }">★★★★★</c:when>
		<c:when test="${kuchi.hoshi >= 4 }">★★★★</c:when>
		<c:when test="${kuchi.hoshi >= 3 }">★★★</c:when>
		<c:when test="${kuchi.hoshi >= 2 }">★★</c:when>
		<c:when test="${kuchi.hoshi >= 1 }">★</c:when>
	</c:choose>
	<h3><c:out value="${kuchi.des }"/></h3>
	
	<form action="KuchiServlet" method="post">
		<input type="submit" class="btn btn-success btn-lg" value="編集"/>
		<button type="button" class="btn btn-success btn-lg" onclick="history.back()">戻る</button>
	</form>
</div>
</body>
</html>