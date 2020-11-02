<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_manager_check.jsp" %>
<%@ include file="/common/common_subpage_head.jsp"%>
<%@ page import="common.*" %>
<%
	common common = new common();
%>


<script>
	function goSave(){
		var s_date = noti.t_s_reg_date.value;
		var e_date = noti.t_e_reg_date.value;
		
		if(noti.t_title.value==""){
			alert(" 제목 입력! ");
			noti.t_title.focus();
			return;
		}
		if(noti.t_content.value==""){
			alert(" 내용 입력! ");
			noti.t_content.focus();
			return;
		}
		

		if(s_date > e_date){
			alert(" 시작날짜와 종료날짜 확인해주세요. ");
			return;
		}
		
		if(noti.t_s_reg_date.value==""){
				alert(" 시작일 입력! ");
				noti.t_s_reg_date.focus();
				return;
		}
		if(noti.t_e_reg_date.value==""){
				alert(" 종료일 입력! ");
				noti.t_e_reg_date.focus();
				return;
		}	
				
		
		noti.method="post";
		noti.action="db_event_save.jsp";
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
			<form name="noti">
			<input type="hidden" name="t_work_gubun" value="insert">
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
						<td colspan="3"><textarea name="t_content" class="textArea_H220"></textarea></td>
					</tr>	
					<tr>
						<th>Starting date</th>
						<td>
							<input type="date" name="t_s_reg_date" value="<%=common.getToday() %>" class="input110"> 
						</td>
						<th>Ending date</th>
						<td>
							<input type="date" name="t_e_reg_date" value="<%=common.getToday() %>" class="input110">
						</td>
					</tr>
					<tr>
					</tr>
						<th>Writer</th>
							<td>
							<input type="hidden" name="t_reg_name" value="<%=session_name%>" class="input100"><%=session_name %>
							</td>
						<th>Reg date</th>
							<td>
								<input type="date" name="t_reg_date" value="<%=common.getToday()%>" class="input110">
							</td>
					</tr>	

				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="event_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>






