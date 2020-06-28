<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
table {
  border-collapse: separate;
  border-spacing: 0 10px;
}
#register_announce{

background-color: #FFD9FA;
	border: 2px solid #FFD9FA;
	width: 100px;
	height: 50px;
	border-radius: 4px;

}
th{
font-size:  22px;

border-bottom: 5px solid #FFD9FA;
}
td{
font-size:  16px;
 font-weight: bold;
border-bottom: 3px solid #FFD9FA;
}
.divc{
margin-top: 100px;
cursor: pointer;
}
ul {
  list-style-type: none;
}

li {
  display: inline-block;
}
</style>
<title>Insert title here</title>
<%@ include file="/resources/import/qnaboard.jspf"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<table>
			<thead>

				<tr style="">

					<th>번호</th>
					<th> 분류</th>
					<th style="width: 320px;">제목</th>
					<th style="width: 100px;">답변상태</th>
					<th>작성자</th>
					<th style="width: 130px;">작성일</th>
				</tr>

			</thead>
			<tbody>
			
				<c:forEach var="vo" items="${qlist }">
			<fmt:formatDate value="${vo.q_date }" pattern="yyyy-MM-dd"
				var="q_date" />
			<c:if test="${vo.q_answer  != null }">
				<tr class="divc" onclick="open_content(${vo.q_bno})">
			<td>${vo.q_bno }</td>
			<td>${vo.q_menu}</td>
			<td>${vo.q_title }</td>
			<td style="color: green; ">답변완료</td>
			<td>${vo.user_name}</td>
			<td>${q_date}</td>
					
			</tr>
			<tr id="content${vo.q_bno }" style="display: none;height: 200px;background: ">
					<td  colspan="2">
					<div style="text-align: center;">
							내용 
					</div>
					</td>
					<td colspan="4">
					<textarea style="margin:5px 0px 0px 10px;  height:130px; width:500px;resize: none;" readonly >${vo.q_content }</textarea>
					
					<textarea style="margin-left:10px; height:130px; width:500px;resize: none;" readonly >${vo.q_answer }</textarea>
						
					</td>



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
$(document).ready(function() {
    $('.pager li a').click(function(){
       console.log("클릭");
         event.preventDefault();
         var targetPage = $(this).attr('href');
         console.log(targetPage);
         var frm = $('#pagingForm');
         frm.find('[name = "page"]').val(targetPage);
         frm.attr('method', 'get');
         frm.attr('action','admin-qnaEnd');
         frm.submit();
      }); // end pager clicked
});
function open_content(bno) {
    console.log("클릭");
    console.log(bno);
    var on_off= '#content'+bno ;
    console.log(on_off);
    var status = $(on_off).css("display");
    
    console.log(status);
    if (status == "none") {
       $(on_off).css("display", "");
    } else {
       $(on_off).css("display", "none");
    }
 }
 
</script>

	

	
	
	
	
</body>
</html>