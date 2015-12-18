<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your orders</title>


<link href="resources/assets/myorders/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/myorders/css/myorders.css" rel="stylesheet">


</head>

<body>

	<div id="rootwizard">
		<ul>
			<li><a href="#past_orders" data-toggle="tab">Past Orders</a></li>
			<li><a href="#open_orders" data-toggle="tab">Open Orders</a></li>
			<li><a href="#cancelled_orders" data-toggle="tab">Cancelled
					Orders</a></li>

		</ul>
		<div class="tab-content">
			<div class="tab-pane" id="past_orders">

				<!--  accordion content starts -->
				<c:forEach var="order" items="${deliveredOrders}">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#${order.orderId}" aria-expanded="true"
									aria-controls="collapseOne"> ${order.orderId}</a>
							</h4>
						</div>
						<div id="${order.orderId}" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								Delivered Date : ${order.deliveredDate} <br />
								<c:forEach items="${order.items}" var="item">
									<table class="order_items_table">
										<tr>
											<td><img height="75" width="75" src="${item.image}" /></td>
											<td>${item.productName}</td>
											<td>${item.totalSoldPrice}</td>
											<td>${item.quantity}<c:if test="${item.quantity == 1}">&nbsp;no</c:if>
												<c:if test="${item.quantity > 1}">&nbsp;nos</c:if></td>
											<c:if
												test="${item.returnStatus.equals('DISPLAY_RETURN_LINK')}">
												<td><div id="return_div">
														<a>return</a>
													</div></td>
												<input type="hidden" id="orderItemId_hidden"
													value="${item.orderItemId}" />
											</c:if>
											<c:if test="${item.returnStatus.equals('RETURNED')}">
												<td><div id="return_div">You returned this item
														on ${item.returnDate} due to ${item.adminComments}</div></td>
											</c:if>
										</tr>
									</table>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--  accordion content ends -->

			</div>
			<div class="tab-pane" id="open_orders">
				<!--  accordion content starts -->
				<c:forEach var="order" items="${openOrders}">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#${order.orderId}" aria-expanded="true"
									aria-controls="collapseOne"> ${order.orderId}</a>
							</h4>
						</div>
						<div id="${order.orderId}" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								Delivered Date : ${order.deliveredDate} <br />
								<c:forEach items="${order.items}" var="item">
									<table class="order_items_table">
										<tr>
											<td><img height="75" width="75" src="${item.image}" /></td>
											<td>${item.productName}</td>
											<td>${item.totalSoldPrice}</td>
											<td>${item.quantity}<c:if test="${item.quantity == 1}">&nbsp;no</c:if>
												<c:if test="${item.quantity > 1}">&nbsp;nos</c:if></td>
										</tr>
									</table>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--  accordion content ends -->

			</div>
			<div class="tab-pane" id="cancelled_orders">
				<!--  accordion content starts -->
				<c:forEach var="order" items="${cancelledOrders}">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#${order.orderId}" aria-expanded="true"
									aria-controls="collapseOne"> ${order.orderId}</a>
							</h4>
						</div>
						<div id="${order.orderId}" class="panel-collapse collapse in"
							role="tabpanel" aria-labelledby="headingOne">
							<div class="panel-body">
								Delivered Date : ${order.deliveredDate} <br />
								<c:forEach items="${order.items}" var="item">
									<table class="order_items_table">
										<tr>
											<td><img height="75" width="75" src="${item.image}" /></td>
											<td>${item.productName}</td>
											<td>${item.totalSoldPrice}</td>
											<td>${item.quantity}<c:if test="${item.quantity == 1}">&nbsp;no</c:if>
												<c:if test="${item.quantity > 1}">&nbsp;nos</c:if></td>
											<td>${item.quantity}<c:if test="${item.quantity == 1}">&nbsp;no</c:if>
												<c:if test="${item.quantity > 1}">&nbsp;nos</c:if></td>
										</tr>
									</table>
								</c:forEach>
							</div>
						</div>
					</div>
				</c:forEach>
				<!--  accordion content ends -->
			</div>

		</div>
	</div>


	<div id="myModal" class="modal fade">
		<form action="return" method="post" name="return">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title">Confirmation</h4>
					</div>
					<div class="modal-body">
						<div>
							<div class="return_text_area">
								<div>
									<textarea name="comment" rows="4" cols="50"></textarea>
								</div>
								<div>Please mention the reason for returning the product.</div>
							</div>
						</div>
						<p>Are you sure you want to place return request?</p>
						<p class="text-warning">
							<small>Please click submit to place return request. You
								request will be processed immediately.</small>
						</p>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="submit" id="submit_return" class="btn btn-primary">Place
							Return Request</button>
					</div>
				</div>
			</div>
			<input type="hidden" id="orderItemId" name="orderItemId" />
		</form>
	</div>




	<script src="resources/assets/myorders/js/jquery-2.1.4.min.js"></script>
	<script src="resources/assets/myorders/js/myorders.js"></script>
	<script src="resources/assets/myorders/js/bootstrap.min.js"></script>
	<script src="resources/assets/myorders/js/pills.js"></script>
</body>
</html>