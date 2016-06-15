
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/javascript/viewPlan.js"/>"></script>
   <script type="text/javascript" src="<c:url value="/resources/js/jqgrid/jquery.jqGrid.min.js"/>"></script>
</head>
<body>
	<h2>PLAN ADDED SUCCESSFULLY</h2>
	<div class="container">
	<div class="pull-right">
		
		<button onclick="location.href='logout.htm'" type="button" class="btn btn-danger" >Logout</button>
		</div>
	 </div>
	
	<table border="1" cellpadding="5" cellspacing="5">
            <tr>
               
                <th><b>planName</b></th>
                <th><b>price</b></th>
              
            </tr>
           
                <tr>
                   
                    <td>${plan.planName}</td>
                    <td>${plan.price}</td>
                 
                   
                </tr>
          
        </table>
       
</body>
</html>
<html>
   