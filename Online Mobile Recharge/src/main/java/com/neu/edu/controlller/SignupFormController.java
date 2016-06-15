package com.neu.edu.controlller;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.neu.edu.dao.UserDAO;
import com.neu.edu.exception.AdException;
import com.neu.edu.pojo.User;


@Controller
@RequestMapping("/signUpUser.htm")
public class SignupFormController {

	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@RequestParam("pic")MultipartFile file1, @ModelAttribute("user") User user, BindingResult result, MultipartHttpServletRequest req) throws Exception {
		if (result.hasErrors()) {
			return "addUserForm";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			System.out.print("test1");
			File file;
	        String check = File.separator; 
	        String path = null;
	        if (check.equalsIgnoreCase("\\")) {
	            path = servletContext.getRealPath("").replace("build\\", "");
	        }

	        if (check.equalsIgnoreCase("/")) {
	            path = servletContext.getRealPath("").replace("build/", "");
	            path += "/";

	        }
	        if (user.getPic() != null) {
	            String fileNameWithExt = System.currentTimeMillis() + user.getPic().getOriginalFilename();

	            file = new File(path + fileNameWithExt);
	            String context = servletContext.getContextPath();

	            user.getPic().transferTo(file);

	            user.setPicName(context + "/" + fileNameWithExt);
	            userDao.create(user.getName(), user.getPhone(),user.getEmail(), user.getUsername(), user.getPassword(), user.getConfirmPassword(), user.getPicName());
	        }
			
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "addUserForm";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {

		return "addUserForm";
	}
}