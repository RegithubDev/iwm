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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import com.resustainability.reisp.common.DateParser;
import com.resustainability.reisp.constants.PageConstants;
import com.resustainability.reisp.model.Category;
import com.resustainability.reisp.model.City;
import com.resustainability.reisp.model.IRM;
import com.resustainability.reisp.model.Role;
import com.resustainability.reisp.model.SBU;
import com.resustainability.reisp.model.Transaction;
import com.resustainability.reisp.model.State;
import com.resustainability.reisp.model.User;
import com.resustainability.reisp.model.UserPaginationObject;
import com.resustainability.reisp.service.CategoryService;
import com.resustainability.reisp.service.IrisCityService;
import com.resustainability.reisp.service.IrisRoleService;
import com.resustainability.reisp.service.IrisSBUService;
import com.resustainability.reisp.service.IrisSiteService;
import com.resustainability.reisp.service.IrisStateService;
import com.resustainability.reisp.service.IrisTransactionsService;
import com.resustainability.reisp.service.IrisUserService;
import com.resustainability.reisp.service.UserService;

@RestController
public class IrisTransactionsController {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
	Logger logger = Logger.getLogger(IrisTransactionsController.class);
	
	@Autowired
	IrisTransactionsService service;

	@RequestMapping(value = "/ajax/upload-collect-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadCollectData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			//obj.setCreated_by(userId);
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadCollectData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value = "/ajax/upload-bmw-processing-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadBMWProcessingData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadBMWProcessingData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value = "/ajax/upload-bmw-distribute-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadBMWDistributeData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadBMWDistributeData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value = "/ajax/upload-iwm-disposal-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadIWMDisposalData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadIWMDisposalData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
	
	@RequestMapping(value = "/ajax/upload-iwm-leftoverstock-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadIWMLeftoverstockData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadIWMLeftoverstockData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
	
	
	@RequestMapping(value = "/ajax/upload-msw-distribute-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadMSWDistributeData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadMSWDistributeData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}

	@RequestMapping(value = "/ajax/upload-msw-processing-data", method = {RequestMethod.GET,RequestMethod.POST},produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String uploadMSWProcessingData(@RequestBody Transaction obj,HttpSession session) {
		String userId = null;
		String userName = null;
		String role = null;
		String msg = null;
		boolean flag = false;
		try {
			userId = (String) session.getAttribute("USER_ID");
			userName = (String) session.getAttribute("USER_NAME");
			role = (String) session.getAttribute("BASE_ROLE");
			if(StringUtils.isEmpty(obj.getCreated_by())) {
				obj.setCreated_by(userId);
			}
			flag = service.uploadMSWProcessingData(obj);
			if(flag == true) {
				msg ="Collect Data Uploaded Succesfully.";
			}
			else {
				msg = "Collecting Data failed. Try again.";
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.error("uploadCollectData : " + e.getMessage());
		}
		return msg;
	}
}
