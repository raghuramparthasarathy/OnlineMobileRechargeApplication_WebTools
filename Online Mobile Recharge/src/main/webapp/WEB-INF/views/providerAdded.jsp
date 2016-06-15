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
<!--Custom Theme files-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<script>
var your_name = /^[A-Za-z]{3,20}$/;


function FeedbackForm(planname){
  this.planname=planname;
 }
FeedbackForm.prototype.getPlanname=
function()
{
  return this.planname;
}
FeedbackForm.prototype.setPlanname=
function()
{
   this.planname=planname;
}




function myFunction(myForm){
var feedbackForm = new FeedbackForm(myForm["planname"].value);
var errors = [];
 
 if (!your_name.test(feedbackForm.getPlanname())) {
  errors[errors.length] = "Enter a valid planname with a minimum of 3 characters";
 }
  
 

  if (errors.length > 0) {

  reportErrors(errors);
  return false;
 }
else{
  reportNoErrors(errors);
  return true;
 }
  

}
function reportErrors(errors){
 var msg = "Please check the following Errors...\n";
 for (var i = 0; i<errors.length; i++) {
 var numError = i + 1;
  msg += "\n" + numError + ". " + errors[i];
}
 alert(msg);
}


function reportNoErrors(errors){
 
 alert("Form Submitted Successfully");
}

</script>
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>Easy Recharge</h1>
		<div class="main-row">
		<div class="pull-right">
		
		<button onclick="location.href='logout.htm'" type="button" class="btn btn-danger" >Logout</button>
		</div>
			<div class="footer-grids grid-one">
				<h3>Provider ${sessionScope.service.serviceProviderName}<br></h3>
				<form:form action="addedProvider.htm" onSubmit="return myFunction(this);" name="myForm" commandName="plan" method="post">
					<label>Plan Name*</label>
					<form:input type="text" path="planName" id="planname"  placeholder="Monthly" required=""/>
					<label>Price*</label>
					<form:input type="text" path="price" placeholder="$27.50" required=""/>
					
					<c:set var="serviceProvider" value="${sessionScope.service.serviceProviderName}" scope="session"></c:set>
					<br/>
					<input type="submit" value="Proceed">
				</form:form>


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
   