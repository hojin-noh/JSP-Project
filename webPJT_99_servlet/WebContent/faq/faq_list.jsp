<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp" %>
<%@ page import=" dto.*, java.util.*, common.*" %>
<%
	ArrayList<Faq_dto> dtos = (ArrayList<Faq_dto>)request.getAttribute("t_dtos");

	String no				= (String)request.getAttribute("t_no");
	
	String select 			= (String)request.getAttribute("t_select");
	String search 			= (String)request.getAttribute("t_search");
	
	int v_count 		= (int)request.getAttribute("v_count");
	int a_count 		= (int)request.getAttribute("a_count");
	int for_count 		= (int)request.getAttribute("for_count");
	int total_page 		= (int)request.getAttribute("total_page");
	int current_page	= (int)request.getAttribute("current_page");

%>
<style>
	#deletebox, #updatebox{
		float:right;
		margin-right:10px;
	}
</style>
<script type="text/javascript">
	function goSearch(){
		faqForm.method="post";
		faqForm.action="/FaqList";
		faqForm.submit();
	}

	function goPage(pageNumber){
		faqForm.r_page.value = pageNumber;
		faqForm.method="post";
		faqForm.action="/FaqList";
		faqForm.submit();
	}
	
	function goUpdate(){
			detail.method="post";
			detail.action="/FaqUpdateForm";
			detail.submit();
	}
	
	function goDelete(){
			if(confirm(" 정말 삭제하시겠습니까? ")){
				detail.method="post";
				detail.action="/DBFaqDelete";
				detail.submit();
			}
	}
</script>
		<!--  header end -->
		<!-- sub page start -->
		<form name="detail">
			<input type="hidden" name="t_no" value="<%=no%>">
		</form>
		<div class="notice">
			<div class="sub-notice">
				<h2 ><a href="faq_list.jsp"> NOTICE</a></h2>	
				<h2><a href="/NewsList"> NEWS</a></h2>	
				<h2><a href="/QnaList"> QnA</a></h2>
				<h2 class="color"><a href="/FaqList"> <i class="fas fa-check"></i>FAQ</a></h2>	
			</div>

		<div class="search_wrap">
			<div class="record_group">
				<p> 총게시글 : <span><%=dtos.size() %></span>건</p>
			</div>
			<form name="faqForm">
				<input type="hidden" name="r_page">
			<div class="search_group">
				<select name="t_select" class="select">
					<option value="question" <%if(select.equals("question")) out.print("selected"); %>>제목</option>
					<option value="answer" <%if(select.equals("answer")) out.print("selected"); %>>내용</option>
				</select>
				<input type="text" name="t_search" value="<%=search %>" class="search_word">
				<button class="btn_search" onclick="goSearch()"><i class="fa fa-search"></i><span class="sr-only">검색버튼</span></button>
			</div>
			</form>
		</div>

			
			<!-- table start-->
			<div class="table-box">
				<table class="table">
					<caption>공지사항 - 번호, 제목, 첨부, 작성일, 조회수</caption>
					<colgroup>
						<col width="5%">
						<col width="*">
						<col width="15%">
						<col width="15%">
						<col width="10%">
					</colgroup>
					
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">작성일</th>
							<th scope="col">작성자</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
<%	if ( dtos.size() > 0 ){
		for(int k = 0 ; k < dtos.size() ; k++ )	{
			if(v_count == for_count){ 
%>						
						<tr>
							<td><%=dtos.get(k).getNo() %></td>
							<td class="txt">
								<a href="faq_view.jsp"><%=dtos.get(k).getQuestion() %></a>
								<button id=updatebox onclick="goUpdate()">수정</button> 
								<button id=deletebox onclick="goDelete()">삭제</button>
							</td>
							<td><%=dtos.get(k).getReg_date() %></td>
							<td><%=dtos.get(k).getReg_id() %></td>
							<td><%=dtos.get(k).getHit() %></td>
						</tr>
<%
				v_count = v_count + 1;
				for_count = for_count + 1;
			}else { 
				v_count = v_count + 1;
			}
			if(v_count == a_count)break; 
		}
	}
%>							
					</tbody>
				</table>
			</div>
			
			<div class="page-number">
				<div class="page-number">
<%
					out.println(CommonUtil.pageListPost(current_page, total_page, 5));
					if(session_level.equals("top")){		
%>
					<a href="/FaqWrite" class="btn-write">글쓰기</a>
<%	} %>
				</div>				
			</div>
		
		</div>
		
		
		
		<!--  footer start  -->
		<div id="footer">
			<div class="footer-text">
				<ul class="sub-logo">
					<li><a href="index.html" alt="서브로고">JSL 인재개발원</a></li>
				</ul>
				
				<ul class="copy">
					<li>Copyright ⓒ EL WIDE. All Rights Reserved.</li>
				</ul>
			</div>
		</div>
		</div>
	
	
	
	</body>
</html>









    