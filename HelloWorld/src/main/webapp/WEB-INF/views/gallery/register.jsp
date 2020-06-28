<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
  *{
   margin: 0 auto; 
  }
  
   a{
  text-decoration: none;
  }
  
  #div_menu{
    width:200px;
    height: 637px;
    float: left;
    border: 1px solid grey;
    margin-left: 50px;
  }
  
  #div_con{
   width:600px;
   height: 388px;
   float: left;
   overflow-x: auto;
   overflow-y: auto;
   background-color: #e2e2e2;
   padding: 10px 10px 10px 10px;
  }
  
  #div_all{
    width:750px;
    height: 500px;
   
  }
 .folder_img{
  background: url("${pageContext.request.contextPath}/resources/img/folder2.png" );
  width: 15px;
  height: 15px;
  border: 0 ; 
  padding: 0 ; 
  cursor: pointer;
 }
 body {
  padding: 15px 30px 15px 30px;
 }

</style>
<meta charset="UTF-8">
<title>사진첩 글 등록</title>
</head>
<body>
<div id = "div_all">
 
 <div id = "div_con" >
  <form action = "register" method = "post" enctype="multipart/form-data" id = "frm">
    

    <b>폴더 선택
    <select name = "gl_folder">
     <c:forEach var = "folder" items="${folderList}">
      <option >${folder}</option>
     </c:forEach> 
    </select>
    </b>
    
    
    <br><br>
  
    <p>제목 입력 <input type = "text" name = "gl_title" maxlength="20" required ="required"></p>
     
    <br><br>
     <!-- 파일 선택 그림 -->
    <input type = "file" name = "file" id = "file" required ="required" accept='image/jpeg,image/gif,image/png' onchange='chk_file_type(this)'>
    <div id = "PREVIEW_IMG_DIV" >
      <img id = "preview" src =""  width = 70% >
    </div>
    <br>
    
    <textarea rows="10" cols="80" name = "gl_content" placeholder="최대 100자리 까지"  required ="required" maxlength="100" style = "resize: none;"></textarea> <br><br>
    <input type = "submit" value = "등록" style = "float: right;">
    <a href = "list"><button type = "button" style = "float: left;" >목록</button></a>
  
  
  </form>
  </div>
  
 </div> 

  <script type="text/javascript">
     
    function chk_file_type(obj) {

          var file_kind = obj.value.lastIndexOf('.');

          var file_name = obj.value.substring(file_kind+1,obj.length);

          var file_type = file_name.toLowerCase();

          var check_file_type=new Array();

          check_file_type=['jpg','gif','png','jpeg','bmp','tif'];
          
          var file = document.querySelector('#file');
          
          if(check_file_type.indexOf(file_type)==-1) {

             alert('이미지 파일만 업로드 가능합니다');

             var parent_Obj=obj.parentNode;

             var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);

            

             document.getElementById("file").value = "";    //초기화를 위한 추가 코드

             document.getElementById("file").select();      //초기화를 위한 추가 코드


             return false;

          } else {
          //else 파일 미리보기 실행 .
            var fileList = file.files ;
         
           // 읽기
          var reader = new FileReader();
            reader.readAsDataURL(fileList [0]);

             //로드 한 후
          reader.onload = function(){
           document.querySelector('#preview').src = reader.result ;
         }    
          
       }
          
    }
     $(document).ready(function(){
 
      $('#left_side_down a').click(function(){
        
        event.preventDefault();
        folder = $(this).attr('href');
        console.log(folder);
        if (confirm("작성중인 내용은 모두 사라집니다. 이동하시겠습니까?") == true){
        if(folder == 'list'){
          window.location.href = '/helloworld/gallery/list';
        }else if (folder == 'managingFolder'){
          window.location.href = '/helloworld/gallery/managingFolder';
        }
        else{
        var frm = $('#selectByFolder');
        frm.find('[name = "folder_name"]').val(folder);
        frm.attr('action' , 'list');
        frm.attr('method', 'get');
        frm.submit();
        }
       }else{
         return ;
       }
     });// select_folder
     
       
     }); //end document 
  
  
  </script>
  
</body>
</html>