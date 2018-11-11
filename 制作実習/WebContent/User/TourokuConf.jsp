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
<title>ユーザー情報確認画面</title>
<jsp:include page="/header.jsp" />
</head>
<%-- ユーザー情報更新内容の確認画面 --%>
<body>
	<div class="container">
	<h2>ユーザー情報更新内容確認</h2><br>
		<form id="sender" action="UserTourokuEditServlet" method="POST">
		表示の登録内容でよろしければ、【更新】ボタンを押してください。
		<table>
		<tr height="40"><th>ユーザーID : </th><td><c:out value="${userse.id}" /></td></tr>
		<tr height="40"><th>パスワード : </th><td><c:out value="${userse.pw}" /></td></tr>
		<tr height="40"><th>ニックネーム ： </th><td><c:out value="${userse.nick}" /></td></tr>
		<tr height="40"><th>メールアドレス ： </th><td><c:out value="${userse.mail}" /></td></tr>
		</table>

		<%-- 更新の為、hiddenで値渡し --%>
		<input type="hidden" name="user_id" value="<c:out value="${userse.id}" />">
		<input type="hidden" name="user_pw" value="<c:out value="${userse.pw}" />">
		<input type="hidden" name="user_nick" value="<c:out value="${userse.nick}" />">
		<input type="hidden" name="user_mail" value="<c:out value="${userse.mail}" />">

		<input type="submit" class="btn btn-success btn-lg" style="margin-top: 50px"  value="更新" />
		<%-- 【更新】ボタンの右側のマージンを2文字分取る --%>
		<span style="margin-right: 1em;"></span>

		<button type="button" class="btn btn-success btn-lg" style="margin-top: 50px" onclick="history.back()">入力へ戻る</button>
		<%-- 【入力へ戻る】ボタンの右側のマージンを4文字分取る --%>
		<span style="margin-right: 4em;"></span>

		<a href="EventServlet" class="btn btn-success btn-lg" style="margin-top: 50px" >TOPへ戻る</a>

		</form>
	</div>
</body>
</html>