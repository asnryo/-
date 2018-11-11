<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../header.jsp"/>
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<title>画像アップロード</title>
<script type="text/javascript"></script>
</head>
<body>
	<div class="container">
	<h2 style="line-height : 5em;">イベント情報画像アップロード</h2>
		<h4 style="line-height : 5em;">アップロードするファイルを選択して、【アップロード】ボタンを押してください。</h4>
		<form name="upload" action="AdminUpload" method="post" enctype="multipart/form-data" >
			<input type="file" name="img" accept="image/*" style="margin-top: 20px;" required="required"/>
			<input type="submit" class="btn btn-primary  btn-lg" style="margin-top: 50px;" value="アップロード"/>
			<button type="button" class="btn btn-info  btn-lg" onclick="history.back()">戻る</button>
			<input type="hidden" name="code" value="<c:out value="${code }"/>"/>
		</form>
	</div>

</body>
</html>