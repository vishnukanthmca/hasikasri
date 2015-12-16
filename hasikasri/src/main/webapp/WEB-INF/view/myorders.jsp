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
				<c:forEach var="order" items="${orders}">
					<div class="panel panel-default">
						<div class="panel-heading" role="tab" id="headingOne">
							<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion"
									href="#${order.orderId}" aria-expanded="true"
									aria-controls="collapseOne"> ${order.orderId} #1 </a>
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
											<td>${item.price}</td>
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
			<div class="tab-pane" id="open_orders"></div>
			<div class="tab-pane" id="cancelled_orders">2</div>

		</div>
	</div>






	<script src="resources/assets/myorders/js/jquery-2.1.4.min.js"></script>
	<script src="resources/assets/myorders/js/myorders.js"></script>
	<script src="resources/assets/myorders/js/bootstrap.min.js"></script>
	<script src="resources/assets/myorders/js/pills.js"></script>
</body>
</html>