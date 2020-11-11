<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common_head.jsp" %> 
<%@ page import="common.*"%> 
<style>
	.table{
		height:700px;
		width:700px;
	}
	.table_head{
		width:250px;
	}
	.btn{
		height:38px;
		width:70px;
		margin-left:5px;
	}
	#tell_1{width:40px;} 
	#tell_2{width:40px;}
	#tell_3{width:40px;}
	#id_box{width:300px;}
</style>

<script type="text/javascript">
//<![CDATA[
	$(document).ready(function(){
		$("#idCheck").click(function(){
			var id = mem.t_id.value;
			if(id == ""){
				alert(" ID 입력 후 검사! ");
				mem.t_id.focus();
				return;
			}
			
			$.ajax({
				type:"post",
				url:"/MemberIdCheck",
				data:"t_id="+id,
				dataType:"text",
				error:function(){
					alert(" 통신실패 ");
				},
				success:function(data){
					//alert(" 넘어온 값 : ==="+data+"====");
					$(".id_check_span").html(data);
					if($.trim(data) == "사용가능"){
						$(".id_check_span").css("color","blue");
						mem.id_check_gubun.value = id;
						mem.t_name.focus();
					} else{
						$(".id_check_span").css("color","red");						
						mem.id_check_gubun.value = "";
						mem.t_id.focus();
					}
				}
			});
			
		});	
	});
	
	function goRegister(){
		if(!checkEmpty(mem.id_check_gubun, "ID를 입력하시오. ")) return;
		if(!checkEmpty(mem.id_check_gubun, "ID 중복검사를 하시오. ")) return;
		if(mem.id_check_gubun.value != mem.t_id.value){
			alert(" 변경된 ID를 중복 검사 하시오. ");
			return;
		}
		
		if(!checkEmpty(mem.t_pw, "비밀번호 입력~~~~~")) return;
		if(!checkEmpty(mem.t_pw_confirm, "비밀번호 다시 입력~~~~~")) return;
		if(!checkEmpty(mem.t_name, "성명 입력~~~~~")) return;		
		if(!checkEmpty(mem.t_area, "지역 입력~~~~~")) return;
		if(!checkEmpty(mem.t_address, "주소 입력~~~~~")) return;
		if(!checkEmpty(mem.t_tel_1, "연락처 첫 세 자리 입력~~~~~")) return;
		if(!checkEmpty(mem.t_tel_2, "연락처 중간 네 자리 입력~~~~~")) return;
		if(!checkEmpty(mem.t_tel_3, "연락처 마지막 네 자리 입력~~~~~")) return;
		if(!checkEmpty(mem.t_mf, "성별 입력~~~~~")) return;
		if(!checkEmpty(mem.t_hobby_t|| mem.t_hobby_r || mem.t_hobby_s, "취미 입력~~~~~")) return;
		
		if(mem.t_pw.value != mem.t_pw_confirm.value){
			alert(" 비밀번호를 확인하세요. ");
			mem.t_pw_confirm.focus();
			return;
		}
		
		mem.method="post";
		mem.action="DBMemberJoin";
		mem.submit();
	}
	
</script>	

		<!--  header end -->
		
		<!-- sub page start -->
		<div class="notice">
			<div class="sub-notice">
			<h2><span><i class="fas fa-edit"></i> MEMBER-JOIN</span></h2>	
			</div>
			
			<div class="notice-write">
			
			<form name="mem">
				
					<fieldset>
						<legend>회원가입</legend>
						
						<table class="table">
							<colgroup>
								<col width="20%">
								<col width="*">
								<col width="20%">
								<col width="*">
								<col width="20%">
								<col width="*">
								<col width="20%">
								<col width="*">
								<col width="20%">
							</colgroup>
						
							<tr>
								<th class="table_head">ID</th>
								<td colspan="3">
									<input type="text" name="t_id" id="id_box" placeholder="영문자 대소문자, 숫자, 특수기호를 사용해서 만들어 주세요." autofocus>
									<input type="button" id="idCheck"  onclick="goCheck()" class="btn2" value="중복검사">
									<span class="id_check_span"></span>
									<input type="hidden" name="id_check_gubun">
								</td>
							</tr>
							<tr>
								<th>비밀번호</th>
								<td colspan="3"><input type="text" name="t_pw" id="id_pw"  placeholder=" 영문자는 대소문자에 주의해주세요. ">
							</tr>
							<tr>
								<th>비밀번호 확인</th>
								<td colspan="3"><input type="text" id="id_confirm_pw"placeholder=" 비밀번호를 다시 입력해주세요. ">
							</tr>
							<tr>
								<th>이름</th>
								<td colspan="3"><input type="text" name="t_name" id="name_phone" name_phone>
							</tr>
							<tr>
								<th>지역</th>
								<td colspan="3"><select name="t_area">
									<option value="01">서울</option>
									<option value="02">대전</option>
									<option value="03">부산</option>
									<option value="04">대구</option>
							</tr>
							<tr>
								<th>주소</th>
								<td colspan="3"><input type="text" name="t_address"placeholder="내용을 입력해주세요">
							</tr>
							<tr>
								<th>전화번호</th>
								<td colspan="3">
								<input type="text" name="t_tell_1" id="tell_1" value="010">-
								<input type="text" name="t_tell_2" id="tell_2" placeholder="1234">-
								<input type="text" name="t_tell_3" id="tell_3" placeholder="5678" >
							</tr>
							<tr>
								<th>성별</th>
								<td>
									<input type="radio" value="F" checked name="t_mf" > 여&nbsp;&nbsp;
									<input type="radio" value="M" checked name="t_mf" > 남
								</td>
							</tr>
							<tr>
								<th>취미</th>
								<td>
									<input type="checkbox" value="Y" name="t_bobby_t">여행&nbsp;&nbsp;
									<input type="checkbox" value="Y" name="t_bobby_r">독서&nbsp;&nbsp;
									<input type="checkbox" value="Y" name="t_bobby_s">운동;
								</td>
							</tr>
								<td colspan="4">
								<input type="button" onclick="goRegister()" value=" 회원가입하기 " class="btn" >
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









    