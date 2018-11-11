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
<!-- ヘッダーのブランド -->
<div class="container">
	<img src="../pt5.png">

	<!-- ログイン入力 -->
	<div id="center" style="margin-top: 60px;">
		<form method="post" action="../AdminLoginServlet">
			<table>
				<tr height="40">
					<td width="120"><label>管理者ID</label></td>
					<td><input type="text" name="id" maxlength="32" required /></td>
				</tr>
				<tr height="40">
					<td width="120"><label>パスワード</label>
					<td><input type="password" name="pass"></td>
				</tr>
				</table>
				<input type="submit" class="btn btn-primary  btn-lg" style="margin-top: 50px;" value="ログイン" name="submit">
				<input type="reset" class="btn btn-info  btn-lg" style="margin-top: 50px;" value="リセット" name="reset">
			</form>
		<font color="red"><c:out value="${message}"/></font>
		</div>
	</div>
</body>
</html>