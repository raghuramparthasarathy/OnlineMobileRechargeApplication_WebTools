package com.neu.edu.controlller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.neu.edu.dao.RechargeDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.RechargeModel;
import com.neu.edu.pojo.TransactionDetails;
import com.neu.edu.pojo.User;


@Controller
public class AddPriceController {

	@RequestMapping(value="/addedPrice.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("rechargeDetails") RechargeDetails rechargeDetails, BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			return "phoneAdded";
		}

		try {
			System.out.print("test");
			RechargeDAO rechargeDAO = new RechargeDAO();
			System.out.print("test1");	
			User user=(User)request.getSession().getAttribute("user");
			String temp=request.getParameter("amount");
			System.out.println(temp);
			
			PhoneNumber phonenumber=(PhoneNumber)request.getSession().getAttribute("phonenumber");
			System.out.println("inside0"+rechargeDetails.getAmount());
			System.out.println("inside phone"+phonenumber);
			RechargeDetails r = rechargeDAO.create(rechargeDetails.getRechargeID(), user,phonenumber, rechargeDetails.getAmount());
			System.out.println("innn"+r);
			request.getSession().setAttribute("rc", r);
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "redirect:/sample.htm";
		}
	
	@RequestMapping(value="/sample.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("transactiondetails") TransactionDetails transactiondetails, BindingResult result) {

		return "transactionPage";
	}

	
	
}