<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#All_View {
  width: 492px;
  height: 384px;
  border: 1px solid grey;
}

#select_folder {
  width: 596px;
  height: 450px;
  border: none;
}

#submit_list {
  background-color: #E2E2E2;
}

#registerContent {
  background-color: #E2E2E2;
}
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<meta charset="UTF-8">
<title>다이어리 글 작성 페이지</title>
</head>
<body>


  <div id="All_View">
    <!-- select Option 부분 -->
   
      <form id="DiaryFolderList">
        <input type="text" name="folder" hidden="hidden">
      </form>
      <!-- DiaryFolderList -->

      <!-- folder select 부분 -->
      <form action="diaryregister" method="post">
        <select name="d_folder" style="float: right;">
          <c:forEach var="folder" items="${DiaryFolderList }">
            <option value="${folder }">${folder }</option>
          </c:forEach>
        </select>

        <!-- 글 작성 부분 -->
        <div id="registerContent">
          <textarea rows="22" cols="67" name="d_content"
            placeholder="내용 입력" required style="resize: none;"></textarea>
        </div>

        <div id="submit_list">
          <a href="diarylist"><input type="button" value="목록"></a>
          <input type="submit" value="등록" style="float: right;">

        </div>
        <!--submit_list  -->
      </form>
      <!--diaryregister  -->




  </div>
  <!-- All_View  -->







</body>
</html>