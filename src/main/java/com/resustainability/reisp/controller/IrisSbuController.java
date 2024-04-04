package com.resustainability.reisp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.resustainability.reisp.constants.PageConstants;
import com.resustainability.reisp.model.SBU;
import com.resustainability.reisp.model.SBUPaginationObject;
import com.resustainability.reisp.model.User;
import com.resustainability.reisp.service.IrisSBUService;

@Controller
public class IrisSbuController {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(IrisSbuController.class);
	
	@Autowired
	IrisSBUService service;
	
	@RequestMapping(value = "/iris-sbu", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView irissbu(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.irissbu);
		SBU obj = null;
		try {
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/ajax/getSBUFilterListForSBU", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SBU> getSBUFilterListForSBU(@ModelAttribute SBU obj,HttpSession session) {
		List<SBU> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getSBUFilterListForSBU(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getSBUFilterListForSBU : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getStatusFilterListForSBU", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SBU> getStatusFilterListForSBU(@ModelAttribute SBU obj,HttpSession session) {
		List<SBU> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getStatusFilterListForSBU(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getStatusFilterListForSBU : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/get-sbu-iris", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSBUsList(@ModelAttribute SBU obj, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) throws IOException {
		PrintWriter pw = null;
		//JSONObject json = new JSONObject();
		String json2 = null;
		String userId = null;
		String siteName = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");

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

			List<SBU> budgetList = new ArrayList<SBU>();

			//Here is server side pagination logic. Based on the page number you could make call 
			//to the data base create new list and send back to the client. For com.resustainability.brainbox I am shuffling 
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

			SBUPaginationObject personJsonObject = new SBUPaginationObject();
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
					"getSBUsList : SBU Id - " + userId + " - SBU Name - " + siteName + " - " + e.getMessage());
		}

		pw.println(json2);
	}

	/**
	 * @param searchParameter 
	 * @param activity 
	 * @return
	 */
	public int getTotalRecords(SBU obj, String searchParameter) {
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
	public List<SBU> createPaginationData(int startIndex, int offset, SBU obj, String searchParameter) {
		List<SBU> objList = null;
		try {
			objList = service.getSBUList(obj, startIndex, offset, searchParameter);
		} catch (Exception e) {
			logger.error("createPaginationData : " + e.getMessage());
		}
		return objList;
	}
	
	@RequestMapping(value = "/add-sbu-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addSBUIris(@ModelAttribute SBU obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String siteName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/iris-sbu");
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			obj.setCreated_by(userId);
			obj.setModified_date(null);
			flag = service.addSBUIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "SBU Added Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Adding SBU is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/update-sbu-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateSBUIris(@ModelAttribute SBU obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String siteName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/iris-sbu");
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			obj.setModified_by(userId);
			obj.setModified_date(null);
			flag = service.updateSBUIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "SBU Updated Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Updating SBU is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
