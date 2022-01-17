function emailCheck(){
	var id=$('#id').val();
	if (id.replace(/[@]/,'').length >= id.length){
		$('#eMessage').html('Only email address can be entered');
		return false;
	} else {
		$('#eMessage').html('');
		return true;
	}
}//emailCheck

function passwordCheck(){
	var password=$('#password').val();
	if (password.length<8) {
		$('#pMessage').html('Please enter 8 or more characters');
		return false;
	}else if (password.replace(/[!-*]/gi,'').length >= password.length ) {
		$('#pMessage').html('It must contain a digit character');
		return false;
	}else if (password.replace(/[a-z.0-9.!-*]/gi,'').length > 0) {
		$('#pMessage').html('Please enter English, number and digit character');
		return false;
	}else {
		$('#pMessage').html('');
		return true;
	}
}//passwordCheck

function password2Check(){
	var password2=$('#password2').val();
	var password=$('#password').val();
	if (password2!=password) {
		$('#p2Message').html('Please enter the same password');
		return false;
	}else {
		$('#p2Message').html('');
		return true;
	}
}//password2Check

function nameCheck(){
	var name=$('#name').val() ;
	if (name.length<2) {
		$('#nMessage').html('Please enter 2 or more characters');
		return false;
	}else if (name.replace(/[a-z.가-힣.0-9]/gi,'').length > 0) {
		$('#nMessage').html('Can not enter digit character');
		return false;
	}else {
		$('#nMessage').html('');
		return true;
	}	
}//nameCheck