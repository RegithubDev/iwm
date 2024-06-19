package com.resustainability.reisp.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

import com.resustainability.reisp.common.EncryptDecrypt;
import com.resustainability.reisp.model.IWM;
import com.resustainability.reisp.model.User;

@Repository
public class IrisUserDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public int getTotalRecords(User obj, String searchParameter) throws Exception {
		int totalRecords = 0;
		try {
			int arrSize = 0;
			String qry = "select count( um.user_id) as total_records FROM [user_profile] um "
					+ "left join  [user_profile] um1 on um.created_by = um1.user_id "
					+ " left join [user_profile] um2 on um.modified_by = um2.user_id  "
			+ " where um.user_id <> '' ";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				qry = qry + " and  um.user_id = ? ";
				arrSize++;
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.user_name like ? or um.base_role like ?"
						+ " or um.email_id like or um.status like ? )";
				arrSize++;
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				pValues[i++] = obj.getUser_id();
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
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

	public List<User> getUserList(User obj, int startIndex, int offset, String searchParameter) throws Exception {
		List<User> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = " select um.[id]"
					+ "      ,um.[user_id]"
					+ "      ,um.[user_name]"
					+ "      ,um.[email_id]"
					+ "      ,um.[password]"
					+ "      ,um.[phone]"
					+ "      ,um.[base_role]"
					+ "      ,um.[sbu_code]"
					+ "      ,um.[department_code]"
					+ "      ,um.[status]"
					+ "      ,um1.user_name as [created_by]"
					+ "      ,FORMAT(um.created_date, 'dd MMM yy') as [created_date]"
					+ "      ,um2.user_name as [modified_by]"
					+ "      ,FORMAT(um.modified_date, 'dd MMM yy') as [modified_date]"
					+ "  FROM [weibridgeDB].[dbo].[user_profile] um "
					+ " left join [user_profile] um1 on um.created_by = um1.user_id "
					+ " left join [user_profile] um2 on um.modified_by = um2.user_id  "
					+ " WHERE    "
					+ "    um.user_id IS NOT NULL ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				qry = qry + " and  um.user_id = ? ";
				arrSize++;
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.user_name like ? or um.base_role like ?"
						+ " or um.email_id like or um.status like ? )";
				arrSize++;
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
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				pValues[i++] = obj.getUser_id();
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				pValues[i++] = startIndex;
				pValues[i++] = offset;
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<User>(User.class));	
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public boolean addUserIris(User obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [user_profile] "
					+ "		( user_id,user_name"
					+ "      ,email_id"
					+ "      ,phone"
					+ ",password"
					+ "      ,base_role"
					+ "      ,status,created_by,created_date) "
					+ "		VALUES "
					+ "		( :user_id,:user_name"
					+ "      ,:email_id"
					+ "      ,:phone"
					+ ",:password"
					+ "      ,:base_role"
					+ "      ,:status,:created_by,getdate())";
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

	public User getUserDetails(User user) throws Exception {
		User obj = null;
		try {
			String qry = " select um.[id]"
					+ "      ,um.[user_id]"
					+ "      ,um.[user_name]"
					+ "      ,um.[email_id]"
					+ "      ,um.[password]"
					+ "      ,um.[phone]"
					+ "      ,um.[base_role]"
					+ "      ,um.[sbu_code]"
					+ "      ,um.[department_code]"
					+ "      ,um.[status]"
					+ "      ,um1.user_name as [created_by]"
					+ "      ,FORMAT(um.created_date, 'dd MMM yy') as [created_date]"
					+ "      ,um2.user_name as [modified_by]"
					+ "      ,FORMAT(um.modified_date, 'dd MMM yy') as [modified_date]"
					+ "  FROM [weibridgeDB].[dbo].[user_profile] um "
					+ " left join [user_profile] um1 on um.created_by = um1.user_id "
					+ " left join [user_profile] um2 on um.modified_by = um2.user_id  "
					+ " WHERE    "
					+ "    um.user_id IS NOT NULL ";
			int arrSize = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getUser_id())) {
				qry = qry + " and um.user_id = ? ";
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(user) && !StringUtils.isEmpty(user.getUser_id())) {
				pValues[i++] = user.getUser_id();
			}
			obj = (User)jdbcTemplate.queryForObject(qry, pValues, new BeanPropertyRowMapper<User>(User.class));

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return obj;
	}

	public boolean updateUserIris(User obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [user_profile] set "
					+ "		user_name= :user_name"
					+ "      ,email_id= :email_id"
					+ "      ,phone= :phone"
					+ "      ,base_role= :base_role,status= :status,modified_date= getdate(),modified_by= :modified_by"
					+ " where user_id =  '"+obj.getUser_id()+"'";
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

	public List<User> getDepartmentFilterListForUser(User obj) throws Exception {
		List<User> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT t1.sbu, STRING_AGG(t2.sbu_name, ', ') AS sbu_name "
					+ "FROM [user_management] t1 "
					+ "CROSS APPLY STRING_SPLIT(t1.sbu, ',') s "
					+ "JOIN sbu t2 ON t2.sbu_code = s.value where sbu is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu())) {
				qry = qry + " and  t1.sbu = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				qry = qry + " and t1.site_name = ? ";
				arrSize++;
			}
			
			qry = qry + " GROUP BY  t1.id,t1.sbu ";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu())) {
				pValues[i++] = obj.getSbu();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				pValues[i++] = obj.getUser_id();
			}
			
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<User>(User.class));	
			Set<String> nameSet = new HashSet<>();
			objsList = objsList.stream()
		            .filter(e -> nameSet.add(e.getSbu_name()))
		            .collect(Collectors.toList());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<User> getSiteFilterListForUser(User obj) throws Exception {
		List<User> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT s.site_name,um.site_name as id from [user_management] um "
					+ " left join site s on um.site_name = s.id "
					+ "where um.site_name is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu())) {
				qry = qry + " and  um.sbu = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				qry = qry + " and um.site_name = ? ";
				arrSize++;
			}
			
			qry = qry + "group by s.site_name,um.site_name order by s.site_name asc";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu())) {
				pValues[i++] = obj.getSbu();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				pValues[i++] = obj.getUser_id();
			}
			
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<User>(User.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<User> getRoleFilterListForUser(User obj) throws Exception {
		List<User> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.user_id,um.user_name FROM [user_profile] um "
					+ " where user_id is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				qry = qry + " and  um.user_id = ? ";
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getUser_id())) {
				pValues[i++] = obj.getUser_id();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<User>(User.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public boolean updateUserSelfIris(User obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [user_profile] set "
					+ "		user_name= :user_name"
					+ "      ,phone= :phone,modified_date= getdate(),modified_by= :modified_by"
					+ " where user_id =  '"+obj.getUser_id()+"'";
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

	public int getTotalRecords(IWM obj, String searchParameter) throws Exception {
		int totalRecords = 0;
		try {
			int arrSize = 0;
		
			String qry = "WITH CTE AS ( "
					+ "    SELECT  "
					+ "        [id], "
					+ "        [Werks_plant], "
					+ "        FORMAT(erdat_creationDate, 'dd MMM yy') AS [erdat_creationDate], "
					+ "        [Auart_SalesDocTy], "
					+ "        [Kunnr_customer], "
					+ "        [Name1_name], "
					+ "        [Charg_batch], "
					+ "        [Net_wt_Manifestweight], "
					+ "        [Vehicleno_vehicleNumber], "
					+ "        [Net_wt_VehicleWeight], "
					+ "        [Kdmat_customerMaterial], "
					+ "        [Gbstk_overallStatus], "
					+ "        [Faksk_billingBlock], "
					+ "        [Abgru_rejectionReason], "
					+ "        FORMAT(aedat_changedDate, 'dd MMM yy') AS [aedat_changedDate], "
					+ "        [metadata], "
					+ "        [Vbeln_salesDocument], "
					+ "        [StatusDescription], "
					+ "        [last_modified], "
					+ "        [Posnr_salesItem], "
					+ "        [iwma_no], "
					+ "        [waste_category], "
					+ "        [waste_name], "
					+ "        [disposal_method], "
					+ "        [manifest_no], "
					+ "        [Manifest_Weight], "
					+ "        [First_Weight], "
					+ "        [Second_Weight], "
					+ "        [Tcode], "
					+ "        ROW_NUMBER() OVER (PARTITION BY [manifest_no] ORDER BY [last_modified] DESC) AS RowNum "
					+ "    FROM  "
					+ "        [weibridgeDB].[dbo].[WEIGHT_3] um "
					+ "    LEFT JOIN  "
					+ "        master_table mt ON um.Werks_plant = mt.project_code "
					+ "    WHERE  "
					+ "        manifest_no IS NOT NULL  "
					+ "        AND manifest_no <> ''  "
					+ ""
					+ "";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				qry = qry + " and  um.Werks_plant = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.Name1_name like ? or um.Werks_plant like ?"
						+ " or mt.project_name like ?  or um.manifest_no like ? or um.iwma_no like ? )";
				arrSize++;
				arrSize++;
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			qry = qry + ") SELECT   "
					+ "    COUNT(*) as total_records "
					+ "FROM  "
					+ "    CTE "
					+ "WHERE  "
					+ "    RowNum = 1;";
			Object[] pValues = new Object[arrSize];
			int i = 0;

			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				pValues[i++] = obj.getWerks_plant();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getFrom_date();
				pValues[i++] = obj.getTo_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				pValues[i++] = obj.getFrom_date();
				pValues[i++] = obj.getFrom_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getTo_date();
				pValues[i++] = obj.getTo_date();
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
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

	public List<IWM> getIWMList(IWM obj, int startIndex, int offset, String searchParameter) throws Exception {
		List<IWM> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "WITH CTE AS ( "
					+ "    SELECT  "
					+ "        [id], "
					+ "        [Werks_plant], "
					+ "        FORMAT(erdat_creationDate, 'dd MMM yy') AS [erdat_creationDate], "
					+ "        [Auart_SalesDocTy], "
					+ "        [Kunnr_customer],"
					+ "        [Name1_name], "
					+ "        [Charg_batch], "
					+ "        [Net_wt_Manifestweight], "
					+ "        [Vehicleno_vehicleNumber], "
					+ "        [Net_wt_VehicleWeight], "
					+ "        [Kdmat_customerMaterial], "
					+ "        [Gbstk_overallStatus], "
					+ "        [Faksk_billingBlock], "
					+ "        [Abgru_rejectionReason], "
					+ "        FORMAT(aedat_changedDate, 'dd MMM yy') AS [aedat_changedDate], "
					+ "        [metadata], "
					+ "        [Vbeln_salesDocument], "
					+ "        [StatusDescription], "
					+ "        [last_modified], "
					+ "        [Posnr_salesItem], "
					+ "        [iwma_no], "
					+ "        [waste_category], "
					+ "        [waste_name], "
					+ "        [disposal_method], "
					+ "        [manifest_no], "
					+ "        [Manifest_Weight], "
					+ "        [First_Weight], "
					+ "        [Second_Weight], "
					+ "        [Tcode], "
					+ "        ROW_NUMBER() OVER (PARTITION BY [manifest_no] ORDER BY [last_modified] DESC) AS RowNum "
					+ "    FROM  "
					+ "        [weibridgeDB].[dbo].[WEIGHT_3] um "
					+ "		 LEFT JOIN master_table mt ON um.Werks_plant = mt.project_code "
					+ "    WHERE  "
					+ "        manifest_no IS NOT NULL  "
					+ "        AND manifest_no <> '' "
					+ ""
					+ "";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				qry = qry + " and  um.Werks_plant = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + "  AND erdat_creationDate >=  ?  AND erdat_creationDate <= ? ";
				arrSize++;arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				qry = qry + " AND erdat_creationDate = ? ";
				arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " AND erdat_creationDate = ? ";
				arrSize++;
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				qry = qry + " and (um.Name1_name like ? or um.Werks_plant like ?"
						+ " or mt.project_name like ?  or um.manifest_no like ? or um.iwma_no like ? )";
				arrSize++;
				arrSize++;
				arrSize++;
				arrSize++;
				arrSize++;
			}	
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				qry = qry + ") "
						+ " SELECT  "
						+ "    [id], "
						+ "    [Werks_plant], "
						+ "    [erdat_creationDate], "
						+ "    [Auart_SalesDocTy], "
						+ "    [Kunnr_customer], "
						+ "    [Name1_name], "
						+ "    [Charg_batch],mt.project_name, "
						+ "    [Net_wt_Manifestweight], "
						+ "    [Vehicleno_vehicleNumber], "
						+ "    [Net_wt_VehicleWeight], "
						+ "    [Kdmat_customerMaterial], "
						+ "    [Gbstk_overallStatus], "
						+ "    [Faksk_billingBlock], "
						+ "    [Abgru_rejectionReason], "
						+ "    [aedat_changedDate], "
						+ "    [metadata], "
						+ "    [Vbeln_salesDocument], "
						+ "    [StatusDescription], "
						+ "    [last_modified], "
						+ "    [Posnr_salesItem], "
						+ "    [iwma_no], "
						+ "    [waste_category], "
						+ "    [waste_name], "
						+ "    [disposal_method], "
						+ "    [manifest_no], "
						+ "    [Manifest_Weight], "
						+ "    [First_Weight], "
						+ "    [Second_Weight], "
						+ "    [Tcode] "
						+ "FROM  "
						+ "    CTE um "
						+ "		 LEFT JOIN master_table mt ON um.Werks_plant = mt.project_code "
						+ "WHERE  "
						+ "    RowNum = 1 "
						+ "ORDER BY  "
						+ "    [erdat_creationDate] DESC offset ? rows  fetch next ? rows only ";
				arrSize++;
				arrSize++;
			}
			Object[] pValues = new Object[arrSize];
			int i = 0;
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				pValues[i++] = obj.getWerks_plant();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getFrom_date();
				pValues[i++] = obj.getTo_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				pValues[i++] = obj.getFrom_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getTo_date();
			}
			
			if(!StringUtils.isEmpty(searchParameter)) {
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
				pValues[i++] = "%"+searchParameter+"%";
			}
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				pValues[i++] = startIndex;
				pValues[i++] = offset;
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<IWM>(IWM.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<IWM> getSiteFilterListForIWM(IWM obj) throws Exception {
		List<IWM> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT [Werks_plant],project_name"
					+ "  FROM [weibridgeDB].[dbo].[WEIGHT_3] um   "
					+ " left join master_table mt on um.Werks_plant = mt.project_code "
					+ " WHERE um.[Werks_plant] IS NOT NULL and  um.[Werks_plant] <> '' ";
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				qry = qry + " and  um.Werks_plant = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " and  um.erdat_creationDate between ? and ? ";
				arrSize++;arrSize++;
			}
			qry = qry + " group by [Werks_plant],project_name ";
			Object[] pValues = new Object[arrSize];
			int i = 0;

			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getWerks_plant())) {
				pValues[i++] = obj.getWerks_plant();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getFrom_date();
				pValues[i++] = obj.getTo_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date())) {
				pValues[i++] = obj.getFrom_date();
				pValues[i++] = obj.getFrom_date();
			}else if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getTo_date();
				pValues[i++] = obj.getTo_date();
			}
			
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<IWM>(IWM.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}
	
	
	
	
}
