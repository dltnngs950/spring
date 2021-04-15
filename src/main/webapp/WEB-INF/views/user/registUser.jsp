<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">

   <meta name="description" content="">
   <meta name="author" content="">

   <title>allUser</title>

   <%@ include file="../common/common_lib.jsp" %>
   
<!--    <script src="/js/jquery/jquery-1.12.4.js"></script> -->
   <link href="${cp}/css/dashboard.css" rel="stylesheet">
   <link href="${cp}/css/blog.css" rel="stylesheet">
   
   <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script> 
   <script>
     	
      $(function(){	  
         $('#addrBtn').on('click',function(){        
             new daum.Postcode({
                 oncomplete: function(data) {
                     // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
                     // 예제를 참고하여 다양한 활용법을 확인해 보세요.
   
                     $('#addr1').val(data.roadAddress);   // 도로주소
                     $('#zipcode').val(data.zonecode);      // 우편번호
                     
                     // 사용자 편의성을 위해 상세주소 입력 input 태그로 focus 설정
                     $('#addr2').focus();
                 }
             }).open();
         })       
       })        
   </script>
   
</head>

<body>

   <%@ include file="../common/header.jsp" %>
<%--    spring Message : <spring:message> --%>
   
   <nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>

   <div class="container-fluid">
      <div class="row">
         <div class="col-sm-3 col-md-2 sidebar">
            <%@ include file="../common/left.jsp" %>
         </div>
         
         <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
     
            <form class="form-horizontal" id="sendfrm" role="form" 
            	action="${cp}/user/registUser" method="POST"
            							  enctype="multipart/form-data">
            	 
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
                  <div class="col-sm-8">
	                    <input type="text" class="form-control" id="userid" name="userid" 
	                      	   placeholder="사용자 아이디" value="${param.userid }"/>
	                      	   
	                      	  <span style="color:red;">*<form:errors path="userVo.userid" /></span>
	                      	  
	                  	<input type="file" class="form-control" name="profile" />
                  </div>
               </div>

               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="usernm" name="usernm" 
                     placeholder="사용자 이름" value="${param.usernm }"/>
                  </div>
               </div>
                  
                 <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">비밀번호</label>
                  <div class="col-sm-8">
                     <input type="password" class="form-control" id="pass" name="pass" 
                     placeholder="비밀번호" value="${param.pass }"/>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="userNm" class="col-sm-2 control-label">별명</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="alias" name="alias" 
                     placeholder="별명" value="${param.alias }"/>
                  </div>
               </div>
                            
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">도로주소</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="addr1" name="addr1" 
                     placeholder="도로주소" value="${param.addr1 }" readonly/>
                  </div>
                  <div class="col-sm-2">
                     <button type="button" id="addrBtn"class="btn btn-default">주소검색</button>
                  </div>
               </div>
               
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">상세주소</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="addr2" name="addr2" 
                     placeholder="상세주소" value="${param.addr2 }"/>
                  </div>
               </div>
               <div class="form-group">
                  <label for="pass" class="col-sm-2 control-label">우편번호</label>
                  <div class="col-sm-8">
                     <input type="text" class="form-control" id="zipcode" name="zipcode" 
                     placeholder="우편번호" value="${param.zipcode }" readonly/>
                  </div>
               </div>
             

               <div class="form-group">
                  <div class="col-sm-offset-2 col-sm-10">
                     <button type="submit" class="btn btn-default" id="registBtn">등록</button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </div>
</body>
</html>