<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("t_id");
//	out.print("========="+name);
	
	String name = request.getParameter("t_name");
	String password = request.getParameter("t_pw");
	String area = request.getParameter("t_area");
	String mf = request.getParameter("t_mf");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ID : <% out.print(id);%><br>
성명 : <%= name%><br>
비번 : <%= password%><br>
지역 : <%= area%><br>
성별 : <%= mf%><br>
 
<input type="button" onclick="history.back()" value="이전~">
</body>
</html>