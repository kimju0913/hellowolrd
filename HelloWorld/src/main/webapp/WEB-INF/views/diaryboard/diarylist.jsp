<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>

<html>
<head>

<style type="text/css">
li {
  display: inline-block;
}

ul {
  list-style-type: none;
}

/* 화면 전체   */
#div_all {
  
  width: auto;
  height: auto;
}

/* 본문 부분  */
#div_diary {
  margin: 20px auto;
  overflow-y: auto;
  width: 90%;
  padding:15px 15px;
 
  border: 2px solid #e2e2e2;
  border-radius: 2px;

}

/* 글 보여지는 부분 */
#div_content {
  width: 590px;
  height: 155px;
}

#div_content_text {
  width: 600px;
  height: 280px;
  border: 1px solid grey;
}

#lbl_d_date{
  color: #4582b4;
   font-weight: bold;
}

a:link {
  
  text-decoration: none;
}

#div_insertContent {
 margin-left : 640px;
}

.btn_update, .btn_delete, .btn_reply {
  float: right;
}



#selectByFolder, #All_folder {
  color: black;
}

.reply_show {
  float: left;
}

.btn_reply_Add {
  float: right;
}

.btn_reply_update {
  background:
    url("${pageContext.request.contextPath}/resources/images/update.png" );
  width: 12px;
  height: 12px;
  border: 0;
  padding: 0;
  cursor: pointer;
}

.btn_reply_delete {
  background:
    url("${pageContext.request.contextPath}/resources/images/delete.png" );
  width: 12px;
  height: 12px;
  border: 0;
  padding: 0;
  cursor: pointer;
}

.folder_img {
  background:
    url("${pageContext.request.contextPath}/resources/images/folder.png" );
  width: 15px;
  height: 15px;
  border: 0;
  padding: 0;
  cursor: pointer;
}

input[type="date"]::-webkit-calendar-picker-indicator, input[type="date"]::-webkit-inner-spin-button
  {
  display: none;
  appearance: none;
}

.ui-datepicker-trigger {
  cursor: pointer;
}

.ui-datepicker-calendar>tbody td.ui-datepicker-week-end:first-child a {
  color: red;
}

.ui-datepicker-calendar>tbody td.ui-datepicker-week-end:last-child a {
  color: blue;
}

#replies a:link {text-decoration: none; color: #DE9920;}
#replies a:visited {text-decoration: none; color: #DE9920;}
#replies a:hover{text-decoration: none; color: #F4AE72;}

.ntreadyImg{
 
  background: url("${pageContext.request.contextPath}/resources/images/ntReady.png" );
  width: 455px ;
  height : 137px ;
  text-align: center;
  margin-top : 140px;
  margin-left : 170px;
  border: 0 ; 
  
 }
  
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
  href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>





<meta charset="UTF-8">
<title>다이어리</title>
</head>


