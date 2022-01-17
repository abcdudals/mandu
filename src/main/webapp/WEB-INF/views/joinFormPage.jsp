<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mandu: Sign Up</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mjoin.20210916.css">
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
<script src="resources/myLib/onCheck.js"></script>
<script>
//1) 전역변수
var eCheck=false;
var pCheck=false;
var p2Check=false;
var nCheck=false;
//2) 무결성 점검
$(function(){
	$('#id').focus();
	$('#id').focusout(function(){
		eCheck=emailCheck();
	});
	$('#password').focusout(function(){
		pCheck=passwordCheck();
	});
	$('#password2').focusout(function(){
		p2Check=password2Check();
	});
	$('#name').focusout(function(){
		nCheck=nameCheck();
	});
});
//3) submit 처리
function inCheck(){
	if(eCheck==false){
		$('#eMessage').html('Please enter email');
	}
	if(pCheck==false){
		$('#pMessage').html('Please enter password');
	}
	if(p2Check==false){
		$('#p2Message').html('Please enter password');
	}
	if(nCheck==false){
		$('#nMessage').html('Please enter name');
	}
	if(eCheck && pCheck && p2Check && nCheck){
		alert('Sign Up is completed');
		return true;
	}
	else alert('Problem'); return false;
}
//4) Email Check
function emailDupCheck(){
	if(eCheck==false){
		eCheck=emailCheck();
	}else{
		var url="emailCheck?id="+$('#id').val();
		window.open(url,"_blank",
				"toolbar=no,menubar=yes,scrollbars=yes,resizable=yes,width=300,height=200");
	}
}//emailDupCheck

</script>
</head>
<body>
<div id="wrap">
	<div id="header" class="join_membership" role="banner">
		<a href="home" class="h_logo">
			<img src="resources/image/Mandu.PNG" width="100" height="80">
		</a>
	</div>
	<form action="join" id="join_form" method="post" enctype="multipart/form-data">
		<div id="container" role="main">
			<div id="content">
				<div class="join_content">
					<div class="row_group">
						<div class="join_row">
							<h3 class="join_title">
								<label for="id">E-mail</label>
							</h3>
							<span class="join_box int_id">
								<input type="text" id="id" name="id" 
								class="int" title="e-mail" maxlength="50">
								<span id="eMessage" class="eMessage"></span>
							</span>
							<span class="int_email">
								<input type="button" value="Check" id="idDup" 
								onclick="emailDupCheck()" class="int_idDup">
							</span>
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="pswd1">Password</label>
							</h3>
							<span class="join_box int_pass" id="pswd1Img">
								<input type="password" id="password" name="password" 
								class="int" title="password" maxlength="20">
								<span id="pMessage" class="eMessage"></span>
							</span>
							<h3 class="join_title">
								<label for="pswd2">Check Password</label>
							</h3>
							<span class="join_box int_pass_check" id="pswd2Img">
								<input type="password" id="password2" name="password2" 
								class="int" title="check password" maxlength="20">
								<span id="p2Message" class="eMessage"></span>
							</span>
						</div>
						<div class="join_row">
							<h3 class="join_title">
								<label for="name">Name</label>
							</h3>
							<span class="join_box int_name">
								<input type="text" id="name" name="name" 
								class="int" title="name" maxlength="20">
								<span id="nMessage" class="eMessage"></span>
							</span>
							<h3 class="join_title">
								<label for="idimg">Image</label>
							</h3>
							<img src="" class="select_img"><br>
							<input type="file" name="myImagef" id="myImagef">
							<script>
								$('#myImagef').change(function(){
									if(this.files && this.files[0]) {
										var reader = new FileReader;
							 				reader.onload = function(e) {
						 					$(".select_img").attr("src", e.target.result)
						 						.width(70).height(70); 
						 					} // onload_function
						 					reader.readAsDataURL(this.files[0]);
						 			} // if
								}); // change	
							</script>
						</div>
					</div>
					<div class="btn_area">
						<button type="submit" class="btn_type" 
						onclick="return inCheck()" disabled id="submit">
							<span>Sign Up</span>
						</button>
					</div>					
				</div>
			</div>
		</div>
	</form>
</div>
</body>
</html>