<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/common_subpage_head.jsp"%>
<%@ include file="/common/session_member_check.jsp" %>
<%@ page import="common.*" %>
<%
	common common = new common();
%>


<script>
	function goSave(){
		if(!checkEmpty(qna.t_title, " 제목 입력~~~~~")) return;
		if(qna.t_content.value==""){
			alert(" 내용 입력! ");
			noti.t_content.focus();
			return;
		}
		
		
		qna.method="post";
//		qna.action="db_question_save.jsp";
		qna.action="db_question_save.jsp";
		qna.submit();
	}
</script>	
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="/event/event_list.jsp">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				QUESTION & ANSWER
			</p>
			<form name="qna">
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name %>
							<input type="hidden" name="t_reg_id" value="<%=session_id%>" class="input100">
						</td>
						<th>RegDate</th>
						<td><%=common.getToday() %></td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="qanda_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>






