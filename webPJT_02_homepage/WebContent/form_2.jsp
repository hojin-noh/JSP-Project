<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("t_name");
//	out.print("========="+name);
	
	String area = request.getParameter("t_area");
	String age = request.getParameter("t_age");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
성명 : <% out.print(name);%><br>
지역 : <%= area%><br>
나이 : <%= age%><br>
<input type="button" onclick="history.back()" value="이전~">
</body>
</html>