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
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.AjaxModel;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.Plan;
import com.neu.edu.pojo.ServiceProvider;
import com.neu.edu.pojo.User;


@Controller
public class AddPlanController {

	@RequestMapping(value="/addedProvider.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("plan") Plan plan	, BindingResult result,HttpServletRequest request) throws Exception {
		
		if (result.hasErrors()) {
			return "adminLogin";
		}

		try {
			System.out.print("test");
			PlanDAO planDAO = new PlanDAO();
			System.out.print("test1");
			HttpSession session = request.getSession();
			String sp_name = (String)session.getAttribute("serviceProvider");
//			ServiceProvider ss = (ServiceProvider) session.getAttribute("serviceProvider");
			System.out.println(plan);
			
			
			planDAO.create(sp_name,plan.getPlanID(),plan.getPlanName(),plan.getPrice());	
			
			
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "planAdded";
	}
	
	@RequestMapping(value="/addPlan.htm", method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("plan") Plan plan, BindingResult result) {
		System.out.println("ghjgjhgjh");
		return "addPlan";
	}
	
	@RequestMapping(value="/plansAsJson.htm", method = RequestMethod.GET)
	public @ResponseBody List<AjaxModel> getPlans(HttpServletRequest request,HttpServletResponse response,Model model) {
		List<AjaxModel> planList=new ArrayList<AjaxModel>();
		PlanDAO planDAO = new PlanDAO();
		try {
			planList=planDAO.getPlans();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return planList;
		
		
		
	}
	
	

	
}