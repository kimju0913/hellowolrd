<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

.registerbtn{
	width: 460px;
 	height: 35px;
 	background-color: #FF6F61;
 	color: white;
 	margin: 20px 0px 10px;
 	font-size: 120%;
 	font-weight: bold;
 	border-style: none;
 	border-radius: 10px;
}
body{
background: #F6F6F6;
}
p{
font-size: 10px;}
a{
height :14px;
width :32px;
font-family: Dotum,'돋움',Helvetica,sans-serif;
}
.inputBox {
	width: 202px;
	height: 25px;
	display: block;
	position: relative;

	height: 29px;
	line-height: 29px;
	border: none;
	background: #fff;
	font-size: 15px;
}

.mainback {
	height: 1048px;
	width: 450px;
	margin: auto;
}

.spaninput {
	display: block;
	position: relative;
	width: 100%;
	height: 45px;
	border: solid 1px #dadada;
	padding: 10px 14px 10px 14px;
	background: #fff;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	vertical-align: top;
}

.stepurl {
	position: absolute;
	top: 16px;
	right: 13px;
	font-size: 15px;
	line-height: 18px;
	color: #8e8e8e;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>회원 가입</title>
</head>
<body>
	<div>
		

		<div class="mainback">
				<div>
				<div id ="logo" style=" text-align: center;"><img  src="${pageContext.request.contextPath}/resources/images/logo1.png">	
					</div><br>
					<a>아이디</a>
					<div>
						<span class="spaninput">
						 <input class="inputBoxid"type="text" name="userid" id="registerid"/> <span class="stepurl">@helloworld.com</span>
						</span>
					</div>
					<p id="useridtxt"></p>
				</div>

				<div>
					<a>비밀번호</a>	
					<div>
						<span class="spaninput"> <input class="inputBoxPw"
							type="password" name="password" id ="registerpw"><samp class="stepurl"><img class="passwordimg" src="${pageContext.request.contextPath}/resources/images/nopassword.PNG"></samp>
						</span>
						<p id="userpwtxt"></p>
					</div>
				</div>
					<div>
					<a>비밀번호 재확인</a>	
					<div>
						<span class="spaninput"> <input class="reinputBoxPw"
							type="password"  id ="reinputBoxPw"><samp class="stepurl"><img class="passwordckimg" src="${pageContext.request.contextPath}/resources/images/notpass.PNG"></samp>
						</span>
						<p id="reuserpwtxt"></p>
					</div>
				</div>
				<div>
					<a>이름</a>
					<div>
						<span class="spaninput"> <input class="inputBoxname"
							type="text" name="user_name" maxlength="4">
						</span>
                      <p id="reusernametxt"></p>
					</div>
				</div>
				<div>

					<label for="user_gender">성별</label> <span class="spaninput">
					  <select class="inputBoxgender" id="user_gender" name="user_gender"
						size="1">
							<option value="">선택하세요</option>
							<option value="M">남자</option>
							<option value="W">여자</option>
					</select>
					</span>
                  <p id="reusergendertxt"></p>
				</div>
        
                <div>

             <label for="user_state">지역</label>
              <span class="spaninput">
             <select class = "user_state" id="user_state" name="user_state" size="1">
                <option value="">선택하세요</option>
                <option value="서울">서울</option>
                <option value="부산">부산</option>
                <option value="대구">대구</option>
                <option value="인천">인천</option>
                <option value="광주">광주</option>
                <option value="대전">대전</option>
                <option value="울산">울산</option>
                <option value="경기">경기</option>
                <option value="강원">강원</option>
                <option value="충북">충북</option>
                <option value="충남">충남</option>
                <option value="전북">전북</option>
                <option value="전남">전남</option>
                <option value="경북">경북</option>
                <option value="경남">경남</option>
                <option value="제주">제주</option>
                
                 </select>
                </span>
                <p id="reuserstatetxt"></p>
               </div>
        
				<br>
				<div>
					<a>본인확인 이메일 </a>
					<div>
						<span class="spaninput"> <input class="inputBoxemail"
							type="text" name="user_email">
						</span>
                <p id="reuseremailtxt"></p>
					</div>
				</div>
				<div>
					<a>생년월일</a>
					<div>
                        <div> <!-- 고쳐야함 -->
						<span class="spaninput">
						
								<span>
                                <select class = "userBirthYear" name="user_birth" >
                                <option>년</option>
                                 <c:forEach var = "year" begin="1900" end="2020" step="1">
                                   <option value = ${year }>${year }</option>
                                 </c:forEach>             
                                </select>
                                </span>
                                <span>
                                <select id="user_birth"
									name="user_birth" class = "userBirthMonth" size="1">
										<option value="">월</option>
										<option value="01">01</option>
										<option value="02">02</option>
										<option value="03">03</option>
										<option value="04">04</option>
										<option value="05">05</option>
										<option value="06">06</option>
										<option value="07">07</option>
										<option value="08">08</option>
										<option value="09">09</option>
										<option value="10">10</option>
										<option value="11">11</option>
										<option value="12">12</option>
								</select>
								
                                  <select name="userBirthDay" class="userBirthDay">
                                       <option value="">일</option>
                                       <c:forEach var = "day" begin="1" end="31" step="1">
                                         <option value = ${day }>${day }</option>
                                        </c:forEach>    
                                  </select>
                               </span>
                               <span>
                                    
                               </span>
						</span>
							<p id="reuserbirthtxt"></p>
					</div>
					</div>
				</div>
				<p id="userbir"></p>

				<div>
					<a>휴대전화</a>
					<div>
						<span class="spaninput"> <input class="inputBoxphone"
							type="text" name="user_phone"></span>
					</div>
				</div>
					<p id="phoentxt"></p>


				<button type="button"  class ="registerbtn">가입하기</button>
			
		</div>
	</div>
	
	<script type="text/javascript">
	
	
	$(document).ready(function(){
		var idRegExp = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
		var password1RegExp = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/; // 비밀번호 유효성 검사
		var nameRegExp = /^[가-힣]{2,4}$/;
		var phoneRegExp = /^\d{11}$/;
		var idCheck = false;
		var pwCheck1 = false;
		var pwCheck2 = false;
		var nameCheck = false;
		var phoneCheck = false;
		var genderCheck = false;
		var stateCheck = false;
		var emailCheck = false;
		var birthCheck = false;

		$(".inputBoxid").blur(function () {
				
		  var userid =$(".inputBoxid").val();
		  console.log(userid);
 		  if(userid != ""){
		  $.ajax({
			 type : 'post',
			 url : '/helloworld/user/useridselect/'+userid,
			headers : {
				'Content-Type' : 'application/json',
				'X-HTTP-Method-Override' : 'POST'
			},
			data : JSON.stringify(userid),
			success : function(result){
	  	        if(result == 1){
	  	        	 useridtxt.style.color = 'red';
	  		         useridtxt.innerHTML = '이미존재한 아이디입니다.';
	  		         idCheck = false;
	  		         return;
	  	         }else if (!idRegExp.test(userid)) {
	  		         useridtxt.style.color = 'red';
	  		         useridtxt.innerHTML = '5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.';
	  		         idCheck = false;
	  		         return;
	  		        }else if (userid.length < 5 || userid.length > 20){
	  		       	 useridtxt.style.color = 'red';
	  		         useridtxt.innerHTML = '아이디는 5~20자로 제한합니다' ;
	  		         idCheck = false;
	  		         return;
	  		        } else {
	  		         useridtxt.style.color = '#53C14B';
	  		         useridtxt.innerHTML = '멋진 아이디네요!';
	  		         idCheck = true;
	  		         return ;
	  		        }
	  	       }			
		}); 
	   }else {
	     useridtxt.style.color = 'red';
	     useridtxt.innerHTML = '필수 정보입니다.'; 
	     idCheck = false;
	     return;
	   }
	}); // inputBoxid.blur end
	
	
	
	
	$(".inputBoxPw").blur(function () {
	var	pw = $(".inputBoxPw").val();
	console.log(pw);
		if(pw == ""){
			userpwtxt.style.color = 'red';
		    userpwtxt.innerHTML = '필수 정보입니다.';
		    $(".passwordimg").attr("src", "${pageContext.request.contextPath}/resources/images/notpassword.PNG");
		    pwCheck1 = false;
		    return;
		} else if (pw.length < 8 || pw.length >17){	
			userpwtxt.style.color = 'red';
			userpwtxt.innerHTML = '비밀번호는 8~16자로 제한합니다' ;
			  $(".passwordimg").attr("src", "${pageContext.request.contextPath}/resources/images/notpassword.PNG");
		    pwCheck1 = false;
		    return;
	    } else if (!password1RegExp.test(pw)) {
		  	userpwtxt.style.color = 'red';
	       	userpwtxt.innerHTML = '8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.';
	        $(".passwordimg").attr("src", "${pageContext.request.contextPath}/resources/images/notpassword.PNG");
	        pwCheck1 = false;
			return;
	      } else {
	        userpwtxt.style.color = '#53C14B';
	        userpwtxt.innerHTML = '사용 가능한 비밀번호';
	        $(".passwordimg").attr("src", "${pageContext.request.contextPath}/resources/images/passpassword.PNG");
	        pwCheck1 = true;
		    return;
	      }
	}); //inputBoxPw.blur end
	
	$(".reinputBoxPw").blur(function () {
		var	pw = $(".inputBoxPw").val();
		var repw = $(".reinputBoxPw").val();
		console.log(pw);
		
		if(repw == ""){
				reuserpwtxt.style.color = 'red';
				reuserpwtxt.innerHTML = '필수 정보입니다.';
				pwCheck2 = false;
				
		}else if(pw == repw){
			reuserpwtxt.style.color = '#53C14B';
				reuserpwtxt.innerHTML = '일치합니다.';
			    $(".passwordckimg").attr("src", "${pageContext.request.contextPath}/resources/images/passsave.PNG");
			    pwCheck2 = true;
		}else{
				reuserpwtxt.style.color = 'red';
				reuserpwtxt.innerHTML = '비밀번호가 일치하지 않습니다.';
				pwCheck2 = false;
				 $(".passwordckimg").attr("src", "${pageContext.request.contextPath}/resources/images/notpass.PNG");
				
		}
		});// reinputBoxPw.blur end
	
	$(".inputBoxname").blur(function () {
		var	username = $(".inputBoxname").val();
		if(username == ""){
		  reusernametxt.style.color = 'red';
		  reusernametxt.innerHTML = '필수 정보입니다.';
		  nameCheck = false;
		  return;
		 }else if (!nameRegExp.test(username)){
		   reusernametxt.style.color = 'red';
		   reusernametxt.innerHTML = '이름이 올바르지 않습니다.';
		   nameCheck = false;
		   return ;
		 } else {
		   reusernametxt.innerHTML = '';
		   nameCheck = true;
		   return ;
		 }
		});// inputBoxname.blur  end
	
	$(".userBirthYear").blur(function(){
		var year = $(".userBirthYear").val();
		var Month = $(".userBirthMonth").val();
		var Day = $(".userBirthDay").val();
		
		if(year == '년'|| year == ""){
		  reuserbirthtxt.style.color = 'red';
		  reuserbirthtxt.innerHTML = '태어난 년도 4자리를 정확하게 선택하세요.';
		  birthCheck = false;
		  return;
		  }else if (year != '년' && Month =="" ){
			  reuserbirthtxt.style.color = 'red';
			  reuserbirthtxt.innerHTML = '태어난 월을 선택하세요.';
			  birthCheck = false;
			  return;
		 } else if (year != '년'&& Month !=""  && Day == ""){
		   	  reuserbirthtxt.style.color = 'red';
			  reuserbirthtxt.innerHTML = '태어난 일(날짜) 2자리를 선택하세요.';
			  birthCheck = false;
		 } else {
		    reuserbirthtxt.innerHTML = '';
		    birthCheck = true;
		    return ;
		 }
			
	});//userBirthYear.blur  end
	
	$(".userBirthMonth").blur(function(){
	   var year = $(".userBirthYear").val();
		var Month = $(".userBirthMonth").val();
		var Day = $(".userBirthDay").val();

		if(Month == ""){
		  reuserbirthtxt.style.color = 'red';
		  reuserbirthtxt.innerHTML = '태어난 월을 선택하세요.';
		  birthCheck = false;
		  return ; 
		  } else if (year == '년' || year == ""){
		    reuserbirthtxt.style.color = 'red';
			reuserbirthtxt.innerHTML = '태어난 년도 4자리를 정확하게 선택하세요.';
			birthCheck = false;
			return ;
		  }
		else if (Month != "" && Day == ""){
		    reuserbirthtxt.style.color = 'red';
			  reuserbirthtxt.innerHTML = '태어난 일(날짜) 2자리를 선택하세요.';
			  birthCheck = false;
			  return;
		  }else {
		    reuserbirthtxt.innerHTML = '';
		    birthCheck = true;
		    return ;
			 }
	});// userBirthMonth.blur  end
	
	$(".userBirthDay").blur(function(){
	    var year = $(".userBirthYear").val();
		var Month = $(".userBirthMonth").val();
		var Day = $(".userBirthDay").val();
		
		if(Day == ""){
		  reuserbirthtxt.style.color = 'red';
		  reuserbirthtxt.innerHTML = '태어난 일(날짜) 2자리를 선택하세요.';
		  birthCheck = false;
		  return ;
		}else if (year == '년' || year == ""){
		  reuserbirthtxt.style.color = 'red';
		  reuserbirthtxt.innerHTML = '태어난 년도 4자리를 정확하게 선택하세요.';
		  birthCheck = false;
		  return ;
		}
		else if (Day != "" &&  Month == ""){
		  reuserbirthtxt.style.color = 'red';
		  reuserbirthtxt.innerHTML = '태어난 월을 선택하세요.';
		  birthCheck = false;
		  return ;
		} 
		else if (Day != "" && year != '년' && Month != ""){
		  reuserbirthtxt.innerHTML = '';
		  birthCheck = true;
		  // 카운트 + 1 
		  return ;
		}
		  
	});//userBirthDay.blur  end
	
	$(".inputBoxphone").blur(function(){
		var phoen = $(".inputBoxphone").val();
		console.log(phoen);
		if(phoen == ""){
			phoentxt.style.color = 'red';
			phoentxt.innerHTML = '필수 정보입니다.';
			phoneCheck = false;
			return;
		} else if (!phoneRegExp.test(phoen)){
		  phoentxt.style.color = 'red';
		  phoentxt.innerHTML = '하이픈(-)을 제외한 11자리 숫자를 입력하세요. ';
		  phoneCheck = false;
		  return ;
		} else {
		  phoentxt.innerHTML = '';
		  phoneCheck = true;
	    return ;
		 } 
		
	});//inputBoxphone.blur  end
	$(".inputBoxemail").blur(function(){
		var email = $(".inputBoxemail").val();
		
		if(email == ""){
		  reuseremailtxt.style.color = 'red';
		  reuseremailtxt.innerHTML = '필수 정보입니다.';
		  emailCheck = false;
		  return;
		}
		else {
		  reuseremailtxt.style.color = '#53C14B';
		  reuseremailtxt.innerHTML = '';
		  emailCheck = true;
		  return ;
		}
	});//inputBoxphone.blur  end
	
	$(".inputBoxgender").blur(function(){
		var gender = $(".inputBoxgender").val();
		
		if(gender == ""){
		  reusergendertxt.style.color = 'red';
		  reusergendertxt.innerHTML = '필수 정보입니다.';
		  genderCheck = false;
		  return;
		}else {
		  reusergendertxt.style.color = '#53C14B';
		  genderCheck = true;
		  reusergendertxt.innerHTML = '';
		}
	});//inputBoxphone.blur  end
	
	
	$(".user_state").blur(function(){
		var state = $(".user_state").val();
		
		if(state == ""){
		  reuserstatetxt.style.color = 'red';
		  reuserstatetxt.innerHTML = '필수 정보입니다.';
		  stateCheck = false;
		  return;
		}else {
		  reuserstatetxt.style.color = '#53C14B';
		  reuserstatetxt.innerHTML = '';
		  stateCheck = true;
		  return;
		}
	});//inputBoxphone.blur  end
	
	
	
	
	
	
	$(".mainback").on("click", ".registerbtn" ,function(){
	  
 		var userid =$(".inputBoxid").val(); // 아이디 
 		var	pw = $(".inputBoxPw").val(); //회원 비밀번호
		var	username = $(".inputBoxname").val(); //이름 
		var	gender = $(".inputBoxgender").val(); // 성별 
		var Year = $(".userBirthYear").val(); // 생일 /년
		var Month = $(".userBirthMonth").val(); // 생일 /월 
		var Day = $(".userBirthDay").val();    // 생일 /일
		var state = $(".user_state").val();
		console.log(state);
		var phoen = $(".inputBoxphone").val();// 핸드폰 번호 
		var user_email = $(".inputBoxemail").val(); // 이메일
		
		var user_birth = Year + "." + Month + "." + Day;
		
		console.log(user_birth);
		var obj = {
				'userid' : userid,
				'password': pw,
				'user_name' : username,
				'user_gender' : gender,
				'user_state' : state,
				'user_email' : user_email,
				'user_birth':user_birth,
				'user_phone':phoen
		};// obj end
		
		var allCheck = idCheck + pwCheck1 + pwCheck2 + nameCheck + phoneCheck + genderCheck + stateCheck + emailCheck + birthCheck;
		
		if(allCheck==9){
		  
		  $.ajax({
       	  url : '/helloworld/user/user-register',
          type : 'post',
          headers : {
           'Content-Type' : 'application/json',
           'X-HTTP-Method-Override' : 'POST'
        	},
      	  data : JSON.stringify(obj),
          success : function(result){
               if(result == 'success'){
                 alert('회원 가입 성공');                     
                 var target = encodeURI('/helloworld/user/login');
                 location = target;
               }else {
                 alert('서버에 문제가 생겼습니다. 고객센터로 문의 바랍니다.');
               } // end if()
            
             }// end success()
    	 });
		}else{
		  alert('모든 항목이 올바르게 입력되었는지 다시 한번 확인바랍니다.');
		}
		
	});// mainback.on(click) end
	  $('#logo').click(function() {//로고클릭 

			location = '/helloworld';

		});
});// document ready()end
	
	
	</script>
</body>
</html>