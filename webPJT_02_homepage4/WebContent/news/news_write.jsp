<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*" %>
<%@ include file="/common/session_manager_check.jsp" %>
<%@ include file="/common/common_subpage_head.jsp" %>
<%
	Notice_dao dao = new Notice_dao();
	String pageType = "news";
	dao.DefinitionPageType(pageType);

%>
<script type="text/javascript">
		function goSave(){
			if(news.t_title.value == ""){
				alert(" 제목을 입력하시오. ");
				news.t_title.focus();
				return;
			}
			if(news.t_content.value == ""){
				alert(" 내용을 입력하시오. ");
				news.t_title.focus();
				return;
			}
			if(news.t_reg_name.value == ""){
				alert(" 작성자를 입력하시오. ");
				news.t_title.focus();
				return;
			}
			if(news.t_reg_date.value == ""){
				alert(" 작성일을 입력하시오. ");
				news.t_title.focus();
				return;
			}
			news.method="post";
			news.action="db_news.jsp";
			news.submit();
		}
</script>
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="/event/event_list.jsp">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			<form name="news">
				<input type="hidden" name="t_work_gubun" value="save">
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
						<td colspan="3"><input name="t_title" type="text" class="input600"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea name="t_content" class="textArea_H250"></textarea></td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name %>
							<input name="t_reg_name" value="<%=session_name %>" type="hidden" class="input100">
						</td>
						<th>RegDate</th>
						<td><input name="t_reg_date" type="date" class="input130"></td>
					</tr>	
				</tbody>
			</table>
			</form>
			<div class="buttonGroup">
				<a href="javascript:goSave()" class="butt">Save</a>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>
		
</body>
</html>






