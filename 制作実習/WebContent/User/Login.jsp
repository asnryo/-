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
<title>ユーザーログイン</title>
<jsp:include page="/header.jsp" />
</head>
<body>
	<div class="container">
	<h3 style="margin-bottom: 100px;">ユーザーログイン</h3><br>
	<h4 style="margin-bottom: 50px;">ユーザーIDとパスワードを入力してください。</h4>

		<%--UserIdとUserPwを入力してサーブレットでログインの可否を判断 --%>
		<form method="post" action="../UserLoginServlet">
			<table>
				<tr height="40">
					<td width="120"><label>ユーザーID</label></td>
					<td><input type="text" name="id" maxlength="32" required /></td>
				</tr>
				<tr height="40">
					<td><label>パスワード</label></td>
					<td><input type="password" name="pass" maxlength="64" required /></td>
				</tr>
			</table>

			<input type="submit" class="btn btn-success btn-lg" style="margin-top: 50px" value="ログイン" name="submit">
			<%-- 【ログイン】ボタンの右側のマージンを2文字分取る --%>
			<span style="margin-right: 2em;"></span>

			<input type="reset" class="btn btn-success btn-lg" style="margin-top: 50px" value="リセット" name="reset">
			<%-- 【リセット】ボタンの右側のマージンを4文字分取る --%>
			<span style="margin-right: 4em;"></span>

			<a href="../EventServlet" class="btn btn-success" style="margin-top: 50px" >TOPへ戻る</a>
		</form>
	</div>
</body>
</html>