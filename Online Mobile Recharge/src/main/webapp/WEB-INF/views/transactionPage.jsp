<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<title>Transaction</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">

<meta name="keywords" content="Multi Column Footer template Responsive, Login form web template,Flat Pricing tables,Flat Drop downs  Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, SmartPhone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<!--Custom Theme files-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
<!--//Custom Theme files -->
<!--web font-->
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
      <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

</head>
<body>
<div class="main">
        <h1>Easy Recharge</h1>
        <div class="main-row">
            <div class="pull-right">
		
		<button onclick="location.href='logout.htm'" type="button" class="btn btn-danger" >Logout</button>
		</div>
            <div class="main">
    <div class="row">
      <div class="col-xs-12 col-md-2">

      </div>
        <div class="col-xs-12 col-md-6">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><img class="pull-right" src="http://i76.imgup.net/accepted_c22e0.png">Payment Details</h3>
                </div>
                <div class="panel-body">
                    <form:form action="addTransaction.htm" onSubmit="return myFunction(this);" name="myForm" commandName="transactiondetails" method="post" class="form-horizontal">
                       <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
<label for="cardNumber">PAYMENT TYPE</label>
  <div class="col-md-9">
    <form:select id="selectbasic" path="card" style="width: 150px;height: 35px;" name="selectbasic" class="form-control">
      <option value="Debit">Debit Card</option>
      <option value="Credit">Credit Card</option>
      <option value="American Express">American Express</option>
    </form:select>
  </div>
</div>                          
                            </div>
                        </div><br>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="cardNumber">CARD NUMBER</label>
                                    <div class="input-group">
                                        <form:input path="cardNumber" type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="Valid Card Number" />
                                        <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                    </div>
                                </div>                            
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label for="expMonth">EXPIRATION DATE</label>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <form:select path="expMonth" type="text" class="form-control" name="expMonth" placeholder="MM"  data-stripe="exp_month">
                    <option>Jan</option>
                    <option>Feb</option>
                    <option>March</option>
                    <option>April</option>
                    <option>May</option>
                    <option>June</option>
                    <option>July</option>
                    <option>Aug</option>
                    <option>Sept</option>
                    <option>Oct</option>
                    <option>Nov</option>                    
                    <option>Dec</option>
                  </form:select>
                                       
                                    </div>
                                    <div class="col-xs-6 col-lg-6 pl-ziro">
                                        <form:select path="expYear" type="text" class="form-control" name="expYear" placeholder="yy"  data-stripe="exp_yy">
                    <option>2016</option>
                    <option>2017</option>
                    <option>2018</option>
                    <option>2019</option>
                    <option>2020</option>
                    <option>2021</option>
                    <option>2022</option>
                    <option>2023</option>
                    <option>2024</option>
                    <option>2025</option>
                    <option>2026</option>
                    <option>2027</option>
                    <option>2028</option>
                    
                    
                   
                  </form:select>
                                       
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label for="cvCode">CV CODE</label>
                                    <form:input path="cvv" type="password" class="form-control" name="cvCode" placeholder=""  data-stripe="cvc" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label for="couponCode">YOUR MESSAGE</label>
                                    <form:input path="message" type="text" class="form-control" name="your message" />
                                </div>
                            </div>                        
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <button class="btn btn-success btn-lg btn-block" type="submit">Make Payment</button>
                            </div>
                        </div>
                    </form:form>
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
</body>
</html>