<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
        <meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Login and Registration Form with HTML5 and CSS3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Login and Registration Form with HTML5 and CSS3" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">
          <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet"> 
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />
    
    <script type="text/javascript">
    javascript:window.history.forward(1);
var your_name = /^[A-Za-z]{3,20}$/;
var your_phone = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
var your_email = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i 
var your_username = /^[A-Za-z0-9 ]{3,20}$/;

function FeedbackForm(name,phone,email,username){
  this.name=name;
  this.phone=phone;
  this.email=email;
  this.username=username;

}
FeedbackForm.prototype.getName=
function()
{
  return this.name;
}
FeedbackForm.prototype.setName=
function()
{
   this.name=name;
}

FeedbackForm.prototype.getPhone=
function()
{
  return this.phone;
}
FeedbackForm.prototype.setPhone=
function()
{
   this.phone=phone;
}
FeedbackForm.prototype.getEmail=
function()
{
  return this.email;
}
FeedbackForm.prototype.setEmail=
function()
{
   this.email=email;
}

FeedbackForm.prototype.getUsername=
function()
{
  return this.username;
}
FeedbackForm.prototype.setUsername=
function()
{
   this.username=username;
}


function myFunction(myForm){
var feedbackForm = new FeedbackForm(myForm["name"].value,myForm["phone"].value,myForm["email"].value,myForm["username"].value);
var errors = [];
 
 if (!your_name.test(feedbackForm.getName())) {
  errors[errors.length] = "Enter a valid First Name";
 }
  if (!your_phone.test(feedbackForm.getPhone())) {
  errors[errors.length] = "Enter a valid phone";
 }

 if (!your_email.test(feedbackForm.getEmail())) {
  errors[errors.length] = "Enter a valid email address";
 }
  if (!your_username.test(feedbackForm.getUsername())) {
  errors[errors.length] = "Enter a valid username";
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

function checkPass()
{
    
    var pass1 = document.getElementById('passwordsignup');
    var pass2 = document.getElementById('passwordconfirm');
    
    var message = document.getElementById('validate');
    
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
  
    if(pass1.value == pass2.value){
        
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
       
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}


</script>

    </head>
<body>

<div class="container">
                    <header>
                <br>
            </header>
            <section>				
                <div id="container_demo" >
                    <!-- hidden anchor to stop jump http://www.css3create.com/Astuce-Empecher-le-scroll-avec-l-utilisation-de-target#wrap4  -->
                    <a class="hiddenanchor" id="toregister"></a>
                    <a class="hiddenanchor" id="tologin"></a>
                    <div id="wrapper">
                        <div id="login" class="animate form">
                            <form:form  action="adduser.htm" commandName="user" method="post" autocomplete="on" > 
                                <h1>Log in</h1> 
                                <p> 
                                    <label for="username" class="username" data-icon="u" > Your username </label>
                                    <form:input id="username" path="username" name="username" value='${cookie.userName.value}' required="required" type="text" placeholder="myusername or mymail@mail.com"/><form:errors path="name"/>
                                </p>
                                <p> 
                                    <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                                    <form:input id="password" path="password" name="password" value='${cookie.password.value}' required="required" type="password" placeholder="eg. X8df!90EO" /> <form:errors path="password"/>
                                </p>
                                <input type='checkbox' name='rememberMe' value='rememberMe'>Remember Me</br>
                                
                                <p class="login button"> 
                                    <input type="submit" value="Login" /> 
								</p>
                                <p class="change_link">
									Not a member yet ?
									<a href="#toregister" class="to_register">Join us</a>
								</p>
                            </form:form>
                        </div>	
                        <div id="register" class="animate form">
                            <form:form commandName="user" method="post" onSubmit="return myFunction(this);" name="myForm" action="signUpUser.htm" enctype="multipart/form-data" autocomplete="on"> 
                                <h1> Sign up </h1> 
                                <p> 
                                    <label for="namesignup" class="name" data-icon="u">Your name</label>
                                    <form:input path="name" id="namesignup" name="name" required="required" type="text" placeholder="mysupername690" />
                                </p>
                                <p> 
                                    <label for="phonesignup" class="youphone" data-icon="u" > Your phone</label>
                                    <form:input path="phone" id="phonesignup" name="phone" required="required" type="phone" placeholder="8579995878"/> 
                                </p>
                                <p> 
                                    <label for="emailsignup" class="youmail" data-icon="e" > Your email</label>
                                    <form:input path="email" id="emailsignup" name="email" required="required" type="email" placeholder="mysupermail@mail.com"/> 
                                </p>
                                <p> 
                                    <label for="usernamesignup" class="uname" data-icon="u">Your username</label>
                                    <form:input path="username" id="usernamesignup" name="username" required="required" type="text" placeholder="mysuperusername690" />
                                </p>
                                <p> 
                                    <label for="passwordsignup" class="youpasswd" data-icon="p">Your password </label>
                                    <form:input path="password" id="passwordsignup" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                </p>
                                <p> 
                                    <label for="passwordsignup_confirm" class="youpasswd" data-icon="p">Please confirm your password </label>
                                    <form:input path="confirmPassword" id="passwordconfirm" name="passwordconfirm" onkeyup="checkPass(); return false;" required="required" type="password" placeholder="eg. X8df!90EO"/>
                                    <span id="validate" class="validate"></span>
                                                                 </p>
                                                                 
                                <p><form:input path="pic" type="file" placeholder="Photo"/></p>
                                                                 
                                <p class="signin button"> 
									<input type="submit" value="Sign up"/> 
								</p>
                                <p class="change_link">  
									Already a member ?
									<a href="#tologin" class="to_register"> Go and log in </a>
								</p>
                            </form:form>
                        </div>
                        			
                    </div>
                </div>  
            </section>
        </div>

</body>
</html>