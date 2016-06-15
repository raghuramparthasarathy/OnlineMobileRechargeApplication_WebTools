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
<!--Custom Theme files-->
<!--//Custom Theme files -->
<!--web font-->

<!--//web font-->

<style>
.server-action-menu {
    background-color: transparent;
    background-image: linear-gradient(to bottom, rgba(30, 87, 153, 0.2) 0%, rgba(125, 185, 232, 0) 100%);
    background-repeat: repeat;
    border-radius:10px;
    padding: 5px;
}
</style>
</head>
<body>
	<!-- main -->
	<div class="main">
		<h1>Easy Recharge</h1>
		<div class="main-row">
		<div class="container">
	<div class="pull-right">
		
		<button onclick="location.href='logout.htm'" type="button" class="btn btn-danger" >Logout</button>
		</div>
	 </div>
	
			
		  <table border="1" cellpadding="50" cellspacing="15">
				 <tr>
                
                <th><b>Recharge ID</b></th>
                <th><b>card</b></th>
                <th><b>cardNumber</b></th>
                <th><b>Expiration Month</b></th>
                <th><b>Expiration Year</b></th>
                <th><b>cvv</b></th>
                <th><b>message</b></th>
                
            </tr>
           
                <tr>
                    
                    <td>${sessionScope.rc.rechargeID}</td>
                    <td>${transactiondetails.card}</td>
                    <td>${transactiondetails.cardNumber}</td>
                    <td>${transactiondetails.expMonth}</td>
                    <td>${transactiondetails.expYear}</td>
                    <td>${transactiondetails.cvv}</td>
                    <td>${transactiondetails.message}</td>
                </tr>
                </table>
                <br>
                <button onclick="location.href='generatePDF.htm'" type="button" class="btn btn-success" >Generate Pdf</button>

		
			
			<div class="clear"> </div>
		</div>	
	</div>	
	<!--//main -->
	<!--copyright--></br>
	</br>
	<div class="copyright">
		<p> &copy; 2016 Easy Recharge . All rights reserved </p>
	</div>
	<!--//copyright-->
</body>
</html>
<html>
   