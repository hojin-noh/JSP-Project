<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*"%>
<%
	request.setCharacterEncoding("utf-8");
	News_dao dao = new News_dao();

	String no		 = dao.getNewsNo();
	String title 	 = request.getParameter("t_title");
	String content 	 = request.getParameter("t_content");
	String reg_name  = request.getParameter("t_reg_name");
	String reg_date  = request.getParameter("t_reg_date");
	
/*	News_dto dto = new News_dto(no, title, content, reg_name, reg_date, 0); 이거 쓰려면 위에서 import해야 함
	int result = dao.saveNews(dto);
*/
	String query = "insert into h02_news " +
			" (no, title, content, reg_name, reg_date) " +
			" values "+
			" ('"+no+"', '"+title+"','"+content+"','"+reg_name+"','"+reg_date+"')";
	
	int result = dao.newsQuery(query);
	String msg="";
	if(result == 1) msg = " 등록 성공~ ";
	else msg = " 등록 실패~~ ";
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href = "news_list.jsp";
</script>
</head>
<body>
</body>
</html>





