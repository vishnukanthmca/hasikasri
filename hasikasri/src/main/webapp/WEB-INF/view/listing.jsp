<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Yamm">
<meta name="author" content="@geedmo">
<title>Yamm</title>

<link href="resources/assets/listing/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/assets/listing/css/bootstrap-theme.min.css"
	rel="stylesheet">

<link href="resources/assets/listing/css/demo.css" rel="stylesheet">
<link href="resources/assets/listing/css/yamm.css" rel="stylesheet">

<link href="resources/assets/listing/css/navbar-fixed-top.css"
	rel="stylesheet">

<link href="resources/assets/listing/css/awesome-bootstrap-checkbox.css"
	rel="stylesheet">
<link href="resources/assets/listing/css/jquery.raty.css"
	rel="stylesheet">
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
											<li><strong><a href="listing?cat=4">Men</a></strong></li>
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
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
										</div>
										<div class="col-xs-6 col-sm-2">
											<a href="#" class="thumbnail"><img alt="150x190"
												src="resources/assets/listing/images/190.jpg"></a>
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
			<c:if test="${sessionScope.user != null }">
				<div class="login_div">Hi, ${sessionScope.user}</div>
				<div class="logout_div">
					<a href="logout">&nbsp;&nbsp;&nbsp;&nbsp;Logout</a>
				</div>
			</c:if>
			<c:if test="${sessionScope.user == null }">
				<div>
					<a href="register">New User?</a>
				</div>
			</c:if>
			<c:if test="${sessionScope.user == null}">
				<div class="login_div">
					<nav>
						<ul>
							<li id="login"><a id="login-trigger" href="#"> Log in <span></span>
							</a>
								<div id="login-content">
									<div id="login_failed_message"></div>
									<form method="post" action="login" name="form">
										<fieldset id="inputs">
											<input id="emailOrMobile" type="email" name="emailOrMobile"
												placeholder="Email/Mobile" required> <input
												id="password" type="password" name="Password"
												placeholder="Password" required>
										</fieldset>
										<fieldset id="actions">
											<input type="button" id="login_button" value="Log in">
											<label><input type="checkbox" checked="checked">
												Keep me signed in</label>
										</fieldset>
									</form>
								</div></li>

						</ul>
					</nav>
				</div>
			</c:if>

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
				</ol>
			</div>
			<div class="row">
				<div id="sort_div_wrapper">
					<div id="sort_div_left"></div>
					<div id="sort_div_right">
						<div class="dropdown sort">
							<div id="sort_by_text">SORT BY</div>
							<a id="dLabel" role="button" data-toggle="dropdown"
								class="btn btn-primary sort_button" data-target=""
								href="/page.html">What's New <span class="caret"></span>
							</a>
							<ul class="dropdown-menu multi-level" role="menu"
								aria-labelledby="dropdownMenu">
								<li><a href="#">Price: High To Low</a></li>
								<li><a href="#">Price: Low To High</a></li>
								<!-- <li class="divider"></li> -->
								<li><a href="#">Discount: High To Low</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3" id="left_block">
					<div class="row">
						<div id="treeview10"></div>
					</div>

					<!-- All Refiners starts here -->
					<div class="row">
						<div class="refiner">
							<div class="panel panel-primary">
								<div class="panel-heading refiner">
									<button class="refiner_shrink_button" type="button"
										data-toggle="collapse" data-target="#shrinkprice"
										aria-expanded="
										true" aria-controls="shrink">
										<span aria-hidden="false">Price</span>
									</button>
								</div>
								<div class="collapse in" id="shrinkprice">
									<div class="panel-body" id="price_slider">
										<div>
											<table>
												<tr>
													<td><input id="price_textbox_min" type=text size="8"
														id="max_price" /></td>
													<td><div class="price_separator">-</div></td>
													<td><input id="price_textbox_max" id="min_price"
														type=text size="8" /></td>
													<td><input type="button" value="Go" /></td>
												</tr>
												<tr>
													<td><span class="price_label">From</span></td>
													<td>&nbsp;</td>
													<td><span class="price_label">To</span></td>
													<td>&nbsp;</td>
												</tr>
											</table>
										</div>
										<div id="loader-icon_left">
											<img src="resources/assets/listing/images/GreenLoader.gif" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row" id="refiners_and_attributes"></div>
					<!-- All Refiners ends here -->


				</div>
				<!-- products list starts here -->
				<div class="col-lg-9 product_container"></div>
				<!-- products list ends here -->
			</div>

		</div>
		<div id="loader-icon">
			<img src="resources/assets/listing/images/loader_icon.gif" />
		</div>
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

	<!-- /container -->

	<!-- Bootstrap core JavaScript-->
	<!-- <script src="demo/components/jquery/dist/jquery.js"></script>
	
    <script src="demo/components/bootstrap/dist/js/bootstrap.min.js"></script> -->

	<script src="resources/assets/listing/js/jquery-1.9.1.min.js"></script>
	<script src="resources/assets/listing/js/bootstrap.min.js"></script>
	<script src="resources/assets/listing/js/bootstrap-treeview.js"></script>
	<script src="resources/assets/listing/js/jquery.raty.js"></script>
	<script src="resources/assets/common/js/main.js"></script>

	<!-- 	<script
		src="https://google-code-prettify.googlecode.com/svn/loader/run_prettify.js?lang=css"></script>-->
	<script>
		$(function() {
			window.prettyPrint && prettyPrint()
			$(document).on('click', '.yamm .dropdown-menu', function(e) {
				e.stopPropagation()
			})
		})
	</script>
	<script src="resources/assets/listing/js/typeahead.bundle.js"></script>
	<script src="resources/assets/listing/js/custom.js"></script>

	<input type="hidden" id="current_cat_id"
		value='<%=request.getParameter("cat")%>' />
	<input type="hidden" id="child_category_ids" value="" />
	<input type="hidden" id="attribute_ids" value="-1" />
	<a href="#0" class="cd-top">Top</a>
</body>
</html>