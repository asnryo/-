<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse navbar-fixde-top" style="height: 110px">
	<div class="container">
		<div class="navbar-header">
			<h4><a href="EventServlet" ><img src="pt5.png"></a></h4>
		</div>

		<div id="navbar" class="navbar-collapse collapse">
		<!-- ゲスト -->
				<ol class="nav navbar-nav navbar-right">
					<c:if test="${userse.id == null && admse.id == null}">
					<li><h6><a href="Gest/NewTouroku.jsp">新規登録</a></h6></li>

					<li><h6><a href="User/Login.jsp">ログイン</a></h6></li>
					</c:if>
				</ol>
		<!-- ユーザー -->
				<c:if test="${userse.id != null && admse.id == null}">
					<ol class="nav navbar-nav navbar-right">
						<li><a href="User/Touroku.jsp"><c:out value="${userse.nick}"  /></a></li>
	 					<li><a href="UserLogoutServlet">ログアウト</a></li>
	 				</ol>
				</c:if>
		<!-- 管理者 -->
				<c:if test="${admse.id != null}">
					<ol class="nav navbar-nav navbar-right">
						<li><a href="AdminEventTourokuProcessServlet">イベント新規登録</a></li>
						<li><a href="AdminSerchServlet">管理者一覧</a></li>
						<li><a href="AdminUserSerchServlet">ユーザー 一覧</a></li>
						<li><a href="./AdminDetailServlet?id=<c:out value="${admse.id }"/>"><c:out value="${admse.id}"/></a></li>
						<li><a href="AdminLogoutServlet">ログアウト</a></li>
	 				</ol>
				</c:if>
		</div>
		<!-- /.navbar-collapse -->
	</div>
</nav>

