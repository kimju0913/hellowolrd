<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %> 
<!DOCTYPE html>
<html>
<head>
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
   width:620px;
   height: 400px;
   float: left;
   overflow-x: auto;
   overflow-y: auto;
   background-color: #e2e2e2;
   padding:20px 20px 10px 20px;
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
  padding: 15px 30px 15px 30px ;
 }
 
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
  <div id = "div_all">
  
    
  <form id="frm" enctype="multipart/form-data" >
  <div id = "div_con" >
    <br>
    <input type = "text" name = "gl_bno" value = "${galleryBoardVO.gl_bno }" hidden="hidden">
    <input type = "text" name = "folder_name" value = "${galleryBoardVO.gl_folder }" hidden = "hidden">
      <div style = "background-color: #f1f3f5; text-align: center;">
      <input type ="text" name = "gl_title" value = "${galleryBoardVO.gl_title }"  maxlength="20" style = "background-color: #f1f3f5; ">
    </div>
    
    <div>
      <span style = "float: left;">${galleryBoardVO.user_name }</span>
    <fmt:formatDate value="${galleryBoardVO.gl_date }"
            pattern="yyyy-MM-dd HH:mm:ss"
            var="gl_date"/>
            <p style = "float:right;">작성 시간 : ${gl_date }</p>
    </div>
    
    <br><br>
    <select name = "gl_folder">
     <c:forEach var = "folder" items="${folderList}">
      <option >${folder}</option>
     </c:forEach> 
    </select>
    <br>
    <input type = "file" name = "file" id = "file" accept='image/jpeg,image/gif,image/png' onchange='chk_file_type(this)'>
    <div id = "PREVIEW_IMG_DIV" >
      <input type = text name = "gl_img" value = "${galleryBoardVO.gl_img }" hidden="hidden"/>
      <img id = "PREVIEW_IMG" src = "display?fileName=${galleryBoardVO.gl_img }" style = "width: 70%;"/>
    </div>
    <br>
    
    <textarea rows="10" cols="80" name = "gl_content" maxlength="100" style = "resize: none;">${galleryBoardVO.gl_content }</textarea><br><br>
  
  <button type="button" id="btn_update" style = "float: right;">수정</button>
   <a href = "list"><button type = "button" style = "float: left;" >목록</button></a>
  </div>
  </form>
 
  </div>
  <script type="text/javascript">
  
  
    function chk_file_type(obj) {

          var file_kind = obj.value.lastIndexOf('.');

          var file_name = obj.value.substring(file_kind+1,obj.length);

          var file_type = file_name.toLowerCase();

          var check_file_type=new Array();

          check_file_type=['jpg','gif','png','jpeg','bmp','tif'];



          if(check_file_type.indexOf(file_type)==-1) {

             alert('이미지 파일만 업로드 가능합니다');

             var parent_Obj=obj.parentNode;

             var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);



             document.getElementById("file").value = "";    //초기화를 위한 추가 코드

             document.getElementById("file").select();      //초기화를 위한 추가 코드


             return false;

          } else {
             
           var file = document.querySelector('#file');

              var fileList = file.files ;
              
              // 읽기
              var reader = new FileReader();
              reader.readAsDataURL(fileList [0]);

              //로드 한 후
              reader.onload = function  () {
                  //로컬 이미지를 보여주기
                  document.querySelector('#PREVIEW_IMG').src = reader.result;
                  
                  //썸네일 이미지 생성
                  var tempImage = new Image(); //drawImage 메서드에 넣기 위해 이미지 객체화
                  tempImage.src = reader.result; //data-uri를 이미지 객체에 주입
                  tempImage.onload = function() {
                      //리사이즈를 위해 캔버스 객체 생성
                      var canvas = document.createElement('canvas');
                      var canvasContext = canvas.getContext("2d");
                      
                      //캔버스 크기 설정
                      canvas.width = 100; //가로 100px
                      canvas.height = 100; //세로 100px
                      
                      //이미지를 캔버스에 그리기
                      canvasContext.drawImage(this, 0, 0, 100, 100);
                      //캔버스에 그린 이미지를 다시 data-uri 형태로 변환
                      var dataURI = canvas.toDataURL("image/jpeg");
                    
                  };
              }; 
            
          }

       }    
   
    
   

    
  $(document).ready(function(){
    var frm = $('#frm');
    
    $('#btn_update').click(function(){
      frm.attr('action' , 'update');
      frm.attr('method', 'post');
      frm.submit();
    });//end update

    
    $('#div_menu a').click(function(){
      
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
    
    
    
  });//end document
  
  </script>
</body>
</html>