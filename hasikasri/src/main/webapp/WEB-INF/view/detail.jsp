<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Yamm">
<meta name="author" content="@geedmo">
<title>Yamm</title>

<link href="resources/assets/detail/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/detail/css/bootstrap-theme.min.css"
	rel="stylesheet">

<link href="resources/assets/detail/css/demo.css" rel="stylesheet">
<link href="resources/assets/detail/css/yamm.css" rel="stylesheet">

<link href="resources/assets/detail/css/detail.css" rel="stylesheet">
<link href="resources/assets/common/css/style.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--if lt IE 9
    script(src='https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js')
    script(src='https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js')
-->

</head>
<body>




	<div class="navbar yamm navbar-default navbar-fixed-top">
		<div class="container static_top">
			<div class="navbar-header">
				<button type="button" data-toggle="collapse"
					data-target="#navbar-collapse-1" class="navbar-toggle">
					<span class="icon-bar"></span><span class="icon-bar"></span><span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">Yamm</a>
			</div>
			<div id="navbar-collapse-1" class="navbar-collapse collapse">


				<ul class="nav navbar-nav">
					<!-- Classic list -->
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Go To<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<!-- Content container to add padding -->
								<div class="yamm-content">
									<div class="row">
										<ul class="col-sm-2 list-unstyled">
											<li><strong><a href="detail?cat=4">Men</a></strong></li>
											<li><a href="#">Clothes</a></li>
											<li>T-Shirts</li>
										</ul>
										<ul class="col-sm-2 list-unstyled">
											<li><strong>Women</strong></li>
											<li>Clothes</li>
											<li>T-Shirts</li>
										</ul>
										<ul class="col-sm-2 list-unstyled">
											<li><strong>Footwear</strong></li>
											<li>Women's footwear</li>
											<li>Men's footwear</li>
											<li>Kids footwear</li>
										</ul>
										<ul class="col-sm-2 list-unstyled">
											<li><strong>Kids</strong></li>
											<li>T-Shirts</li>
											<li>Diaphers</li>
											<li>Clothes</li>
										</ul>
									</div>
								</div>
							</li>
						</ul></li>
					<!-- Accordion demo -->
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Offers<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<div class="yamm-content">
									<div class="row">
										<div id="accordion" class="panel-group">
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseOne">Collapsible Group Item #1</a>
													</h4>
												</div>
												<div id="collapseOne" class="panel-collapse collapse in">
													<div class="panel-body">Ut consectetur ullamcorper
														purus a rutrum. Etiam dui nisi, hendrerit feugiat
														scelerisque et, cursus eu magna.</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseTwo">Collapsible Group Item #2</a>
													</h4>
												</div>
												<div id="collapseTwo" class="panel-collapse collapse">
													<div class="panel-body">Nullam pretium fermentum
														sapien ut convallis. Suspendisse vehicula, magna non
														tristique tincidunt, massa nisi luctus tellus, vel laoreet
														sem lectus ut nibh.</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapseThree">Collapsible Group Item #3</a>
													</h4>
												</div>
												<div id="collapseThree" class="panel-collapse collapse">
													<div class="panel-body">Praesent leo quam, faucibus
														at facilisis id, rhoncus sit amet metus. Sed vitae ipsum
														non nibh mattis congue eget id augue.</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</li>
						</ul></li>
					<!-- Classic dropdown -->
					<li class="dropdown"><a href="#" data-toggle="dropdown"
						class="dropdown-toggle">Sell<b class="caret"></b></a>
						<ul role="menu" class="dropdown-menu">
							<li><a tabindex="-1" href="#"> Action </a></li>
							<li><a tabindex="-1" href="#"> Another action </a></li>
							<li><a tabindex="-1" href="#"> Something else here </a></li>
							<li class="divider"></li>
							<li><a tabindex="-1" href="#"> Separated link </a></li>
						</ul></li>
					<!-- Pictures -->
					<li class="dropdown yamm-fw"><a href="#"
						data-toggle="dropdown" class="dropdown-toggle">Pictures<b
							class="caret"></b></a>
						<ul class="dropdown-menu">
							<li>
								<div class="yamm-content">
									<div class="row">
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x200"
												src="resources/assets/detail/resources/assets/detail/images/200.jpg"></a>
										</div>
									</div>
								</div>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>

		<div class="container static_top">
			<div id="search_div">


				<div class="input-group">
					<div class="input-group-btn">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							All <span class="caret"></span>
						</button>
						<ul class="dropdown-menu">
							<li><a href="#">All</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</div>
					<!-- <input type="text" data-provide="typeahead" class="form-control"
						placeholder="What are you looking for?"
						aria-describedby="basic-addon2"> <span
						class="input-group-addon" id="basic-addon2">Search</span> -->
					<div id="scrollable-dropdown-menu" class="col-md-8">
						<input class="typeahead form-control" id="basic-addon2"
							type="text" placeholder="Search">
					</div>
				</div>
				<!-- /input-group -->
			</div>
		</div>

		<header>
			<div id="cd-cart-trigger">
				<a class="cd-img-replace" href="#0">Cart</a>
			</div>
		</header>

	</div>

	<div class="container">

		<!-- Main component for a primary marketing message or call to action -->
		<div class="jumbotron">
			<div class="row">
				<ol class="breadcrumb" id="breadcrumb_category">
					<li><a href="home">Home</a></li>
					<c:forEach begin="0" end="${product.breadcrumbsSize}"
						var="breadcrumb" items="${product.breadcrumbs}">
						<li><a href="listing?cat=${breadcrumb.id}">${breadcrumb.name}</a></li>
					</c:forEach>
				</ol>
			</div>

			<div class="row">
				<div class="col-md-6" style="border: 1px solid red;">
					<div class="row">
						<%-- <c:forEach begin="0" items="${product.resources/assets/detail/images}"
							end="${product.resources/assets/detail/imagesSize}" var="img">
							<img id="zoom_03" src="${img.location}"
								data-zoom-image="resources/assets/detail/resources/assets/detail/images/large/image1.jpg" />


						</c:forEach>
						
						
 --%>
						<div id="gallery_01">
							<img id="zoom_03"
								src="resources/assets/detail/images/small/image1.png"
								data-zoom-image="resources/assets/detail/images/large/image1.jpg" />
							<div id="gal1">
								<a href="#"
									data-image="resources/assets/detail/images/small/image1.png"
									data-zoom-image="resources/assets/detail/images/large/image1.jpg">
									<img id="zoom_03"
									src="resources/assets/detail/images/thumb/image1.jpg" />
								</a> <a href="#"
									data-image="resources/assets/detail/images/small/image2.png"
									data-zoom-image="resources/assets/detail/images/large/image2.jpg">
									<img id="zoom_03"
									src="resources/assets/detail/images/thumb/image2.jpg" />
								</a> <a href="#"
									data-image="resources/assets/detail/images/small/image3.png"
									data-zoom-image="resources/assets/detail/images/large/image3.jpg">
									<img id="zoom_03"
									src="resources/assets/detail/images/thumb/image3.jpg" />
								</a> <a href="#"
									data-image="resources/assets/detail/images/small/image4.png"
									data-zoom-image="resources/assets/detail/images/large/image4.jpg">
									<img id="zoom_03"
									src="resources/assets/detail/images/thumb/image4.jpg" />
								</a>
							</div>
						</div>
					</div>
					<div class="row">bottom</div>
				</div>
				<div class="col-md-6" style="border: 1px solid red;">
					<div id="product_info_div">
						<div class="row">
							<h3>${product.name}</h3>
						</div>
						<div class="row">
							<hr />
							<div id="rating" data-score='${product.rating}'></div>
							<div>&nbsp;&nbsp;&nbsp;&nbsp;5 ratings</div>
						</div>

						<div class="row">
							<hr />
							<div id="size">
								SIZE <input type="text" class="textbox" name="size" size="3" />
								&nbsp; &nbsp; &nbsp; <input type="text" class="textbox"
									name="quantity" value="1" id="quantity" size="3" />
							</div>
						</div>
						<div class="row">
							<hr />
							<div id="check_availability">
								<span id="check_availability_text">Check availability</span> <br />
								Pincode <input type="text" class="textbox" name="quantity"
									size="6" />
							</div>
						</div>
						<div class="row">
							<hr />
							<div id="price_details">
								<c:if test="${product.actualPrice != null}">
									List Price: <label id="actualPrice">Rs.
										${product.actualPrice}</label>
								</c:if>
								<br /> <label id="price">Rs.${product.price}</label>
								<c:if test="${product.discount != null}">
									<label id="discount"> ${product.discount}% OFF</label>
								</c:if>
								<c:if test="${product.deliveryCharge != null}">
									<label id="delivery_charge"> +
										${product.deliveryCharge} Delivery</label>
								</c:if>
								<c:if test="${product.deliveryCharge == null}">
									<label id="delivery_charge"> FREE Delivery</label>
								</c:if>
							</div>
						</div>
						<div class="row">
							<hr />

							<div id="add_to_cart">
								<button
									onclick="addToCart(${product.pid},${product.price},'${product.name}')"
									type="button" class="btn btn-success add_to_cart">ADD
									TO CART</button>
							</div>
							<div id="buy_now">
								<button type="button" class="btn btn-success buy_now">
									BUY NOW</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div id="rootwizard">
					<ul>
						<li><a href="#tab1" data-toggle="tab">Product Description</a></li>
						<li><a href="#tab2" data-toggle="tab">Shipping Details</a></li>
						<li><a href="#tab3" data-toggle="tab">Return Policy</a></li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane" id="tab1">
							<table class="table product_description_table">
								<c:forEach begin="0" end="${product.descriptionsSize}"
									items="${product.descriptions}" var="description"
									varStatus="currentIndex">
									<c:if test="${currentIndex.index % 2 == 0}">
										<tr class="info">
									</c:if>
									<c:if test="${currentIndex.index % 2 != 0}">
										<tr class="warning">
									</c:if>
									<td>${description.type}</td>
									<td>${description.description}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="tab-pane" id="tab2">2</div>
						<div class="tab-pane" id="tab3">3</div>
					</div>
				</div>

			</div>

		</div>
		<!-- /container -->

	</div>


	<div id="cd-cart">
		<h2>Cart</h2>
		<!-- cd-cart-items -->
		<ul class="cd-cart-items">
		</ul>
		<!-- cd-cart-items -->

		<div class="cd-cart-total">
			<p>
				Total <span id="cart_total">Rs. 0.0</span>
			</p>
		</div>
		<!-- cd-cart-total -->

		<a href="#0" class="checkout-btn">Checkout</a>

		<p class="cd-go-to-cart">
			<a href="#0">Go to cart page</a>
		</p>
	</div>
	<!-- cd-cart -->

	<script src="resources/assets/detail/js/jquery-1.9.1.min.js"></script>
	<script src="resources/assets/detail/js/bootstrap.min.js"></script>
	<script src="resources/assets/detail/js/bootstrap-treeview.js"></script>
	<script src="resources/assets/detail/js/jquery.raty.js"></script>
	<script src="resources/assets/detail/js/jquery.elevatezoom.js"></script>
	<script src="resources/assets/detail/js/pills.js"></script>
	<script src="resources/assets/common/js/main.js"></script>

	<script>
		$(function() {
			window.prettyPrint && prettyPrint()
			$(document).on('click', '.yamm .dropdown-menu', function(e) {
				e.stopPropagation()
			})
		})
	</script>
	<script src="resources/assets/detail/js/typeahead.bundle.js"></script>
	<script src="resources/assets/detail/js/detail.js"></script>
</body>
</html>