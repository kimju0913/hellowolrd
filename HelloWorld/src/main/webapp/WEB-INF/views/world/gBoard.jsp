<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<style type="text/css">
ul {
   list-style-type: none;
}

ul li {
   display: inline-block;
}

ol {
   list-style: none;
   padding-inline-start: 10px;
}

ol li {
   background:
      url("${pageContext.request.contextPath}/resources/images/folder2.png")
      left center no-repeat;
   list-style-position: inside;
   padding-left: 20px;
}

.boardsize {
   border-style: solid;
   border-width: 1px;
   text-align: center;
}

.guestboard {
   height: 300px;
   width: 720px;
   background-color: white;
}

.guestboardInput {
   height: 200px;
   width: 720px;
   background-color: #f1f3f6;
   border-top: 1px solid grey;
   border-bottom: 1px solid grey;
   margin-bottom: 10px;
}

.contentBox {
   width: 720;
   float: left;
   margin-left: 15px;
}

.preContent {
   font-size: 110%;
   height: 150px;
   float: left;
}

.contentdiv {
   float: none;
}

.replyBox {
   width: 719px;
   padding: 15px 3px;
   float: left;
   background-color: #f1f3f5;
}

.img_wrap img {
   width: 100px;
   height: 120px;
   border: 1px solid grey;
   margin: 15px 10px;
}

.content1 {
   padding-top: 10px;
   margin-top: 10px;
   width: 480px;
   height: 100px;
   float: none;
   display: none;
   resize: none;
}

#guestboardAlert {
   width: 719px;
   height: 25px;
   border-top: 1px solid grey;
   background-color: #f1f3f5;
   padding-top: 5px;
   float: left;
}
#guestboardAlert_s {
   width: 719px;
   height: 25px;
   border-top: 1px solid #ffe485;
   background-color: #ffe485;
   padding-top: 5px;
   float: left;
}

#gbInfoWrapper {
   width: 250px;
   float: left;
   height: 25px;
}

#gbfunctionWrapper {
   width: 100px;
   height: 24px;
   float: right;
   margin-right: 20px;
}

#contentWrapper {
   width: 500px;
   float: left;
   margin: 0px 15px;
}

#photoWrapper {
   width: 129px;
   height: 149px;
   float: left;
   margin-left: 10px;
}

#inputReplyWrapper {
   width: 719px;
   height: 25px;
}

#profile {
   border: 1px solid black;
   float: left;
   width: 100px;
   height: 100px;
}

#g_content {
   margin-top: 15px;
   margin-left: 10px;
   width: 400px;
   height: 100px;
   float: none;
}

#aDate {
   font-size: 80%;
   color: grey;
}

#aBno {
   font-size: 80%;
   margin-left: 15px;
   margin-right: 0px;
}

#aName {
   color: #000080;
}

#g_bno {
   font-size: 90%;
}

#btn_add {
   float: right;
   margin-right: 15px;
}

#gbInfoWrapper a {
   margin-right: 10px;
}

#gbfunctionWrapper a:hover {
   cursor: pointer;
}
 .gbreadyImg{
 
  background: url("${pageContext.request.contextPath}/resources/images/gbReady.png" );
  width: 455px ;
  height : 137px ;
  text-align: center;
  margin-top : 170px;
  margin-left : 170px;
  border: 0 ; 
  
 }
