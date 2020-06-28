<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
.pp {
  margin: 5px 0px;
}

.pb {
  font-size: 120%;
  font-weight: bold;
}

.lblmemberName {
  float: left;
  font-size: 150%;
  font-weight: bold;
  margin: 25px 20px;
}

.imgBtn {
  margin-right: 10px;
}

.searchTitleName {
  float: left;
  font-size: 150%;
  font-weight: bold;
  margin: 25px 20px;
}

#mainpageMain {
  width: 620px;
  height: 100%;
  margin: 30px auto;
  text-align: center;
}

#btnSearch {
  border-style: none;
  position: relative;
  float: right;
  margin: 5px 5px;
  background-color: white;
}

#btnApplyFrd {
  font-size: 110%;
  background-color: white;
  width: 100px;
  color: #ff6f6b;
  float: left;
  margin-top: 5px;
  margin-right: 20px;
  border: 2px solid #ff6f6b;
  border-radius: 10px;
}

#btnUpdateFrd {
  font-size: 90%;
  background-color: white;
  width: 100px;
  height : 30px;
  color: #ff6f6b;
  float: left;
  margin-top: 5px;
  margin-right: 20px;
  border: 2px solid #ff6f6b;
  border-radius: 10px;
}

#btntest {
  font-size: 110%;
  background-color: white;
  width: 100px;
  color: #ff6f6b;
  float: left;
  margin-top: 5px;
  border: 2px solid #ff6f6b;
  border-radius: 10px;
}

#seachMainWrapper {
  width: 520px;
  padding: 8px;
}

#searchInputWrapper {
  width: 590px;
  height: 45px;
  background-color: white;
  border: 3px solid #ff6f6b;
  border-radius: 10px;
  padding: 5px;
}

#memberWrapper {
  width: 600px;
  height: 80px;
  border-radius: 40px;
  background-color: white;
  margin: 20px 4px;
  box-shadow: 3px 3px 3px grey;
}

#memberBtnWrapper {
  width: 120px;
  margin-top: 4px;
  margin-right: 20px;
  float: right;
}

#pInfoWrapper {
  width: 100px;
  height: 60px;
  margin: 20px 5px;
  float: left;
}

#searchInput {
  width: 430px;
  height: 35px;
  border-style: none;
  position: relative;
  margin: 5px 5px;
  float: left;
}

#searchType {
  height: 35px;
  margin: 5px 5px;
  border-radius: 5px;
  float: left;
}

#imgmemberProfile {
  float: left;
  margin: 4px 15px;
}

p {
  margin: 2px 20px 5px;
  color: grey;
  font-family: Batang;
}

body {
  height: 100%;
  background-color: #fafafa;
}

header {
  background-color: #ff6f6b;
  height: 90px;
}

button:hover {
  cursor: pointer;
}

#imgheaderlogo:hover {
  cursor: pointer;
}
</style>
<title>사람 찾기</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

</head>
<%@ include file="/resources/import/subheader.jspf"%>

