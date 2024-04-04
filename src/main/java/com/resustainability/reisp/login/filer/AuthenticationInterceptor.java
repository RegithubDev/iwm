package com.resustainability.reisp.login.filer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.resustainability.reisp.common.UrlGenerator;
import com.resustainability.reisp.dao.UserDao;
import  com.resustainability.reisp.model.User;


public class AuthenticationInterceptor extends HandlerInterceptorAdapter{
	Logger logger = Logger.getLogger(AuthenticationInterceptor.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws IOException {
		String requestURI = null;
		String context_path = null;
		try {
			requestURI = request.getRequestURI();
			UrlGenerator ugObj = new UrlGenerator();
			context_path = ugObj.getContextPath();
			// Avoid a redirect loop for some urls
			if(!request.getRequestURI().contains("@")){
			if( !requestURI.equals("/"+context_path+"/") && !requestURI.equals("/"+context_path+"/sign-in") 
					&& !requestURI.equals("/") && !requestURI.equals("/sign-in") 
					&& !requestURI.equals("/"+context_path+"/someone-login") && !requestURI.equals("/someone-login") 
					&& !requestURI.equals("/"+context_path+"/access-denied") && !request.getRequestURI().equals("/access-denied")){
			    User userData = (User) request.getSession().getAttribute("user");
			    if( requestURI.equals("/"+context_path+"/add-user-iris")) {
					return true;
				}
			    if(requestURI.contains("reone")  ) {
			    	return true;
			    }
			    if(!requestURI.equals("/"+context_path+"/sign-in-first") && userData == null){
			    	if(request.getRequestURI().contains("/"+context_path+"/")){
			    		response.sendRedirect("/"+context_path+"/sign-in");
			    	}else{
			    		response.sendRedirect("/sign-in");
			    	}
				    return false;
				}
			}
		   }
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("preHandle : " + e.getMessage());
			return false;
		}
		  return true;
	}
	private static boolean checkSignIn(String clientId, String idToken) {
        try {
            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
                    .setAudience(Collections.singletonList(clientId))
                    .build();

            GoogleIdToken token = verifier.verify(idToken);
            return token != null;
        } catch (GeneralSecurityException | IOException e) {
            e.printStackTrace();
        }

        return false;
    }
	public int checkUserLoginDetails(User obj) throws Exception {
		int totalRecords = 0;
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String subQry = " and device_type_no = 2";
			if(obj.getDevice_type().equals("mobile")) {
				subQry = " and device_type_no = 1";
			}
			String qry = "select count(user_id) from [user_audit_log] where user_logout_time is null or  user_logout_time = '' "+ subQry;
			int arrSize = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_session_id())) {
				qry = qry + " and user_session_id = ? ";
				arrSize++; 
			}	
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_session_id())) {
				pValues[i++] = obj.getUser_session_id();
			}
			totalRecords = jdbcTemplate.queryForObject( qry,pValues,Integer.class);
			if(totalRecords > 1) {
			//	String updateQry = "update [user_audit_log] set user_logout_time=GETDATE()  where user_id= :user_id and user_logout_time is null or  user_logout_time = '' ";
			//	BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
			//    namedParamJdbcTemplate.update(updateQry, paramSource);
			}
		}catch(Exception e){ 
			e.printStackTrace();
			throw new Exception(e);
		}
		return totalRecords;
		
		
	}
}
