package com.resustainability.reisp.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.StringUtils;

import com.resustainability.reisp.model.City;
import com.resustainability.reisp.model.City;

@Repository
public class IrisCityDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public int getTotalRecords(City obj, String searchParameter) throws Exception {
		int totalRecords = 0;
		try {
			int arrSize = 0;
			String qry = "select count(DISTINCT um.city_name) as total_records FROM [city] um "
					+ "left join state s on um.state = s.id "
			+ " where um.city_name <> '' ";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				qry = qry + " and  um.city_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				qry = qry + " and  um.state = ? ";
				arrSize++;
			}
		
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.city_name like ? or um.status like ? or s.state_name = ?)";
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				pValues[i++] = obj.getCity_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				pValues[i++] = obj.getState();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			
			totalRecords = jdbcTemplate.queryForObject( qry,pValues,Integer.class);
		}catch(Exception e){ 
			e.printStackTrace();
			throw new Exception(e);
		}
		return totalRecords;
	}

	public List<City> getCityList(City obj, int startIndex, int offset, String searchParameter) throws Exception {
		List<City> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT s.[id],state"
					+ "        ,ss.[state_name]"
					+ "      ,s.[city_name]"
					+ "      ,s.[status],s.sbu_code,sss.sbu_name"
					+ "      ,um.user_name as [created_by]"
					+ "      ,FORMAT (s.created_date, 'dd-MMM-yy') as [created_date]"
					+ "      ,um1.user_name as [modified_by]"
					+ "      ,FORMAT (s.modified_date, 'dd-MMM-yy') as [modified_date] FROM [city] s  "
					+ "left join state ss on s.state = ss.id "
					+ "left join sbu sss on s.sbu_code = sss.sbu_code "
					+ " left join user_management um on s.created_by = um.id   "
					+ " left join user_management um1 on s.modified_by = um1.id  "
					+ "where s.id is not null  ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				qry = qry + " and  s.city_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				qry = qry + " and  s.state = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and s.status = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (s.city_name like ? or um.status like ? or ss.state_name = ?)";
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				qry = qry + " ORDER BY um.user_name asc offset ? rows  fetch next ? rows only";	
				arrSize++;
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				pValues[i++] = obj.getCity_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				pValues[i++] = obj.getState();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				pValues[i++] = startIndex;
				pValues[i++] = offset;
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<City>(City.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public boolean addCityIris(City obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [city] "
					+ "		( state"
					+ "      ,city_name"
					+ "      ,status"
					+ "      ,created_by,created_date) "
					+ "		VALUES "
					+ "		( :state"
					+ "      ,:city_name"
					+ "      ,:status"
					+ "      ,:created_by,getdate())";
			BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
		    count = namedParamJdbcTemplate.update(insertQry, paramSource);
			if(count > 0) {
				flag = true;
			}
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw new Exception(e);
		}
		return flag;
	}

	public City getCityDetails(City user) throws Exception {
		City obj = null;
		try {
			String qry = "SELECT s.[id]"
					+ "        , ,[state]"
					+ "      ,[city_name]"
					+ "      ,[status]"
					+ "      ,um.user_name as [created_by]"
					+ "      ,FORMAT (um.created_date, 'dd-MMM-yy') as[created_date]"
					+ "      ,um1.user_name as [modified_by]"
					+ "      ,FORMAT (um.modified_date, 'dd-MMM-yy') as[modified_date] FROM [city] s  "
					+ " left join user_management um on s.created_by = um.id   "
					+ " left join user_management um1 on s.modified_by = um1.id  "
					+ "where um.id is not null  ";
			int arrSize = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getId())) {
				qry = qry + " and um.id = ? ";
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getId())) {
				pValues[i++] = user.getId();
			}
			obj = (City)jdbcTemplate.queryForObject(qry, pValues, new BeanPropertyRowMapper<City>(City.class));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return obj;
	}

	public boolean updateCityIris(City obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [city] set state= :state,"
					+ "      city_name= :city_name"
					+ "      ,status= :status,modified_date= getdate(),modified_by= :modified_by"
					+ " where id =  '"+obj.getId()+"'";
			BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(obj);		 
		    count = namedParamJdbcTemplate.update(insertQry, paramSource);
			if(count > 0) {
				flag = true;
			}
			transactionManager.commit(status);
		}catch (Exception e) {
			transactionManager.rollback(status);
			e.printStackTrace();
			throw new Exception(e);
		}
		return flag;
	}

	public List<City> getCityFilterListForCity(City obj) throws Exception {
		List<City> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.id,um.[city_name],city_name from [city] um  where um.city_name is not null ";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				 String input = obj.getSbu_code();
				 StringBuilder concatenated = new StringBuilder();
				qry = qry + " and  um.sbu_code in (";
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 qry = qry + " ?,";
						 arrSize++;
					 }
				    qry =  qry.trim().replaceAll(",$", "");
					qry = qry + " )";
				 }else {
					 qry = qry + " ?)";
					 arrSize++;
				 }
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				qry = qry + " and  um.city_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				qry = qry + " and  um.state = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " order by um.city_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				 String input = obj.getSbu_code();
				 if (input.contains(",")) {
					 String [] arr = input.split(",");
					 for(String arrObj : arr) {
						 pValues[i++] = arrObj ;
					 }
				
			     }else {
			    	 pValues[i++] = obj.getSbu_code();
			     }
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				pValues[i++] = obj.getCity_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				pValues[i++] = obj.getState();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<City>(City.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}
	
	public List<City> getStateFilterListForCity(City obj) throws Exception {
		List<City> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.[state],ss.state_name from [city] um left join state ss on um.state = ss.id   where um.city_name is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				qry = qry + " and  um.city_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				qry = qry + " and  um.state = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " group by um.[state],state_name order by ss.state_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				pValues[i++] = obj.getCity_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				pValues[i++] = obj.getState();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<City>(City.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<City> getStatusFilterListForCity(City obj) throws Exception {
		List<City> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT distinct([status]) from [city] um where status is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				qry = qry + " and  um.city_name = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				qry = qry + " and  um.state = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				qry = qry + " and um.status = ? ";
				arrSize++;
			}
			qry = qry + " order by um.status asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getCity_name())) {
				pValues[i++] = obj.getCity_name();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState())) {
				pValues[i++] = obj.getState();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getStatus())) {
				pValues[i++] = obj.getStatus();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<City>(City.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<City> getStateList(City obj) throws Exception {
		List<City> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT id,state_name from [state] um where status <> 'Inactive' ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState_name())) {
				qry = qry + " and  um.state_name = ? ";
				arrSize++;
			}
			qry = qry + " order by um.state_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getState_name())) {
				pValues[i++] = obj.getState_name();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<City>(City.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	
	}

	
	
	

