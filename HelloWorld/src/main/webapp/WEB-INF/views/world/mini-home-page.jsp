<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

  
<style type="text/css">
.tap_button{
   width : 70px;
   height: 40px;
   color: white;
   float:left;
   position: relative;
   border-top-right-radius: 5px;
   border-bottom-right-radius:5px;
   border-top: 1px solid grey;
   border-bottom: 1px solid grey;
   border-right: 1px solid grey;
   margin-bottom: 1px;
}

.tap_button.on{
   width : 70px;
   height: 40px;
   background-color: white;
   color: black;
   float:left;
   position: relative;
   border-top-right-radius: 5px;
   border-bottom-right-radius:5px;
   border-top: 1px solid grey;
   border-bottom: 1px solid grey;
   border-right: 1px solid grey;
   margin-bottom: 1px;
   
}
.left_side_down.on{
	display: block;
}
.left_side_down{
	display: none;
}
.btnMngFolder{
	width: 190px;
	height:30px;
	font-size: 100%;
	border : 1px solid grey;
	background-color: white;
	border-radius:3px;
	margin: 0px 20px 0px auto;
	outline: 0px;
}

.lblVisitCnt{
	font-size: 50%;
	font-family: Verdana;
	color: #504E48;
}

.lblBoard{
	font-weight:bold;
	color:#50BCDF;
}

a{
	font-family: 'Open Sans';
	font-size: 90%;
}

#left_side{
	background-color: #f1f3f5;
	width : 220px;
	height: 565px;
	margin: 69px 60px;
	position: absolute;
	border-radius: 10px;
	
}

#left_side_upper{
	background-color: #f1f3f5;
	width : 215px;
	height: 45px;
	float: left;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	text-align:center;
	
}
#left_side_down{
	background-color: white;
	width : 210px;
	height: 505px;
	float: left;
	margin:5px;
	border:1px solid grey;
	border-radius: 7px;
}
#right_side{	
	
	width : 977px;
	height: 565px;
	margin: 69px 280px;
	position: absolute;
}
#right_side_upper{
	background-color: #f1f3f5;
	width: 837px;
	height: 45px;
	float: left;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
}
#right_side_down{
	width: 837px;
	background-color: #f1f3f5;
	float:left;
	height: 520px;
}
#ntBoardFolderList{
	float : left;
 	width : 189px; 
 	margin: 20px 8px;
 	margin-right: 25px;
 	background-color: white;
 	
}

#glBoardFolderList{
	float : left;
 	width : 189px; 
 	margin: 20px 8px;
 	margin-right: 25px;
 	background-color: white;
}

#drBoardFolderList{
  float : left;
  width : 189px; 
  margin: 20px 8px;
  margin-right: 25px;
  background-color: white;
  
}

#MngFolderList{
	float : left;
 	width : 189px; 
 	margin: 20px 8px;
 	margin-right: 25px;
 	background-color: white;
}

#minihome_content{
	width : 825px;
	height: 505px;
	float:left;
	border-radius: 7px;
	position: relative;
	background-color: white;
	margin: 5px;
	border:1px solid grey;

}
#btnWrapper{
	width : 100px;
	height: 515px;
	text-align: center;
	background-color:transparent;
	float: left;
}
#btnEdit {
	font-size: 50%;
	font-family: Verdana;
	color : black;
    margin-left: 14px; 
}
#btnImg{
  font-size: 50%;
  font-family: Verdana;
  color : black;
}
#btnTitleUpdate{
	background: grey;
	border:none;
	border-radius:2px;
	float: right;
	color:white;
	margin-top: 5px;
}
#homepageReload{
	width: 190px;
	height:30px;
	font-size: 100%;
	border : 1px solid grey;
	background-color: white;
	border-radius:3px;
	margin: 0px 20px 0px auto;
}
#visitWrapper{
	width: 220px;
	height: 10px;
	text-align: center;
	margin-top: 30px;
}
#titleWrapper{
	width: 500px;
	margin : 20px 25px 10px 10px;
	float: left;
}

#profilePhotoWrapper{
	width :141px;
	height: 200px;
	margin:30px auto 5px;
	border: 0 ;
}

#profileWrapper{
	width : 170px;
	height: 150px;
	margin: 10px 20px 10px 20px;
	font-size:120%;
	float:left;
	color : grey;
	position: relative;
    
}

