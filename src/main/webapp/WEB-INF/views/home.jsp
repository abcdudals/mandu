<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
	<title>MANDU</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mmain.20210909.css">
<script src="resources/myLib/jquery-3.2.1.min.js"></script>

</head>
<body>
<div id="wrap">
	<div id="header" role="banner">
		<div class="special_bg">
			<div class="group_flex">
				<div class="logo_area">
					<h1 class="logo_img">
						<a href="home">
							<img src="resources/image/Mandu.PNG" width="130" height="104">
						</a>
					</h1>
				</div>
				<div id="search" class="search_area">
					<form id="sform" name="sform" action="searchlist" method="get" role="search">
						<fieldset>
							<div class="black_window">
								<input type="text" name="keyword" id="keyword" class="input_text" maxlength="255">
							</div>
							<button id="searchBtn" type="submit" title="검색" 
							tabindex="3" class="btn_submit" >
							</button>
						</fieldset>
					</form>
				</div>
				<div id="account" class="sc_login">
				</div>
			</div>
		</div>
		<div id="categori">
			<div id="favorite" class="categori_inner">
				<div class="group_nav">
					<ul class="list_nav favorite_list">
						<li class="nav_item">
							<a href="category?itemType=fashion" class="nav">Fashion</a>
						</li>
						<li class="nav_item">
							<a href="category?itemType=food" class="nav">Food</a>
						</li>
						<li class="nav_item">
							<a href="category?itemType=life" class="nav">Life</a>
						</li>
						<li class="nav_item">
							<a href="category?itemType=digital" class="nav">Digital</a>
						</li>
						<li class="nav_item">
							<a href="category?itemType=furniture" class="nav">Furniture</a>
						</li>
					</ul>
				</div>
				<c:if test="${loginID==null}">
					<div id="account" class="sc_login_join">
						<a href="loginform" class="link_login_join">Sign In</a>
						<a href="joinform" class="link_login_join">Sign Up</a>
					</div>
				</c:if>
				<c:if test="${loginID!=null}">
					<div id="account" class="sc_login_join">
						<span>${loginName}</span>
						<a href="profile" class="link_login_join">My Mandu</a>
						<a href="logout" class="link_login_join">Sign Out</a>
					</div>
				</c:if>
			</div>
		</div>
	</div>
	<div id="container" role="main">
		<div class="b_main_board">
			<img src="resources/image/background2.png" align="middle">
		</div>
		<div class="b_main_list">
			<div class="b_list_title">
				<h2>인기상품</h2>
			</div>
			<div class="b_list_card">
				<div class="swiper-container">
					<div class="slide" style="width: 1240px; margin-right: 29px; display: inline-block; white-space: normal;">
						<ul>
							<c:forEach var="list" items="${HomeSaleList}">
							<li>
								<div class="b_card">
									<a href="item?itemNo=${list.itemNo}">
										<div class="card_image">
											<img src="${list.itemImage}" width="360px" height="250px">
										</div>
										<div class="card_content">
											<div class="card_title">
												<p>${list.itemTitle}</p>
											</div>
											<div class="card_number">
												<span>
													<strong class="strong_number"><fmt:formatNumber value="${list.itemPrice}"/></strong>원
												</span>
											</div>
											<div class="card_number">
												<span>
													재고 <strong class="strong_number"><fmt:formatNumber value="${list.itemCount}"/></strong>개
												</span>
											</div>
										</div>
									</a>
								</div>
							</li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<nav class="b_list_page">
				<div class="list">
					<ul>
						<li>
							<button type="button">1</button>
						</li>
						<li>
							<button type="button">2</button>
						</li>
						<li>
							<button type="button">3</button>
						</li>
						<li>
							<button type="button">4</button>
						</li>
						<li>
							<button type="button">5</button>
						</li>
						<li>
							<button type="button">6</button>
						</li>
					</ul>
					<div class="navigator">
						<button type="button" class="previous"></button>
						<button type="button" class="next"></button>
					</div>
				</div>
			</nav>
		</div>
	</div>
	<div id="footer" role="contentinfo">
	</div>
</div>
</body>
</html>