#secret_a {
  color :#ff7f00 ;
  font-size: 85%;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!-- 작성  -->
   
  <c:if test ="${empty guestlist }">
   <c:if test = "${homeId eq loginId }"> 
  <div class = "gbreadyImg">
  </div>
  </c:if>
  </c:if> 
   <c:if test="${homeId ne loginId }">
   <div class="guestboardInput">
      <form action="gbRegister" method="POST">
         <div style="float: left; height: 25px; width: 720px">
            <div style="float: right; margin-right: 15px">
               <input type="checkbox" name="g_secret" id="g_secret" value="Y"><a>비밀글</a>
            </div>
         </div>
         <div id="photoWrapper">
            <div class="img_wrap">
               <img id="img" src="displayFile?fileName=/${loginvo.user_photo }">
               
            </div>
         </div>
         <div>
            <textarea id="g_content" name="g_content"
               style="width: 500px; height: 118px; resize: none;"></textarea>
         </div>


         <input type="submit" id="btn_add" value="작성 ">
      </form>
   </div>
	</c:if>



   <!------------------------------------------------------------------->
   <div id="guest">
   <c:set var="countBoard" value = "${gbtotalCnt }"></c:set>
      <c:forEach var="vo" items="${guestlist }" varStatus="status">
         <fmt:formatDate value="${vo.g_date }" pattern="yyyy.MM.dd HH:mm"
            var="date" />
         <br>
         <div class="guestboard">
           <c:if test="${vo.g_secret == 'Y' }">
            <div id="guestboardAlert_s">
          
               <div id="gbInfoWrapper">
                  <a id="aBno">NO.</a><a id="g_bno">${countBoard} </a> <a
                     id="aName"> ${vo.user_name}</a> <a id="aDate">(${date })</a>
               </div>
               <div id="gbfunctionWrapper">
                  <c:if test="${loginId == vo.userid}">
                     <a id="delect" onclick="deletegb('${vo.g_bno}')">삭제</a> |
                  <a class="btnupdate" onclick="update('${vo.g_bno}')">수정</a>
                  </c:if>
               </div>
            </div>
            </c:if>
            <c:if test="${vo.g_secret == 'N' }">
            <div id="guestboardAlert">
          
               <div id="gbInfoWrapper">
                  <a id="aBno">NO.</a><a id="g_bno">${countBoard} </a> <a
                     id="aName"> ${vo.user_name}</a> <a id="aDate">(${date })</a>
               </div>
               <div id="gbfunctionWrapper">
                  <c:if test="${loginId == vo.userid}">
                     <a id="delect" onclick="deletegb('${vo.g_bno}')">삭제</a> |
                  <a class="btnupdate" onclick="update('${vo.g_bno}')">수정</a>
                  </c:if>
               </div>
            </div>
            </c:if>

            <div class="contentBox">
               <div id="photoWrapper">

                  <c:choose>
                     <c:when test="${vo.user_photo != null  }">

                        <div class="img_wrap">
                           <img id="img" src="displayFile?fileName=/${vo.user_photo }" />
                        </div>

                     </c:when>
                     <c:otherwise>
                        <div class="img_wrap">
                           <img id="img" src="displayFile?fileName=/notphoto.png">
                        </div>

                     </c:otherwise>
                  </c:choose>
               </div>

               <div id="contentWrapper">



                  <c:choose>
                     <c:when test="${vo.g_secret == 'Y' }">
                        <c:choose>

                           <c:when test="${vo.userid == loginId || homeId == loginId}">
                           <img src = "${pageContext.request.contextPath}/resources/images/secret_a.PNG" style = "width: 20px; height: 18px;  margin-top: 12px;"> <a id = "secret_a"><b>비밀이야</b>(이 글은 홈 주인과 작성자만 볼 수 있어요.)</a>
                              <pre class="preContent" id="preContent${vo.g_bno }">${vo.g_content }
                              </pre>

                              <textarea class="content1" id="updateBox${vo.g_bno }">${vo.g_content }</textarea>
                           </c:when>
                           <c:otherwise>
                            <img src = "${pageContext.request.contextPath}/resources/images/secret_a.PNG" style = "width: 20px; height: 18px;  margin-top: 12px;"><a id = "secret_a"><b>비밀이야</b>(이 글은 홈 주인과 작성자만 볼 수 있어요.)</a>
                              <pre class="preContent" id="preContent${vo.g_bno }">비밀글 입니다.
                              </pre>
                              <textarea class="content1" id="updateBox${vo.g_bno }">${vo.g_content }</textarea>
                           </c:otherwise>

                        </c:choose>
                     </c:when>
                     <c:otherwise>
                        <pre class="preContent" id="preContent${vo.g_bno }">${vo.g_content } 
                        </pre>
                        <textarea class="content1" id="updateBox${vo.g_bno }">${vo.g_content }</textarea>
                     </c:otherwise>
                  </c:choose>

               </div>


            </div>
            <!-- contentBox -->


            
               <div class="replyBox">
                 <c:if test="${homeId ==loginId }">
                  <div id="inputReplyWrapper">
                     <input
                        style="width: 620px; height: 22px; resize: none; float: left"
                        class ="replyupdateBox" id="replyupdateBox${vo.g_bno }" >
                  
                     <button class ="replyupdate" onclick="replyupdate(${vo.g_bno})" style="float: left; margin-left: 10px;">
                     확인</button>
                  </div>
				</c:if>

                  <c:if test="${vo.g_reply != null}">
                  <br><div style="float: left;"> ${homevo.user_name} : ${vo.g_reply}</div> 
               	  </c:if>
               </div>
            

         </div>
      <c:set var = "countBoard" value="${countBoard-1 }"></c:set>
      </c:forEach>
   </div>
   
     <div id = "paging">

     <ul class = "pager">
     
      <c:if test = "${maker.hasPrev }">
         <li><a href = "${maker.startPageNo - 1 }">◀</a> </li> 
      </c:if>
      
      <c:forEach begin = "${maker.startPageNo }" end = "${maker.endPageNo }" var = "num">
         <li><a href = "${num }"> ${num } | </a></li>
      </c:forEach>
      <c:if test = "${maker.hasNext }">
         <li><a href = "${maker.endPageNo + 1 }">▶</a></li>
      </c:if>   
     </ul> 
  </div>
  
    <div>
  
    <form id ="pagingForm" style = "display: none;">
      <input type = "text" name = "page" value = "${pageMaker.criteria.page }">
      <input type = "text" name = "perPage" value = "${pageMaker.criteria.numsPerPage }">
    </form>
      </div>

   <script type="text/javascript">
      var g_bno = "";

      function update(bno) {
         var updateBox = '#updateBox' + bno;
         var preContent = '#preContent' + bno;

         g_bno = bno;
         $(updateBox).css('display', 'block');
         $(preContent).css('display', 'none');
      }

      $("#guest").on("click", ".guestboard .btnupdate ", function() {

         $(this).html('저장');
         $(this).attr("class", "saveupdate");
         $(this).attr("onclick", "saveUpdate(${vo.g_bno})");

      });

      function saveUpdate(bno) {
         var preContent = '#updateBox' + g_bno;
         var content = $(preContent).val();
         console.log("test " + g_bno);

         $.ajax({
            url : '/helloworld/world/' + g_bno,
            type : 'put',
            headers : {
               'Content-Type' : 'application/json',
               'X-HTTP-Method-Override' : 'POST'
            },
            data : JSON.stringify({
               'g_content' : content
            }),
            success : function(result) {
               if (result == 'success') {
                  alert('방명록 수정성공');
                  location.reload();
               } // end if()
            }// end success()
         });

      }// end saveUPdate
      function replyupdate(g_bno) {
         
           
               var replyto  ='#replyupdateBox'+g_bno
            var reply = $(replyto).val() ;
            
            console.log("test " + g_bno);
            console.log("test " + reply);
            $.ajax({
               url : '/helloworld/world/reply',
               type : 'put',
               headers : {
                  'Content-Type' : 'application/json',
                  'X-HTTP-Method-Override' : 'POST'
               },
               data : JSON.stringify({
                  'g_bno' : g_bno ,
                  'g_reply' : reply
               }),
               success : function(result) {
                  if (result == 'success') {
                     alert('댓글 작성 성공 ');
                     location.reload();
                  } // end if()
               }// end success()
      
            });
         
         
         
         
      }
      
	 function deletegb(bno){
    	  
    	  var deleteCheck = confirm('방명록을 삭제하시겠습니까?')
    	  
    	  if(deleteCheck){
    	  $.ajax({
              url : '/helloworld/world/' + bno,
              type : 'delete',
              headers : {
                 'Content-Type' : 'application/json',
                 'X-HTTP-Method-Override' : 'DELETE'
              },
              data : JSON.stringify({
                 g_bno : bno
              }),
              success : function(result) {
                 if (result == 'success') {
                    alert('방명록 삭제 성공');
                    location.reload();
                 } // end if()
              }// end success()
           });
    	  }
      }
      

      $(document).ready(function() {
         $('.pager li a').click(function(){
            
              event.preventDefault();
              var targetPage = $(this).attr('href');
              console.log(targetPage);
              var frm = $('#pagingForm');
              frm.find('[name = "page"]').val(targetPage);
              frm.attr('action','gBoard');
              frm.attr('method', 'get');
              
              frm.submit();
           }); // end pager clicked
         
         
         

         $("#guest").on("click", ".guestboard .saveupdate", function() {
            console.log("세이브 체크");
            var g_bno = $('#g_bno').text();
            var g_content = $('.content1').val();

            console.log(this);
            console.log(g_bno);
            console.log(g_content);
            //ajax

         });

         $("#guest").on("click", ".guestboard #delect", function() {
            console.log(this);
            var g_bno = $('#g_bno').text();

            console.log(g_bno);

         }); // end btn_delte.click()


         $("#guest").on("click", ".guestboard #reply_btn", function() {
             
         }); // end btn_delte.click()
         
      });
   </script>













</body>
</html>