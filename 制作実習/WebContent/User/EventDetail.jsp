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
<title>イベント詳細</title>
</head>
<body>
<jsp:include page="/nav.jsp"/>

<div id="inner0">
	<%--管理者ならイベント編集リンク表示 --%>
	<div class="btn-toolbar" role="toolbar" style="margin-bottom: 20px;">
		<c:if test="${admse != null}">
			<a class="btn btn-default"  href="AdminEventEditServlet?ev_code=<c:out value="${event.code}"/>">イベント編集</a><br>
			<a class="btn btn-warning"  href="AdminEventDeleteServlet?ev_code=<c:out value="${event.code }"/>">イベント削除</a><br>
		</c:if>
	</div>
	<%--イベント名--%>
		<h2><c:out value="${event.name }"/></h2><br>
</div>

	<%--イベント画像、イベント内容--%>
	<div id="inner">
		<img src="img/<c:out value="${event.img}"/>" class="event_img" height="550px" width="550px" ><br><br>
		</div>
		<div id="inner2">
		<h3>イベント内容</h3>
		<h4><c:out value="${event.des }"/></h4><br>
		</div>
	<div id="inner3"><br>
	<%--イベント詳細情報 --%>
	<h4>基本情報</h4>
		<table class="table table-bordered" style="font-size: 12pt; border: 2px solid #9c9a9a;">
			<tr>
				<th class="active" style="width: 98px;">開催日</th>
				<td><c:out value="${event.openDate }"/></td>
			</tr>
			<tr>
				<th class="active" style="width: 98px;">終了日</th>
				<td><c:out value="${event.endDate }"/></td>
			</tr>
			<tr>
				<th class="active" style="width: 98px;">開催時間</th>
				<td><c:out value="${event.openTime }"/></td>
			</tr>
			<tr>
				<th class="active" style="width: 98px;">終了時間</th>
				<td><c:out value="${event.endTime }"/></td>
			</tr>
			<tr>
				<th class="active" style="width: 98px;">場所</th>
				<td><c:out value="${event.spot }"/></td>
			</tr>
		</table>

	<%--口コミフォーム --%>
	<c:if test="${userse != null}">
		<form action ="NewKuchiConfServlet" method="post">
			<p>口コミ情報</p>
			<textarea name="kuchi_des" cols="128"></textarea><br>
			星
			<select name="kuchi_hoshi">
				<option value="1">★1</option>
				<option value="2">★2</option>
				<option value="3">★3</option>
				<option value="4">★4</option>
				<option value="5">★5</option>
			</select>

	<%--送信を押した時にサーブレットにデータを渡す --%>
			<input type="hidden" name="kuchi_eCode" value="<c:out value="${event.code }"/>"/>
			<input type="submit" value="送信"/>
			<input type="reset" value="リセット"/>
		</form>
	</c:if>

	<%--既存の口コミ --%>
	<img src="kutikomi.png" style="width: 300px;">
	<hr style="border-top: 2px solid #9c9a9a;"><br>
	<c:forEach items="${kuchi }" var="kuchi">
		<h4><c:out value="${kuchi.userNick }"/>
		<c:out value="${kuchi.date }"/></h4>

	<%--ユーザーidと口コミidが一致すれば、編集と削除ボタン表示 --%>
		<c:set var="kuchiId" value="${kuchi.userid }"></c:set>
		<c:set var="sessionId" value="${userse.id}"></c:set>
		<c:if test="${!(sessionId == kuchiId || admse != null) }">

			<c:choose>
				<c:when test="${kuchi.hoshi >= 5 }">★★★★★</c:when>
				<c:when test="${kuchi.hoshi >= 4 }">★★★★</c:when>
				<c:when test="${kuchi.hoshi >= 3 }">★★★</c:when>
				<c:when test="${kuchi.hoshi >= 2 }">★★</c:when>
				<c:when test="${kuchi.hoshi >= 1 }">★</c:when>
			</c:choose>
			<h4><c:out value="${kuchi.des }"/></h4>
		</c:if>

		<c:if test="${sessionId == kuchiId || admse != null}">
		<div class="btn-toolbar" role="toolbar" style="margin-bottom: 20px;">
		<form action="KuchiEditConfServlet" method="post" >
			<textarea name="kuchi_des" cols="128"><c:out value="${kuchi.des }"/></textarea>

			<%--kuchiを取得した状態で星を設定 --%>
			<script type="text/javascript">
				window.onload = function(){
				var status = document.getElementById("hoshi");
				status.selectedIndex = ${kuchi.hoshi - 1};
				}
			</script>

			<select name="hoshi" id="hoshi">
				<option value="1">★1</option>
				<option value="2">★2</option>
				<option value="3">★3</option>
				<option value="4">★4</option>
				<option value="5">★5</option>
			</select>

			<%-- 編集ボタン --%>

			<input type="hidden" name="kuchi_kCode" value="<c:out value="${kuchi.kCode }"/>"/>
			<input type="hidden" name="kuchi_eCode" value="<c:out value="${kuchi.eCode }"/>"/>
<!-- 			<input type="submit" value="編集" class="btn btn-succes  btn-lg" style="margin-top: 22px;margin-bottom: 20px;margin-right: 10px;" /> -->
					<input type="submit" value="編集"  />
		</form>

		<%-- 削除ボタン --%>
		<form action="KuchiDeleteServlet" method="post">
			<input type="hidden" name="kuchi_code" value="<c:out value="${kuchi.kCode }"/>"/>
			<input type="hidden" name="code" value="<c:out value="${event.code }"/>"/>
<!-- 			<input type="submit" value="削除" class="btn btn-warning  btn-lg"/> -->
			<input type="submit" value="削除"  class="btn btn-warning " style="margin-top: 20px;" />
		</form>
		</div>
		</c:if>
		<hr style="border-top: 2px solid #9c9a9a;">

		<br>
	</c:forEach>
	</div>

	<%--先頭ページへ戻るボタンの配置 --%>
	<a href="#">
	<button type="button" class="btn btn-default btn-lg pull-right"
	style="margin-right: 400px; margin-bottom: 100px; margin-top: 100px;">
	<img src="ue.gif" width="80" height="60">	<br>先頭へ戻る
	</button>
	</a>

</body>
</html>