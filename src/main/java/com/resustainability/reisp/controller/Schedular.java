package com.resustainability.reisp.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.resustainability.reisp.common.DateParser;
import com.resustainability.reisp.model.DashBoardWeighBridge;
import com.resustainability.reisp.model.IWM;
import com.resustainability.reisp.service.DashBoardWeighBridgeService;


@Controller
public class Schedular {
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    } 
	public static Logger logger = Logger.getLogger(Schedular.class);
	
	@Autowired
	LoginController loginController;
	
	@Autowired
	
	@Value("${common.error.message}")
	public String commonError;
	
	@Value("${run.cron.jobs}")
	public boolean is_cron_jobs_enabled;
	
	@Value("${run.cron.jobs.in.qa}")
	public boolean is_cron_jobs_enabled_in_qa;
	
	@Autowired
	DashBoardWeighBridgeService service;

	/**********************************************************************************/
	@Scheduled(cron = "${cron.expression.user.login.timeout}")
	public void userLoginTimeout() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 			List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        String yesterdaysDate = yesterday.format(formatter);
 			pData.forEach(plist-> {
 				
 				 String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json"
 				 		+ "&$filter=20CreationDate%20eq%20%27"
 			    		 
		     		+ yesterdaysDate
		     		+ "%27%20or%20CreationDate%20ge%20datetime%27"
		     		
		     		+ yesterdaysDate
		     		
		     		+ "%27%20"
		     		+ ""
		     		+ "and%20Werks_plant%20eq%20%27"
		     		
		     		+ plist.getProject()
		     		
		     		+ "%27%20";
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                        //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWMRecords(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList + " - "+resultsArray.length());
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
		     }
	}
	
	@Scheduled(cron = "${cron.expression.user.login.weight3}")
	public void WEIGHT() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 			List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 			pData.forEach(plist-> {
 	

		     String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3626'%20and%20CreationDate%20le%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                     //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
		     }
	}
	
	@Scheduled(cron = "${cron.expression.user.login.weight2}")
	public void WEIGHT2() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 			//List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 		//	pData.forEach(plist-> {
 	

 	       String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3614'%20and%20CreationDate%20eq%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
 	       
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                        //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }//});
		     }
	}
	
	@Scheduled(cron = "${cron.expression.user.login.weight1}")
	public void WEIGHT3() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 		//	List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 		//	pData.forEach(plist-> {
 				
 	       String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3603'%20and%20CreationDate%20eq%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
 	       
 			
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                        //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }//});
		     }
	}
	private String capitalize( String line) {
		 char[] charArray = line.toCharArray();
		    boolean foundSpace = true;

		    for(int i = 0; i < charArray.length; i++) {

		      // if the array element is a letter
		      if(Character.isLetter(charArray[i])) {

		        // check space is present before the letter
		        if(foundSpace) {
		          // change the letter into uppercase
		          charArray[i] = Character.toUpperCase(charArray[i]);
		          foundSpace = false;
		        }
		      }
		      else {
		        // if the new character is not character
		        foundSpace = true;
		      }
		    }
		    line = String.valueOf(charArray);
			return line;
		}
	
	/**********************************************************************************/	
	@Scheduled(cron = "${cron.expression.run.procedures}")
	public void WEIGHTRE() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 			List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 			pData.forEach(plist-> {
 	

		     String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3626'%20and%20CreationDate%20le%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                     //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }});
		     }
	}
	
	@Scheduled(cron = "${cron.expression.run.procedures1}")
	public void WEIGHT22() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 			//List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 		//	pData.forEach(plist-> {
 	

 	       String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3614'%20and%20CreationDate%20eq%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
 	       
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                        //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }//});
		     }
	}
	
	@Scheduled(cron = "${cron.expression.run.procedures2}")
	public void WEIGHT33() throws Exception{	
		 IWM obj = null;
		 HashMap<String, String> data1 = new HashMap<String, String>();
		 ObjectMapper objectMapper = new ObjectMapper();
 		if(is_cron_jobs_enabled || is_cron_jobs_enabled_in_qa) {
 		//	List<DashBoardWeighBridge> pData = service.projectsIWMList("IWM");
 		    LocalDate yesterday = LocalDate.now().minusDays(1);
 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
 	        System.out.println("wfw");
 	        String yesterdaysDate = yesterday.format(formatter);
 		//	pData.forEach(plist-> {
 				
 	       String url = "http://10.100.1.7:8000/sap/opu/odata/sap/ZIWM_REPORT_CDS/ZIWM_REPORT?$format=json&$filter=Plant%20eq%20'3603'%20and%20CreationDate%20eq%20datetime"
		     		+ "'"+yesterdaysDate+"T24:00:00"+"'";
 	       
 			
	            String username = "22011982";
	            String password = "Ramky@567";

	            CredentialsProvider provider = new BasicCredentialsProvider();
	            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(username, password);
	            provider.setCredentials(AuthScope.ANY, credentials);

	            try (CloseableHttpClient httpClient = HttpClients.custom()
	                    .setDefaultCredentialsProvider(provider)
	                    .build()) {
	                HttpGet request = new HttpGet(url);

	                HttpResponse response = httpClient.execute(request);

	                if (response.getStatusLine().getStatusCode() == 200) {
	                    HttpEntity entity = response.getEntity();
	                    String responseBody = EntityUtils.toString(entity);
	                    // Parse the JSON response
	                    JSONObject jsonResponse = new JSONObject(responseBody);
	                    JSONObject dObject = jsonResponse.getJSONObject("d");
	                    JSONArray resultsArray = dObject.getJSONArray("results");


	                    // Process the data and set it in a list
	                    List<IWM> resultList = new ArrayList<>();
	                    for (int i = 0; i < resultsArray.length(); i++) {
	                        JSONObject resultObject = resultsArray.getJSONObject(i);
	                        IWM iwm = new IWM();
	                        //   iwm.setVbeln_salesDocument(resultObject.getString("Vbeln_salesDocument"));
	                        //iwm.setCharg_batch(resultObject.getString("Charg_batch"));
	                        iwm.setAbgru_rejectionReason(resultObject.getString("Abgru_rejectionReason"));
	                      //  iwm.setKdmat_customerMaterial(resultObject.getString("Kdmat_customerMaterial"));
	                        iwm.setWerks_plant(resultObject.getString("Plant"));
	                        iwm.setNet_wt_Manifestweight(resultObject.getString("Manifest_Weight"));
	                        iwm.setVehicleno_vehicleNumber(resultObject.getString("Vehicle_number"));
	                        iwm.setNet_wt_VehicleWeight(resultObject.getString("Net_wt_VehicleWeight"));
	                        iwm.setErdat_creationDate(DateParser.parseDateTime(resultObject.getString("erdat_creationDate")));
	                        iwm.setAuart_SalesDocTy(resultObject.getString("Auart_SalesDocTy"));
	                        if(!"00-00-0000".equals(resultObject.getString("aedat_changedDate"))) {
		                        iwm.setAedat_changedDate(DateParser.parseDateTime(resultObject.getString("aedat_changedDate")));
	                        }else {
		                        iwm.setAedat_changedDate(null);
	                        }
	                       // iwm.setPosnr_salesItem(resultObject.getString("Posnr_salesItem"));
	                      //  iwm.setGbstk_overallStatus(resultObject.getString("Gbstk_overallStatus"));
	                       // iwm.setFaksk_billingBlock(resultObject.getString("Faksk_billingBlock"));
	                      //  iwm.setStatusDescription(resultObject.getString("StatusDescription"));
	                        iwm.setKunnr_customer(resultObject.getString("Customer_Name"));
	                        iwm.setName1_name(resultObject.getString("Name1_name"));
	                        iwm.setWaste_name(resultObject.getString("Waste_type"));
	                        iwm.setManifest_no(resultObject.getString("Manefest_No"));
	                        iwm.setIwma_no(resultObject.getString("IWMA_NO"));
	                        
	                        iwm.setManifest_Weight(resultObject.getString("Manifest_Weight"));
	                        iwm.setFirst_Weight(resultObject.getString("First_weight"));
	                        iwm.setSecond_Weight(resultObject.getString("Second_weight"));
	                        iwm.setTcode(resultObject.getString("Tcode"));
	                        resultList.add(iwm);
	                    }
	                    if(resultList.size() > 0) {
	                    	service.uploadIWM3Records(resultList);
	                    }
	                    // Print the list
	                    System.out.println("Result List: " + resultList);
	                } else {
	                    System.out.println("Error: HTTP " + response.getStatusLine().getStatusCode());
	                }
	            	
	            } catch (Exception e) {
	                e.printStackTrace();
	            }//});
		     }
	}
}
