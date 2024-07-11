<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
결과는 ${msg} <br>
결과는 ${requestScope.msg }<br>
<%
String ss = (String)request.getAttribute("msg");
out.println("결과는 "+ ss);
// 상단의 세방법은 표현방법이 다르고 같은 것. 

%>
</body>
</html>