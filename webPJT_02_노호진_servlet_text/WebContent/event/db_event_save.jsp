<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>    
<%
	request.setCharacterEncoding("utf-8");
	Event_dao dao = new Event_dao();

	String no = dao.getEventNo();
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String s_date = request.getParameter("t_s_reg_date");
	String e_date = request.getParameter("t_e_reg_date");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	Event_dto dto = new Event_dto(no, title, content, s_date, e_date, reg_name, reg_date, 0);
	int result = dao.SaveEvent(dto);
	String msg="";
	if(result == 1) msg=" 작성되었습니다. ";
	else msg=" 작성 실패~ ";
%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="event_list.jsp";
</script>
</head>
<body>

</body>
</html>