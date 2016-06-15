package com.neu.edu.controlller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.edu.dao.AdminDAO;
import com.neu.edu.dao.PhoneDAO;
import com.neu.edu.dao.PlanDAO;
import com.neu.edu.dao.RechargeDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.AjaxModel;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.RechargeModel;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;


@Controller
public class AddPhoneNumberController {

	@RequestMapping(value="/recharge.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("phonenumber") PhoneNumber phonenumber, BindingResult result,HttpServletRequest request) throws Exception {
		
		if (result.hasErrors()) {
			return "userLogin";
		}

		try {
			System.out.print("test");
			PhoneDAO phoneDAO = new PhoneDAO();
			System.out.print("test1");
			System.out.println(phonenumber.getServicePhoneNumber());
			System.out.println(phonenumber.getServiceProviderName());
			User user=(User)request.getSession().getAttribute("user");
			request.getSession().setAttribute("pn", phonenumber);
			
			
			phoneDAO.create(phonenumber.getServicePhoneNumber(),phonenumber.getServiceProviderName(),user);
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "redirect:/phoneAddedd.htm";
	}
	@RequestMapping(value="/phoneAddedd.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("rechargeDetails") RechargeDetails rechargeDetails, BindingResult result, HttpServletRequest request) {
		return "phoneAdded";
	}
	
	
	
}