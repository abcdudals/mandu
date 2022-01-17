<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mitem.20211004.css">
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
			<div class="left_content">
				<div class="item_image">
					<img src="${HomeItem.itemImage}" width="400px" height="400px">
				</div>
			</div>
			<div class="right_content">
				<div class="item_title">
					<span class="title_text">${HomeItem.itemTitle}</span>
				</div>
				<div class="item_price">
					<span class="item_text">
						<strong class="strong_num"><fmt:formatNumber value="${HomeItem.itemPrice}"/></strong>원
					</span>
				</div>
				<div class="item_count">
					<span class="item_text">
						재고 <strong class="strong_num"><fmt:formatNumber value="${HomeItem.itemCount}"/></strong>개
					</span>
				</div>
				<div class="item_seller">
					<span class="item_text">
						Type: ${HomeItem.itemType}
					</span>
				</div>
				<div class="item_seller">
					<span class="item_text">
						Seller: ${HomeItemName.name}
					</span>
				</div>
				<div class="button_area">
				<a href="basketinsert?itemNo=${HomeItem.itemNo}" id="btnUpdate" class="btn_type">
					<span>Basket</span>
				</a>
				</div>
			</div>
		</div>
		<div class="bottom_content">
			<div class="item_content">
				<span>${HomeItem.itemContent}</span>
			</div>
		</div>
	</div>
	<div id="footer">
	
	</div>
</div>
</body>
</html>