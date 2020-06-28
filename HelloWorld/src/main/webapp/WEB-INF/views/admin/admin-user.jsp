<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>

<style type="text/css">
table {
   border-spacing: 55px;
   border-collapse: separate;
   width :780px;
   border: 3px solid #ff6f6b;
}

thead {
   border: 3px solid #ff6f6b;
}
ul {
   list-style-type: none;
}

li {
   display: inline-block;
}

</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>


<title>Insert title here</title>


</head>
<body>

   <table>

      <thead>

         <tr style="">

            <th>이름 (아이디)</th>
            <th>전화번호</th>
            <th>성 별</th>
            <th>생년 월일</th>
            <th>탈퇴</th>
         </tr>

      </thead>


      <tbody>
         <c:forEach var="vo" items="${memberlist }">
            <c:if test = "${vo.userid != 'test' }">
            <tr class="content" >
               <td>${vo.user_name}</td>
               <td>${vo.user_phone}</td>
               <td>${vo.user_gender}</td>
               <td>${vo.user_birth}</td>
               <td><button onclick="userdelete('${vo.userid}')" >탈퇴</button></td>
            </tr>
            </c:if>
         </c:forEach>

      </tbody>
   </table>
   
   <div id="paging">

         <ul class="pager">

            <c:if test="${pageMaker.hasPrev }">
               <li><a href="${pageMaker.startPageNo - 1 }">◀</a></li>
            </c:if>

            <c:forEach begin="${pageMaker.startPageNo }"
               end="${pageMaker.endPageNo }" var="num">
               <li><a href="${num }"> ${num } | </a></li>
            </c:forEach>
            <c:if test="${pageMaker.hasNext }">
               <li><a href="${pageMaker.endPageNo + 1 }">▶</a></li>
            </c:if>
         </ul>
      </div>
      <div>
         <form id="pagingForm" style="display: none;">
            <input type="text" name="page" value="${pageMaker.criteria.page }">
            <input type="text" name="bno">
         </form>
      </div>
   <script type="text/javascript">
     function userdelete(userid){
             console.log(userid);
             window.open('admin-userdelete?userid='+userid , 'title', 'width=500, height=360')
            
         }
     $(document).ready(function() {
            $('.pager li a').click(function(){
               console.log("클릭");
                 event.preventDefault();
                 var targetPage = $(this).attr('href');
                 console.log(targetPage);
                 var frm = $('#pagingForm');
                 frm.find('[name = "page"]').val(targetPage);
                 frm.attr('method', 'get');
                 frm.attr('action','admin-user');
                 frm.submit();
              }); // end pager clicked
     });
   
   </script>


   

</body>
</html>