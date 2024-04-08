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
import org.springframework.util.StringUtils;
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
import com.resustainability.reisp.common.DateParser;
import com.resustainability.reisp.constants.PageConstants;
import com.resustainability.reisp.model.Category;
import com.resustainability.reisp.model.City;
import com.resustainability.reisp.model.IRM;
import com.resustainability.reisp.model.Role;
import com.resustainability.reisp.model.SBU;
import com.resustainability.reisp.model.Site;
import com.resustainability.reisp.model.State;
import com.resustainability.reisp.model.User;
import com.resustainability.reisp.model.UserPaginationObject;
import com.resustainability.reisp.service.CategoryService;
import com.resustainability.reisp.service.IrisCityService;
import com.resustainability.reisp.service.IrisRoleService;
import com.resustainability.reisp.service.IrisSBUService;
import com.resustainability.reisp.service.IrisSiteService;
import com.resustainability.reisp.service.IrisStateService;
import com.resustainability.reisp.service.IrisUserService;
import com.resustainability.reisp.service.UserService;

@Controller
public class IrisUserController {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(IrisUserController.class);
	
	@Autowired
	IrisUserService service;
	
	@Autowired
	IrisRoleService roleService;

	@Autowired
	IrisSBUService sbuService;
	
	@Autowired
	IrisStateService stateService;
	
	@Autowired
	CategoryService catService;

	@Autowired
	IrisCityService cityService;
	
	@Autowired
	IrisSiteService siteService;
	
