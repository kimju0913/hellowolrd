<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대문 사진 변경</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style type="text/css">
#mainWrapper {
  width: 294px;
  height: 349px;
  background: #4582b4;
  padding: 6px;
}

#innerWrapper {
  width: 260px;
  height: 320px;
  background: white;
  margin: 13px 13px;
  border-radius: 4px;
  padding: 5px;
  text-align: center;
}

#headWrapper {
  width: 250px;
  height: 30px;
  float: left;
}

#contentWrapper {
  width: 250px;
  height: 280px;
  float: left;
}

#buttonWrapper {
  width: 100px;
  height: 25px;
  float: right;
  margin-top: 15px;
}

#inputProfile {
  width: 170px;
  height: 150px;
  resize: none;
}

button {
  border: 1px solid grey;
  background-color: white;
  border-radius: 3px;
  width: 40px;
  height: 25px;
}

button:hover {
  background-color: #504E48;
  color: white;
  cursor: pointer;
}
</style>
</head>
<body>
  <div id="mainWrapper">
    <div id="innerWrapper">
      <div id="headWrapper">
        <h4>미니홈피 대문 사진 변경</h4>
      </div>

      <div id="contentWrapper">
        <br>
        <div id="PREVIEW_IMG_DIV">
          <img id="preview" src = "display?fileName=${vo.profile_photo}"  width="176px" height="156px" >
         
        </div>
        
        <br> 
        <form id = "frm" enctype="multipart/form-data">
        <input type="file" name="file" id="file"
          required="required" accept='image/jpeg,image/gif,image/png'
          onchange='chk_file_type(this)'>
         <input type = "text"  name = "profile_photo" value = "${vo.profile_photo }" hidden= "hidden">
         </form>
        <div id="buttonWrapper">
          <input type ="button" id="btnUpdate" value = "수정">
          <input type = "button" id="btnCancle" value = "취소">
        </div>
      </div>
    </div>
  </div>

  <script type="text/javascript">
      function chk_file_type(obj) {

        var file_kind = obj.value.lastIndexOf('.');

        var file_name = obj.value.substring(file_kind + 1, obj.length);

        var file_type = file_name.toLowerCase();

        var check_file_type = new Array();

        check_file_type = [ 'jpg', 'gif', 'png', 'jpeg', 'bmp', 'tif' ];

        var file = document.querySelector('#file');

        if (check_file_type.indexOf(file_type) == -1) {

          alert('이미지 파일만 업로드 가능합니다');

          var parent_Obj = obj.parentNode;

          var node = parent_Obj.replaceChild(obj.cloneNode(true), obj);

          document.getElementById("file").value = ""; //초기화를 위한 추가 코드

          document.getElementById("file").select(); //초기화를 위한 추가 코드

          return false;

        } else {
          //else 파일 미리보기 실행 .
          var fileList = file.files;

          // 읽기
          var reader = new FileReader();
          reader.readAsDataURL(fileList[0]);

          //로드 한 후
          reader.onload = function() {
            document.querySelector('#preview').src = reader.result;
          }

        }

      }

      $(document).ready(function() {
		
       var frm = $('#frm');
      
        
        $('#btnUpdate').click(function() {
    		    var form = $('#frm');
       			var formData = new FormData(form[0]);
       			
       			
    			 $.ajax({
    				type : 'post',
    				url : '/helloworld/worldRest/profPhoto',
    				data : formData,
    				processData : false,
    				contentType : false,
    				/*
    					form의 enctype 속성을 
    					기본값인 "application/x-www-form-urlencoded"을 사용하지 않고 
    					"multipart/form-data"를 사용하기 위해 (contenType : false)를 지정
    				
    				*/
    				success : function(data) {
    				    opener.location.reload();
		  			    window.close();
    				}
    			});
           		
        });

        $('#btnCancle').click(function() {
	          window.close();
        }); //end btnCancle

      });
    </script>
</body>
</html>