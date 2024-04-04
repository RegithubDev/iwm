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
import com.resustainability.reisp.common.DateParser;
import com.resustainability.reisp.constants.PageConstants2;
import com.resustainability.reisp.model.City;
import com.resustainability.reisp.model.IRM;
import com.resustainability.reisp.model.SBU;
import com.resustainability.reisp.model.Site;
import com.resustainability.reisp.model.SitePaginationObject;
import com.resustainability.reisp.model.State;
import com.resustainability.reisp.service.IrisCityService;
import com.resustainability.reisp.service.IrisSBUService;
import com.resustainability.reisp.service.IrisSiteService;
import com.resustainability.reisp.service.IrisStateService;
import com.resustainability.reisp.service.IrisSiteService;

@Controller
public class IrisSiteController {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(IrisSiteController.class);
	
	@Autowired
	IrisSiteService service;
	
	
	@Autowired
	IrisSBUService sbuService;
	
	@Autowired
	IrisStateService stateService;
	
	@Autowired
	IrisCityService cityService;
	
	@RequestMapping(value = "/sitemanagement", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView sitemanagement(@ModelAttribute Site site, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants2.siteUsers);
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	
	@RequestMapping(value = "/iris-addsite", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView irisaddsite(@ModelAttribute SBU obj, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants2.irisaddsite);
		try {
			model.addObject("action", "add");
			obj.setStatus("Active");
			List<SBU> sbuList = sbuService.getSBUFilterListForSBU(obj);
			model.addObject("sbuList", sbuList);
			
			State state = new State();
			state.setStatus("Active");
			List<State> stateList = stateService.getStateFilterListForState(state);
			model.addObject("stateList", stateList);
			
			City city = new City();
			city.setStatus("Active");
			List<City> cityList = cityService.getCityFilterListForCity(city);
			model.addObject("cityList", cityList);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/ajax/getCityFilterListWithStateForState", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<City> getCityFilterListWithStateForState(@ModelAttribute City obj,HttpSession session) {
		List<City> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setStatus("Active");
			companiesList = cityService.getCityFilterListForCity(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCityFilterListForSite : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/get-site-details", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView getSiteDetails(@ModelAttribute Site site, HttpSession session) {
		ModelAndView model = new ModelAndView(PageConstants2.irisaddsite);
		try {
			//List <Site> departmentsList = service.getDepartmentsList(null);
			//model.addObject("departmentsList", departmentsList);
			model.addObject("action", "edit");
			SBU sbu = new SBU();
			List<SBU> sbuList = sbuService.getSBUFilterListForSBU(sbu);
			model.addObject("sbuList", sbuList);
			
			State state = new State();
			state.setStatus("Active");
			List<State> stateList = stateService.getStateFilterListForState(state);
			model.addObject("stateList", stateList);
			
			City city = new City();
			city.setStatus("Active");
			List<City> cityList = cityService.getCityFilterListForCity(city);
			model.addObject("cityList", cityList);
			Site SiteDetails = service.getSiteDetails(site);
			model.addObject("SiteDetails", SiteDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}

	@RequestMapping(value = "/ajax/getSBUFilterListForSite", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Site> getSBUFilterListForSite(@ModelAttribute Site obj,HttpSession session) {
		List<Site> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			companiesList = service.getSBUFilterListForSite(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getSBUFilterListForSite : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getStateFilterListForSite", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Site> getStateFilterListForSite(@ModelAttribute Site obj,HttpSession session) {
		List<Site> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			
			
			companiesList = service.getStateFilterListForSite(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getStateFilterListForSite : " + e.getMessage());
		}
		return companiesList;
	}
	
	@RequestMapping(value = "/ajax/getCityFilterListForSite", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Site> getCityFilterListForSite(@ModelAttribute Site obj,HttpSession session) {
		List<Site> companiesList = null;
		String userId = null;
		String siteName = null;
		String role = null;
		try {
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			obj.setSbu_code(obj.getSbu());
			companiesList = service.getCityFilterListForSite(obj);
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("getCityFilterListForSite : " + e.getMessage());
		}
		return companiesList;
	}
	
	
	@RequestMapping(value = "/ajax/get-site-iris", method = { RequestMethod.POST, RequestMethod.GET })
	public void getSitesList(@ModelAttribute Site obj, HttpServletRequest request,
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

			List<Site> budgetList = new ArrayList<Site>();

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

			SitePaginationObject personJsonObject = new SitePaginationObject();
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
					"getSitesList : Site Id - " + userId + " - Site Name - " + siteName + " - " + e.getMessage());
		}

		pw.println(json2);
	}

	/**
	 * @param searchParameter 
	 * @param activity 
	 * @return
	 */
	public int getTotalRecords(Site obj, String searchParameter) {
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
	public List<Site> createPaginationData(int startIndex, int offset, Site obj, String searchParameter) {
		List<Site> objList = null;
		try {
			objList = service.getSiteList(obj, startIndex, offset, searchParameter);
		} catch (Exception e) {
			logger.error("createPaginationData : " + e.getMessage());
		}
		return objList;
	}
	
	@RequestMapping(value = "/add-site-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView addSiteIris(@ModelAttribute Site obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String siteName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/sitemanagement");
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			obj.setCreated_by(userId);
			obj.setModified_date(null);
			flag = service.addSiteIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "Site Added Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Adding Site is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
	
	@RequestMapping(value = "/update-site-iris", method = {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView updateSiteIris(@ModelAttribute Site obj,RedirectAttributes attributes,HttpSession session) {
		boolean flag = false;
		String userId = null;
		String siteName = null;
		ModelAndView model = new ModelAndView();
		try {
			model.setViewName("redirect:/sitemanagement");
			userId = (String) session.getAttribute("USER_ID");
			siteName = (String) session.getAttribute("USER_NAME");
			obj.setModified_by(userId);
			obj.setModified_date(null);
			flag = service.updateSiteIris(obj);
			if(flag == true) {
				attributes.addFlashAttribute("success", "Site Updated Succesfully.");
			}
			else {
				attributes.addFlashAttribute("error","Updating Site is failed. Try again.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return model;
	}
}