	@RequestMapping(value = "/usermanagement", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView irisusermanagement(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.irisusermanagement);
		try {
			Role obj = new Role();
			List<Role> objList = roleService.getSBUList(obj);
			model.addObject("objList", objList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/add-role-iris-user", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addRoleIris(@ModelAttribute Role obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String siteName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/usermanagement");
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			obj.setCreated_by(userId);
			obj.setModified_date(null);
			obj.setStatus("Active");
			flag = roleService.addRoleIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "Role Added Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Adding Role is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/iris-accountinfo", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView irisaccountinfo(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.irisaccountinfo);
		try {
			String userId = (String) session.getAttribute("USER_ID");
			user.setId(userId);
			User userDetails = service.getUserDetails(user);
			model.addObject("UserDetails", userDetails);
			session.setAttribute("user", userDetails);
			session.setAttribute("USER_NAME", userDetails.getUser_name());
			session.setAttribute("BASE_SBU", userDetails.getSbu());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/update-user-self-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateUserSelfIris(@ModelAttribute User obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String userName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/iris-accountinfo");
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			obj.setModified_by(userId);
			obj.setId(userId);
			flag = service.updateUserSelfIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "User Updated Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Updating User is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/iris-adduser", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView irisadduser(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.irisadduser);
		try {
			model.addObject("action", "add");
			
			SBU obj = new SBU();
			obj.setStatus("Active");
			List<SBU> sbuList = sbuService.getSBUFilterListForSBU(obj);
			model.addObject("sbuList", sbuList);
		
			Category cat = new Category();
			cat.setStatus("Active");
			List<Category> catList = catService.getCategoryFilterListForCategory(cat);
			model.addObject("catList", catList);
			
			Role role = new Role();
			role.setStatus("Active");
			List<Role> roleList = roleService.getRoleFilterListForRole(role);
			model.addObject("roleList", roleList);
		
			
			Site site1 = new Site();
			site1.setStatus("Active");
			site1.setSbu_code(obj.getSbu());
			List<Site> cityList = siteService.getCityFilterListForSite(site1);
			model.addObject("cityList", cityList);
			
			
			Site site = new Site();
			site.setStatus("Active");
			List<Site> siteList = siteService.getSiteList(site);
			model.addObject("siteList", siteList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/ajax/getSiteFilterListWithCityForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Site> getSiteList(@ModelAttribute Site obj,HttpSession session) {
		List<Site> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setStatus("Active");
			companiesList = siteService.getSiteList(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCategoryFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getCitiesFilterListWithSBUForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<City> getCitiesFilterListWithSBUForUser(@ModelAttribute City obj,HttpSession session) {
		List<City> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setSbu_code(obj.getSbu());
			obj.setStatus("Active");
			companiesList = cityService.getCityFilterListForCity(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCitiesFilterListWithSBUForUser : " + e.getMessage());
		}
		return companiesList;
	}
	
	
	@RequestMapping(value = "/ajax/getCategoryFilterListWithSBUForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Category> getCityFilterListWithStateForState(@ModelAttribute Category obj,HttpSession session) {
		List<Category> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setStatus("Active");
			obj.setSbu_code(obj.getSbu());
			companiesList = catService.getCategoryFilterListForCategory(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCategoryFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getRolesFilterListWithSBUForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Role> getRolesFilterListWithSBUForUser(@ModelAttribute Role obj,HttpSession session) {
		List<Role> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setStatus("Active");
			obj.setSbu_code(obj.getSbu());
			companiesList = roleService.getRoleFilterListForRole(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCategoryFilterListForCategory : " + e.getMessage());
		}
		return companiesList;
	}
	
	
	@RequestMapping(value = "/get-user-details", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView getUserDetails(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.irisadduser);
		try {
			
			model.addObject("action", "edit");
			User UserDetails = service.getUserDetails(user);
			model.addObject("UserDetails", UserDetails);
			
			SBU obj = new SBU();
			obj.setStatus("Active");
			List<SBU> sbuList = sbuService.getSBUFilterListForSBU(obj);
			model.addObject("sbuList", sbuList);
		
			Category cat = new Category();
			cat.setStatus("Active");
			cat.setSbu_code(UserDetails.getSbu());
			List<Category> catList = catService.getCategoryFilterListForCategory(cat);
			model.addObject("catList", catList);
			
			Role role = new Role();
			role.setStatus("Active");
			role.setSbu_code(UserDetails.getSbu());
			List<Role> roleList = roleService.getRoleFilterListForRole(role);
			model.addObject("roleList", roleList);
			

			Site site1 = new Site();
			site1.setStatus("Active");
			site1.setSbu_code(UserDetails.getSbu());
			List<Site> cityList = siteService.getCityFilterListForSite(site1);
			model.addObject("cityList", cityList);
			
			
			Site site = new Site();
			site.setStatus("Active");
			List<Site> siteList = siteService.getSiteList(site, 0, 1000, null);
			model.addObject("siteList", siteList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/create-new", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView signUp(@ModelAttribute User user, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants.signUp);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/ajax/getDepartmentFilterListForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getDepartmentFilterListForUser(@ModelAttribute User obj,HttpSession session) {
		List<User> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setUser_id(userId);
			obj.setRole(role);
			
			companiesList = service.getDepartmentFilterListForUser(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getDepartmentFilterListForUser : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getSiteFilterListForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getSiteFilterListForUser(@ModelAttribute User obj,HttpSession session) {
		List<User> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setUser_id(userId);
			obj.setRole(role);
			
			companiesList = service.getSiteFilterListForUser(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getSiteFilterListForUser : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getRoleFilterListForUser", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<User> getRoleFilterListForUser(@ModelAttribute User obj,HttpSession session) {
		List<User> companiesList = null;
		String userId = null;
		String userName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setUser_id(userId);
			obj.setRole(role);
			
			companiesList = service.getRoleFilterListForUser(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getRoleFilterListForUser : " + e.getMessage());
		}
		return companiesList;
	}
	
	
	@RequestMapping(value = "/ajax/get-users-iris", method = { RequestMethod.POST, RequestMethod.GET })
	public void getUsersList(@ModelAttribute User obj, HttpServletRequest request,
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

			List<User> budgetList = new ArrayList<User>();

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

			UserPaginationObject personJsonObject = new UserPaginationObject();
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
					"getUsersList : User Id - " + userId + " - User Name - " + userName + " - " + e.getMessage());
		}

		pw.println(json2);
	}

	/**
	 * @param searchParameter 
	 * @param activity 
	 * @return
	 */
	public int getTotalRecords(User obj, String searchParameter) {
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
	public List<User> createPaginationData(int startIndex, int offset, User obj, String searchParameter) {
		List<User> objList = null;
		try {
			objList = service.getUserList(obj, startIndex, offset, searchParameter);
		} catch (Exception e) {
			logger.error("createPaginationData : " + e.getMessage());
		}
		return objList;
	}
	
	@RequestMapping(value = "/add-user-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addUserIris(@ModelAttribute User obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String userName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/usermanagement");
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			obj.setCreated_by(userId);
			obj.setModified_date(null);
			flag = service.addUserIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "User Added Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Adding User is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/update-user-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateUserIris(@ModelAttribute User obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String userName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/usermanagement");
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			if(StringUtils.isEmpty(obj.getModified_by())) {
				obj.setModified_by(userId);
			}
			obj.setModified_date(null);
			flag = service.updateUserIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "User Updated Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Updating User is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
