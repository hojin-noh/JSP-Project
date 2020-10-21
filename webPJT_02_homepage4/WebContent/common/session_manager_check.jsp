<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String session_manager = (String)session.getAttribute("session_level"); 
	if(session_manager == null) session_manager = "";
	if(!session_manager.equals("top")){
	//file="/common/common_session_info.jsp" page 아래에 따로 include 해야 함(위의 방법을 안 쓸 때)
	//if(!session_level.equals("top")){
%>
	<script type="text/javascript">
		alert(" 관리자가 아닙니다. ");
		location.href="/index.jsp";
	</script>
<%		
	}
%>