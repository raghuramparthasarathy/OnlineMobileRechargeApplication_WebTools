
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Multi Column Footer template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/javascript/viewPlan.js"/>"></script>
   <script type="text/javascript" src="<c:url value="/resources/js/jqgrid/jquery.jqGrid.min.js"/>"></script>
   
   <link rel="stylesheet" type="text/css" media="screen"
      href="<c:url value="/resources/css/jqgrid/ui.jqgrid.css"/>"></link>
      
      <link rel="stylesheet" type="text/css" media="screen"
      href="<c:url value="/resources/css/jqgrid/jqGridCustom.css"/>"></link>
   
 
<!--Custom Theme files-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<!--//Custom Theme files -->
<!--web font-->

<!--//web font-->

<style>

</style>
<script type="text/javascript">
  var headers=["Plan Name","Recharge Amount","Service Provider"];
</script>

<style>
.selected{
background: yellow;
}
</style>
</head>
<body>
	<div class="main">
		<h1>Easy Recharge</h1>
		<div class="main-row">
		<div class="pull-right">
		
		<button onclick="location.href='logout.htm'" type="button" class="btn btn-danger" >Logout</button>
		</div>
			<div class="footer-grids">
				<c:set var="phone" value="${sessionScope.pn}"></c:set>
				<h3>You are recharging your ${phone.serviceProviderName} provider with number ${phone.servicePhoneNumber}</h3>
				<form:form action="addedPrice.htm" commandName="rechargeDetails" method="post">
					<label>Enter Recharge Amount*</label>
					<form:input type="text" path ="amount" name ="amount" disabled="true" placeholder="amount" required=""/>
					<input type="submit" value="Proceed">
					<c:out value="${phone.servicePhoneNumber}"></c:out>
					<c:set var="phonenumber" value="${phone}" scope="session"></c:set>
				</form:form>


			</div>
			 <div class="footer-grids address">
				<h3>OUR INFORMATION</h3>
				<div class="address-info">
					<h4>Address :</h4>
					<p>123 T. Global Place.
						<span>CG 09-123</span>
						Italy, Ba. 4567
					</p>
				</div>
				<div class="address-info address-middle">
					<h4>Office Contact :</h4>
					<p>Tel: (000) 123 45 678
						<span>Mon - Thu 9:30am – 5:00pm</span>
						Friday 10:00am – 4:00pm
					</p>
				</div>
				<div class="address-info">
					<h4>Contact :</h4>
					<p>Tel: (111) 123 45 678
						<span>Fax: (555) 12 345 678</span>
						Email: <a href="mailto:info@example.com"> mail@example.com</a>
					</p>
				</div>
			</div> 
			<div class="footer-grids">
			</br></br></br>
				<h3>Please select a plan below</h3>
					<ul>
					<li><button type="button" class="btn btn-success" onClick="viewPlans()">VIEW PLANS</button></li>
					
				</ul>
				
				

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog model-trade" style="max-width: 50%; width: auto !important;">
    
      <!-- Modal content-->
      <div class="modal-content model-content-width">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Plan Details</h4>
        </div>
        <div id="modal-body" class="model-body modal-body-height">
        	
          <table id="planList"></table>
          <div id="planList" class="jqtabs"></div>
       
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  			</div>
			<div class="clear"> </div>
		</div>	
	</div>	
	<!--//main -->
	<!--copyright-->
	<div class="copyright">
				<p> &copy; 2016 Easy Recharge . All rights reserved </p>
	</div>
	<!--//copyright-->
</body>
</html>
<html>
   