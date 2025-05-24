package com.resustainability.reisp.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

	@Value("${common.error.message}")
	public String commonError;
	
	@Value("${record.dataexport.success}")
	public String dataExportSucess;
	
	@Value("${record.dataexport.invalid.directory}")
	public String dataExportInvalid;
	
	@Value("${record.dataexport.error}")
	public String dataExportError;
	
	@Value("${record.dataexport.nodata}")
	public String dataExportNoData;
	
	@Value("${template.upload.common.error}")
	public String uploadCommonError;
	
	@Value("${template.upload.formatError}")
	public String uploadformatError;
	
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
	
	@RequestMapping(value = "/export-iwm", method = {RequestMethod.GET,RequestMethod.POST})
	public void exportIRM(HttpServletRequest request, HttpServletResponse response,HttpSession session,@ModelAttribute IWM obj,RedirectAttributes attributes){
		ModelAndView view = new ModelAndView(PageConstants.dashboardAdmin);
		List<IWM> dataList = new ArrayList<IWM>();
		String userId = null;String userName = null;
		try {
			userId = (String) session.getAttribute("USER_ID");userName = (String) session.getAttribute("USER_NAME");
			view.setViewName("redirect:/home");
			int sNo = 0;sNo++;
			dataList = service.getIWMList(obj); 
			if(dataList != null && dataList.size() > 0){
	            XSSFWorkbook  workBook = new XSSFWorkbook ();
	            XSSFSheet sheet = workBook.createSheet(WorkbookUtil.createSafeSheetName("IWM"));
		        workBook.setSheetOrder(sheet.getSheetName(), 0);
		        
		        byte[] blueRGB = new byte[]{(byte)0, (byte)176, (byte)240};
		        byte[] yellowRGB = new byte[]{(byte)255, (byte)192, (byte)0};
		        byte[] greenRGB = new byte[]{(byte)146, (byte)208, (byte)80};
		        byte[] redRGB = new byte[]{(byte)255, (byte)0, (byte)0};
		        byte[] whiteRGB = new byte[]{(byte)255, (byte)255, (byte)255};
		        
		        boolean isWrapText = true;boolean isBoldText = true;boolean isItalicText = false; int fontSize = 11;String fontName = "Times New Roman";
		        CellStyle blueStyle = cellFormating(workBook,blueRGB,HorizontalAlignment.CENTER,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        CellStyle yellowStyle = cellFormating(workBook,yellowRGB,HorizontalAlignment.CENTER,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        CellStyle greenStyle = cellFormating(workBook,greenRGB,HorizontalAlignment.CENTER,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        CellStyle redStyle = cellFormating(workBook,redRGB,HorizontalAlignment.CENTER,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        CellStyle whiteStyle = cellFormating(workBook,whiteRGB,HorizontalAlignment.CENTER,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        
		        CellStyle indexWhiteStyle = cellFormating(workBook,whiteRGB,HorizontalAlignment.LEFT,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        
		        isWrapText = true;isBoldText = false;isItalicText = false; fontSize = 9;fontName = "Times New Roman";
		        CellStyle sectionStyle = cellFormating(workBook,whiteRGB,HorizontalAlignment.LEFT,VerticalAlignment.CENTER,isWrapText,isBoldText,isItalicText,fontSize,fontName);
		        
		        
	            XSSFRow headingRow = sheet.createRow(0);
	        	String headerString = "#,IWMA NO,MANIFEST NO,CUSTOMER,PLANT NAME	,DATE,WASTE NAME	,DISPOSAL METHOD,QTY IN KG" + 
	    				"";
	            String[] firstHeaderStringArr = headerString.split("\\,");
	            
	            for (int i = 0; i < firstHeaderStringArr.length; i++) {		        	
		        	Cell cell = headingRow.createCell(i);
			        cell.setCellStyle(greenStyle);
					cell.setCellValue(firstHeaderStringArr[i]);
				}
	            
	            short rowNo = 1;
	            for (IWM obj1 : dataList) {
	                XSSFRow row = sheet.createRow(rowNo);
	                int c = 0;
	              
	                
	                Cell cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue(sNo++);
					
				    cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getIwma_no());
						
	                cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getManifest_no());
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getName1_name());
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getProject_name());
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getErdat_creationDate());
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getWaste_name());
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getDisposal_method());
					
					
					cell = row.createCell(c++);
					cell.setCellStyle(sectionStyle);
					cell.setCellValue (obj1.getManifest_Weight());
					
	                rowNo++;
	            }
	            for(int columnIndex = 0; columnIndex < firstHeaderStringArr.length; columnIndex++) {
	        		sheet.setColumnWidth(columnIndex, 25 * 200);
	        		sheet.setColumnWidth(3, 100 * 150);
				}
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
                Date date = new Date();
                String fileName = "IWM_"+dateFormat.format(date);
                
	            try{
	                /*FileOutputStream fos = new FileOutputStream(fileDirectory +fileName+".xls");
	                workBook.write(fos);
	                fos.flush();*/
	            	
	               response.setContentType("application/.csv");
	 			   response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	 			   response.setContentType("application/vnd.ms-excel");
	 			   // add response header
	 			   response.addHeader("Content-Disposition", "attachment; filename=" + fileName+".xlsx");
	 			   
	 			    //copies all bytes from a file to an output stream
	 			   workBook.write(response.getOutputStream()); // Write workbook to response.
		           workBook.close();
	 			    //flushes output stream
	 			    response.getOutputStream().flush();
	            	
	                
	                attributes.addFlashAttribute("success",dataExportSucess);
	            	//response.setContentType("application/vnd.ms-excel");
	            	//response.setHeader("Content-Disposition", "attachment; filename=filename.xls");
	            	//XSSFWorkbook  workbook = new XSSFWorkbook ();
	            	// ...
	            	// Now populate workbook the usual way.
	            	// ...
	            	//workbook.write(response.getOutputStream()); // Write workbook to response.
	            	//workbook.close();
	            }catch(FileNotFoundException e){
	                //e.printStackTrace();
	                attributes.addFlashAttribute("error",dataExportInvalid);
	            }catch(IOException e){
	                //e.printStackTrace();
	                attributes.addFlashAttribute("error",dataExportError);
	            }
         }else{
        	 attributes.addFlashAttribute("error",dataExportNoData);
         }
		}catch(Exception e){	
			e.printStackTrace();
			logger.error("exportCompany : : User Id - "+userId+" - User Name - "+userName+" - "+e.getMessage());
			attributes.addFlashAttribute("error", commonError);			
		}
		//return view;
	}
	

	private CellStyle cellFormating(XSSFWorkbook workBook,byte[] rgb,HorizontalAlignment hAllign, VerticalAlignment vAllign, boolean isWrapText,boolean isBoldText,boolean isItalicText,int fontSize,String fontName) {
		CellStyle style = workBook.createCellStyle();
		//Setting Background color  
		//style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		if (style instanceof XSSFCellStyle) {
		   XSSFCellStyle xssfcellcolorstyle = (XSSFCellStyle)style;
		   xssfcellcolorstyle.setFillForegroundColor(new XSSFColor(rgb, null));
		}
		//style.setFillPattern(FillPatternType.ALT_BARS);
		style.setBorderBottom(BorderStyle.MEDIUM);
		style.setBorderTop(BorderStyle.MEDIUM);
		style.setBorderLeft(BorderStyle.MEDIUM);
		style.setBorderRight(BorderStyle.MEDIUM);
		style.setAlignment(hAllign);
		style.setVerticalAlignment(vAllign);
		style.setWrapText(isWrapText);
		
		Font font = workBook.createFont();
        //font.setColor(HSSFColor.HSSFColorPredefined.WHITE.getIndex());
        font.setFontHeightInPoints((short)fontSize);  
        font.setFontName(fontName);  //"Times New Roman"
        
        font.setItalic(isItalicText); 
        font.setBold(isBoldText);
        // Applying font to the style  
        style.setFont(font); 
        
        return style;
	}

}
	