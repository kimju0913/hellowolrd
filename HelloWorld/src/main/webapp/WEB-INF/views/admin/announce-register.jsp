<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
}
</style>
<title>Insert title here</title>
</head>
<body>
   <table>
      
      <tbody>
      <tr>
      
      </tbody>
   </table>



<form action="announce-register" method="post">
      <table>
         <thead>
            <tr>
               <th>제목</th>
               <td><input type="text" name="an_title"required></td>
            </tr>

            <tr>
               <th>분류</th>
               <td><select required
         style="width: 70px; height: 30px; margin-top: 10px; float: left;  "
         id="an_menu" name="an_menu" size="1">
         <option value="">분 류</option>
         <option value="이벤트">이벤트</option>
         <option value="공지">공지</option>
         <option value="일반">일반</option>
      </select></td>
            </tr>

            

            <tr>
               <th>내용</th>
               <td><textarea style="height: 300px; width: 400px;" name="an_content" required> </textarea></td>
            </tr>

            



         </thead>
      </table>
      <input class="btn" type="submit" value="작성">
      <button class="btn" type="button"
         onclick="location = '/helloworld/admin/admin-announce'">취소</button>
   </form>



<script type="text/javascript">

$(document).ready(function() {
   $('#btn').click(function() {
      var menu = $("#an_menu").val();
      var title = $("#an_title").val();
      var content = $("#an_content").val();

         console.log(menu);
      if (menu == "" || content == "" || title == "") {
         alert('모든 내용을 채워주세요. ')
      } else {
         alert('문의하신 내용이 검토중입니다 ')
   $("#btn").submit();
      }

   });

});
</script>




</body>
</html>