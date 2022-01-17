<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mprofile.20210916.css">
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
		<div class="account_container">
			<div>
				<h1 class="account_header">Account</h1>
				<div class="header_box">
					<a class="box_link" href="seller">
					Seller
					</a>
					<a class="box_link" href="consumer">
					Consumer
					</a>
				</div>
				<hr>
				<div class="account_content">
					<header class="content_header">
						<h2 class="heading">My Account</h2>
					</header>
					<section class="content_body">
						<div class="body_account">
							<div class="account_section">
								<div class="account_section_item section_email">
									${ManduPerson.id}
								</div>
								<div class="account_section_item">
									${ManduPerson.password}
								</div>
								<div class="account_section_item">
									${ManduPerson.name}
								</div>
								<div class="account_section_item">
									<img src="${ManduPerson.myImage}" width="100" height="100">
								</div>
							</div>
							<div class="account_section">
								<div class="account_section_item">
									<a class="account_section_link" href="">
									change e-mail
									</a>
								</div>
								<div class="account_section_item">
									<a class="account_section_link" href="">
									change password
									</a>
								</div>
								<div class="account_section_item">
									<a class="account_section_link" href="">
									change name
									</a>
								</div>
								<div class="account_section_item">
									<a class="account_section_link" href="">
									change image
									</a>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>	
		</div>
		<div class="account_section_remove">
			<hr>
			<a class="account_section_link" href="mdelete">
			Remove Account
			</a>
			<c:if test="${message != null}"><br><br>&nbsp;&nbsp;<h3 align="right" style="color: red">${message}</h3></c:if>
		<div>
	</div>
</div>
</body>
</html>