<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*" %>
<%@ include file="/common/common_subpage_head.jsp" %>
<%
	Notice_dao dao = new Notice_dao();
	String pageType = "news";
	dao.DefinitionPageType(pageType);
	
	String no = request.getParameter("t_no");
	dao.hitCount(no);
	Notice_dto dto = dao.getNoticeView(no);
%>
<script type="text/javascript">
	function goUpdate(){
		news.method="post";
		news.action="news_update.jsp";
		news.submit();
	}
	
	function goDelete(){
		news.method="post";
		news.action="db_news.jsp";
		news.submit();
	}

</script>
	<form name="news">
		<input type="hidden"  name="t_no"  value="<%=no%>" >
		<input type="hidden"  name="t_work_gubun"  value="delete" >
	</form>
	
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"> NOTICE</a></li>
				<li><a href="/news/news_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span>NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
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
						<th>Attach</th>
						<td colspan="3">
							<%if(dto.getAttach() != null){%> 
								<%=dto.getAttach() %>  
							<% } %>
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=dto.getReg_name() %></td>
						<th>RegDate</th>
						<td><%=dto.getReg_date() %></td>
					</tr>	

				</tbody>
			</table>
			<div class="buttonGroup">
		<%		if(session_level.equals("top")){ %>
				<a href="javascript:goDelete()" class="butt">Delete</a>
				<a href="javascript:goUpdate()" class="butt">Update</a>
		<%										} %>
				<a href="news_list.jsp" class="butt">List</a>
			</div>	
		</div>	
<%@ include file="/common/common_subpage_bottom.jsp" %>
		






