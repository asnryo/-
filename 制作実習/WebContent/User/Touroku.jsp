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

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jqvery.bxslider.css" />
<link rel="stylesheet" type="text/css" href="../css/style.css">
<link rel="shortcut icon" href="favicon.png"/>
<style type="text/css">
body{
	padding-top: 60px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>管理者ログイン</title>
</head>

<body>
<div class="container">
	<form id="sender" action="../UserConfServlet" method="POST">
	<h3>変更したい項目をご入力ください。</h3><br>
	<!-- <td><font size="2" color="red">※ユーザーIDは変更はできません。</font></td> -->
		<table>
		<tr height="20"><td></td>
					<td><font size="2" color="red">※管理者IDは一度登録すると、変更はできません。</font></td>
			<tr height="40">
				<th>ユーザーID</th>
				<td><c:out value="${userse.id}" /></td>
			</tr>
			<tr height="40">
				<th width="120">パスワード</th>
				<td><input type="password" name="user_pw" value="<c:out value="${user.pw}" />" maxlength="64" required /></td>
			</tr>
			<tr height="20"><td></td>
			<td><font size="2" color="red">※パスワードは半角英数字で4文字以上入力してください。</font></td>
			</tr>
			<tr height="40">
				<th width="120">ニックネーム</th>
				<td><input type="text" name="user_nick" value="<c:out value="${userse.nick}" />" maxlength="64" required /></td>
			</tr>
			<tr height="40">
				<th width="120">メールアドレス</th>
				<td><input type="email" name="user_mail" value="<c:out value="${userse.mail}" />" maxlength="64" required /></td>
			</tr>
		</table>

	<input type="hidden" name="user_id" value="<c:out value="${userse.id }" />" />

	<input type="submit" class="btn btn-success btn-lg" style="margin-top: 50px" value="変更内容確認へ" />
	<span style="margin-right: 2em;"></span>

	<button type="button" class="btn btn-success btn-lg" onclick="history.back()" style="margin-top: 50px">戻る</button>
	<span style="margin-right: 2em;"></span>



	</form>
	<form id="sender" action="../TaikaiConfServlet" method="POST">
	<input type="hidden" name="user_id" value="<c:out value="${userse.id }" />" />
	<input type="hidden" name="user_nick" value="<c:out value="${userse.nick }" />" />
	<input type="submit" class="btn btn-warning btn-lg" style="margin-top: 50px" value="退会する" />
	</form>
</div>
</body>
</html>