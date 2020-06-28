<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<style type="text/css">
table {
	border-collapse: separate;
	border-spacing: 0 10px;
}

#register_announce {
	background-color: #FFD9FA;
	border: 2px solid #FFD9FA;
	width: 600px;
	height: 70px;
	border-radius: 4px;
	margin-left: 80px;
	font-size: 26px;
    cursor: pointer;
}

th {
	font-size: 24px;
	border-bottom: 5px solid #FFD9FA;
}

td {
	font-size: 20px;
	font-weight: bold;
	border-bottom: 3px solid #FFD9FA;
}

.divc {
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
<title>::공지사항::</title>
</head>
<body>

	<button id="register_announce" type="button">공지 사항 작성</button>


	<table>
		<thead>

			<tr style="margin-top: 4px;">

				<th>번호</th>
				<th style="width: 70px;">분류</th>
				<th style="width: 400px;">제목</th>
				<th>작성자</th>
				<th style="width: 130px;">작성일</th>
			</tr>

		</thead>
		<tbody>

			<c:forEach var="vo" items="${anlist }">
				<fmt:formatDate value="${vo.an_date }" pattern="yyyy-MM-dd"
					var="an_date" />

				<tr class="divc" onclick="open_content(${vo.an_bno})" >
					<td>${vo.an_bno }</td>
					<td>${vo.an_menu}</td>
					<td>${vo.an_title }</td>

					<td>관리자</td>
					<td>${an_date}</td>

				</tr>
				<tr id="content${vo.an_bno }"
					style="display: none; height: 200px; background:">
					<td colspan="2">
						<div style="text-align: center;">내용</div>
					</td>
					<td colspan="3"><textarea
							style="height: 200px; width: 400px; resize: none;" readonly>${vo.an_content}
					</textarea></td>



				</tr>

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
	  function myopendiv(bno) {
	         //check_on_off
	        // console.log("bno:::" + bno);
	      
	      }
	  $(document).ready(function() {
		  $('#register_announce').click(function(){
		  
			  location = '/helloworld/admin/announce-register';
	 	 });
		  
		  
		  $('.pager li a').click(function(){
	            console.log("클릭");
	              event.preventDefault();
	              var targetPage = $(this).attr('href');
	              console.log(targetPage);
	              var frm = $('#pagingForm');
	              frm.find('[name = "page"]').val(targetPage);
	              frm.attr('method', 'get');
	              frm.attr('action','admin-announce');
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