<body>



  <div id="div_all">
    <!-- 보내주는 역할 -->
    <!-- 본문 내용(다이어리)이 나오는 부분 -->
     <c:if test="${homeId==loginId }">
     <div id="div_insertContent">
      <a href="diaryregister"><input type="button" value="글작성" style="float: right; margin-right: 20px;"></a>
     </div>
     </c:if>
    <br>
    
       <c:if test = "${empty diary_board  }">
       <div class = "ntreadyImg">
       </div>
      </c:if>
    
    <c:forEach var="vo" items="${diary_board }">
    <div id="div_diary">
      

        <form id="frm_date${vo.d_date }">
          <fmt:formatDate value="${vo.d_date }" pattern="yyyy-MM-dd E"
            var="d_date1" />
          <fmt:formatDate value="${vo.d_date }" pattern="HH:mm"
            var="d_date2" />
          <fmt:formatDate value="${vo.d_date }" pattern="E"
            var="d_date3" />
          <div id="date_color">
          <label id = "lbl_d_date">${d_date1} ${d_date2}</label></div>
          <br>
          <!-- 쓴 글 본문 들어가는 곳 -->
          <div id="div_content">
            <pre>${vo.d_content }</pre>
          </div>
        </form>
        <!-- date form -->


        <div>
          <form class="frm_update" style="display: none">
            <input type="text" name="d_bno">
          </form>
          <form class="frm_delete" style="display: none">
            <input type="text" name="d_bno">
          </form>
        </div>


        <div id="replies" style="text-align: center;">
          <hr>
           <c:if test="${homeId==loginId }">
          <a class="btn_delete" href="${vo.d_bno }" style="float: right"> 삭제 </a>
          <a style= "float : right;"> &nbsp;|&nbsp;</a>
          <a class="btn_update" href="${vo.d_bno }" style="float: right"> 수정</a> 
          <a style= "float : right;"> &nbsp;|&nbsp;</a>
          </c:if>
          <a class="btn_reply" href="#" id="replies__" onclick="getReply_content(${vo.d_bno})">댓글 </a>

        </div>
        <!-- replies -->

      
        <br><br>
        <div class="reply_show ${vo.d_bno }" id="${vo.d_bno }"
          style="display: none; width : 100%;">
          <button type="button" class="btn_reply_Add"
            id="btn_reply_Add${vo.d_bno}"
            onclick="reply_Add(${vo.d_bno})">작성</button>
          <pre>댓글 <textarea
              id="reply_content${vo.d_bno}"
              style="width: 510px; height: 15px; resize: none;"></textarea>
             </pre>

      
          <div id="d_reply${vo.d_bno }"></div>
          </div>
        <!-- div_content_text -->


        <br>
       
     
      
      </div>
       </c:forEach>

      <!-- 페이징 처리 부분  -->
      
      <div>
        <ul class="pager">
          <c:if test="${pageMaker.hasPrev }">
            <li><a href="${pageMaker.startPageNo - 1}">이전</a></li>
          </c:if>
          <c:forEach begin="${pageMaker.startPageNo }"
            end="${pageMaker.endPageNo }" var="num">
            <li><a href="${num }">${num } |</a></li>
          </c:forEach>
          <c:if test="${pageMaker.hasNext }">
            <li><a href="${pageMaker.endPageNo + 1}">다음</a></li>
          </c:if>
        </ul>
      </div>

      <div>
        <form id="pagingForm" style="display: none;">
          <input type="text" name="page"
            value="${pageMaker.criteria.page }"> <input
            type="text" name="perPage"
            value="${pageMaker.criteria.numsPerPage }"> <input
            type="text" name="folder_name" value="${folder }"> <input
            type="text" name="d_bno"> <input type="text"
            name="d_date" value="${d_date }">
        </form>
        <!--from_pagingForm  -->
      </div>
      <!-- div_pagingForm -->
    
   
  </div>
  <!-- div_all -->



  <script type="text/javascript">
  
      // * 댓글 처리 부분
      // 댓글 입력 기능
       function reply_Add(d_bno) { 
        
        var inputbox = '#reply_content' + d_bno;
        var d_reply_content = $(inputbox).val();
       
        if(d_reply_content == null || d_reply_content == ""){
          alert('댓글 내용을 작성하세요.');
          return;
        }

        var obj = {
          'd_bno' : d_bno,
          'd_reply_content' : d_reply_content,
        };// end obj 

        // $.ajax
        $.ajax({
          type : 'post',
          url : '/helloworld/replies',
          headers : {
            'Content-Type' : 'application/json',
            'X-HTTP-Method-Override' : 'POST'
          },
          data : JSON.stringify(obj), // JSon -> 문자열 
          success : function(result) {
            console.log(result);
            if (result == 1) {
              alert('댓글 입력 성공');
              getReply_content(d_bno);
              $(inputbox).val('');
              var check_on_off = document.getElementById(d_bno);
              check_on_off.style.display = 'block';
             
            } // end if
          } // end function(reulst)
        }); // end $.ajax
      };  // end btn_reply_add
      
      
      
      // 게시판 댓글 전체 가져오기
      function getReply_content(d_bno) {
        console.log(d_bno);
        var div = '';
        var url = '/helloworld/replies/all/' + d_bno;
        var loginId = '${loginId}';
        
        var check_on_off = document.getElementById(d_bno);
        if (check_on_off.style.display == 'none') {
          check_on_off.style.display = 'block';
        } else {
          check_on_off.style.display = 'none';
        }

        // $.getJSON(url, data, callback)
     $.getJSON(
       url,
        function(jsonData) {
         console.log(jsonData);
          var list = '';
           $(jsonData).each(
            function() {
              
              div += "#d_reply" + this.d_bno + "";
              var test = '';
              var userid = this.userid; 
              if(loginId == userid){
              test += '<button type = "button" id = "btn_reply_updateShow('+ this.d_rno + ')" class = "btn_reply_update" onclick = "reply_showUpdate(' + this.d_rno + ')" ></button>'
              + '&nbsp;'
              + '<button type = "button" id = "btn_reply_delete('+this.d_rno+')" class = "btn_reply_delete" onclick = "reply_Delete('+this.d_rno +',' +this.d_bno+')" ></button>'
              }
              
              var date = getFormatDate(new Date(this.d_reply_date));
              
              list += '<div class =  id="' + this.d_bno + '">'
              + '<pre>'
              + '<input type="hidden" id="d_rno" value="' + this.d_rno + '" />'
              + '<input type="hidden" id="userid" value="' + this.userid + '" />'
              + this.user_name + ':'
              + '&nbsp;&nbsp;' // 공백
              +  this.d_reply_content
              + '&nbsp;&nbsp;' // 공백     
              + '('
              + date
              + ')'
              + '&nbsp;&nbsp;'  // 공백   
              + test
              + '<hr>'
              + '</pre>' 
              + '<pre id = "'+ this.d_rno + '" style = "display : none ;"> '
              + '<textarea  id = "d_reply_content" style=" resize: none; width: 434px;height: 12px">'+ this.d_reply_content + '</textarea>'                              
              + '&nbsp;'
              + '<button type = "button" id = "btn_reply_update(' + this.d_rno + ')" onclick = "reply_Update(' + this.d_rno + ',' + this.d_bno + ')" >수정</button>'
              + '&nbsp;'
              + '<button type = "button" id = "btn_reply_cancel(' + this.d_rno + ')" onclick = "reply_showUpdate(' + this.d_rno + ')">취소</button>'
              + '</pre>'
              +'</div>';
              
             }); // end each()
          $(div).html(list);
         } // end jsonData
       ); // end getJSON
     }// end getReply_content() 

     
     
     function reply_showUpdate(d_rno){
       console.log(d_rno);
       var check_on_off_reply = document.getElementById(d_rno);
       if(check_on_off_reply.style.display == 'none'){
         check_on_off_reply.style.display = 'block';
       } else {
         check_on_off_reply.style.display = 'none';
       } 
       
     } // end reply_showUpdate()
     
     
       // **** 수정 , 삭제 *****
       // 댓글 수정 버튼
       function reply_Update(d_rno, d_bno){
      var d_bno = d_bno ; 
      var d_reply_content = $('#d_reply_content').val();
       $.ajax({
         type : 'put',
         url : '/helloworld/replies/' + d_rno,
         headers : {
            'Content-Type' : 'application/json',
            'X-HTTP-Method-Override' : 'PUT'
          },
          data : JSON.stringify({
           'd_reply_content' : d_reply_content
         }),
         success : function(result){
           if(result == 'success'){
           alert('댓글 수정성공');
           getReply_content(d_bno); //
            var check_on_off = document.getElementById(d_bno);
            check_on_off.style.display = 'block';
         
           } // end if()
         }// end success()
       }); // end ajax()
    }; //end update
    
    // 댓글 삭제 
    function reply_Delete(d_rno, d_bno){
      var d_rno = d_rno ;
      var d_bno = d_bno ;
       $.ajax({
         type : 'delete',
         url : '/helloworld/replies/' + d_rno,
         headers : {
            'Content-Type' : 'application/json',
            'X-HTTP-Method-Override' : 'DELETE'
          },
          data : JSON.stringify({
           'd_rno' : d_rno
         }),
         success : function(result){
           if(result == 'success'){
           alert('댓글 삭제성공');
           getReply_content(d_bno); 
            var check_on_off = document.getElementById(d_bno);
            check_on_off.style.display = 'block';
         
           } // end if()
         }// end success()
       }); // end ajax()
  	  }; //end delete
      
        
        // 날짜
        function getFormatDate(date){
          var year = date.getFullYear();              //yyyy 년도
          var month = (1 + date.getMonth());          //M    
          month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
          
          var day = date.getDate();                   //d
          day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
          
          var hour = date.getHours();                 // 시, 
          hour = hour >= 10 ? hour : '0' + hour;
          
          var min = date.getMinutes();               // 분
          min = min >= 10 ? min : '0' + min;
          
          return  year + '-' + month + '-' + day + ' ' + hour + ':' + min;
      } // end getFormatDate(date)
        
        // document
        $(document).ready(function() {
          var folder;
         
          // 수정 페이지로 
          $('.btn_update').click(function() {
            event.preventDefault();
            var d_bno = $(this).attr('href');
            var frm_update = $('.frm_update');
            frm_update.attr('action', 'diaryupdate');
            frm_update.attr('method', 'get');
            frm_update.find('[name="d_bno"]').val(d_bno);
            frm_update.submit();
          }); // end btn_update()
          
          
          // 삭제 삭제
          $('.btn_delete').click(function() {
            event.preventDefault();
            var d_bno = $(this).attr('href');
            var frm_delete = $('.frm_delete');
            frm_delete.attr('action', 'diarydelete');
            frm_delete.attr('method', 'post');
            frm_delete.find('[name="d_bno"]').val(d_bno);

            var delConfirm = confirm('삭제하시겠습니까?');
            if (delConfirm) {
              alert('삭제 되었습니다.');
              frm_delete.submit();
            } else {
              alert('삭제가 취소 되었습니다.');
              return;
            }
          }); // end btn_delete()
          
          
       

        
        // 클릭한 a태그의 정보를 가져오는 코드
        $('.pager li a').click(function() {
          // .pager 클래스의 하위 li 요소의 하위 a 요소를 찾아감
          event.preventDefault(); // a 태그의 기본 동작(페이지 이동)을 금지
          var targetPage = $(this).attr('href');
         
          console.log(targetPage);
          
          var frm_pagingForm = $('#pagingForm'); // form의 정보를 frm에 저장
          frm_pagingForm.find('[name="page"]').val(targetPage);
          frm_pagingForm.attr('action', 'diarylist'); // form에 action 속성 추가
          frm_pagingForm.attr('method', 'get'); // form에 method 속성 추가
          frm_pagingForm.submit(); // form 데이터 전송
          
        }); // end click()

        // register에서 넘어온 insert_result 데이터를 바탕으로 alert 처리
        if ('${insert_result}' === 'success') {
          alert('새 글 작성 완료');
        } else if ('${insert_result}' === 'fail') {
          alert('새 글 작성 실패');
        }

        // update 완료 alert
        if ('${update_result}' == 'success') {
          alert('글 수정 완료');
        } else if ('${update_result}' == 'fail') {
          alert('글 수정 실패');
        }
     
        
      }); // end document
        
      
    </script>



</body>
</html>



