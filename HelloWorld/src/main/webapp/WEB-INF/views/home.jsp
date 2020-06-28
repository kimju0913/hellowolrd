<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>메인 페이지</title>
<style type="text/css">

.pb{
	font-size: 120%;
	font-weight: bold;
}

#mainpageMain{
	width: 500px;
	height: 100%;
	margin: 30px auto;
	
	text-align: center;
}
#headerWrapper{
	width : 80%;
	margin: 0px auto;
}
#logoWrapper{
	margin-top : 50px;
}
#btnMenuWrapper{
	width: 500px;
	height: 300px;
	margin-top: 40px;
	background-color: white;
	border-radius:20px;
	padding-top: 50px;
	border : 1px solid grey;
}
#btnGoHompie{
	border-style: none;
	background-color: white;
	
}

#btnFriends{
	border-style: none;
	margin-left: 60px;
	background-color: white;
}

#btnRcmFrd{
	border-style: none;
	margin-left: 60px;
	background-color: white;
}
#btnSearchFrd{
	border-style: none;
	background-color: white;
}
#btnCallCenter{
	border-style: none;
	margin-left: 60px;
	background-color: white;
}
#btnPrivacy{
	border-style: none;
	margin-left: 60px;
	background-color: white;
}
#btnAdmin{
  border-style: none;
  width : 76px;
  height:122px;
  margin-left: 60px;
  background-color: white;
}
#btnLogout{
	font-size: 150%;
	background-color: #ff6f6b;
	color :white;
	float : right;
	margin : 30px;
	border : 2px solid white;
	border-radius: 10px;
}
#pWelecomeMsg{
	font-size: 150%;
	color: white;
	margin-top : 30px;
	padding: 30px;
}
#logoInHeader{
	float: left;
	width: 90px;
	height: 90px;
}

body{
	height: 100%;
	background-color: #fafafa;
}
header{
  background-color: #ff6f6b;
  height: 90px;
  
}

button:hover {
	cursor: pointer;
}


</style>
<script src = "https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<%@ include file="/resources/import/mainheader.jspf" %>



<body>




<div id = "mainpageMain">
  <div id = "logoWrapper">
  	<img id = "imgheaderlogo" src="${pageContext.request.contextPath}/resources/images/logo3_big.png">
  </div>
  
  <c:if test = "${loginId == 'test' }">
    <h2>관리자 모드</h2>
  </c:if>
  
  <div id = "btnMenuWrapper">
  	<button id = "btnGoHompie"><img  src="${pageContext.request.contextPath}/resources/images/homeIcon.png"><br>
  	<p class = "pb">미니홈피</p>
  	</button>
  	
  	<button id = "btnFriends"><img  src="${pageContext.request.contextPath}/resources/images/friendIcon.png"><br>
  	<p class = "pb">일촌</p>
  	</button>
  	
  	<button id = "btnRcmFrd"><img  src="${pageContext.request.contextPath}/resources/images/shakehand.png"><br>
  	<p class = "pb">일촌신청 관리</p>
  	</button>
  	
  	<br><br><br>
  	
  	<button id = "btnSearchFrd"><img  src="${pageContext.request.contextPath}/resources/images/search_.png"><br>
  	<p class = "pb">사람 찾기</p>
  	</button>
  	
    <c:if test = "${loginId != 'test' }">
  	<button id = "btnCallCenter"><img  src="${pageContext.request.contextPath}/resources/images/callCenter.png"><br>
  	<p class = "pb">고객센터</p>
  	</button>
  	</c:if>
    
    <c:if test= "${loginId == 'test' }">
    <button id = "btnAdmin"><img  src="${pageContext.request.contextPath}/resources/images/admin.png"><br>
    <p class = "pb">관리자 페이지</p>
    </button>
    </c:if>
    
  	<button id = "btnPrivacy"><img  src="${pageContext.request.contextPath}/resources/images/locker.png"><br>
  	<p class = "pb">개인정보 관리</p>
  	</button>
  	
  </div>




</div>


<form id = "frmGoHompie" action = "/helloworld/ntBoard/ntList" method="get">
	<input type = "text" name = "homeId" value="test" hidden="hidden">
</form>




<script type="text/javascript">

	$(document).ready(function(){
	  
		var loginId='${loginId}'
		$('#btnGoHompie').click(function(){  //미니홈피 버튼 클릭 
			window.open('world/mini-home-page?homeId='+loginId , 'title', 'width=1200, height=720')
		});
		
		$('#logoWrapper').click(function() {//로고클릭 

			location = '/helloworld';

		}); // emd #logoWrapper click()
		$('.logout').click(function() {// 로그아웃 버튼 클릭 

			location = 'user/logout';

		}); // emd #btn_logout click()
		$('.login').click(function() {// 로그인 버튼 클릭 

			location = 'user/login';

		}); 
		$('#btnPrivacy').click(function() {// 마이페이지 버튼 클릭 

			location = 'user/mypage';

		}); 
		
		
		$('#btnRcmFrd').click(function(){
			location.href = "main/appliedFrd";
			
		});  
		
		$('#btnSearchFrd').click(function(){
			location.href = "main/searchFrd";
			
		});
		
		$('#btnFriends').click(function(){
			location.href = "main/managingFrd";
			
		});
		$('#btnCallCenter').click(function(){
			location.href = "main/main-center";
			
		});
		
		
		$('#btnAdmin').click(function(){
			location.href = "admin/admin-main";
			
		});
	
	});

</script>

</body>
</html>