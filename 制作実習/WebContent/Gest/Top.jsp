<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="beens.EventBean"%>
<%@page import="beens.KuchiBean"%>
<%@page import="java.util.List"%>
<%@page import="beens.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>

<jsp:include page="/header.jsp"/>
<title>地域情報サイト</title>

<body>
<jsp:include page="/nav.jsp"/>
<ul class="haikei">
    <li></li>
    <li></li>
    <li></li>
    <li></li>
</ul>

<!-- コンテンツ（イベント一覧） -->
	<div id="content">
		<div id="main" style="width:1000px;height:790px;overflow:auto;">
			<h2>イベント一覧</h2><br>
			<dl>
				<c:forEach items="${eventList}" var="event">
				<%//DATE型へ変換
						EventBean event = (EventBean)pageContext.findAttribute("event");
						String opstr = event.getOpenDate();
						String edstr = event.getEndDate();
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
						Date opdate = sdf.parse(opstr);
						Date eddate = sdf.parse(edstr);

				%>
				<!-- イベントのcodeを取得してイベント詳細画面を表示。パスの確認をする。 -->
				<dt><a href="EventDetailGetServlet?code=<c:out value="${event.code }" />">
				<c:out value="${event.name}" /></a>&emsp;開催日&ensp;<fmt:formatDate value="<%=opdate %>" pattern="yyyy年m月d日"/>
													&emsp;終了日&ensp;<fmt:formatDate value="<%=eddate %>" pattern="yyyy年m月d日"/></dt>
				<dd><c:out value="${fn:substring(event.des,0,30).concat('・・・')}"/></dd>
				<img src="linem.jpg" style="width:1000px;"><br><br>
				</c:forEach>
			</dl>
		</div>


<!-- サブメニュー（検索） -->
		<div id="submenu">
			<form action="./EventSearchServlet" method="post">

			<h4>キーワード検索</h4>
			<input type="text" name=keyword>

			<h4>カテゴリ</h4>
			<input type="radio" name="cate" value="行楽">行楽<span style="margin-right: 2em;"></span>
			<input type="radio" name="cate" value="グルメ">グルメ<span style="margin-right: 2em;"></span>
			<input type="radio" name="cate" value="アート">アート<br>
			<input type="radio" name="cate" value="祭り">祭り<span style="margin-right: 2em;"></span>
			<input type="radio" name="cate" value="スポーツ">スポーツ<span style="margin-right: 1em;"></span>
			<input type="radio" name="cate" value="ドライブ">ドライブ

			<h4>期間</h4>
			<input type="date"  name="start" value=""/>開催日<br>
			<input type="date"  name="end" value=""/>終了日

			<h4>エリア</h4>
			<input type="radio" name="spot" value="ベイエリア">ベイエリア<span style="margin-right: 2em;"></span>
			<input type="radio" name="spot" value="東葛飾">東葛飾<span style="margin-right: 2em;"></span>
			<input type="radio" name="spot" value="北総">北総<br>
			<input type="radio" name="spot" value="かずさ・臨海">かずさ・臨海<span style="margin-right: 2em;"></span>
			<input type="radio" name="spot" value="南房総">南房総<span style="margin-right: 1em;"></span>
			<input type="radio" name="spot" value="九十九里">九十九里<span style="margin-right: 5em;"></span>

			<input type="submit" name="submit" value="検索">
			<input type="reset" name="clear" value="クリア">
			<br><br>

						<div>
							<img src="chiba1.png" alt="chibamap" usemap="#chibamap">
								<map name="chibamap">
									<area style="border:none;outline:none;" shape="poly" coords="16,28,37,97,47,119,102,95,22,19" href="MapServlet?chiku=東葛飾" alt="東葛飾">
									<area style="border:none;outline:none;" shape="poly" coords="136,80,136,130,224,132,230,80" href="MapServlet?chiku=北総" alt="北総">
									<area style="border:none;outline:none;" shape="poly" coords="47,145,47,184,117,179,119,145" href="MapServlet?chiku=ベイエリア" alt="ベイエリア">
									<area style="border:none;outline:none;" shape="poly" coords="160,170,160,200,230,200,230,170" href="MapServlet?chiku=九十九里" alt="九十九里">
									<area style="border:none;outline:none;" shape="poly" coords="20,230,20,260,110,260,110,230" href="MapServlet?chiku=かずさ" alt="かずさ">
									<area style="border:none;outline:none;" shape="poly" coords="80,300,80,320,150,320,150,300" href="MapServlet?chiku=南房総" alt="南房総">
								</map>
						</div>
			</form>
		</div>
	</div>
<img src="image002.png" class="pos">
</body>
</html>