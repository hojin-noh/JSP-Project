<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*" %>
<%
	Notice_dao dao = new Notice_dao();
	String no = request.getParameter("t_no");
	
	int result = dao.deleteNotice(no);
	
%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	<%if(result == 1) { %>
		alert(" 삭제되었습니다. ");
	<%}else{            %>
		alert(" 삭제실패 되었습니다. 관리자에게 문의하세요. ");
	<%}					%>
		location.href = "notice_list.jsp";
</script>
</head>
<body>

</body>
</html>