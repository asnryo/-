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
<title>新規登録画面</title>
<jsp:include page="/header.jsp" />
</head>
<%-- ゲストの新規登録入力画面 --%>
<body>
	<div class="container">

	<h2 style="line-height : 5em;">ユーザー新規登録</h2>
		<form method="post" action="../NewUserConfServlet">
		<table  style="font-size: 12pt;">
			<tr height="20"><td></td>
			</tr>
			<tr height="30">
				<td><label>ユーザーID</label></td>
				<td><input type="text" name="user_id" maxlength="16"  pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" required /></td>
			</tr>
			<tr height="20"><td></td>
			<td><font size="2" color="red">※ユーザーIDは一度登録すると、変更はできません。</font></td>
			<tr height="20"><td></td>
			<td><font size="2" color="red">※ユーザーID半角英数字で入力してください。</font></td>
			</tr>
			<tr height="40">
				<td><label>パスワード</label></td>
				<td><input type="password" name="user_pw" maxlength="16" minlength="4" pattern="^[0-9A-Za-z]+$" title="半角英数字で4文字以上入力してください" required /></td>
			</tr>
			<tr height="20"><td></td>
			<td><font size="2" color="red">※パスワードは半角英数字で4文字以上入力してください。</font></td>
			</tr>
			<tr height="40">
				<td><label>ニックネーム</label></td>
				<td><input type="text" name="user_nick" maxlength="16" required /></td>
			</tr>
			<tr height="40">
				<td width="130"><label>メールアドレス</label></td>
				<td><input type="email" name="user_mail" maxlength="64" required /></td>
			</tr>
		</table>

		<input type="submit" class="btn btn-danger  btn-lg" style="margin-top: 50px;" value="登録確認へ" />
		<%-- 【登録確認へ】ボタンの右側のマージンを2文字分取る --%>
		<span style="margin-right: 2em;"></span>

		<a href="../EventServlet" class="btn btn-info  btn-lg" style="margin-top: 50px;">TOPへ戻る</a>

		</form>
	</div>


</body>
</html>