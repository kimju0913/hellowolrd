<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문 프로필 글귀 변경</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
	#mainWrapper{
		width: 294px;
		height: 349px;
		background: #4582b4;
		padding: 6px;
	}
	#innerWrapper{
		width: 260px;
		height: 320px;
		background: white;
		margin: 13px 13px;
		border-radius: 4px;
		padding: 5px;
		text-align: center;
	}
	
	#headWrapper{
		width: 250px;
		height: 30px;
		float: left;
	}
	#contentWrapper{
		width: 250px;
		height: 280px;
		float: left;
	}
	#buttonWrapper{
		width:100px;
		height: 25px;
		float: right;
		margin-top: 15px;
	}
	#inputProfile{
		width: 170px;
		height: 150px;
		resize: none;
	}
	button{
		border : 1px solid grey;
		background-color: white;
		border-radius:3px;
		width: 40px;
		height: 25px;
	}
	
	button:hover{
		background-color: #504E48;
 		color: white;
 		cursor: pointer;
 	}
	
</style>
</head>
<body>
<div id = "mainWrapper">
  <div id = "innerWrapper">
	<div id = "headWrapper">
		<h4>미니홈피 대문 프로필 글귀 변경</h4>
		
	</div>
	
	<div id = "contentWrapper">
	<br>
		<textarea id = "inputProfile">${vo.profile_content }</textarea>
		<br>
		<div id = "buttonWrapper">
			<input type = "button" id = "btnUpdate" value = "수정"> <input type = "button"id = "btnCancle" value = "취소">
		</div>
	</div>
  </div>	
</div>

<script type="text/javascript">

	$(document).ready(function(){
		
		$('#btnUpdate').click(function(){
			var profcontent = $('#inputProfile').val();
			
			if(profcontent.length > 50){
				alert("글자수가 너무 많습니다.");
				return;
			}
			
			$.ajax({
	              type : 'put',
	              url : '/helloworld/worldRest/profContent',
	              headers : {
	                 'Content-Type' : 'application/json',
	                 'X-HTTP-Method-Override' : 'put'
	               },
	               data : JSON.stringify({
	                'profile_content' : profcontent
	              }),
	              success : function(result){
	                if(result == 1){
	                  opener.location.reload();
		  			  window.close();
	                
	                } // end if()
	              }// end success()
	              
	            }); // end ajax()
			
		});
		
		$('#btnCancle').click(function(){
			window.close();
			
		});
		
		
		
	});
	
	

</script>
</body>
</html>