<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.img_wrap img {
	width: 100px;
	height: 120px;
	border: 1px solid grey;
	float: right;
}
.content{
float: left;
margin-left: 30px;

width: 70px;
height: auto;

}
.pp{
	font-size: 90%;
}
.content a {
float: left;


}

button:hover {
  cursor: pointer;
}
.userinfo a{
float: left;
}
#mainWrapper{
	height: 900px; 
	width: 700px; 	
	margin: 30px auto;
	padding-top: 30px;
}
#profileUpdateWrapper{
	float:left;
	
	height: 250px;
	width: 620px;
	padding: 20px;
	border: 3px solid #ff6f6b;
	border-radius: 5px;
	background-color: white;
}
#privateInfoWrapper{
	float:left;
	margin-top: 20px;
	height: 250px;
	width: 620px;
	padding: 20px;
	padding: 20px;
	border: 3px solid #ff6f6b;
	border-radius: 5px;
	background-color: white;
}

#minihomeUpdateWrapper{
  float:left;
  margin-top: 20px;
  height: 200px;
  width: 620px;
  
  padding: 10px 20px;
  border: 3px solid #ff6f6b;
  border-radius: 5px;
  background-color: white;
}

#profilePhotoDownWrap{
	width: 620px;
	float: left;
}
#privateDownWrap{
	width: 620px;
	float: left;
}

#profilebtn{
	margin-top: 20px;
	float: right;
	width: 200px;
	height: 40px;
	border-radius: 5px;
	background-color: #ff6f6b;
	color : white;
	border: none; 
}
#userupdatebtn{
	margin-top: 20px;
	float: right;
	width: 200px;
	height: 40px;
	border-radius: 5px;
	background-color: #ff6f6b;
	color : white;
	border: none; 
	}
 #minihomeupdatebtn{
  margin-top: 20px;
  float: right;
  width: 200px;
  height: 40px;
  border-radius: 5px;
  background-color: #ff6f6b;
  color : white;
  border: none; 
}

</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>마이 페이지</title>
</head>
<%@ include file="/resources/import/subheader.jspf"%>

<body>
	<div id="mainWrapper" >
  
		<div id = "privateInfoWrapper" >
	 		<div><h2>개인정보 변경</h2> <br>
	 		<p class = "pp">회원님의 정보를 수정할 수 있습니다.</p>
			<p class = "pp">프로필 사진, 이메일, 전화번호, 비밀번호 등을 이곳에서 변경하세요.</p>
	 		
	 		<div id = "privateDownWrap">
	 		<button id="userupdatebtn">수정 </button>
	 		</div>
	 		</div>
		</div>
	 
        <div id = "minihomeUpdateWrapper" >
         <div><h2>미니홈피 설정</h2> 
         <p class = "pp">회원님의 미니홈피 설정을 변경할 수 있습니다.</p>
          <p class = "pp">미니홈피 스킨, 사용할 메뉴 등 이곳에서 변경하세요.</p>
      
          <div id = "privateDownWrap">
           <button id="minihomeupdatebtn">수정 </button>
         </div>
       </div>
    </div>
   
	
	
	</div>


	
	<script type="text/javascript">
		$(document).ready(function() {

		
			$('#userupdatebtn').click(function() {// 로그아웃 버튼 클릭 
				location = '/helloworld/user/user-update';
			});
			
			$('#minihomeupdatebtn').click(function(){
				location = '/helloworld/user/minihomeUpdate';
			});
		});
	</script>

</body>


</html>