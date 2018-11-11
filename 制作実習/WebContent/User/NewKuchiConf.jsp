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
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<jsp:include page="/header.jsp"/>
<title>口コミ入力確認画面</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>
	<div class="container">

	<h3><c:out value="${kuchi.des }"/></h3>
	<h4>口コミ内容は以上でよろしいですか？</h4>

	<form action="NewKuchiServlet" method="post">
		<input type="submit" class="btn btn-success btn-lg" value="送信"/>
	</form>

	</div>
</body>
</html>