<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="resources/myLib/mseller.20210917.css">

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
		<div class="sale_container">
			<div>
				<h1 class="sale_header">Sale Details</h1>
				<h3 class="sale_header1"><a href="profile">My Mandu</a></h3>
				<hr>
				<div class="sale_content">
					<table class="details_table">
						<thead>
							<tr>
								<th>Date</th>
								<th>Item</th>
								<th>Buyer</th>
								<th>Amount</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="date"></td>
								<td class="item"></td>
								<td class="buyer"></td>
								<td class="amount"></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		<div class="sale_container">
			<div>
				<h1 class="sale_header">My Item</h1>
				<div class="sale_new">
					<a href="newsale" class="sale_new_link">New Sale</a>
				</div>
				<hr>
				<div class="sale_content">
					<div class="slide" style="width: 1024px; margin-right: 29px; display: inline-block; white-space: normal;">
						<ul>
							<c:forEach var="list" items="${SaleList}">
							<li>
								<div class="b_card">
									<a href="saledetail?itemNo=${list.itemNo}">
										<div class="card_image">
											<img src="${list.itemImage}" width="180px" height="120px">
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
				<nav class="sale_page">
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
	</div>
</div>
</body>
</html>