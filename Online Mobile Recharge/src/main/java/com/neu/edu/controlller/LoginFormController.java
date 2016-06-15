package com.neu.edu.controlller;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.Plan;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.User;


@Controller
public class LoginFormController {

	@RequestMapping(value="/adduser.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result,HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (result.hasErrors()) {
			return "addUserForm";
		}
		UserDAO userDAO = new UserDAO();
		User result1 = userDAO.get(user);
		
		if(result1!=null){
			request.getSession().setAttribute("user", result1);
			if (result1.getRole().equals("customer")){
				Cookie userCookie = new Cookie("userName", user.getUsername());
	            Cookie pwdCookie = new Cookie("password", user.getPassword());
	            response.addCookie(userCookie);
	            response.addCookie(pwdCookie);
				return "redirect:/userLogin.htm";
			}
			else if(result1.getRole().equals("admin")){
				Cookie userCookie = new Cookie("userName",  user.getUsername());
	            Cookie pwdCookie = new Cookie("password", user.getPassword());
	            response.addCookie(userCookie);
	            response.addCookie(pwdCookie);
				return "redirect:/adminLogin.htm";
			}
			
						}
		return null;

	}

	@RequestMapping(value="/adduser.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
	

	
	
	@RequestMapping(value="/userLogin.htm", method = RequestMethod.GET)
	public String showForm(@ModelAttribute("phonenumber") PhoneNumber phonenumber, BindingResult result1) {

		return "userLogin";
	}
	
	@RequestMapping(value="/logout.htm", method = RequestMethod.GET)
	public String doLogout(@ModelAttribute("user") User user, BindingResult result1, HttpServletRequest request ) {
		HttpSession session =request.getSession();
		session.invalidate();

		return "redirect:/adduser.htm";
	}
	
	
}