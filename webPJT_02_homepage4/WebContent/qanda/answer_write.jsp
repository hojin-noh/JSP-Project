<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*, dto.*,common.*" %>    
<%
	Qanda_dao dao = new Qanda_dao();
	String no = request.getParameter("t_no");
	dao.hitCount(no);
	Qanda_dto dto = dao.getQandaView(no);
	
%>    
<%@ include file="/common/common_subpage_head.jsp"%>

<script type="text/javascript">
		function goSaveAnswer(){
				qna.method = "post";
				qna.action = "db_answer_save.jsp";
				qna.submit();
		}
</script>	
		<form name="qna">
			<input type="hidden" name="t_no" value="<%=no%>">
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
						<td colspan="4">
							<textarea class="textArea_H120_noBorder" readonly><%=dto.getContent() %></textarea>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getQ_reg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getQ_reg_date() %></td>
					</tr>
					
					<tr>
						<th>Answer</th>
						<td colspan="4">
							<textarea name="t_answer" class="textArea_H120" ></textarea>
						</td>
					</tr>
					<tr>
						<th>AnswerName</th>
						<td><%=session_name %></td>
						<th>AnswerRegDate</th>
						<td><%=common.getToday() %></td>
					</tr>	
				</tbody>
			</table>
			<div class="buttonGroup">
				<a href="javascript:goSaveAnswer()" class="butt">AnsSave</a>
				<a href="qanda_list.jsp" class="butt">List</a>

			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>				
	</div>	
</body>
</html>






