<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>

<%
	
	news_dao dao = new news_dao();
	String no = request.getParameter("t_no");
	int hitUp = dao.hitCount(no);
	
	news_dto dto = dao.getNewsView(no);
		
%>
<!DOCTYPE html>
<html>
<head>
	<title>홍길동</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">	
	<link href="../css/common.css" rel="stylesheet">
	<link href="../css/layout.css" rel="stylesheet" >	
	<script>
		function goUpdateForm(){
			news.method="post";
			news.action="news_updateForm.jsp";
			news.submit();
		}
		
		function goDelete(){
			var chk = confirm(" 증말 삭제 하겠니? ");
			if(chk){
			news.method="post";
			news.action="news_delete.jsp";
			news.submit();
			}
		}
	</script>
</head>
<body>
	<form name="news">
		<input type="hidden" name="t_no" value="<%=no%>">
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
						<col width="30%">
						<col width="12%">
						<col width="*">
					</colgroup>
					<tbody>
						<tr>
							<th>게시판 제목</th>
							<td class="th_left" >
								<%=dto.getTitle() %>
							</td>
							<th>조회수</th>
							<td class="th_left" >
								<%=dto.getHit() %>
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td class="th_left" colspan="3">
								<textarea name="t_content" class="board_textarea_H270_noBorder" readonly><%=dto.getContent() %></textarea>
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
		<script type="text/javascript">//스크립트를 사용하면 아래 목록에 onClick에 location.href='news_list.jsp'"대신 onClick="goList()"가 있어야함.
			function goList(){
				Location.href="news_list.jsp";		//자바스크립트로 페이지 넘김
			}
		</script>	
			
			<div class="btn_wrap">
				
				<input type="button" onClick="location.href='news_list.jsp'" value="목록" class="btn_list">
				<input type="button" onClick="location.href='news_updateForm.jsp?t_no=<%=no%>'" value="수정GET" class="btn_list">
				<input type="button" onClick="goUpdateForm()" value="수정POST" class="btn_list">
				<input type="button" onClick="goDelete()" value="삭제" class="btn_list">
				<!-- <a href="javascript:goDelet()">삭제</a> 위에 꺼 자바 스크립트로 할때 -->
			</div>
		</div>
	</div>
</body>
</html>



















