<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#All_View {
  width: 492px;
  height: 384px;
  border: 1px solid grey;
  margin-top: 20px;
  background-color: #E2E2E2;
}

#submit_list {
  background-color: #E2E2E2;
}

</style>


<meta charset="UTF-8">
<title>다이어리 글 수정</title>
</head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<body>


  <div id="All_View">
    <!-- select Option 부분 -->
    <div id="select_folder">
      <form id="DiaryFolderList">
        <input type="text" name="folder" hidden="hidden">
      </form> <!-- DiaryFolderList -->


      <!-- folder select 부분 -->
      <form action="diaryupdate" method="post">
           <select name="d_folder" style="float: right;">
         <c:forEach var="folder" items= "${DiaryFolderList }">
            <option value="${folder }">${folder }</option>
          </c:forEach>
           </select>


         <!-- 본문 내용 수정 부분 -->
        <div id="updateContent">
          <textarea rows="22" cols="67" name="d_content" style="resize: none;'">${DiaryBoardVO.d_content }</textarea>
          <input type="text" name="d_bno" value="${DiaryBoardVO.d_bno }" style="display: none"> 
          <br>
        </div> <!-- div updateContent -->


        <div id="submit_list">
          <a href="diarylist"><input type="button" value="목록"></a>
          <button type="submit" id="btn_update" style="float: right;">수정 완료</button>
       
        </div> <!--submit_list  -->
      </form>  <!--diaryupdate  -->

    </div> <!-- select_folder -->
    
   </div> <!-- All_View  -->
  


  <script type="text/javascript">
      $(document).ready(function() {
        $('#btn_update').click(function() {
          var frm = $('#frm');
          frm.attr('action', 'diaryupdate');
          frm.attr('method', 'post');
          frm.submit();
        });
      });
    </script>



</body>
</html>