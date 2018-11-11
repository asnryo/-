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
<jsp:include page="/header.jsp"/>
<title>管理者登録編集</title>
</head>
<body>
<jsp:include page="/nav.jsp" />
<%--管理者新規登録画面と管理者編集画面を共有 --%>
<div class="container">
	<h2 style="line-height : 5em;">&emsp;管理者登録</h2>
	<form action="NewAdminTourokuConfServlet" id = "Edit" method="post">
	<table style="font-size: 12pt;">
		<tr height="30">
		<td>管理者コード
			<c:choose>
				<c:when test="${admin.code > 0}">
					<c:out value="${admin.code}"/>
				</c:when>
				<c:otherwise>
					新規
					<input type="hidden" name="new_adm" value="new_adm">
				</c:otherwise>
			</c:choose>
		</td>
		</tr>
		<tr height="40">
			<td><label>管理者ID</label></td>
			<c:choose>
				<c:when test="${admin.id != null }">
					<td><c:out value="${admin.id}" /></td>
					<input type="hidden" name="adm_id" value="<c:out value="${ admin.id }" />" />
					<input type="hidden" name="adm_date" value="<c:out value="${ admin.date }" />" />
				</c:when>
				<c:otherwise>
					<td><input type="text" name="adm_id" maxlength="16"  pattern="^[0-9A-Za-z]+$" title="半角英数字で入力してください" required /><font color="red"><c:out value="${kaburi}"/></font></td>
					<tr height="20"><td></td>
					<td><font size="2" color="red">※管理者IDは一度登録すると、変更はできません。</font></td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr height="40">
			<td><label>パスワード</label></td>
			<td><input type="password" name="adm_pw" maxlength="16" minlength="4" pattern="^[0-9A-Za-z]+$" title="半角英数字で4文字以上入力してください" required value="<c:out value="${admin.pw}"/>" /></td>
		</tr>
		<tr height="20"><td></td>
		<td><font size="2" color="red">※パスワードは半角英数字で4文字以上入力してください。</font></td>
		</tr>
		<tr height="40">
			<td><label>ニックネーム</label></td>
			<td><input type="text" name="adm_nick" maxlength="16" required value="<c:out value="${admin.nick}"/>" /></td>
		</tr>
		<tr height="40">
			<td><label>メールアドレス</label></td>
			<td><input type="email" name="adm_mail" value="<c:out value="${admin.mail}"/>"maxlength="64" required/></td>
		</tr>
		<tr height="40">
			<td>登録日時</td>
			<td><c:out value="${admin.date}"/></td>
			</tr>
	</table>
	<br>

			<c:choose>
				<c:when test="${admin.id != null }">
					<input type="submit" class="btn btn btn-danger  btn-lg" style="margin-top: 50px;" value="更新" />
				</c:when>
				<c:otherwise>
					<input type="submit" class="btn btn-danger  btn-lg" style="margin-top: 50px;" value="管理者新規登録" />
				</c:otherwise>
			</c:choose>

			<a href="AdminSerchServlet" class="btn btn-info  btn-lg" style="margin-top: 50px;">戻る</a>
			<c:if test="${admin.id != 'ADMIN01' && admin.id != null }"> <%--マスターと新規登録は表示しない --%>
			<a href="AdminAdmDeleteConfServlet?id=<c:out value="${admin.id}"/>" class="btn  btn-warning  btn-lg" style="margin-top: 50px;">削除</a>
			</c:if>
	</form>
</div>
</body>
</html>