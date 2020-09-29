<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "dao.*, dto.*" %>

<%
	
	Event_dao dao = new Event_dao();
	String no = request.getParameter("t_event_no");
	dao.hitCount(no);
	Event_dto dto = dao.getEventView(no);
	
%>    

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="/css/common.css" rel="stylesheet">
	<link href="/css/layout.css" rel="stylesheet" >	
</head>
<script>
	function goUpdateForm(){
			view.method="post";
			view.action="event_updateForm.jsp"
			view.submit();
		}
	function goDelete(){
			if(confirm(" 정말 삭제하시겠습니까? ")){
				view.method="post";
				view.action="db_delete.jsp";
				view.submit();
			}
	}
</script>

<body>
	<form name="view">
		<input type="hidden" name="t_event_no" value="<%=no%>">
	</form>
	<div class="container">
	
		<div class="leftmargin">
			<h1>성명 : 홍길동</h1>
		</div>		
		<div class="write_wrap">
		
			<div class="board_list">
				<table class="board_table">
					<colgroup>
						<col width="12%">
						<col width="50%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>Event 제목</th>
							<td class="th_left" >
								<%=dto.getTitle() %>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								<%=dto.getHit() %>
							</td>
						</tr>
						<tr>
							<th>Event 기간</th>
							<td class="th_left" colspan='3'>
								<%=dto.getS_date() %> ~ <%=dto.getE_date() %>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan='3'>
								<textarea readonly><%=dto.getContent() %></textarea>
							</td>
						</tr>
						<tr>
							<th>작성자</th>
							<td class="th_left">
								<%=dto.getReg_name() %>
							</td>
							<th>작성일</th>
							<td class="th_left">
								<%=dto.getReg_date() %>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="btn_wrap">
				<input type="button" onClick="location.href='event_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="location.href='event_updateForm.jsp?t_event_no=<%=no %>'" value="수정1" class="btn_list"> <!-- get 방식 -->
				<input type="button" onClick="goUpdateForm()" value="수정2" class="btn_list"> 
								<!-- post 방식 onclick이라서 ""안에 javascript로 시작 안 해도 됨 -->
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
			</div>
		</div>
	</div>
</body>
</html>


