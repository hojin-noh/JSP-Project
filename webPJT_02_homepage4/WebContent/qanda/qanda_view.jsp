<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*" %>    
<%
	Qanda_dao dao = new Qanda_dao();
	String no = request.getParameter("t_no");
	dao.hitCount(no);
	Qanda_dto dto = dao.getQandaView(no);
	
%>    
<%@ include file="/common/common_subpage_head.jsp"%>

<script type="text/javascript">
		function goUpdateForm(){
			noti.method="post";
			noti.action="notice_update.jsp";
			noti.submit();
		}
		function goDelete(){
			if(confirm(" 정말 삭제 하시겠습니까? ")){
			noti.method="post";
			noti.action="db_notice.jsp";
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
				<li><a href="/qanda/qanda_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QUESTION & ANSWER
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
							<textarea class="textArea_H120_noBorder" readonly><%=dto.getContent() %></textarea>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getQ_reg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getQ_reg_date() %></td>
					</tr>
<%					if(dto.getAnswer() != null){	 %>					
					<tr>
						<th>Answer</th>
						<td colspan="3">
							<textarea class="textArea_H120_noBorder" readonly><%=dto.getAnswer() %></textarea>
						</td>
					</tr>
					<tr>
						<th>Writer</th>
						<td><%=dto.getA_reg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getA_reg_date() %></td>
					</tr>	
<% 								}%>
				</tbody>
			</table>
			<div class="buttonGroup">
<%				if(session_level.equals("top")){ %>				
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdateForm()" class="butt">Update</a>
<%					}	 %>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>				
	</div>	
</body>
</html>






