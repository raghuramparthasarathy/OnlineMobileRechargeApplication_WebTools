package com.neu.edu.controlller;

import javax.servlet.http.HttpServletRequest;
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

import com.neu.edu.dao.AdminDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.Plan;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;


@Controller
public class AdminController {

	@RequestMapping(value="/addProvider.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("sp") ServiceProvider sp, BindingResult result, HttpServletRequest request) throws Exception {
		
		if (result.hasErrors()) {
			return "adminLogin";
		}
		System.out.println("inisde admin con");
		try {
			System.out.print("test");
			AdminDAO adminDAO = new AdminDAO();
			System.out.print("test1");
			
			ServiceProvider service = adminDAO.create(sp.getServiceProviderID(), sp.getServiceProviderName());
			HttpSession sess = request.getSession();
			sess.setAttribute("service",service );
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "redirect:/provideradd.htm";
	}

	@RequestMapping(value="/adminLogin.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("sp") ServiceProvider sp, BindingResult result) {

		return "adminLogin";
	}
	
	@RequestMapping(value="/provideradd.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("plan") Plan plan, BindingResult result) {

		return "providerAdded";
	}
}