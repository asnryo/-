<%@page import="beens.KuchiBean"%>
<%@page import="java.util.List"%>
<%@page import="beens.UserBean"%>
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
<title>イベント確認</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>

	<div class="container">
		<form name="upload" action="AdminEventEditForwardServlet" method="post" >
		<%--イベント名、画像、イベント内容--%>
		<h2><c:out value="${ev.name}"/></h2>
		<img src="img/${ev.img }" height="600px" width="600px"><br>
		<c:out value="${ev.des }"/><br>

		<%--イベント詳細情報 --%>
		<p>基本情報</p>
			<table class="table">
				<tr>
					<th>開催日</th>
					<td><c:out value="${ev.openDate}"/></td>
				</tr>
				<tr>
					<th>終了日</th>
					<td><c:out value="${ev.endDate }"/></td>
				</tr>
				<tr>
					<th>開催時間</th>
					<td><c:out value="${ev.openTime }"/></td>
				</tr>
				<tr>
					<th>終了時間</th>
					<td><c:out value="${ev.endTime }"/></td>
				</tr>
				<tr>
					<th>場所</th>
					<td><c:out value="${ev.spot }"/></td>
				</tr>
				<tr>
					<th>カテゴリ</th>
					<td><c:out value="${ev.cate }"/></td>
				</tr>
			</table>
			<a class="btn btn-success  btn-lg" href="AdminPreUpload">画像の編集</a>
			<input type="submit" class="btn btn-danger  btn-lg" value="決定" />
			<button type="button" class="btn btn-info  btn-lg" onclick="history.back()">戻る</button>
		</form>
	</div>
</body>
</html>