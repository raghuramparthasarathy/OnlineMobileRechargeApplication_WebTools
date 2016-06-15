package com.neu.edu.controlller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.neu.edu.dao.RechargeDAO;
import com.neu.edu.dao.TransactionDAO;
import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.PdfReportView;
import com.neu.edu.pojo.PhoneNumber;
import com.neu.edu.pojo.RechargeDetails;
import com.neu.edu.pojo.TransactionDetails;
import com.neu.edu.pojo.User;


@Controller
public class TransactionController {

	@RequestMapping(value="/addTransaction.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("transactiondetails") TransactionDetails transactiondetails, BindingResult result, HttpServletRequest request) throws Exception {
		if (result.hasErrors()) {
			return "transactionPage";
		}

		try {
			System.out.print("test");
			TransactionDAO transactionDAO = new TransactionDAO();
			System.out.print("test1");
			
			RechargeDetails rc=(RechargeDetails)request.getSession().getAttribute("rc");
			
			request.getSession().setAttribute("tc", transactiondetails);
			
			transactionDAO.create(transactiondetails.getTransactionID(),rc,rc, transactiondetails.getCard(),transactiondetails.getCardNumber(),transactiondetails.getExpMonth(),
					transactiondetails.getExpYear(),transactiondetails.getCvv(),transactiondetails.getMessage() );
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		
		return "transactionAdded";
	}
	@RequestMapping(value="/generatePDF")
	public ModelAndView createReport(HttpServletRequest req)
    {
        
        View view = new PdfReportView();
        return new ModelAndView(view);
    }

	
}