<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>イベント削除</title>
<jsp:include page="/header.jsp" />
</head>
<body>
<jsp:include page="/nav.jsp" />

<div class="container">
<form id="sender" action="AdminEventDeletekakuninServlet" method="post">
	<h2><font color="red">このイベントを削除してもよろしいですか？</font></h2>
	<h4>イベントコード&emsp;<c:out value="${event.code}"/><br></h4>
	<h2>イベント名&emsp;<c:out value="${event.name}" /></h2>
	<h3>イベント説明</h3>
	<h4><c:out value="${event.des}" /></h4>
<table class="table" style="font-size: 12pt;">
	<tr>
		<th>開催日</th>
		<td><c:out value="${event.openDate}"/></td>
	</tr>
	<tr>
		<th>終了日</th>
		<td><c:out value="${event.endDate}"/></td>
	</tr>
	<tr>
		<th>開催時間</th>
		<td><c:out value="${event.openTime}"/></td>
	</tr>
	<tr>
		<th>終了時間</th>
		<td><c:out value="${event.endTime}"/></td>
	</tr>
	<tr>
		<th>場所</th>
		<td><c:out value="${event.spot}" /></td>
	</tr>
	<tr>
			<th>画像</th>
			<td>
				<img src="img/<c:out value="${event.img}"/>" class="event_img" height="550px" width="550px" ><br><br><br>

			</td>
		</tr>

	<tr>
		<th>カテゴリ</th>

		<td><c:out value="${event.cate}" />
		</td>
	</tr>

</table>

<input type="hidden" name="ev_code" value="<c:out value="${ event.code }" />" />
<input type="submit" class="btn btn-warning btn-lg" value="削除" />
<span style="margin-right: 2em;"></span>

<button type="button" class="btn btn-info btn-lg" onclick="history.back()">戻る</button>
</form>

<c:if test="${dto.id > 0 }">
<br />
</c:if>

</div>
</body>
</html>