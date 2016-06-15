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
<!--//Custom Theme files -->
<!--web font-->

<!--//web font-->

<script>
var your_name = /^[A-Za-z]{3,20}$/;


function FeedbackForm(serviceProviderName){
  this.serviceProviderName=serviceProviderName;
 }
FeedbackForm.prototype.getServiceProviderName=
function()
{
  return this.serviceProviderName;
}
FeedbackForm.prototype.setServiceProviderName=
function()
{
   this.serviceProviderName=serviceProviderName;
}




function myFunction(myForm){
var feedbackForm = new FeedbackForm(myForm["serviceProviderName"].value);
var errors = [];
 
 if (!your_name.test(feedbackForm.getServiceProviderName())) {
  errors[errors.length] = "Enter a valid ServiceProviderName with a minimum of 3 characters";
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
				<h3>Welcome ${user.username}<div><img width="100px" height="70px" src="${user.picName}"/></div></h3>
				<form:form action="addProvider.htm" onSubmit="return myFunction(this);" name="myForm" commandName="sp" method="post">
					<label>Service Provider*</label>
					<form:input type="text" id="serviceProviderName" path="serviceProviderName" placeholder="T-Mobile" required=""/>
									
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
   