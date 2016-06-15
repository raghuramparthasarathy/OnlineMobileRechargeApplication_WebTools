<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%
//get the category list
        com.neu.edu.dao.AdminDAO admindao = new com.neu.edu.dao.AdminDAO();
        java.util.List providerList =admindao.list();
        pageContext.setAttribute("providers", providerList);
%>

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
				<form:form action="recharge.htm" commandName="phonenumber" method="post">
					<label>Mobile Number*</label>
					<form:input type="text" path="servicePhoneNumber" placeholder="857-999-5878" required=""/>
					<label>Service Provider*</label><br/>
					<form:select path="serviceProviderName" style="width: 318px;height: 45px;">
                            <c:forEach var="categ" items="${providers}">
                                <form:option value="${categ.serviceProviderName}"/>
                            </c:forEach>
                        </form:select>
                    
  </br></br>
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
   