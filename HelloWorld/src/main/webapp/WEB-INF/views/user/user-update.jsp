<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
#content {
	width: 800px;
	height: 100%;
	margin: 30px auto;
	text-align: center;
}

#usercontent {
	font-size: 14px;
	align-content: left;
	line-height: 19px;
	padding-top: 10px;
	letter-spacing: -1px;
	color: #666;
}

#usercontent strong {
	font-size: 14px;
	color: green;
}

th, td {
	
	padding: 20px;
	border-collapse: collapse;
	border-bottom: 1px solid grey;
	
}
table{
	width:100%;
	border:1px solid grey;
	border-collapse: collapse;
}

th {
	width: 100px;
}

td {
	text-align: left;
}
html, body{
	height: 100%;
}
.img_wrap img {
  width: 100px;
  height: 120px;
  border: 1px solid grey;
}
</style>

<meta charset="UTF-8">
<title>개인정보수정::Helloworld</title>
<%@ include file="/resources/import/subheader.jspf"%>
</head>
<body>




	<div id="content" style="margin: auto;">
		<h2>개인정보 수정</h2>
		<div id="usercontent">
			<p>
				<strong>${loginId }</strong>님의 연락처 정보입니다.<br> 회원정보는 개인정보처리방침에
				따라 안전하게 보호되며, 회원님의 명백한 동의 없이 공개 또는 제 3자에게 제공되지 않습니다. 
			</p>
		</div>
		<table>
			<tbody>
              <tr>

          <th>프로필 사진</th>
          <td>
            <p style="font-size: 80%;">회원님을 대표할 사진을 선택할 수 있습니다.다른 친구들에게 자신을 알릴 사진을 선택해주세요.</p>
            
            <div class="img_wrap">
              <img id="preview" src ="displayFile?fileName=/${user.user_photo }" >
           </div>
            
            <form id = "frm"  enctype="multipart/form-data">
               <div style = "width : 100%; float : left;">
               <input type="file" name ="file" id="file" onchange='chk_file_type(this)'>
               </div>
              
               <input type ="button" id="btnUpdate" value = "수정" style = " display: none; float:left;">
               
            </form>
            

            </td>
           </tr>
      
      
				<tr>

					<th>휴대전화</th>
					<td><strong>${user.user_phone }</strong>
						<p style="font-size: 80%;">아이디, 비밀번호 찾기 등 본인확인이 필요한 경우 또는 유료 결제 등 알림을 받을 때 사용할
							휴대전화입니다.</p>
						<button id="phoen_update_btn">수정</button>

						<div id="user_phoen_update_div" style="display: none;">
							<p>변결할 휴대전화</p>
							<input type="text" id="change_phoen">
							<button id="phoen_update_cancel">수정취소</button>
							<button id="update_phoen_insert">수정완료</button>
						</div></td>
				</tr>
        
				<tr>
					<th style="width: 145px;">비밀번호 변경</th>

					<td>
						<div>
						<p style="font-size:80%">다른 아이디/사이트에서 사용한 적 없는 비밀번호<br>			
							이전에 사용한 적 없는 비밀번호가 안전합니다.</p>
							<strong>현재비밀번호</strong><br><input type="password" id="user_password_ck">
							<button id="pw_update_btn">확인</button>
							<input id="user_password" hidden="hidden"
								value="${user.password }">

							<p id="userpwtxt"></p>
						</div>
						<div id="user_pw_update_div" style="display: none;">
							<p id="pwtxt"></p>
							<input type="password" id="change_pw">
							<button id="pw_update_cancel">수정취소</button>
							<button id="update_password_insert">수정완료</button>

						</div>
					</td>
				</tr>

				<tr>
					<th>이메일 수정</th>
					
					<td><a>현재 이메일<br><br></a><strong>${user.user_email }</strong>
						<button id="email_update_btn">수정</button>

						<div id="user_email_update_div" style="display: none">
							<p id="emailtxt"></p>
							<input id="change_email" type="text">
							<button id="email_update_cancel">수정취소</button>
							<button id="update_email_insert">수정완료</button>
						</div></td>
				</tr>
			</tbody>




		</table>


	</div>
	<script type="text/javascript">
	
	function chk_file_type(obj) {

    var file_kind = obj.value.lastIndexOf('.');

    var file_name = obj.value.substring(file_kind + 1, obj.length);

    var file_type = file_name.toLowerCase();

    var check_file_type = new Array();

    check_file_type = [ 'jpg', 'gif', 'png', 'jpeg', 'bmp', 'tif' ];

    var file = document.querySelector('#file');

    if (check_file_type.indexOf(file_type) == -1) {

      alert('이미지 파일만 업로드 가능합니다');

      var parent_Obj = obj.parentNode;

      var node = parent_Obj.replaceChild(obj.cloneNode(true), obj);

      document.getElementById("file").value = ""; //초기화를 위한 추가 코드

      document.getElementById("file").select(); //초기화를 위한 추가 코드

      return false;

    } else {
      //else 파일 미리보기 실행 .
      var fileList = file.files;

      // 읽기
      var reader = new FileReader();
      reader.readAsDataURL(fileList[0]);

      //로드 한 후
      reader.onload = function() {
        document.querySelector('#preview').src = reader.result;
        
      }
      var check_on_off = document.getElementById('btnUpdate');
        check_on_off.style.display = 'block';

    }
	}
    
	$(document).ready(function(){
	  
	  $('#btnUpdate').click(function() {
	    var form = $('#frm');
 			var formData = new FormData(form[0]);
 			
		 $.ajax({
			type : 'post',
			url : '/helloworld/find/uploadAjax',
			data : formData,
			processData : false,
			contentType : false,
			success : function(data) {
			    alert('사진 수정이 완료되었습니다.');
			    var check_on_off = document.getElementById('btnUpdate');
	        	check_on_off.style.display = 'none';
			}
		});
 	 });
	  
		var password1RegExp = /(?=.*\d{1,50})(?=.*[~`!@#$%\^&*()-+=]{1,50})(?=.*[a-zA-Z]{2,50}).{8,50}$/;// 비밀번호 유효성 검사
		 var emailRegExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; //  이메일 유효성 검사 
		  // ---------------------phoen start
		  $('#phoen_update_btn').click(function(){
			  console.log("클릭");
			  
			  $("#phoen_update_btn").css("display", "none");
			  $("#user_phoen_update_div").css("display", "block");
			  //block , none
		  });
	
		  $('#phoen_update_cancel').click(function(){
			  console.log("핸드폰 번호 변경 취소 ");
			  
			  $("#phoen_update_btn").css("display", "block");
			  $("#user_phoen_update_div").css("display", "none");
			  //block , none
		  });
		  
		 
		  $('#update_phoen_insert').click(function(){
			  console.log("변경버튼  ");
			  var phoen = $("#change_phoen").val();
			 location = '/helloworld/user/update-phoen?phoen='+phoen ;
			 alert('전화번호 변경 성공')		
			 
		  });
		  //-------------------------phoen end 
		  
		  //-------------------------password start
		  $('#pw_update_btn').click(function(){
			  
			  var password = $("#user_password").val(); 
			  var password_ck= $("#user_password_ck").val(); 
			  console.log(password);
			  console.log(password_ck);
			  if (password == password_ck){
				  $("#pw_update_btn").css("display","none");
				  $("#user_pw_update_div").css("display","block");
				
				    userpwtxt.innerHTML = '';
			  }else{
				 	 userpwtxt.style.color = 'red';
				    userpwtxt.innerHTML = '일치하지 않습니다.';
			  }
			  //block , none
			  
			  $('#update_password_insert').click(function(){
				  
				  
				  console.log("변경버튼  ");
				  var password = $("#change_pw").val();
			
				 
				 if(password == ""){
						pwtxt.style.color = 'red';
					    pwtxt.innerHTML = '필수 정보입니다.';
					} else if (password.length <8 || password.length >17){
						pwtxt.style.color = 'red';
						pwtxt.innerHTML = '비밀번호는 8~16자로 제한합니다' ;
				   }else if (!password1RegExp.test(password)) {
					  	pwtxt.style.color = 'red';
				       	pwtxt.innerHTML = '8~16자 영문 , 숫자, 특수문자를 사용하세요.';
				      } else {
				        pwtxt.style.color = '#53C14B';
				        pwtxt.innerHTML = '사용 가능한 비밀번호';
						location = '/helloworld/user/update-password?password='+password ;
						alert('비밀번호 변경 성공')		
				      }
			  });
		  });
		 
		  $('#pw_update_cancel').click(function(){
			  $("#pw_update_btn").css("display", "block");
			  $("#user_pw_update_div").css("display", "none");
		  });
		  //--------------------------------password end
		  //--------------------------------email start
		 $('#email_update_btn').click(function(){
			  $("#email_update_btn").css("display", "none");
			  $("#user_email_update_div").css("display", "block");
		  });
		  
		  $('#email_update_cancel').click(function(){
			  $("#email_update_btn").css("display", "block");
			  $("#user_email_update_div").css("display", "none");
		  });
		  $('#update_email_insert').click(function(){
			  console.log("변경버튼  ");
			  var email = $("#change_email").val();
			
			 if(email == ""){
					emailtxt.style.color = 'red';
					emailtxt.innerHTML = '필수 정보입니다.';
					}else if(!emailRegExp.test(email)){
						emailtxt.style.color = 'red';
						emailtxt.innerHTML = '이메일 형식이 아닙니다';
					}else {
						emailtxt.style.color = 'green';
						emailtxt.innerHTML = 'pass';
						location = '/helloworld/user/update-email?emailn='+email ;
						alert('이메일 변경 성공')		
					}
			  
			 
		  });
		  //--------------------------------email end 
	});
	
	</script>

</body>
</html>