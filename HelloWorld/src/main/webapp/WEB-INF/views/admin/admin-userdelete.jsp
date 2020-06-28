<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
#adminHeader {
   width: 430px;
   height: 40px;
   position: relative;
}

#logouser {
   float: left;
   margin-left: 60px;
}
#imgHeader{
float: left;
}


#userDelete , #btn{
font-size: 100%;
   cursor:pointer;
   background-color: #ff6f6b;
   width: 100px;
   height: 50px;
   color: white;
   float: left;
   margin-top: 5px;
   margin-right: 10px;
   border: 2px solid #ff6f6b;
   border-radius: 10px;
   margin-top: 5px;}
</style>
<title>회원 탈퇴</title>
</head>
<body>
<div>
   <div style="width: 300px;">
      <img style="" id="imgHeader"
         src="${pageContext.request.contextPath}/resources/images/logoIcon40px.png">
      <p id="ptheaderF">회원탈퇴</p><br><br>
   </div>
   
      <div style=" text-align: center;">
          <img id = "userlogo" src=" ${pageContext.request.contextPath}/resources/images/tempProfile.png">
         
         <div><a style="height:72px; font-size: 22px; margin-bottom: 20px;"> "${memberId.userid }"님이 탈퇴가 됩니다.</a>
   </div>
      </div>
      <input id= "userid" hidden="hidden" value="${memberId.userid }">
      <div style="margin-left: 160px; margin-top: 60px;">
<button id="userDelete">탈퇴</button><button id="btn" onclick="window.close();">취소</button>
</div>
</div>
   
   <script type="text/javascript">
      $(document).ready(function() {
         
         $('#userDelete').click(function(){
            var userid =$("#userid").val();
            $.ajax({
                    type : 'delete',
                    url : '/helloworld/admin/userdelet',
                    headers : {
                       'Content-Type' : 'application/json',
                       'X-HTTP-Method-Override' : 'DELETE'
                     },
                     data : JSON.stringify({
                      'userid' : userid
                    }),
                    success : function(result){
                      if(result == 1){
                        alert('탈퇴성공');
                        opener.location.reload();
                      window.close();
                      
                      } // end if()
                    }// end success()
                    
                  }); // end ajax()
            
            
            
         });
      });
      
      
         
         
         
      
   </script>
</body>
</html>