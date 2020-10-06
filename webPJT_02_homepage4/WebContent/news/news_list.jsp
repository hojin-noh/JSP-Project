<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dao.*,dto.*,java.util.*" %>
<%
	request.setCharacterEncoding("utf-8");
	Notice_dao dao = new Notice_dao();
	
	String pageType = "news";
	dao.DefinitionPageType(pageType);
	
	String select = request.getParameter("t_select");
	String search = request.getParameter("t_search");
	
	
	if(select == null){
		select = "title";
		search = "";
	}
	
	ArrayList<Notice_dto> arr = dao.getNoticeList(select, search);
%>
<%@ include file="/common/common_subpage_head.jsp" %>

<script type="text/javascript">
	function goSearch(){
		news.method="post";
		news.action="news_list.jsp";
		news.submit();
	}
	
	function goView(num){
		notiView.t_no.value	= num;
		notiView.method		= "post";
		notiView.action		= "news_view.jsp";
		notiView.submit();
		
	}
</script>

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
				NEWS
			</p>
	<form name="news">
			<p class="select_box">
				<select name="t_select" class="sel_box">
					<option value="title" <%if(select.equals("title")) out.print("selected"); %>>Title</option>
					<option value="content" <%if(select.equals("content")) out.print("selected"); %>>Content</option>
				</select>
				<input name="t_search" type="text" class="sel_text" value="<%=search%>">
				<button type="submit" onclick="goSearch()" class="sel_button"><i class="fa fa-search"></i> SEARCH</button>
			</p>
	</form>		
			<table class="boardList">
				<colgroup>
					<col width="5%">
					<col width="60%">
					<col width="10%">
					<col width="14%">
					<col width="6%">
				</colgroup>
				<thead>
					<tr>
						<th>No</th>
						<th>Title</th>
						<th>Reg Name</th>
						<th>Reg Date</th>
						<th>Hit</th>
					</tr>
				</thead>
				
				<form name="notiView">
					<input type="hidden" name="t_no" >
				</form>
				
				<tbody>
				<%for(int k = 0; k < arr.size(); k++){ %>
					<tr>
						<td><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getNo() %></a></td>
						<td class="t_center"><a href="javascript:goView('<%=arr.get(k).getNo() %>')"><%=arr.get(k).getTitle()%> </a></td>
						<td><%=arr.get(k).getReg_name() %></td>
						<td><%=arr.get(k).getReg_date() %></td>
						<td><%=arr.get(k).getHit() %></td>
					</tr>
				<% 		} %>	
					
				</tbody>
			</table>
			
			<div class="paging">
				<a href=""><i class="fa fa-angle-double-left"></i></a>
				<a href=""><i class="fa fa-angle-left"></i></a>
				<a href="" class="active">1</a>
				<a href="">2</a>
				<a href="">3</a>
				<a href="">4</a>
				<a href="">5</a>
				<a href=""><i class="fa fa-angle-right"></i></a>
				<a href=""><i class="fa fa-angle-double-right"></i></a>
				<a href="news_write.jsp" class="write">글쓰기</a>
			</div>
		</div>	
	<%@ include file="/common/common_subpage_bottom.jsp" %>
		
	</div>	
</body>
</html>









