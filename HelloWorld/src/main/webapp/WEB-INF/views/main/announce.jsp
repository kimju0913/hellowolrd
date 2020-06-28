<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

ul {
	list-style-type: none;
}

li {
	display: inline-block;
}
</style>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<%@ include file="/resources/import/qnaboard.jspf"%>
<body>

 <div id="antitleber" style="display: block;">
         <div id="div_q_bno">번호</div>
         <div id="div_q_menu">분류</div>
         <div id="div_an_content">내용</div>
         <div id="div_q_date">등록일</div>
      </div>
<div id="announcediv">
            <div id="announceboard">
               <c:forEach var="vo" items="${anlist}">
                  <fmt:formatDate value="${vo.an_date }" pattern="yyyy-MM-dd"
                     var="an_date" />
                  <div id="an_list" style="height: 30px; display: block;"
                     onclick="openAn(${vo.an_bno})">
                     <div id="an_bno">${vo.an_bno }</div>
                     <div id="an_menu">${vo.an_menu }</div>
                     <div id="an_title">${vo.an_title }</div>
                     <div id="an_date">${an_date }</div>
                  </div>
                  <div id="an_on_off${vo.an_bno}" style="margin-left: 200px; display: none;">
                     <textarea id="an_content" readonly>${vo.an_content }</textarea>
                  </div>
                  <hr>
               </c:forEach>
            </div>
            
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
         </div>
         <script type="text/javascript">
         function openAn(bno) {
             console.log("클릭");
             var on_off= '#an_on_off'+bno;
             var status = $(on_off).css("display");
             
             console.log(status);
             if (status == "none") {
                $(on_off).css("display", "");
             } else {
                $(on_off).css("display", "none");
             }
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
		              frm.attr('action','announce');
		              frm.submit();
		           }); // end pager clicked
         });s
         </script>

</body>
</html>