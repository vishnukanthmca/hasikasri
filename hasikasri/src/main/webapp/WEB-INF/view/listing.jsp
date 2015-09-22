<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Get more than what you see</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/assets/listing/css/bootstrap.min.css" rel="stylesheet">
	
    <!-- Custom styles for this template -->
    <link href="resources/assets/listing/css/navbar-fixed-top.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Fixed navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
		
		<div class="container">
			<div class="navbar-header">
			  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			  </button>
			  <a class="navbar-brand" href="#">aha shopping</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
			  <ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#about">About</a></li>
				<li><a href="#contact">Contact</a></li>
				
			  </ul>
			  <ul class="nav navbar-nav navbar-right">
				<li><a href="../navbar/">Default</a></li>
				<li><a href="../navbar-static-top/">Static top</a></li>
				<li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
			  </ul>
			</div><!--/.nav-collapse -->
		</div>
    </nav>

	<div class="row">
		<div class="container">
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">Action</a></li>
					<li><a href="#">Another action</a></li>
					<li><a href="#">Something else here</a></li>
					<li role="separator" class="divider"></li>
					<li class="dropdown-header">Nav header</li>
					<li><a href="#">Separated link</a></li>
					<li><a href="#">One more separated link</a></li>
				</ul>
			</li>
		</ul>
	</div>
	
	
	
			
			
	</div>
	
    <div class="container">

      <!-- Main component for a primary marketing message or call to action -->
      <div class="jumbotron">
		
		<div class="row">
			<div class="col-lg-3">
				<div class="row">
					
						<div class="checkbox">
                            <label>
                                
                                    <input type="checkbox">
                                    Apple
                                 
                            </label>
                        </div>
						<div class="checkbox">
                            <label>
                                
                                    <input type="checkbox">
                                    Banana
                                 
                            </label>
                        </div>
					
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="col-lg-4">
						<a class="thumbnail">
							<img src="resources/assets/listing/images/14.jpg" alt="thumbnail_2" />
						</a>
					</div>
					<div class="col-lg-4">
						<a class="thumbnail">
							<img src="resources/assets/listing/images/12.jpg" alt="thumbnail_2" />
						</a>
					</div>
					<div class="col-lg-4">
						<a class="thumbnail">
							<img src="resources/assets/listing/images/13.jpg" alt="thumbnail_2" />
						</a>
					</div>
				</div>
			</div>
		</div>
		
	  </div> <!-- /container -->


	
	
	
	
		
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="bootstrap-3.3.5-dist/js/ie10-viewport-bug-workaround.js"></script>
	
	
	<script src="bootstrap-3.3.5-dist/home_page_main_slider/js/jquery.catslider.js"></script>
		<script>
			$(function() {

				$( '#mi-slider' ).catslider();

			});
	</script>
	
	<script src="resources/assets/bootstrap-3.3.5-dist/slider/js/owl.carousel.js"></script>
	
    <script src="resources/assets/bootstrap-3.3.5-dist/slider/js/bootstrap-collapse.js"></script>
    <script src="resources/assets/bootstrap-3.3.5-dist/slider/js/bootstrap-transition.js"></script>
    <script src="resources/assets/bootstrap-3.3.5-dist/slider/js/bootstrap-tab.js"></script>

    <script src="resources/assets/bootstrap-3.3.5-dist/slider/js/google-code-prettify/prettify.js"></script>
    <script src="resources/assets/bootstrap-3.3.5-dist/slider/js/application.js"></script>

	
	<script>
		$(document).ready(function() {
		 
		  var time = 3; // time in seconds
		 
		  var $progressBar,
			  $bar, 
			  $elem, 
			  isPause, 
			  tick,
			  percentTime;
		 
			//Init the carousel
			$("#owl-demo").owlCarousel({
			  slideSpeed : 200,
			  paginationSpeed : 200,
			  singleItem : true,
			  afterInit : progressBar,
			  afterMove : moved,
			  startDragging : pauseOnDragging
			});
		 
			//Init progressBar where elem is $("#owl-demo")
			function progressBar(elem){
			  $elem = elem;
			  //build progress bar elements
			  buildProgressBar();
			  //start counting
			  start();
			}
		 
			//create div#progressBar and div#bar then prepend to $("#owl-demo")
			function buildProgressBar(){
			  $progressBar = $("<div>",{
				id:"progressBar"
			  });
			  $bar = $("<div>",{
				id:"bar"
			  });
			  $progressBar.append($bar).prependTo($elem);
			}
		 
			function start() {
			  //reset timer
			  percentTime = 0;
			  isPause = false;
			  //run interval every 0.01 second
			  tick = setInterval(interval, 10);
			};
		 
			function interval() {
			  if(isPause === false){
				percentTime += 1 / time;
				$bar.css({
				   width: percentTime+"%"
				 });
				//if percentTime is equal or greater than 100
				if(percentTime >= 100){
				  //slide to next item 
				  $elem.trigger('owl.next')
				}
			  }
			}
		 
			//pause while dragging 
			function pauseOnDragging(){
			  isPause = true;
			}
		 
			//moved callback
			function moved(){
			  //clear interval
			  clearTimeout(tick);
			  //start again
			  start();
			}
		 
			//uncomment this to make pause on mouseover 
			// $elem.on('mouseover',function(){
			//   isPause = true;
			// })
			// $elem.on('mouseout',function(){
			//   isPause = false;
			// })
		 
		});
	</script>
	
	  </body>
</html>
	