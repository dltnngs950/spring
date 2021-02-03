<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title>Signin Template for Bootstrap</title>

<!--     Bootstrap core CSS -->
<%--     <link href="${cp}/css/bootstrap.min.css" rel="stylesheet"> --%>
	<%@ include file="../views/common/common_lib.jsp" %>
	<%-- common_lib.jsp의 내용을 지금 기술되는 부분에 코드를 복사해서 붙여넣기 --%>
	
	<script src="https://cdn.jsdelivr.net/npm/js-cookie@rc/dist/js.cookie.min.js"></script>
	
    <!-- Custom styles for this template -->
    <link href="${cp}/css/signin.css" rel="stylesheet">

    <script>
    
    <c:if test="${msg != null }">
    	alert("${msg}" + "ra");
    </c:if>
    	
	// html 문서 로딩이 완료 되고 나서 실행되는 코드    		
    $(function(){
    	// userid, rememberme 쿠키를 확인하여 존재할 경우 값 설정, 체크
    	if(Cookies.get("userid") != undefined){
			$("#userid").val(Cookies.get("userid"));
			$("#rememberme").prop("checked", true);
		}
    	
    	// signin 아이디를 select
    	$("#signin").on("click", function(){
    		// rememeberme 체크박스가 체크 되어있는지 확인
    		// 체크되어있을 경우
    		if($("#rememberme").is(":checked") == true){
    			// userid input에 있는 값을 userid쿠키로 저장
    			Cookies.set("userid", $("#userid").val());
    			// rememberme 쿠키로 Y 값을 저장
    			Cookies.set("rememberme", "Y");
    			
    		}
    		
    		// 체크 해제되어 있는 경우 : 더 이상 사용하지 않는다는 의미 이므로 userid, rememberme 쿠키 삭제
    		else{
    			Cookies.remove("userid");
    			Cookies.remove("rememberme");
    		}
    		// form태그를 이용해서 signin 요청
    		$("#frm").submit();
    		
    	})
    	
    })
    	
    </script>
  </head>

  <body>

    <div class="container">

      <form id="frm" class="form-signin" action="/login/process" method="post">
        
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="text" class="form-control" placeholder="사용자 아이디" 
        			id="userid"	name ="userid" value="brown" required autofocus>
        				
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="사용자 비밀번호" 
        			name="pass" value="brownPass" required>
        			
        <div class="checkbox">
        
          <label>
            <input type="checkbox" id="rememberme" value="remember-me"> Remember me
          </label>
          
        </div>
        
        <button class="btn btn-lg btn-primary btn-block" type="button" id="signin">Sign in</button>
      </form>

    </div> <!-- /container -->

  </body>
</html>
