<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table {
	border-collapse: separate;
	border-spacing: 0 10px;
}

th {
	border-right: 5px solid #FFD9FA;
	padding: 10px;
}

td {
	padding-left: 30px;
    
}

textarea {
	border: 2px solid #FFD9FA;
}

.btn {
	background-color: #FFD9FA;
	border: 2px solid #FFD9FA;
	width: 60px;
	height: 40px;
	border-radius: 4px;
	margin-left: 80px;
	font-size: 18px;
    cursor: pointer;
}
</style>
<meta charset="UTF-8">
<title>답변 ::QnA</title>
</head>
<body>






	<form action="answer-post" method="post">
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<td>${vo.q_bno }<input name = "q_bno" hidden="hidden"value="${vo.q_bno }"></td>
				</tr>

				<tr>
					<th>분류</th>
					<td>${vo.q_menu }</td>
				</tr>

				<tr>
					<th>작성자</th>
					<td>${vo.userid }(${vo.user_name })</td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea style="height: 200px; width: 500px; resize: none;" readonly="readonly">${vo.q_content }</textarea></td>
				</tr>

				<tr>
					<th>답변</th>
					<td><textarea name="q_answer"
							style="height: 200px; width: 500px; resize: none;" required ="required"></textarea></td>
				</tr>



			</thead>
		</table>
		<input class="btn" type="submit" value="작성">
		<button class="btn" type="button"
			onclick="location = '/helloworld/admin/admin-qna'">취소</button>
	</form>

</body>
</html>