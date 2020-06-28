<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문 글귀 수정</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
	#mainWrapper{
		width: 400px;
		height: 200px;
		background: #4582b4;
		padding: 6px;
	}
	#innerWrapper{
		width: 360px;
		height: 160px;
		background: white;
		margin: 13px 13px;
		border-radius: 4px;
		padding: 5px;
	}
	
	#headWrapper{
		width: 350px;
		height: 30px;
		float: left;
	}
	#contentWrapper{
		width: 350px;
		height: 140px;
		float: left;
	}
	#buttonWrapper{
		width:100px;
		height: 25px;
		float: right;
		margin-top: 15px;
	}
	#inputTitle{
		width: 330px;
		height: 20px;
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
		<h4>미니홈피 대문 글귀 변경</h4>
		
	</div>
	
	<div id = "contentWrapper">
	<br>
		<input type = "text" id = inputTitle value = "${vo.main_title }">
		<br>
		<div id = "buttonWrapper">
			<input type = "button" id = "btnUpdate" value = "수정"> 
            <input type = "button" id = "btnCancle" value = "취소">
		</div>
	</div>
  </div>	
</div>

<script type="text/javascript">

	$(document).ready(function(){
		
		$('#btnUpdate').click(function(){
			var title = $('#inputTitle').val();
			
			if(title.length > 30){
				alert("글자수가 너무 많습니다.");
				return;
			} else if(title.length == 0){
			  alert ("최소 1글자 이상 입력해주세요.");
			  return ;
			}
			
			$.ajax({
	              type : 'put',
	              url : '/helloworld/worldRest/title',
	              headers : {
	                 'Content-Type' : 'application/json',
	                 'X-HTTP-Method-Override' : 'PUT'
	               },
	               data : JSON.stringify({
	                'main_title' : title
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