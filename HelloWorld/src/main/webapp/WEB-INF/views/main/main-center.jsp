<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
<style type="text/css">
li {
	list-style: none;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>Helloworld::고객센터</title>

</head>
<%@ include file="/resources/import/subheader.jspf"%>
<%@ include file="/resources/import/qnaboard.jspf"%>
<body>

	<div style="height: 65px;">

		<button id="announce_btn" >공지사항</button>
		<button id="question_btn" >전체문의</button>
		<button id="myquestion_btn" >나의문의</button>
		<button id="qna_btn">문의하기</button>	
		
	</div>
	<div>
		<iframe src="/helloworld/main/announce" style="display: block;"
			id="QNAdiv"> </iframe>
	</div>
	<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ  나의 문의사항 -->



	<script type="text/javascript">
		$(document).ready(function() {

			$('#announce_btn').click(function() {
				$('#QNAdiv').attr('src', "/helloworld/main/announce");
			});
			$('#question_btn').click(function() {
				$('#QNAdiv').attr('src', "/helloworld/main/question");
			});
			$('#myquestion_btn').click(function() {
				$('#QNAdiv').attr('src', "/helloworld/main/myquestion");
			});
			$('#qna_btn').click(function() {
				$('#QNAdiv').attr('src', "/helloworld/main/qna");
			});
			

		});
	</script>

</body>
</html>