<body>
  <!-- 친구 찾기 페이지 -->

  <div id="mainpageMain">
    <div id="logoWrapper">
      <img id="imgheaderlogo"
        src="${pageContext.request.contextPath}/resources/images/logo2.png">
    </div>
    <h1>사람 찾기</h1>


    <div id="seachMainWrapper">
      <div id="searchInputWrapper">
        <select id="searchType" name="searchType">
          <option value="type">검색조건</option>
          <option value="user_name">이름</option>
          <option value="user_phone">전화번호</option>
        </select> <input type="text" id="searchInput" placeholder="이름 또는 휴대전화 입력">
        <button type="button" id="btnSearch">
          <img id="imgMagnifier"
            src="${pageContext.request.contextPath}/resources/images/magnifier.png">
        </button>
      </div>
      <div id="searchFail">
        <c:if test="${empty memberList && memberList != vo.user_name}">
        <div style="margin-left: 50px;">
          [ 찾으시는 정보가 <a style="color: red; font-weight: bold; ">존재하지 않습니다.</a> ]
        </div>
        <c:if test="${idList == vo.userid }">
          </c:if>
        </c:if>
      </div>

      <div id="searchProfile">
        <c:if test="${empty memberList}">
          <img id="searchTitle"
            style="margin-left: 50px; margin-top: 25px;"
            src="${pageContext.request.contextPath}/resources/images/logoIcon.png">
          <label class="searchTitleName"
            style="text-align: center; margin-left: 130px;">${loginName }님,
            무엇을 찾으시나요?</label>
        </c:if>
      </div>
      <div id="mainWrapper">
        <c:forEach var="vo" items="${memberList }">
          
          <div id="memberWrapper">
            <!--////////작업중  -->
            <img id="imgmemberProfile"
              src="${pageContext.request.contextPath}/resources/images/tempProfile.png">
            <label id="lblmemberName" class="lblmemberName">${vo.user_name }</label>
            <div id="pInfoWrapper">
              <p>${vo.user_birth }</p>
              <p>${vo.user_state }</p>
            </div>
            <div id="memberBtnWrapper">
              <c:set var="contain" value="false"></c:set>
              <c:forEach var="idList" items="${frIdList }">
                <c:if test="${idList == vo.userid }">
                  <c:set var="contain" value="true"></c:set>
                </c:if>
              </c:forEach>
              <c:if test="${contain eq 'true' }">
                <button id="btnUpdateFrd"
                  onclick="goToChangeNickFrd('${vo.userid}','${vo.user_name }')">일촌명
                  변경</button>
                <Br>
              </c:if>
              <c:if test="${contain eq 'false' }">
                <button id="btnApplyFrd"
                  onclick="goToRequestFrd('${vo.userid}','${vo.user_name }')">일촌신청</button>
                <Br>
              </c:if>
              <button id="btntest" onclick="goHompie('${vo.userid}')">미니홈피</button>
            </div>


          </div>
          <!-- end memberWrapper -->
        </c:forEach>
      </div>


      <form id="frmRequestFrd" style="display: none">
        <input name="get_userid"> <input name="get_user_name">
      </form>

    </div>
    <!-- end SearchMainWrap -->

  </div>


  <script type="text/javascript">
  		
  	
  function goHompie(userid){
    window.open('/helloworld/world/mini-home-page?homeId=' + userid, 'title',
    'width=1200, height=720');
 
   }
  		
   
      function goToRequestFrd(getId, getName) {

        var child = "child";
        var frm = $('#frmRequestFrd');
        frm.attr('target', child);
        window.open("", child, "width=550px, height=480px");
        frm.find('[name="get_userid"]').val(getId);
        frm.find('[name="get_user_name"]').val(getName);
        frm.attr('action', "requestPage");
        frm.attr('method', 'get');
        frm.submit();
       

      }; // end goToRequestFrd

      function goToChangeNickFrd(getId, getName) {

        var child = "child";
        var frm = $('#frmRequestFrd');
        frm.attr('target', child);
        window.open("", child, "width=550px, height=480px");
        frm.find('[name="get_userid"]').val(getId);
        frm.find('[name="get_user_name"]').val(getName);
        frm.attr('action', "requestChangePage");
        frm.attr('method', 'get');
        frm.submit();

      }; // end goToChangeNickFrd
      
     
      
      $(document).ready(function() {
        
        $('#btnGoHompie').click(function() {
          var frm = $('#frmGoHompie');
          frm.submit();
        });

        $('#imgheaderlogo').click(function() {
          location.href = "/helloworld";
        });

        $('#btnRcmFrd').click(function() {
          location.href = "/helloworld/main/appliedFrd";

        });

        $('#btnFriends').click(function() {
          location.href = "/helloworld/main/managingFrd";

        });

      $('#btnSearch').click(function() {

          var name = $('#searchInput').val();
          var test = $('#searchType').val();
          if (name == null || name == '') {
            alert('검색조건 및 내용을 입력하세요! ');
            
          } else if (test == "type") {
            
            alert('검색조건 및 내용을 입력하세요! ');
            $("#searchInput").val("");
   
          }
        });

        $('#searchType').change(function() {
          var menu = $(this).val();
          var searchProfile = $('#searchProfile');
          searchProfile.css("display", "block");
          console.log(menu);
          if (menu == "user_name") {
            $('#btnSearch').click(function() {
              console.log("클릭 셀렛 이름 ");
              var name = $('#searchInput').val();
              location = '/helloworld/main/searchFrd?user_name=' + name;
             
              if(name == null || name == ''){
                location = '/helloworld/main/searchFrd';
              }
            });
         

          } else if (menu == "user_phone") {
            $('#btnSearch').click(function() {
              console.log("클릭 셀렛 폰");
              var phone = $('#searchInput').val();
              
              location = '/helloworld/main/searchFrd?user_phone=' + phone;
              if(phone == null || phone == ''){
                location = '/helloworld/main/searchFrd';
                
              }
            });
          }

        }); // end dearchType change
        
      }); //end document.ready

      // 검색 기능 추가
    </script>




</body>
</html>