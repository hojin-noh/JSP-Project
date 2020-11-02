<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_manager_check.jsp" %>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	Event_dao dao = new Event_dao();
	String no = request.getParameter("t_no");
	Event_dto dto = dao.getEventView(no);
%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
		function goUpdate(){
			var s_date	=	noti.t_s_reg_date.value;
			var e_date	=	noti.t_e_reg_date.value;
			
			
			if(!checkEmpty(noti.t_title, " 제목 입력~~~~~")) return;
			if(!checkEmpty(noti.t_content, " 내용 입력~~~~~")) return;
			if(!checkEmpty(noti.t_reg_date, " 수정날짜 입력~~~~~")) return;
			if(s_date > e_date){
				alert(" 시작날짜와 종료날짜를 확인해주세요. ");
				return;
			}
			noti.method="post";
			noti.action="db_event.jsp";
			noti.submit();
		}
		
</script>		
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="/event/event_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				Etc
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<form name="noti" >
					<input type = "hidden" name="t_work_gubun" value="update">
					<input type = "hidden" name="t_no" value="<%=no%>">
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="<%=dto.getTitle()%>"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content" value="<%=dto.getContent()%>"><%=dto.getContent()%></textarea></td>
					</tr>	
					<tr>
						<th>Starting Date</th>
							<td>
								<input type="date" name="t_s_reg_date" value="<%=dto.getS_date()%>"></input>
							</td>
						<th>Ending Date</th>
							<td>
								<input type="date" name="t_e_reg_date" value="<%=dto.getE_date()%>"></input>
							</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name %>
							<input type="hidden" name="t_reg_name" value="<%=session_name %>" class="input100">
						</td>
						<th>RegDate</th>
						<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date() %>" class="input130"></td>
					</tr>	

				</tbody>
			</form>
			</table>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="event_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>






