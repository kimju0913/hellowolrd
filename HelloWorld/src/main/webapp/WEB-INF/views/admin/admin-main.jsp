<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#totalcolumn {
   height: auto;
   width: 900px;
   border: 2px solid #FFD9FA;
   border-radius: 4px;
}

iframe {
   border: 2px solid #FFD9FA;
   margin-left: 35px;
   height: 1000px;
}

#menucolumn {
   float: left;
   border: 1px solid black;
   width: 200px;
   height: 700px;
}

#maincolumn {
   width: auto;
   height: auto;
   border: 1px solid black;
}

body {
   margin: 0;
   padding: 0;
   font-family: "Roboto", serif;
   display: flex;
   flex-flow: column nowrap;
   justify-content: center;
   align-items: center;
   overflow-x: hidden;
}

h1 {
   margin: 2em 0 1.5em 0;
}

nav {
   width: 100%;
   display: flex;
   justify-content: center;
   position: relative;
   background: linear-gradient(90deg, #F361DC, #FFB2F5, #FFD9FA, #FFFFFF);
}

ul, li {
   margin: 0;
   padding: 0;
   list-style: none;
}

#main-menu>li {
   float: left;
   position: relative;
   width: 200px;
}

#main-menu>li>a {
   font-size: 0.85rem;
   color: rgba(0, 0, 0, 0.85);
   text-align: center;
   text-decoration: none;
   letter-spacing: 0.05em;
   display: block;
   padding: 14px 36px;
   border-right: 1px solid rgba(0, 0, 0, 0.15);
   text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.2);
}

#main-menu>li:nth-child(1)>a {
   border-left: 1px solid rgba(0, 0, 0, 0.15);
}

#sub-menu {
   position: absolute;
   background: #FFD9FA;
   opacity: 0;
   visibility: hidden;
   transition: all 0.15s ease-in;
}

#sub-menu>li {
   padding: 16px 28px;
   border-bottom: 1px solid rgba(0, 0, 0, 0.15);
   width: 140px;
}

#sub-menu>li>a {
   color: rgba(0, 0, 0, 0.6);
   text-decoration: none;
   cursor: pointer;
}

#main-menu>li:hover #sub-menu {
   opacity: 1;
   visibility: visible;
}

#sub-menu>li>a:hover {
   text-decoration: underline;
}

section {
   column-width: 15em;
   background: #dadadf;
   padding: 2em 12em;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>관리자 :: 페이지</title>
</head>
<%@ include file="/resources/import/qnaboard.jspf"%>
<body>

   <!--아이 프레임 생성 
사용자 정보 admin user
   ㄴ 사용자 목록 전체 보기 

메뉴  공지사항  admin anno
       ㄴ 등록, 삭제 올리기 
메뉴 문의사항  admin qna 
    ㄴ 답면미등록 답변 달기 기능
    ㄴ 등록 된 것는 관람만 가능 
내일 끝네고 
 
 
미니 홈페이지 수정 페이지 만들기 

버튼 css 변경 확인 

  -->


   <div id="logock" style="margin: auto;">
      <img id="imgheaderlogo"
         src="${pageContext.request.contextPath}/resources/images/logo3_big.png">
   </div>
   <div id="totalcolumn">


      <nav role="navigation">
         <ul id="main-menu">
            <li><a href="#">전체현황</a>
               <ul id="sub-menu">
                  <li id="on-main-content"><a aria-label="subemnu">현황</a></li>
               </ul></li>
            <li><a href="#">회원 관리</a>
               <ul id="sub-menu">
                  <li id="on_admin_user"><a aria-label="subemnu">회원정보</a></li>
               </ul></li>
            <li><a href="#">공지 사항</a>
               <ul id="sub-menu">
                  <li id="on_admin_announce"><a aria-label="subemnu">공지</a></li>
               </ul></li>
            <li><a href="#">문의관리</a>
               <ul id="sub-menu">
                  <li id="on_admin_qna"><a aria-label="subemnu">답변 대기</a></li>
                  <li id="on_admin_qnaEnd"><a aria-label="subemnu">답변 완료</a></li>

               </ul></li>

         </ul>
      </nav>




      <div>

         <iframe style="height: 760px; width: 790px;" id="content_iframe"
            src="/helloworld/admin/admin-situation"> </iframe>





      </div>
   </div>
   <script type="text/javascript">
      $(document).ready(
            function() {

               $('#on-main-content').click(
                     function() {
                        $('#content_iframe').height('760px');
                        $('#content_iframe').attr('src',
                              "/helloworld/admin/admin-situation");
                     });
               $('#on_admin_qna').click(
                     function() {
                        $('#content_iframe').height('500px');
                        $('#content_iframe').attr('src',
                              "/helloworld/admin/admin-qna");

                     });

               $('#on_admin_qnaEnd').click(
                     function() {
                        $('#content_iframe').height('500px');
                        $('#content_iframe').attr('src',
                              "/helloworld/admin/admin-qnaEnd");
                     });
               $('#on_admin_announce').click(
                     function() {
                        $('#content_iframe').height('600px');
                        $('#content_iframe').attr('src',
                              "/helloworld/admin/admin-announce");
                     });
               $('#on_admin_user').click(
                     function() {
                        $('#content_iframe').height('1100px');
                        $('#content_iframe').attr('src',
                              "/helloworld/admin/admin-user");
                     });

               $('#logock').click(function() {
                  location.href = "/helloworld";
               });

            });
   </script>

</body>
</html>