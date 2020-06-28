<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.content {
   border: 2px solid #FFD9FA;
   border-radius: 4px;
   height: 140px;
   width: 300px;
   text-align: center;
   padding-top: 50px;
   margin: auto;
}

.btn {
   background-color: #FFD9FA;
   border: 2px solid #FFD9FA;
   width: 100px;
   height: 50px;
   border-radius: 4px;
   cursor: pointer;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>



   <div style="margin-top: 50px;">
      <div class="content">
         <a style="font-size: 20px;">회원 수</a><br> <a
            style="font-size: 18px;"> ${count.memberCount -1}</a><br> <br>
         <button class="btn"
            onclick="location = '/helloworld/admin/admin-user'">바로가기</button>

      </div>
      <br>
      <br>

      <div class="content">
         <a style="font-size: 20px;">대기중 문의/전체 문의 </a><br> <a
            style="font-size: 18px;">${count.questionTotalCount}/${count.questionNotAnswer}</a><br>
         <br>
         <button class="btn"
            onclick="location = '/helloworld/admin/admin-qna'">바로가기</button>

      </div>
      <br>
      <br>


      <div class="content">
         <a style="font-size: 20px;">전체 공지 수 </a><br> <a
            style="font-size: 18px;"> ${count.announceCount }</a><br> <br>
         <button class="btn"
            onclick="location = '/helloworld/admin/admin-announce'">바로가기</button>
      </div>






      <div></div>

      <div></div>
   </div>
</body>
</html>