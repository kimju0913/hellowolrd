<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
button{
font-size: 100%;
	background-color: #ff6f6b;
	width: 100px;
	height: 50px;
	color: white;
	float: left;
	margin-top: 5px;
	margin-right: 10px;
	border: 2px solid #ff6f6b;
	border-radius: 10px;
	margin-top: 5px;
}
</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>Q & A</title>
</head>

<%@ include file="/resources/import/qnaboard.jspf"%>
<body>


	<form id="qnaform" action="qna" method="post">
		<table>
			<thead>
				<tr>
					<th>분류</th>
					<td>  <select
						style="width: 70px; height: 30px; padding-top:10; float: left;"
						id="q_menu" name="q_menu" size="1">
							<option value="">분 류</option>
							<option value="욕설">욕설</option>
							<option value="음란물">음란물</option>
							<option value="기타">기타</option>
					</select> <input style="margin-left: 20px;" type="checkbox" name="q_secret" value="Y"><a>비밀로
							하기</a> </td>
				</tr>

				<tr>
					<th>아이디</th>
					<td style="float: left;">${loginId }(${loginName})</td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input id="q_title" style="height: 25px; width: 700px;"
						type="text" name="q_title"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input id="q_content" style="height: 350px; width: 700px;"
						type="text" name="q_content" ></td>
				</tr>


			</thead>
		</table>
		<div style="margin-left: 320px;">
		<button id="insert_btn" type="button">작성</button>
		<button onclick="location = '/helloworld/main/question'" type="button">취소</button>
	</div>

	</form>



	<script type="text/javascript">
		$(document).ready(function() {
			$('#insert_btn').click(function() {
				var menu = $("#q_menu").val();
				var title = $("#q_title").val();
				var content = $("#q_content").val();

					console.log(menu);
				if (menu == "" || content == "" || title == "") {
					alert('모든내용을 채워 주세요. ')
				} else {
					alert('문의하신 내용이 검토중입니다 ')
			$("#qnaform").submit();
				}

			});
		
		});
	</script>

</body>
</html>