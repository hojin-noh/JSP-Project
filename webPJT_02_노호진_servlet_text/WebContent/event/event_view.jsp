<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>    
<%
	Event_dao dao = new Event_dao();
	String no = request.getParameter("t_no");
	dao.hitCount(no);
	Event_dto dto = dao.getEventView(no);
	
%>    
<%@ include file="/common/common_subpage_head.jsp"%>

<script type="text/javascript">
		function goUpdateForm(){
			noti.method="post";
			noti.action="event_update.jsp";
			noti.submit();
		}
		function goDelete(){
			if(confirm(" 정말 삭제 하시겠습니까? ")){
			noti.method="post";
			noti.action="db_event.jsp";
			noti.submit();
			}
		}
		
</script>	
		<form name="noti">
			<input type="hidden" name="t_no" value="<%=no%>">
			<input type="hidden" name="t_work_gubun" value="delete">
		</form>
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
					<col width="55%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="2"><%=dto.getTitle() %></td>
						<td> <i class="far fa-eye"></i> <%=dto.getHit() %></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3">
							<textarea class="textArea_H250_noBorder" readonly><%=dto.getContent() %></textarea>
						</td>
					</tr>	
					<tr>
						<th>Period</th>
							<td> 
								<span name="t_s_reg_date" value="<%=dto.getS_date() %>"><%=dto.getS_date() %> ~ </span> 
								<span name="t_e_reg_date" value="<%=dto.getE_date() %>"><%=dto.getE_date() %>   </span>
							</td>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td>
							<%=dto.getReg_name() %>
						</td>
						<th>RegDate</th>
						<td>
							<%=dto.getReg_date() %>
						</td>
					</tr>	

				</tbody>
			</table>
			<div class="buttonGroup">
<%				if(session_level.equals("top")){ %>				
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
<%					}	 %>
				<a href="event_list.jsp" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>				
	</div>	
</body>
</html>






