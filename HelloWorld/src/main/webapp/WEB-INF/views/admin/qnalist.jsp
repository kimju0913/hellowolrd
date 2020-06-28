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
	border: 1px solid black;
	padding: 10px;
	height: auto;
}

#menucolumn {
	float: left;
	border: 1px solid black;
	width: 200px;
	height: 700px;
}

#maincolumn {
	margin-left: 220px;
	border: 1px solid black;
	width: auto;
	height: auto;
	border: 1px solid black;
}

#qnamenu {
	border: 1px solid black;
	margin: 20px;
}

.divc {
  cursor: pointer;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>관리자 :: 페이지</title>
</head>
<%@ include file="/resources/import/qnaboard.jspf"%>
<body>
	<h1>관리자 페이지</h1>
	<div id="totalcolumn">
		<div id="menucolumn">
			<div id="qnamenu">
				<h3>사용자</h3>
				<div>전체 사용자</div>
			</div>
			<div id="qnamenu">
				<h3>문의사항</h3>
				<div>답변대기</div>
				<div>답변완료</div>
			</div>
		</div>



		<div id="maincolumn">

			<c:forEach var="vo" items="${qlist }">
				<fmt:formatDate value="${vo.q_date }" pattern="yyyy-MM-dd"
					var="q_date" />
				<c:if test="${vo.q_answer  == null }">
					<div class="divc" >
						<input hidden="hidden" id="useridcontent" value="${vo.userid }">
						<input class="q_secret" type="hidden" value="${vo.q_secret }">
						<div id="div_q_bno">${vo.q_bno }</div>
						<div id="div_q_menu">${vo.q_menu}</div>
						<div id="div_q_content">${vo.q_title }</div>
						<div id="div_q_answer">답변대기</div>
						<div id="div_q_name">${vo.user_name}</div>
						<div id="div_q_date">${q_date}</div>
					</div>
					<br>
					<br>
				</c:if>
			</c:forEach>

			<div></div>

		</div>
	</div>

</body>
</html>