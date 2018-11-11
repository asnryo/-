<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重複エラー発生</title>
<jsp:include page="/header.jsp" />
</head>
<body>
<jsp:include page="/nav.jsp" />
	<div class="container">
		ご登録希望のIDがすでに登録されています。<br />
		申し訳ございませんが、再度設定をお願いいたします。<br /><br />

		<button type="button" class="btn btn-success btn-lg" onclick="history.back()">戻る</button><br />
		<img alt="エラー画面" src="css/sorry.png">
	</div>
</body>
</html>