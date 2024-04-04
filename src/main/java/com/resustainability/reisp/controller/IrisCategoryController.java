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
import com.resustainability.reisp.constants.PageConstants2;
import com.resustainability.reisp.model.Category;
import com.resustainability.reisp.model.CategoryPaginationObject;
import com.resustainability.reisp.model.SBU;
import com.resustainability.reisp.model.Category;
import com.resustainability.reisp.service.CategoryService;

@Controller
public class IrisCategoryController {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(IrisCategoryController.class);
	
	@Autowired
	CategoryService service;
	
	@RequestMapping(value = "/iris-category", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView iriscategory(@ModelAttribute Category user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants2.iriscategory);
		Category obj = null;
		try {
			List<Category> objList = service.getSBUList(obj);
			model.addObject("objList", objList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/ajax/getSBUFilterListForCategory", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getSBUFilterListForCategory(@ModelAttribute Category obj,HttpSession session) {
		List<Category> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getSBUFilterListForCategory(obj); 
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getSBUFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getCategoryFilterListForCategory", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getCategoryFilterListForCategory(@ModelAttribute Category obj,HttpSession session) {
		List<Category> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getCategoryFilterListForCategory(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCategoryFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getStatusFilterListForCategory", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getStatusFilterListForCategory(@ModelAttribute Category obj,HttpSession session) {
		List<Category> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getStatusFilterListForCategory(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getStatusFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/get-category-iris", method = { RequestMethod.POST, RequestMethod.GET })
	public void getCategorysList(@ModelAttribute Category obj, HttpServletRequest request,
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

			List<Category> budgetList = new ArrayList<Category>();

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

			CategoryPaginationObject personJsonObject = new CategoryPaginationObject();
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
					"getCategorysList : Category Id - " + userId + " - Category Name - " + userName + " - " + e.getMessage());
		}

		pw.println(json2);
	}

	/**
	 * @param searchParameter 
	 * @param activity 
	 * @return
	 */
	public int getTotalRecords(Category obj, String searchParameter) {
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
	public List<Category> createPaginationData(int startIndex, int offset, Category obj, String searchParameter) {
		List<Category> objList = null;
		try {
			objList = service.getCategoryList(obj, startIndex, offset, searchParameter);
		} catch (Exception e) {
			logger.error("createPaginationData : " + e.getMessage());
		}
		return objList;
	}
	
	@RequestMapping(value = "/add-category-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addCategoryIris(@ModelAttribute Category obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String userName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/iris-category");
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			obj.setCreated_by(userId);
			obj.setModified_date(null);
			flag = service.addCategory(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "Category Added Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Adding Category is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/update-category-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateCategoryIris(@ModelAttribute Category obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String userName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/iris-category");
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			obj.setModified_by(userId);
			obj.setModified_date(null);
			flag = service.updateCategory(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "Category Updated Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Updating Category is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

}
