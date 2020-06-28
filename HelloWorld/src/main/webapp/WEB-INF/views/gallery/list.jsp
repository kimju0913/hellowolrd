<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">
  *{
   margin: 0 auto; 
  }
  
  a{
  text-decoration: none;
  }
  
  #div_menu{
    width: 200px;
    height: 637px;
    float: left;
    border: 1px solid grey;
    margin-left: 50px;
  }
  
  #div_con{
   width:100%;
   height: 100%;   
  }
  

  
  #div_write{
    text-align: right;
  }
  ul{
    list-style-type: none;
  }
  
  ul li{
    display: inline-block;
  }
.menu_tool a:link {text-decoration: none; color: #DE9920;}
.menu_tool a:visited {text-decoration: none; color: #DE9920;}
.menu_tool a:hover{text-decoration: none; color: #F4AE72;}

 .btn_reply_update{
  background: url("${pageContext.request.contextPath}/resources/images/replyU.png" );
  width: 12px;
  height: 12px;
  border: 0 ; 
  padding: 0 ; 
  cursor: pointer;
 }
  .btn_reply_delete{
  background: url("${pageContext.request.contextPath}/resources/images/replyD.png" );
  width: 12px;
  height: 12px;
  border: 0 ; 
  padding: 0 ; 
  cursor: pointer;
 }
  .folder_img{
  background: url("${pageContext.request.contextPath}/resources/images/folder2.png" );
  width: 15px;
  height: 15px;
  border: 0 ; 
  padding: 0 ; 
  cursor: pointer;
 }
 .glreadyImg{
 
  background: url("${pageContext.request.contextPath}/resources/images/Imgready3.png" );
  width: 456px ;
  height : 137px ;
  text-align: center;
  margin-top : 150px;
  border: 0 ; 
 }
 
 body {
   padding: 15px 30px 15px 30px;
}

pre{
   font-size: 110%;
} 

</style>

<title>사진첩</title>
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>
  <div id = "div_all">
 
 <div id = "div_con" >
 <c:if test="${homeId==loginId }">
 <div id = "div_write">
   <a href = "register"><button>사진 업로드</button></a>
   </div> <!-- div write -->
 </c:if>  
  <div> 
 <!--    <br><br><br><br><br><br><br><br> --> 
  <!-- 조건문 넣어서 없을때 testImg  --> 
  <!-- 세션 받아서 ㄱㄱ -->
   <c:if test = "${empty glList }">
  <div class = "glreadyImg">
  </div>
  </c:if>
  
  <c:forEach var="vo" items="${glList }">
  
  
  <c:if test="${vo.gl_bno != null }">

    <form action = "update" method ="get" id = "frm">
    
    <input type= "text" id = "homeId" name = "userid" value = "${vo.userid }" hidden="hidden">
    <input type= "text" id = "user_name"  name = "user_name" value = "${vo.user_name }" hidden="hidden">
    <input type= "text" name = "gl_folder" value = "${vo.gl_folder }" hidden="hidden">
    <input type= "text" id = "gl_bno" name="gl_bno" value="${vo.gl_bno}" hidden = "hidden"  />
   <br>
    <hr>
    <div style = "background-color: #f1f3f5; text-align: center;">
    <b>${vo.gl_title }</b>
    </div>
    <input type="text" value="${vo.gl_title }" hidden = "hidden" />
    <hr>
   
    <div>
      <span style = "float: left;">${vo.user_name }</span>
    <fmt:formatDate value="${vo.gl_date }"
            pattern="yyyy-MM-dd HH:mm:ss"
            var="gl_date"/>
            <p style = "float:right;">${gl_date }</p>
    </div>
    <br>
    <br>
    
    <div>
    
    <c:if test = "${vo.gl_img == null }">
    <img src = "${pageContext.request.contextPath}/resources/images/Imgready.png" style = "width: 70%;">
    </c:if>
    
    <c:if test = "${vo.gl_img != null }">
    <img src = "display?fileName=${vo.gl_img }" style = "width: 60%;">
    </c:if>
    
    <br><br>
    <input type = "text"  value = "${vo.gl_content }"  hidden = "hidden" >
    <pre>${vo.gl_content }</pre>
    </div>
   
     <br>
     <br>
     <div class = "menu_tool">
     <c:if test="${homeId==loginId }">
     <a href = "#" style="float: right" onclick="button_delete(${vo.gl_bno})"> 삭제 </a>
     <a style= "float : right;"> &nbsp;|&nbsp;</a>
     <a href = "#" id = "btn_update" style= "float : right;" onclick = "button_update(${vo.gl_bno })"> 수정 </a>
     <a style= "float : right;"> &nbsp;|&nbsp;</a>
     </c:if>
     <a href = "#" style="float : right;" id = "reply"  onclick="getGalleryReply(${vo.gl_bno})">댓글</a>
     <br><br>
     </div>
     <div class = "reply_show ${vo.gl_bno }"  id ="${vo.gl_bno }"  style = "display: none; background-color: #f1f3f5; padding-bottom: 20px;">
        
        <div style=" float: left; height: 30px; padding: 5px 15px 5px 15px; ">
          <span >댓글</span>
          </div>
          <div style = "float:left">
          <textarea id = "gl_reply_content${vo.gl_bno }" style="width: 520px; height: 30px;  resize: none; overflow-y: auto;"></textarea>
          </div>
          <button id = "btn_reply_add ${vo.gl_bno}" style = "width: 40px; height: 36px; margin-left: 5px; font-size: 12px; " onclick = "reply_Add('${vo.gl_bno}')" > 확인 </button>
       <div id = "gl_reply${vo.gl_bno }"></div> 
        
        
     </div>    
   
    
   
    </form>
  </c:if>
  
  </c:forEach>
  
</div>

 <br>
 
   <div>
    <ul class = "pager">
      <c:if test = "${pageMaker.hasPrev }">
        <li> <a href = "${pageMaker.startPageNo -1 }">이전</a></li>
      </c:if>
      <c:forEach begin = "${pageMaker.startPageNo }" end = "${pageMaker.endPageNo }" var = "num">
        <li> <a href = "${num }">${num } |</a></li>
      </c:forEach>
      <c:if test = "${pageMaker.hasNext }">
        <li> <a href = "${pageMaker.endPageNo +1 }">다음</a></li>
      </c:if>
    </ul>
  </div>
  <div>
  
    <form id ="pagingForm" style = "display: none;">
      <input type = "text" name = "page" value = "${pageMaker.criteria.page }">
      <input type = "text" name = "perPage" value = "${pageMaker.criteria.numsPerPage }">
      <input type = "text" name = "folder_name" value = "${folder_name }">
      <input type = "text" name = "bno" >
    </form>
      </div>
      
   </div> <!-- div con -->
  
 </div> <!-- div all -->
 
 <script type="text/javascript">



   //댓글 입력 
   function reply_Add(bno){
      event.preventDefault();
      
    
      var inputbox ='#gl_reply_content' + bno;
      var gl_content = $(inputbox).val();
      
      if(gl_content == null || gl_content == ""){
        alert('한 글자 이상 입력해주세요.');
        return;
      }
      
    var content = gl_content; // 댓글 내용 값
    var obj = {
          'gl_bno' : bno,
        'gl_reply_content' : content,
   
      }; // end var obj
      
      // $.ajax로 송신
      $.ajax({
        type : 'post',
        url : '/helloworld/reply',
        headers : {
          'Content-Type' : 'application/json',
          'X-HTTP-Method-Override' : 'POST'
        },
        data : JSON.stringify(obj), 
        success : function(result){
          if (result == 1){
            alert('댓글 입력 성공');
            getGalleryReply(bno);
            var textClear = '#gl_reply_content' + bno;
            $(textClear).val('');
            var check_on_off = document.getElementById(bno);
            check_on_off.style.display = 'block';
            
          } // end if()
        } // end success
        
      }); // end ajax()
      
    } //end reply_Add
    
    
    function getGalleryReply(bno){
      var url =  '/helloworld/reply/all/' + bno;
      var loginId = '${loginId}';
      var check_on_off = document.getElementById(bno);
      if(check_on_off.style.display == 'none'){
        check_on_off.style.display = 'block';
      } else {
        check_on_off.style.display = 'none';
      } 
      
      var div = '';
      $.getJSON (
        url ,
        function(jsonData){
         
          var list = '';
          
          $(jsonData).each(
          function(){
            div = '';
            div = '#gl_reply' + this.gl_bno;
            var test = '';
            var userid = this.userid; 
            if(loginId == userid){
            test += '<button type = "button" id = "btn_reply_updateShow('+this.gl_rno+')" class = "btn_reply_update" onclick = "reply_showUpdate('+this.gl_rno +')" ></button>'
            + '&nbsp;'
            + '<button type = "button" id = "btn_reply_delete('+this.gl_rno+')" class = "btn_reply_delete" onclick = "reply_Delete('+this.gl_rno +',' +this.gl_bno+')" ></button>'
            }
            
            var reply_date = getFormatDate(new Date(this.gl_reply_date));
            
            list += '<div class="reply_item" id = "'+this.gl_bno+'">'
            + '<br>'
            + '<hr>'
            + '<pre>'
            + '<input type="hidden" id="gl_rno" value="' + this.gl_rno + '" /><br>'
            + '<input type="hidden" id="userid" value="' + this.userid + '" />'
            + '<a style = "font-size : 13px; ">'+this.user_name + ':'
            + '&nbsp;&nbsp;' 
            + this.gl_reply_content
            + '&nbsp;&nbsp;'
            + '('
              + reply_date
              + ')' + '</a>'
            + '&nbsp;&nbsp;'
            + test
            + '</pre>' 
            + '<pre id = "'+this.gl_rno+'" style = "display : none ;"> '
            + '<p><textarea  id = "gl_reply_content" style="resize: none; width: 434px;height: 12px">'+this.gl_reply_content+'</textarea>'
            + '&nbsp;'
            + '<button type = "button" id = "btn_reply_update('+this.gl_rno+')"   onclick = "reply_Update('+this.gl_rno +',' +this.gl_bno+')" >수정</button>'
            + '&nbsp;'
            + '<button type = "button" id = "btn_reply_cancel('+this.gl_rno+')"   onclick = "reply_showUpdate('+this.gl_rno +')">취소</button>'
            + '</p>'
            + '</pre>'
            +'</div>';
            
            $(div).html(list);
          })// end each
          
        }//end jsonData 
      
      )//end get JSON
      
    }//end GalleryReply
  
    function reply_showUpdate(rno){
    
      console.log(rno);
      
      var check_on_off_reply = document.getElementById(rno);
      
      if(check_on_off_reply.style.display == 'none'){
        check_on_off_reply.style.display = 'block';
      } else {
        check_on_off_reply.style.display = 'none';
      } 
      
    }
    
    function reply_Update(rno,bno){
      var bno = bno ; 
      var gl_reply_content = $('#gl_reply_content').val();
       $.ajax({
         type : 'put',
         url : '/helloworld/reply/' + rno,
         headers : {
            'Content-Type' : 'application/json',
            'X-HTTP-Method-Override' : 'PUT'
          },
          data : JSON.stringify({
           'gl_reply_content' : gl_reply_content
         }),
         success : function(result){
           if(result == 'success'){
           alert('댓글 수정성공');
           getGalleryReply(bno); 
            var check_on_off = document.getElementById(bno);
            check_on_off.style.display = 'block';
           } // end if()
         }// end success()
         
       }); // end ajax()
      
    }; //end update
 
    // 댓글 삭제 
    function reply_Delete(rno,bno){
      
      var gl_rno = rno ;
      var gl_bno = bno ;
      
      console.log(rno);
      console.log(bno);
      
       $.ajax({
         type : 'delete',
         url : '/helloworld/reply/' + rno,
         headers : {
            'Content-Type' : 'application/json',
            'X-HTTP-Method-Override' : 'DELETE'
          },
          data : JSON.stringify({
           'gl_rno' : gl_rno
         }),
         success : function(result){
           if(result == 'success'){
           alert('댓글 삭제성공');
           getGalleryReply(gl_bno); 
            var check_on_off = document.getElementById(gl_bno);
            check_on_off.style.display = 'block';
           } // end if()
         }// end success()
         
       }); // end ajax()
      
    }; //end delete

    
    function button_update(bno){
      var bno = bno;
      var frm = $('#frm');
      frm.find('[name = "gl_bno"]').val(bno);
      frm.attr('action' , 'update');
      frm.attr('method', 'get');
      frm.submit();
      
    }
      
    function button_delete(bno){
      var bno = bno;
      var frm = $('#frm');
      if (confirm("삭제 하시겠습니까?") == true){
      frm.attr('action' , 'delete');
      frm.attr('method', 'post');
      frm.submit();
    }else {
      return ;
      }
    } 
    
    function getFormatDate(date){
       var year = date.getFullYear();              //yyyy
       var month = (1 + date.getMonth());          //M
       month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
       var day = date.getDate();                   //d
       day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
       var hour = date.getHours();
       hour = hour >= 10 ? hour : '0' + hour;
       var min = date.getMinutes();
       min = min >= 10 ? min : '0' + min;
       return  year + '-' + month + '-' + day + ' ' + hour + ':' + min;
   }
    
  $(document).ready(function(){


    var folder;
    
    if('${insert_result}' === 'success'){
      alert('글 작성 성공')
    }else if('${insert_result}'=== 'fail'){
      alert('글 작성 실패')
    }else if ('${update_result}' === 'success'){
      alert('글 수정 성공')
    }else if ('${delete_result}' === 'success'){
      alert('글 삭제 성공')
    };
    
    $('#div_menu a').click(function(){
    
       event.preventDefault();
       folder = $(this).attr('href');
       console.log(folder);
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
    });// select_folder
    
    
    $('.pager li a').click(function(){ 
      event.preventDefault(); 
      var targetPage = $(this).attr('href');
      console.log(targetPage);
      var frm = $('#pagingForm'); 
      
      frm.find('[name ="page"]').val(targetPage);
      frm.attr('action','list'); 
      frm.attr('method','get'); 
    frm.submit();
      
    });//end click

 
    
    
  });//end document
  </script>
  
</body>
</html>