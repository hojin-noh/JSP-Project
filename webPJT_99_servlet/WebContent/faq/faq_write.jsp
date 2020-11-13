<%@page import="common.CommonUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_manager_check.jsp" %> 
<%@ include file="/common_head.jsp" %> 

<script>
		function goSave(){
			if(!checkEmpty(write.t_question," 제목 입력! ")) return;
			if(!checkEmpty(write.t_answer," 내용 입력! ")) return;
	
		write.method = "post";
		write.action = "/DBFaqSave";
		write.submit() ;
	}
		function goList(){
			write.method="post";
			write.action = "/FaqList";
			write.submit();
		}
 
 </script> 		
		<!--  header end -->
		
		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2>
				<span><i class="fas fa-edit"></i> FAQ-write</span>
			</h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="write">
				
					<fieldset>
						<legend>자주묻는 질문 글쓰기</legend>
						
						<table class="table">
							<caption>자주묻는 질문 글쓰기</caption>
							<colgroup>
								<col width="15%">
								<col width="35">
								<col width="15">
							</colgroup>
							
							<tr>
								<th><label for="title">질문 제목</label></th>
								<td colspan="3"><input type="text" name="t_question" id="title" class="title" placeholder="제목을 입력해주세요"></td>
							</tr>
							
							<tr>
								<th><label for="cont">답  변</label></th>
								<td colspan="3"><textarea type="cont" name="t_answer" id="cont" class="cont" placeholder="내용을 입력해주세요"></textarea>
							</tr>
							
							<tr>
								<th>중요도</th>
								<td>
									<select name="t-prio" id="priority" >
										<option value="5">5단계</option>
										<option value="4">4단계</option>
										<option value="3">3단계</option>
										<option value="2">2단계</option>
										<option value="1">1단계</option>
									</select>
								</td>
							</tr>
							
							<tr>
								<td colspan="4">
								<input type="button" onclick="goSave()" value="저장" class="btn" >
								<input type="button" onclick="goList()" value="목록" class="btn">
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









    