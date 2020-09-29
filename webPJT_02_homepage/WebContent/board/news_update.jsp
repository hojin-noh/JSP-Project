<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.*" %>   
<%
	request.setCharacterEncoding("utf-8");
	news_dao dao = new news_dao();
	String no 		= request.getParameter("t_no");
	String title	= request.getParameter("t_title");
	String content	= request.getParameter("t_content");
	String reg_name	= request.getParameter("t_reg_name");
	String reg_date	= request.getParameter("t_reg_date");

	int result = dao.updateNews(no, title, content, reg_name, reg_date);
	
%>    
<!DOCTYPE html>
<html>
<head>
<script type = "text/javascript">
<%	if(result == 1){ %>	
		alert(" 수정 성공 " );
<%	} else{	%>
		alert(" 수정 실패~~~ ");
<%	}	%>
	location.href = "news_list.jsp";
</script>
</head>
<body>

</body>
</html>