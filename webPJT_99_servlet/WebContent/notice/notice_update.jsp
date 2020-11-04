<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.*" %>  
<%
	Notice_dto dto = (Notice_dto)request.getAttribute("t_dto");
%>    
<%@ include file="/common_head.jsp" %> 

<script>
		function goUpdate(){
			if(!checkEmpty(write.t_title," 제목 입력! ")) return;
			if(!checkEmpty(write.t_content," 내용 입력! ")) return;
			
			write.method = "post";
			write.action = "/DBNoticeUpdate";
			write.submit() ;
		}
</script> 		
		<!--  header end -->
		
		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> NOTICE-Update</span></h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="write">
				<input type="hidden" name="t_no" value="<%=dto.getNo()%>">
					<h2 class="readonly">제목, 첨부파일, 내용을 작성합니다</h2>
				
					<fieldset>
						<legend>공지사항 글쓰기</legend>
						
						<table class="table">
							<caption>공지사항 글쓰기</caption>
							<colgroup>
								<col width="15%">
								<col width="35">
								<col width="15">
								<col width="35">
							</colgroup>
							
							<tr>
								<th><label for="title">제목</label></th>
								<td colspan="3"><input type="text" name="t_title" id="title" value="<%=dto.getTitle() %>" class="title"></td>
							</tr>
							
							<tr>
								<th><label for="cont">내용</label></th>
								<td colspan="3"><textarea type="cont" name="t_content" id="cont" value="<%=dto.getContent() %>" class="cont"></textarea>
							</tr>
							
							<tr>
								<th><label for="file">파일 첨부</label></th>
								<td colspan="3"><input type="file" name="t_file" class="file" id="file"></td>
							</tr>
							
							<tr>
								<th>등록자</th>
								<td style="text-align:left"><%=dto.getReg_name() %></td>
								<th>등록일자</th>
								<td style="text-align:left"><%=dto.getReg_date() %></td>
							</tr>
							
							<tr>
								<td colspan="4">
								<input type="button" onclick="goUpdate()" value="수정 후 저장" class="btn" >
								<input type="button" onclick="history.back();" value="이전화면으로" class="btn">
								</td>
							</tr>

							</table>
					</fieldset>
				</form>
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
	
	
		<script>


		</script>
	
	</body>
</html>









    