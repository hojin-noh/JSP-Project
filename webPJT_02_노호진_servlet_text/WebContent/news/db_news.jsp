<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>    
<%
	Notice_dao dao = new Notice_dao();
	String pageType = "news";
	dao.DefinitionPageType(pageType);
	
	request.setCharacterEncoding("utf-8");
	News_dao dao1 = new News_dao();
	String gubun = request.getParameter("t_work_gubun");
	
	String title = request.getParameter("t_title");
	String content = request.getParameter("t_content");
	String reg_name = request.getParameter("t_reg_name");
	String reg_date = request.getParameter("t_reg_date");
	
	int result = 0;
	String msg="";
	
	if(gubun.equals("save")){
		String no = dao1.getNewsNo();
		Notice_dto dto = new Notice_dto(no, title, content,"", reg_name, reg_date,0);
		result = dao1.saveNews(dto);
		if(result == 1){
			msg=" 등록 성공 ";
		}else msg=" 등록 실패 ";
	}
	if(gubun.equals("delete")){
		String no = request.getParameter("t_no");
		result = dao1.deleteNews(no);
		if(result == 1){
			msg=" 삭제 성공 ";
		}else msg=" 삭제 실패 ";
	}
	if(gubun.equals("update")){
		String no = request.getParameter("t_no");
		String attach = request.getParameter("t_attach");
		Notice_dto dto = new Notice_dto(no, title, content, attach, reg_name, reg_date, 0);
		result = dao1.updateNews(dto);
		
		if(result == 1){
			msg=" 수정 성공 ";
		}else msg=" 수정 실패 ";
	}
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	location.href="news_list.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>