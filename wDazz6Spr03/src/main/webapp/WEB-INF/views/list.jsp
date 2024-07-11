<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과 : ${msg}<br/>
결과 : ${requestScope.msg}<br/>
<%
String ss = (String)request.getAttribute("msg");
out.println("결과 : " + ss);
%>
</body>
</html>