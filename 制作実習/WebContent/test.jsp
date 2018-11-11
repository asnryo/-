<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content=" text/html; charset=UTF-8">
<title>値渡しのテスト</title>
</head>
<body>
<b>チェックボックスの値渡し確認：</b><p>

<!-- チェックボックスの値 -->
<%
	request.setCharacterEncoding("UTF-8");
	String[] st = request.getParameterValues("category");
	for(int i = 0; i < st.length; i++){
%>
	<%= st[i] %><br>
<%
	}
%>


<!-- テキストの値 -->
<b>テキストの値渡し確認：</b><p>
<%
	request.setCharacterEncoding("UTF-8");
	String keyword = request.getParameter("keyword");
%>
<%=  keyword %><br>

<!-- 日付の値 -->
<b>日付の値渡し確認：</b><p>
<%
	request.setCharacterEncoding("UTF-8");
	String start = request.getParameter("start");
	String end = request.getParameter("end");
%>
<%=  start %>
<%=  end %>


</body>
</html>