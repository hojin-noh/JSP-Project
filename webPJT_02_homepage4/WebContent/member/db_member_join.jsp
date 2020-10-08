<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Member_dao dao = new Member_dao();
	
	String id 		= request.getParameter("t_id");
	String name 	= request.getParameter("t_name");
	String pw 		= request.getParameter("t_pw");
	String area 	= request.getParameter("t_area");
	String address	= request.getParameter("t_address");
	String tel_1 	= request.getParameter("t_tel_1");
	String tel_2 	= request.getParameter("t_tel_2");
	String tel_3 	= request.getParameter("t_tel_3");
	String mf 		= request.getParameter("t_mf");
	String hobby_t 	= request.getParameter("t_hobby_t");
	String hobby_r 	= request.getParameter("t_hobby_r");
	String hobby_s 	= request.getParameter("t_hobby_s");
	if(hobby_t == null) hobby_t="N";
	if(hobby_r == null) hobby_r="N";
	if(hobby_s == null) hobby_s="N";
	String reg_date = common.getToday();			//여기에 common은 클래스 이름임. common 패키지에서 common 클래스에 static을 넣어줘서 생성 안해줘도 됨.
	
	Member_dto dto = new Member_dto(id, name, pw, area, address, tel_1,tel_2, tel_3, mf, hobby_t, hobby_r, hobby_s, reg_date);
	int result = dao.saveMember(dto);
	String msg = "";
	if(result == 1) msg=" 회원 가입 실패~ ";
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	alert("<%=msg%>");
	lacation.href="/index.jsp";
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>