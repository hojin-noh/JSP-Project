<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/session_manager_check.jsp" %>
<%@ page import="dao.*,dto.*,common.*" %>
<%
	Notice_dao dao = new Notice_dao();
	String no = request.getParameter("t_no");
	Notice_dto dto = dao.getNoticeView(no);
%>
<%@ include file="/common/common_subpage_head.jsp"%>
<script type="text/javascript">
		function goUpdate(){
			if(!checkEmpty(noti.t_title, " 제목 입력~~~~~")) return;
			if(!checkEmpty(noti.t_content, " 내용 입력~~~~~")) return;
			if(!checkEmpty(noti.t_reg_date, " 수정날짜 입력~~~~~")) return;
			
			noti.method="post";
//			noti.action="db_notice.jsp";
			noti.action="db_notice_update_file.jsp";
			noti.submit();
		}
		
/*      첨부파일 용략, 확장자 검사            */
		var maxSize  = 1024 * 1024 * 2;    // 첨부용량 설정 (1024*1024 = 1MB)
		var msg = "첨부파일 사이즈는 2MB 이내로 등록 가능합니다.";
		
		var fileName = noti.t_attach.value;
		var pathFileName = fileName.lastIndexOf(".")+1;    //확장자 제외한 경로+파일명
		var extension = (fileName.substr(pathFileName)).toLowerCase();	//확장자명
		
		//파일명.확장자
		if(extension != "jpg" && extension != "gif" && extension != "png"){
			alert(extension +" 형식 파일은 업로드 안됩니다.이미지 파일만 가능!");
			return;
		}		
		
		//첨부 용량 체크		
		var file = noti.t_attach;
		if(file.value !=""){
			// 사이즈체크

			var fileSize = 0;

			// 브라우저 확인
			var browser=navigator.appName;
			// 익스플로러일 경우
			if (browser=="Microsoft Internet Explorer"){
				var oas = new ActiveXObject("Scripting.FileSystemObject");
				fileSize = oas.getFile(file.value).size;
			}else {
			// 익스플로러가 아닐경우
				fileSize = file.files[0].size;
			}

			if(fileSize > maxSize){
				alert(msg);
				return;
			}	
		}
/*      첨부파일 용략, 확장자 검사            */
</script>		
		<div id="b_left">
			<P>NOTICE & NEWS</P>
			<ul>
				<li><a href="/notice/notice_list.jsp"><span class="fnt"><i class="fas fa-apple-alt"></i></span> NOTICE</a></li>
				<li><a href="/news/news_list.jsp">NEWS</a></li>
				<li><a href="/qanda/qanda_list.jsp">Q & A</a></li>
				<li><a href="/freeboard/freeboard_list.jsp">FREE BOARD</a></li>
				<li><a href="/event/event_list.jsp">ETC</a></li>
			</ul>
		</div>
		
		<div id="b_right">
			<p class="n_title">
				NOTICE
			</p>
			
			<table class="boardForm">
				<colgroup>
					<col width="15%">
					<col width="35%">
					<col width="10%">
					<col width="40%">
				</colgroup>
				<form name="noti" enctype="multipart/form-data">
					<input type = "hidden" name="t_work_gubun" value="update">
					<input type = "hidden" name="t_no" value="<%=no%>">
				<tbody>
					<tr>
						<th>Title</th>
						<td colspan="3"><input type="text" name="t_title" class="input600" value="<%=dto.getTitle()%>"></td>
					</tr>	
					<tr>
						<th>Content</th>
						<td colspan="3"><textarea class="textArea_H250" name="t_content" value="<%=dto.getContent()%>"></textarea></td>
					</tr>	
					<tr>
						<th>Attach</th>
						<td colspan="3">
						<% if(dto.getAttach() != null){ %>
							<%=dto.getAttach() %> 
							삭제<input type="checkbox" name="t_del_attach" value="<%=dto.getAttach() %>" ><br>
						<%	} %>
							<input type="file" name="t_attach" class="input600">
							<input type="hidden" name="t_ori_attach" value="<%=CommonUtil.checkNull(dto.getAttach()) %>">
						</td>
					</tr>	
					<tr>
						<th>Writer</th>
						<td><%=session_name %>
							<input type="text" name="t_reg_name" value="<%=session_name %>" class="input100">
						</td>
						<th>RegDate</th>
						<td><input type="date" name="t_reg_date" value="<%=dto.getReg_date() %>" class="input130"></td>
					</tr>	

				</tbody>
			</form>
			</table>
			<div class="buttonGroup">
				
				<a href="javascript:goUpdate()" class="butt">Update</a>
				<a href="notice_list.jsp" class="butt">List</a>
			</div>	
		</div>	
		<%@ include file="/common/common_subpage_bottom.jsp" %>		
	</div>	
</body>
</html>






