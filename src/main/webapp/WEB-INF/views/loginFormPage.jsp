 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mlogin.20210915.css">
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
<script src="resources/myLib/onCheck.js"></script>
<script>
//1) 전역변수 정의
var eCheck=false;
var pCheck=false;
//2) 무결성 점검
$(function(){
	$('#id').focus();
	$('#id').focusout(function(){
		eCheck=emailCheck();
	});
	$('#password').focusout(function(){
		pCheck=passwordCheck();
	});
});
//3) submit 처리
function inCheck(){
	if(eCheck==false){
		$('#eMessage').html('Please enter your E-mail');
	}
	if(pCheck==false){
		$('#pMessage').html('Please enter your password');
	}
	if(eCheck && pCheck){
		return true;
	}else return false;
}
</script>
</head>
<body>
<div class="s_login">
	<h1 class="s_login_logo logo_mandu">
		<a href="home">
			<img src="resources/image/Mandu.PNG" width="100" height="80">Mandu Login
		</a>
	</h1>
	<form action="login" method="post">
		<div class="login_form">
			<div class="login_input">
				<input type="text" name="id" id="id" 
				class="inp" placeholder="ID">
				<span id="eMessage" class="eMessage">
					<c:if test="${emessage != null}">${emessage}</c:if>
				</span>
			</div>
			<div class="login_input">
				<input type="password" name="password" id="password" 
				class="inp" placeholder="Password">
				<span id="pMessage" class="eMessage">
					<c:if test="${pmessage != null}">${pmessage}</c:if>
				</span>
			</div>
			<button type="submit" id="loginbutton" name="loginbutton"
			class="btn_Atype" onclick="return inCheck()">
				<span>Sign In</span>
			</button>
			<div class="login_find">
				<a href="">find ID</a>
				<a href="">find Password</a>
			</div>
			<p class="l_join">
				<a href="joinform">Sign Up</a>
			</p>
		</div>
	</form>
</div>
</body>
</html>