#wavingWrapper{
	width : 170px;
	height: 50px;
	border-top: 1px solid grey;
	float: left;
	margin: 0px 20px;
	padding-top: 10px;
}

#todayCnt{
	color :red;
}
#aTitle{
	font-size: 115%;
	font-weight: bold;
	
}

#lblHomeName{
	font-size: 110%;
	color: #4582b4;
	font-weight: bold;
	
}

#selectFrd{
	width: 167px;
	height: 20px;
	marker-top:10px;
}
body{
	background-repeat: no-repeat;
	background-size: 1200px 720px;
    overflow: hidden;
}
ol {
  list-style : none;
  padding-inline-start: 10px;
  
}
ol li{
	background: url("${pageContext.request.contextPath}/resources/images/folder2.png") left center no-repeat;
	list-style-position : inside;
	padding-left: 20px;
	
}

.btnMngFolder:hover{
	background-color: #504E48;
 	color: white;
}
 #homepageReload:hover{
 	background-color: #504E48;
 	color: white;
 }
 #btnEdit:hover{cursor: pointer;}
 #btnImg:hover{cursor: pointer;}
 button:hover{cursor: pointer;}
 a:link {text-decoration: none; color: #333333;}
 a:visited {text-decoration: none; color: #333333;}
 a:active {text-decoration: none; color: #333333;}
 a:hover {text-decoration: underline; color: black;}
 *:focus { outline:none; }
iframe {
	border:none;
}
#mainImg {
  transform: translate(-12%);
  }
  
input[type="date"]::-webkit-calendar-picker-indicator, input[type="date"]::-webkit-inner-spin-button
  {
  display: none;
  appearance: none;
}

.ui-datepicker-trigger {
  cursor: pointer;
}

.ui-datepicker-calendar>tbody td.ui-datepicker-week-end:first-child a {
  color: red;
}

.ui-datepicker-calendar>tbody td.ui-datepicker-week-end:last-child a {
  color: blue;
} 

 
  
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
  href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<meta charset="UTF-8">
<title>미니홈피</title>
</head>

<c:if test="${mainformVO.theme == 'default' }">
<body style="background-image: url('${pageContext.request.contextPath}/resources/images/defaultbackground.jpg');">
</c:if>
<c:if test="${mainformVO.theme == 'spring' }">
<body style="background-image: url('${pageContext.request.contextPath}/resources/images/springbackground.jpg');">
</c:if>
<c:if test="${mainformVO.theme == 'summer' }">
<body style="background-image: url('${pageContext.request.contextPath}/resources/images/summerbackground.jpg');">
</c:if>
<c:if test="${mainformVO.theme == 'fall' }">
<body style="background-image: url('${pageContext.request.contextPath}/resources/images/fallbackground.jpg');">
</c:if>
<c:if test="${mainformVO.theme == 'winter' }">
<body style="background-image: url('${pageContext.request.contextPath}/resources/images/winterbackground.jpg');">
</c:if>
	<div id = "left_side">
		<div id = "left_side_upper">
			<div id = "visitWrapper">
			<label class = "lblVisitCnt">TODAY </label><a id = "todayCnt">&nbsp;${mainformVO.today_cnt }&nbsp;</a> 
			<label class = "lblVisitCnt">|&nbsp;&nbsp;TOTAL </label><a>&nbsp;${mainformVO.total_cnt }</a>
			</div>
		</div>
		<div id = "left_side_down">
		  <div class = "left_side_down on" id = "main_left_side">
			<div id = "profilePhotoWrapper">
            
             <c:if test = "${mainformVO.profile_photo != null }"> 
                <img id = "mainImg" src = "display?fileName=${mainformVO.profile_photo}" style = "width :180px; height: 200px;" >
              </c:if>
               
			</div>
              
			<div id = "profileWrapper" style = "overflow-y: auto; white-space: normal;">
		    <pre >${mainformVO.profile_content }</pre>
			<div style="position: absolute; bottom: 0px;">
      
			</div>
			</div>
      
			<c:if test="${homeId == loginId }">
			<a id = "btnEdit">▶EDIT</a> <a id = "btnImg">▶PHOTO</a> 
			</c:if>
			<div id = "wavingWrapper">
				<label id = "lblHomeName">${homeName }</label> 
                <c:if test = "${memberVO.user_gender == 'W' }">
                (<img src = "${pageContext.request.contextPath}/resources/images/woman.PNG" width = "15px;"height="15px;">)
                </c:if>
                <c:if test = "${memberVO.user_gender == 'M' }">
                (<img src = "${pageContext.request.contextPath}/resources/images/man.PNG" width = "15px;"height="15px;">)
                </c:if>
                <label style = "font-size: 12px; color: black"> ${memberVO.user_birth } </label>
                 <br><br>
				<select id = "selectFrd">
               <option>파도타기</option>
               <c:forEach var="frVO" items="${frList }">
					<option value = ${frVO.fr_id }>${frVO.fr_user_name }(${frVO.nickname })</option>
			   </c:forEach>
               </select>
        
                
			</div>
		
		  </div>
		
		
		 <div class = "left_side_down" id = "ntBoardFolderList" ><!-- board-folderList -->
		 	<label class = "lblBoard">FREE BOARD</label>
			<hr>
 			<a href = "">전체보기</a><br>
 			<c:forEach var = "folder" items="${ntFolderList }">
 		 	 <ol>
 				<li><a href = "${folder }">${folder }</a>
 		 	 </ol>
 			</c:forEach>
 			<form id = "selectByFolder" style="display: none;">
 				<input type = "text" name = "userid" value = "test">
 				<input type = "text" name = "folder">
 			</form>	
 	
 			<c:if test="${loginId == homeId }">
 			<button class = "btnMngFolder" onclick = "NTFmanager('${homeId}')">폴더 관리하기</button>
 			</c:if>
 		 </div>
 		 
 		  <div class = "left_side_down" id = "glBoardFolderList" ><!-- board-folderList -->
		 	<label class = "lblBoard">PHOTO ALBUM</label>
			<hr>
 			<a href = "">전체보기</a><br>
 			<c:forEach var = "folder" items="${glFolderList }">
 		 	 <ol>
 				<li><a href = "${folder }">${folder }</a>
 		 	 </ol>
 			</c:forEach>
 			<form id = "selectByFolder" style="display: none;">
 				<input type = "text" name = "userid" value = "test">
 				<input type = "text" name = "folder">
 			</form>	
 	
 			<c:if test="${loginId == homeId }">
 			<button class = "btnMngFolder" onclick = "GLFmanager('${homeId}')">폴더 관리하기</button>
 			</c:if>
 		 </div>
     <!-- ============================================== -->
     
          <div class = "left_side_down" id = "drBoardFolderList" >
             <label class = "lblBoard">DIARY</label>
             
             <hr>
                <div id="datepicker"></div>
                <form id="pickDate" style="display: none">
                  <input type="hidden" id="sendDate" name="d_date">
                </form>
             
             
               <a href = "">전체보기</a><br>
               <c:forEach var = "folder" items="${drFolderList }">
                 <ol>
                  <li><a href = "${folder }">${folder }</a>
                  </ol>
                </c:forEach>
            <form id = "selectByFolder" style="display: none;">
              <input type = "text" name = "userid" value = "test">
              <input type = "text" name = "folder">
            </form> 
  
            <c:if test="${loginId == homeId }">
              <button class = "btnMngFolder" onclick = "DRFmanager('${homeId}')">폴더 관리하기</button>
            </c:if>
         </div>
     
     
 		 
 		 <div class = "left_side_down" id = "MngFolderList" ><!-- board-folderList -->
		 	<label class = "lblBoard">폴더 편집하기</label>
			<hr>		
 		 	 <ol>
 				<li><a href = "#" onclick="DRFmanager('${homeId}')">다이어리</a>
 				<li><a href = "#" onclick="NTFmanager('${homeId}')">게시판</a>
 				<li><a href = "#" onclick="GLFmanager('${homeId}')">사진첩</a>		
 		 	 </ol>	
 		 	 
 		 	 <button id = "homepageReload">홈으로</button>
 		 </div>
 		 
		</div>
	</div>


	<!-- right_side -->
	<div id = "right_side"> 
	  <div id = "right_side_upper">
	  	<div id = "titleWrapper">
	  		<a id = "aTitle">${mainformVO.main_title }</a>
	  		<c:if test="${homeId == loginId }">
	  		 <button id = "btnTitleUpdate">수정</button>
	  		 </c:if>
	  	</div>
	  	
	  </div>
	  <div id = "right_side_down">
		<iframe id = "minihome_content" src = "/helloworld/frcboard/frcList">
		</iframe>
	  </div>	
		<div id = "btnWrapper">
         <button class = "tap_button on" id = "home">홈</button>
         <c:forEach var="menuVO" items="${menuList }">
         <c:if test="${menuVO == 'diary' }">
         	<button class = "tap_button" id = "dr">다이어리</button>
         </c:if>
         <c:if test="${menuVO == 'notice' }">
         	<button class = "tap_button" id = "nt">게시판</button>
         </c:if>
         <c:if test="${menuVO == 'photo' }">
         	<button class = "tap_button" id = "gl">사진첩</button>
         </c:if>
         <c:if test="${menuVO == 'guest' }">
         	<button class = "tap_button" id = "gb">방명록</button>
         </c:if>
         </c:forEach>
      </div>
	</div>

<script type="text/javascript">

	function NTFmanager(homeId){
		$('#minihome_content').attr('src', "/helloworld/ntBoard/managingFolder");
		$('.tap_button').css('display', 'none');
	}
	
	function GLFmanager(homeId){
		$('#minihome_content').attr('src', "/helloworld/gallery/managingFolder");
		$('.tap_button').css('display', 'none');
	}
	function DRFmanager(homeId){
		$('#minihome_content').attr('src', "/helloworld/diaryboard/managingFolder");
		$('.tap_button').css('display', 'none');
	}

	$(document).ready(function(){
		
	  var theme = '${mainformVO.theme}';
	   if(theme == 'default'){
		   $(".tap_button").css('background-color', '#4582b4');
	   }else if(theme == "spring"){
		   $(".tap_button").css('background-color', '#ff9999');
	   }else if(theme == "summer"){
		   $(".tap_button").css('background-color', '#1034a6');
	   }else if(theme == "fall"){
		   $(".tap_button").css('background-color', '#ff7f00');
	   }else if(theme == "winter"){
		   $(".tap_button").css('background-color', '#5f5f5f');
	   }
	   $(".tap_button.on").css('background-color', 'white');	
	  
	  
		$('#home').click(function(){
			$('.tap_button.on').removeClass('on');
			$(this).addClass('on');
			$('.left_side_down.on').removeClass('on');
			$('#main_left_side').addClass('on');
			$('#minihome_content').attr('src', "/helloworld/frcboard/frcList");
		  	if(theme == 'default'){
			   $(".tap_button").css('background-color', '#4582b4');
		   	}else if(theme == "spring"){
			   $(".tap_button").css('background-color', '#ff9999');
		   	}else if(theme == "summer"){
			   $(".tap_button").css('background-color', '#1034a6');
		   	}else if(theme == "fall"){
			   $(".tap_button").css('background-color', '#ff7f00');
		   	}else if(theme == "winter"){
			   $(".tap_button").css('background-color', '#5f5f5f');
		   	}
		   	$(".tap_button.on").css('background-color', 'white');	
		});
		// 다이어리 
		$('#dr').click(function(){
			$('.tap_button.on').removeClass('on');
			$(this).addClass('on');
			$('.left_side_down.on').removeClass('on');
			$('#drBoardFolderList').addClass('on');
			$('#minihome_content').attr('src', "/helloworld/diaryboard/diarylist");
		  	if(theme == 'default'){
			   $(".tap_button").css('background-color', '#4582b4');
		   	}else if(theme == "spring"){
			   $(".tap_button").css('background-color', '#ff9999');
		   	}else if(theme == "summer"){
			   $(".tap_button").css('background-color', '#1034a6');
		   	}else if(theme == "fall"){
			   $(".tap_button").css('background-color', '#ff7f00');
		   	}else if(theme == "winter"){
			   $(".tap_button").css('background-color', '#5f5f5f');
		  	}
		   	$(".tap_button.on").css('background-color', 'white');	
		});
		
		$('#nt').click(function(){
			$('.tap_button.on').removeClass('on');
			$(this).addClass('on');
			$('.left_side_down.on').removeClass('on');
			$('#ntBoardFolderList').addClass('on');
			$('#minihome_content').attr('src', "/helloworld/ntBoard/ntList");
		  	if(theme == 'default'){
			   $(".tap_button").css('background-color', '#4582b4');
		   	}else if(theme == "spring"){
			   $(".tap_button").css('background-color', '#ff9999');
		   	}else if(theme == "summer"){
			   $(".tap_button").css('background-color', '#1034a6');
		   	}else if(theme == "fall"){
			   $(".tap_button").css('background-color', '#ff7f00');
		   	}else if(theme == "winter"){
			   $(".tap_button").css('background-color', '#5f5f5f');
		   	}
		   	$(".tap_button.on").css('background-color', 'white');	
						
		});
		
		$('#gl').click(function(){
			$('.tap_button.on').removeClass('on');
			$(this).addClass('on');
			$('.left_side_down.on').removeClass('on');
			$('#glBoardFolderList').addClass('on');
			$('#minihome_content').attr('src', "/helloworld/gallery/list");
		  	if(theme == 'default'){
			   $(".tap_button").css('background-color', '#4582b4');
		   	}else if(theme == "spring"){
			   $(".tap_button").css('background-color', '#ff9999');
		   	}else if(theme == "summer"){
			   $(".tap_button").css('background-color', '#1034a6');
		   	}else if(theme == "fall"){
			   $(".tap_button").css('background-color', '#ff7f00');
		   	}else if(theme == "winter"){
			   $(".tap_button").css('background-color', '#5f5f5f');
		   	}
		   	$(".tap_button.on").css('background-color', 'white');	
						
		});
		
		$('#gb').click(function(){
			$('.tap_button.on').removeClass('on');
			$(this).addClass('on');
			$('.left_side_down.on').removeClass('on');
			$('#main_left_side').addClass('on');
			$('#minihome_content').attr('src', "/helloworld/world/gBoard");
		  	if(theme == 'default'){
			   $(".tap_button").css('background-color', '#4582b4');
		   	}else if(theme == "spring"){
			   $(".tap_button").css('background-color', '#ff9999');
		   	}else if(theme == "summer"){
			   $(".tap_button").css('background-color', '#1034a6');
		   	}else if(theme == "fall"){
			   $(".tap_button").css('background-color', '#ff7f00');
		   	}else if(theme == "winter"){
			   $(".tap_button").css('background-color', '#5f5f5f');
		   	}
		   	$(".tap_button.on").css('background-color', 'white');	
						
		});
		
		$('.btnMngFolder').click(function(){
			$('.left_side_down.on').removeClass('on');
			$('#MngFolderList').addClass('on');
			
		});
		
		$('#ntBoardFolderList a').click(function(){
  			event.preventDefault();
  			var folder = $(this).attr("href");
  			$('#minihome_content').attr('src', "/helloworld/ntBoard/ntList?folder="+folder);
  			
  		});
		
		$('#glBoardFolderList a').click(function(){
  			event.preventDefault();
  			var folder = $(this).attr("href");
  			$('#minihome_content').attr('src', "/helloworld/gallery/list?folder_name="+folder);
  			
  		});
		
		$('#drBoardFolderList a').click(function(){
			event.preventDefault();
			var folder = $(this).attr("href");
			$('#minihome_content').attr('src', "/helloworld/diaryboard/diarylist?folder_name="+folder);
			
		});
		
		$('#homepageReload').click(function(){
			location.reload();
		});
		
		$('#btnTitleUpdate').click(function(){
			window.open('titleUpdate', 'child', 'width=429px, height=230px');
		});
		
		$('#btnEdit').click(function(){
			window.open('profileUpdate', 'child', 'width=330px, height=390px');		
		});
		
		$('#btnImg').click(function(){
			window.open('photoUpdate', 'child', 'width=330px, height=390px');		
		});
		
	    $("#selectFrd").change(function(){
  	    var userid = $(this).val();
  	    console.log('ets' + userid);
  	    if(userid == ''){
  		  return;
  	    }
  	    location.href = "mini-home-page?homeId=" + userid;
        });
	
		
	    
      // datepicker 동작 부분
			$("#datepicker").datepicker({
			  firstDay : 0,
			  showMonthAfterYear: true,
			  yearSuffix: "년",
			  monthNames: [ "1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월" ],
			  dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
			  showOn: 'button',
  			  dateFormat: 'yy-mm-dd',
			  onSelect : function(dateText, inst){
			  var pickDate = dateText; // 현재 선택한 날짜
			  console.log(pickDate);
			
        	  var pd = $('#pickDate'); // form의 정보를 pd에 저장
      	      var sendDate = $('#sendDate'); // 값을 보내줄 input 의 id (sendDate) 로 변수 만들어줌
      	     
      	      $('#minihome_content').attr('src', "/helloworld/diaryboard/diarylist?d_date="+pickDate);
		
			} // end onSelect
			
			}); // end $("#datepicker") 
			
			$("#datepicker").css({"font-size":"11px","width":"200px"});
	    
	    
		
	});





</script>


</body>
</html>