<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mnewsale.20210918.css">
<script src="resources/myLib/jquery-3.2.1.min.js"></script>
</head>
<body>
<div id="wrap">
	<div id="header" role="banner">
		<div class="member_header">
			<div class="hd">
				<a href="home" class="hd_logo">MANDU</a>
			</div>
		</div>
	</div>
	<div id="container">
	<form action="newsaleinsert" method="post" enctype="multipart/form-data">
		<div class="sale_container">
			<h2>New Item</h2>
			<hr>
			<div class="sale_head">
				<div class="item_head">
					<div class="item_title">
						<h3>Title</h3>
					</div>
					<div class="item_title1">
						<input type="text" name="itemTitle" class="input_title" maxlength="49">
					</div>
				</div>
				<div class="item_head">
					<div class="item_title">
						<h3>Price</h3>
					</div>
					<div class="item_title1">
						<input type= "number" name="itemPrice" class="input_price" maxlength="15">
					</div>
				</div>
				<div class="item_head">
					<div class="item_title">
						<h3>Stock</h3>
					</div>
					<div class="item_title1">
						<input type= "number" name="itemCount" class="input_stock" maxlength="7">
					</div>
				</div>
				<div class="item_head">
					<div class="item_title">
						<h3>Type</h3>
					</div>
					<div class="item_title1">
						<select name="itemType">
							<option value="fashion">Fashion</option>
							<option value="food">Food</option>
							<option value="life">Life</option>
							<option value="digital">Digital</option>
							<option value="furniture">Furniture</option>
						</select>
					</div>
				</div>
			</div>
			<div class="sale_body">
				<div class="item_content">
					<div class="item_title">
						<h3>Content</h3>
					</div>
					<div class="item_title1">
						<textarea class="input_content" name="itemContent" maxlength="300"></textarea>
					</div>
				</div>
				<div class="item_content">
					<div class="item_title">
						<h3>Image</h3>
					</div>
					<div class="item_title1">
						<img src="" class="select_img"><br>
						<input type="file" name="itemImagef" id="itemImagef">
						<script>
							$('#itemImagef').change(function(){
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
			</div>
		</div>
		<div class="sale_foot">
			<div class="button_area">
				<button type="submit" id="btnUpdate" class="btn_type">
					<span>Update</span>
				</button>
			</div>
		</div>
		<hr>
	</form>	
	</div>
</div>
</body>
</html>