package com.resustainability.reisp.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.resustainability.reisp.constants.PageConstants;
import com.resustainability.reisp.model.IRM;
import com.resustainability.reisp.model.IWM;
import com.resustainability.reisp.model.IWMPaginationObject;
import com.resustainability.reisp.model.IWM;
import com.resustainability.reisp.model.User;
import com.resustainability.reisp.service.IrisUserService;
import com.resustainability.reisp.service.UserService;

@RestController
public class HomeController {
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(HomeController.class);
	
	@Autowired
	IrisUserService service;
	
	@Autowired
	UserService service1;

	@Value("${Login.Form.Invalid}")
	public String invalidIWMName;

	@RequestMapping(value = "/home", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView user(@ModelAttribute IWM user,IRM obj, HttpSession session) {
		ModelAndView model = null;
		String userId = null;
		String userName = null;
		String role = null;
		List<IRM> companiesList = null;
		try {   
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			String email = (String) session.getAttribute("USER_EMAIL");
			obj.setRole(role);
			obj.setUser(userId);
			User uBoj = new User();
			uBoj.setEmail_id(email);
			//companiesList = service2.UserIRMLAzyList(obj, 0, 10, email);
			//user.setUser_id(userId);
			//user.setRole(role);
			if(role.equals("Admin") || role.equals("Monitor")) {
				 model = new ModelAndView(PageConstants.dashboardAdmin);
			}else if(role.equals("User")) {
				 model = new ModelAndView(PageConstants.dashboardAdmin);
			}else {
				model = new ModelAndView(PageConstants.dashboardAdmin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/dash-sd", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView userSD(@ModelAttribute User user,IRM obj, HttpSession session) {
		ModelAndView model = null;
		String userId = null;
		String userName = null;
		String role = null;
		List<IRM> companiesList = null;
		try {   
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			String email = (String) session.getAttribute("USER_EMAIL");
			obj.setRole(role);
			obj.setUser(userId);
			User uBoj = new User();
			uBoj.setEmail_id(email);
			User userDetails = service1.validateUser(uBoj);
			user.setUser_id(userId);
			user.setRole(role);
			if(role.equals("Admin") || role.equals("Management")) {
				
			}else if(role.equals("User")) {
				 }
			
			
			//List <User> deptList = service.getDeptList(user);
			//model.addObject("deptList", deptList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/ajax/getSiteFilterListForIWM", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<IWM> getSiteFilterListForIWM(@ModelAttribute IWM obj,HttpSession session) {
		List<IWM> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getSiteFilterListForIWM(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getSiteFilterListForIWM : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/get-iwm-list", method = { RequestMethod.POST, RequestMethod.GET })
	public void getIWMsList(@ModelAttribute IWM obj, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		PrintWriter pw = null;
		//JSONObject json = new JSONObject();
		String json2 = null;
		String userId = null;
		String userName = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");

			pw = response.getWriter();
			//Fetch the page number from client
			Integer pageNumber = 0;
			Integer pageDisplayLength = 0;
			if (null != request.getParameter("iDisplayStart")) {
				pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));
				pageNumber = (Integer.valueOf(request.getParameter("iDisplayStart")) / pageDisplayLength) + 1;
			}
			//Fetch search parameter
			String searchParameter = request.getParameter("sSearch");

			//Fetch Page display length
			pageDisplayLength = Integer.valueOf(request.getParameter("iDisplayLength"));

			List<IWM> budgetList = new ArrayList<IWM>();

			//Here is server side pagination logic. Based on the page number you could make call 
			//to the data base create new list and send back to the client. For com.resustainability.reirm I am shuffling 
			//the same list to show data randomly
			int startIndex = 0;
			int offset = pageDisplayLength;

			if (pageNumber == 1) {
				startIndex = 0;
				offset = pageDisplayLength;
				budgetList = createPaginationData(startIndex, offset, obj, searchParameter);
			} else {
				startIndex = (pageNumber * offset) - offset;
				offset = pageDisplayLength;
				budgetList = createPaginationData(startIndex, offset, obj, searchParameter);
			}

			//Search functionality: Returns filtered list based on search parameter
			//budgetList = getListBasedOnSearchParameter(searchParameter,budgetList);

			int totalRecords = getTotalRecords(obj, searchParameter);

			IWMPaginationObject personJsonObject = new IWMPaginationObject();
			//Set Total display record
			personJsonObject.setiTotalDisplayRecords(totalRecords);
			//Set Total record
			personJsonObject.setiTotalRecords(totalRecords);
			personJsonObject.setAaData(budgetList);

			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			json2 = gson.toJson(personJsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(
					"getIWMsList : IWM Id - " + userId + " - IWM Name - " + userName + " - " + e.getMessage());
		}

		pw.println(json2);
	}

	/**
	 * @param searchParameter 
	 * @param activity 
	 * @return
	 */
	public int getTotalRecords(IWM obj, String searchParameter) {
		int totalRecords = 0;
		try {
			totalRecords = service.getTotalRecords(obj, searchParameter);
		} catch (Exception e) {
			logger.error("getTotalRecords : " + e.getMessage());
		}
		return totalRecords;
	}

	/**
	 * @param pageDisplayLength
	 * @param offset 
	 * @param activity 
	 * @param clientId 
	 * @return
	 */
	public List<IWM> createPaginationData(int startIndex, int offset, IWM obj, String searchParameter) {
		List<IWM> objList = null;
		try {
			objList = service.getIWMList(obj, startIndex, offset, searchParameter);
		} catch (Exception e) {
			logger.error("createPaginationData : " + e.getMessage());
		}
		return objList;
	}
	

}
	