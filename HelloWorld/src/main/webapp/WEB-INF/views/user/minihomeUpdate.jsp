<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">

.imgThemeWrap{
	width: 180px;
	height: 150px;
	float: left;
	margin: 10px 10px;
}

.classTheme{
	width : 170px;
}
#btnThemeWrap{
	width: 100%;
	float: left;
}
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

#pMenu{
	font-size: 95%;
	color : #4582b4;
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
</style>

<meta charset="UTF-8">
<title>개인정보수정::Helloworld</title>
<%@ include file="/resources/import/subheader.jspf"%>
</head>
<body>




	<div id="content" style="margin: auto;">
		<h2>미니홈피 설정</h2>
		<div id="usercontent">
			<p>
				<strong>${loginId }</strong>님의 미니홈피 정보입니다.<br> 
				회원님의 미니홈피를 마음껏 꾸며보세요
			</p>
		</div>
		<table>
			<tbody>
				<tr>
					<th>스킨설정</th>
					<td><div>
							<strong>현재 스킨</strong><Br>
							
							<img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/${mainformVO.theme }background.jpg'><br>
							<div style="width: 100%; float: left;">
							<p style="font-size: 80%;float: left;">변경할 스킨을 선택해주세요</p>
							</div>
							<br>
							<div class = imgThemeWrap>
							 <div style="width: 100%; float: left;">
							  <input type="radio" name = "theme" checked="checked" value = "default">기본
							 </div>
							  <img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/defaultbackground.jpg'>
							</div>
							<div class = imgThemeWrap>
							  <div style="width: 100%; float: left;">
								<input type="radio" name = "theme" value = "spring">봄 
							  </div>
							   <img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/springbackground.jpg'>
							</div>  
							<div class = imgThemeWrap>
							  <div style="width: 100%; float: left;">
								<input type="radio" name = "theme" value = "summer">여름	
							  </div>
							   <img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/summerbackground.jpg'>
							</div>  
							<div class = imgThemeWrap>
							  <div style="width: 100%; float: left;">
								<input type="radio" name = "theme" value = "fall">가을
							  </div>
							   <img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/fallbackground.jpg'>
							</div>  
							
							<div class = imgThemeWrap>
							  <div style="width: 100%; float: left;">
								<input type="radio" name = "theme" value = "winter">겨울
							  </div>
							   <img class = "classTheme" src = '${pageContext.request.contextPath}/resources/images/winterbackground.jpg'>
							</div>
							<br><br>
						</div>
						<br>
						<div id = "btnThemeWrap">
						<button id = "btnUpdateTheme">수정</button>
						</div>
						</td>
				</tr>
				<tr>
					<th>메뉴설정</th>
					<td><strong>현재 사용중인 메뉴</strong>
						
						<p id = "pMenu">${mainformVO.tap_menu }</p>
						<hr>

						<div id="menuChangeWrapper">
						<strong>변경할 메뉴</strong><br>
						<p style="font-size: 80%;">회원님이 사용할 메뉴를 자유롭게 설정할 수 있습니다.</p>
							<input id = tap_menu type="checkbox" name = "menu" value = "diary">다이어리
							<input id = tap_menu type="checkbox" name = "menu" value = "notice">게시판
							<input id = tap_menu type="checkbox" name = "menu" value = "photo">사진첩
							<input id = tap_menu type="checkbox" name = "menu" value = "guest">방명록
							
						<button id = "btnUpdateTap">수정</button>	
							
						</div></td>
				</tr>
				
			</tbody>




		</table>


	</div>
	<script type="text/javascript">
	$(document).ready(function(){
		
		
		$("#btnUpdateTap").click(function() {
			var menu = "";
			$("input[name=menu]:checked").each(function() {				
				menu = menu + $(this).val() + ",";			
			});
			
			if(menu==""){
				alert('최소 한개 이상의 메뉴가 선택되어야 합니다.');
				return;
			}
			
			$.ajax({
	              type : 'put',
	              url : '/helloworld/worldRest/tapMenu',
	              headers : {
	                 'Content-Type' : 'application/json',
	                 'X-HTTP-Method-Override' : 'PUT'
	               },
	               data : JSON.stringify({
	                'tap_menu' : menu
	              }),
	              success : function(result){
	                if(result == 1){
	                  alert('수정성공');
	                  location.href = "mypage";
	                
	                } // end if()
	              }// end success()
	              
	            }); // end ajax()

		}); //end btnUpdateTap
		
		$("#btnUpdateTheme").click(function() {
			
			  var theme = $("input:radio[name=theme]:checked").val();

				console.log(theme);
			
				$.ajax({
		              type : 'put',
		              url : '/helloworld/worldRest/theme',
		              headers : {
		                 'Content-Type' : 'application/json',
		                 'X-HTTP-Method-Override' : 'PUT'
		               },
		               data : JSON.stringify({
		                'theme' : theme
		              }),
		              success : function(result){
		                if(result == 1){
		                  alert('수정성공');
		                  location.href = "mypage";
		                
		                } // end if()
		              }// end success()
		              
		            }); // end ajax()

		}); //end btnUpdateTap
		
		
		
		
	});
		
	
	</script>

</body>
</html>