<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mjoin.20210916.css">
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
<script src="resources/myLib/onCheck.js"></script>
<script>
function idOK(){
	opener.$('#id').val('${newID}');
	opener.document.getElementById('submit').disabled='';
	//opener.$('#submit').prop('disabled',false);
	opener.document.getElementById('idDup').disabled='disabled';
	opener.$('#id').prop('readonly',true);
	opener.$('#password').focus();

	self.close();
}//idOK
</script>
<style>
   body {
      background: #E6E6FA;
      font-family: 맑은고딕;
   }
   #checkbox {
      margin-left: 0;
      text-align: center;
   }
   h3 {
      color: #00008B; 
   }
</style>
</head>
<body>
<div id="checkbox">
	<h3>Check E-mail</h3>
	<form action="emailCheck" method="post">
		E-mail : 
		<input type="text" id="id" name="id">&nbsp;
		<input type="submit" value="check" onclick="return emailCheck()"><br>
		<span id="imessage" class="eMessage"></span>
	</form>
	<br><br><hr><br>
	<div id="msgBlock">
		<c:if test="${idUse=='T'}">
			${newID} can be used.
			<input type="button" value="idOK" onclick="idOK()">
<!-- 			사용자가 입력한 id를 사용가능하도록 해주고, 현재 창은 close -->
		</c:if>
		<c:if test="${idUse=='F'}">
			${newID} already exists.
<!-- 			사용자가 입력한 id를 지워주고, 현재 창의 id에 포커스를 준다 -->
			<script>
				$('#id').focus();
				opener.document.getElementById('id').value='';		
			</script>
		</c:if>
	</div>
</div>
</body>
</html>