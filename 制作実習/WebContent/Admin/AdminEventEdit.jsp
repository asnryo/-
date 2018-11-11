<%@page import="java.io.File"%>
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
<title>イベント登録編集</title>
<jsp:include page="/header.jsp" />
<script type="text/javascript">
	window.onload = function(){
		var cate = document.getElementById("cate");
		cate.selectedIndex = ${event.cate};
	};
</script>
</head>
<body>
<jsp:include page="/nav.jsp" />
	<div class="container">
		<form id="sender" action="AdminEventEditKakuninServlet" method="post" >
			<table class="table">
				<tr>
					<th>イベントコード</th>
					<td>
						<c:choose>
							<c:when test="${event.code > 0}">
								<c:out value="${event.code }" />
							</c:when>
							<c:otherwise>
									(新規)
							</c:otherwise>
						</c:choose>
					</td>
				</tr>

				<tr>
					<th>画像</th>
					<td>
						<c:choose>
							<c:when test="${event.img != null}">
								<img src="./img/<c:out value="${event.img}" />"  class="event_img" height="600px" width="600px"><br>
								<input type="hidden" name="ev_img" value="<c:out value="${event.img}" />">
							</c:when>
							<c:otherwise>
								添付ファイルはありません
							</c:otherwise>
						</c:choose>
					</td>
				</tr>

				<tr>
					<th>イベント名</th>
					<td><input type="text" name="ev_name" value="<c:out value="${event.name}" />"size="120"  required  /></td>
				</tr>
				<tr>
					<th>イベント説明</th>
					<td><textarea name="ev_des" rows="8" cols="121"  required ><c:out value="${event.des}" /></textarea></td>
				</tr>
				<tr>
					<th>開催日</th>
					<td><input type="date" name="open_date" value="<c:out value="${event.openDate}"/>"  required/></td>
				</tr>
				<tr>
					<th>終了日</th>
					<td><input type="date" name="end_date" value="<c:out value="${event.endDate}"/>"  required/></td>
				</tr>
				<tr>
					<th>開催時間</th>
					<td><input type="time" name="open_time" value="<c:out value="${event.openTime}"/>"  required/></td>
				</tr>
				<tr>
					<th>終了時間</th>
					<td><input type="time" name="end_time" value="<c:out value="${event.endTime}"/>"  required/></td>
				</tr>
				<tr>
					<th>場所</th>
					<%--ラジオボタンに初期値を持たせる --%>
					<c:choose>
						<c:when test="${event.spot == '東葛飾' }"><c:set var="katu">checked</c:set></c:when>
						<c:when test="${event.spot == '北総' }"><c:set var="hoku">checked</c:set></c:when>
						<c:when test="${event.spot == 'かずさ・臨海' }"><c:set var="kazu">checked</c:set></c:when>
						<c:when test="${event.spot == '南房総' }"><c:set var="minami">checked</c:set></c:when>
						<c:when test="${event.spot == '九十九里' }"><c:set var="kuju">checked</c:set></c:when>
						<c:otherwise><c:set var="bay">checked</c:set></c:otherwise>
					</c:choose>
					<td>
						<input type="radio" name="spot" value="ベイエリア"  <c:out value="${bay }"/>/>ベイエリア<span style="margin-right: 2em;"></span>
						<input type="radio" name="spot" value="東葛飾" <c:out value="${katu}"/>/>東葛飾<span style="margin-right: 2em;"></span>
						<input type="radio" name="spot" value="北総" <c:out value="${hoku}"/>/>北総<br>
						<input type="radio" name="spot" value="かずさ・臨海" <c:out value="${kazu}"/>/>かずさ・臨海<span style="margin-right: 2em;"></span>
						<input type="radio" name="spot" value="南房総" <c:out value="${minami}"/>/>南房総<span style="margin-right: 1em;"></span>
						<input type="radio" name="spot" value="九十九里" <c:out value="${kuju }"/>/>九十九里<span style="margin-right: 5em;"></span>

					</td>
				</tr>

				<tr>
					<th>カテゴリ</th>
					<c:choose>
						<c:when test="${event.cate == 'グルメ' }"><c:set var="guru">checked</c:set></c:when>
						<c:when test="${event.cate == 'アート' }"><c:set var="art">checked</c:set></c:when>
						<c:when test="${event.cate == '祭り' }"><c:set var="matu">checked</c:set></c:when>
						<c:when test="${event.cate == 'スポーツ' }"><c:set var="sports">checked</c:set></c:when>
						<c:when test="${event.cate == 'ドライブ' }"><c:set var="drive">checked</c:set></c:when>
						<c:otherwise><c:set var="kou">checked</c:set></c:otherwise>
					</c:choose>

					<td>
						<input type="radio" name="cate" value="行楽" <c:out value="${kou}"/>>行楽<span style="margin-right: 2em;"></span>
						<input type="radio" name="cate" value="グルメ" <c:out value="${guru}"/>>グルメ<span style="margin-right: 2em;"></span>
						<input type="radio" name="cate" value="アート" <c:out value="${art}"/>>アート<br>
						<input type="radio" name="cate" value="祭り" <c:out value="${matu}"/>>祭り<span style="margin-right: 2em;"></span>
						<input type="radio" name="cate" value="スポーツ" <c:out value="${sports}"/>>スポーツ<span style="margin-right: 1em;"></span>
						<input type="radio" name="cate" value="ドライブ" <c:out value="${drive}"/>>ドライブ
					</td>
			<%-- プルダウン表示　一旦ラジオ
					<td>
						<select name="cate" id="cate">
							<option value="行楽">行楽</option>
							<option value="グルメ">グルメ</option>
							<option value="アート">アート</option>
							<option value="祭り">祭り</option>
							<option value="スポーツ">スポーツ</option>
							<option value="ドライブ">ドライブ</option>
						</select>
					</td>
			--%>
				</tr>

			</table>

		<input type="hidden" name="ev_code" value="<c:out value="${ event.code }" />" />
		<input type="submit" class="btn btn-danger  btn-lg" value="登録" />
		<span style="margin-right: 1em;"></span>

		<button type="button" class="btn btn-info  btn-lg" onclick="history.back()">戻る</button>
		</form>

		<c:if test="${dto.id > 0 }">
		<br />
		<%--<form id="delete" action="delete" method="POST">

			<input type="hidden" name="id" value="<c:out value="${ dto.id }" />" />
			<input type="hidden" name="token" value="<c:out value="${ token }" />" />
			<input type="submit" class="btn btn-warning  btn-lg" value="削除する" />

		</form>--%>
		</c:if>

	</div>
</body>
</html>