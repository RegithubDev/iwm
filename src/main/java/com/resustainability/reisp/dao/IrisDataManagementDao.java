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

import com.resustainability.reisp.model.DataManagement;
import com.resustainability.reisp.model.DataManagement;

@Repository
public class IrisDataManagementDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public List<DataManagement> getSBUFilterListForDM(DataManagement obj) throws Exception {
		List<DataManagement> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.sbu_code from [datamanagement_master] um "
					+ "left join site s on um.sbu_code =s.sbu_code "
					+ "left join sbu sb on um.sbu_code =sb.sbu_code "
					+ " where um.sbu_code is not null and um.status <> 'Inactive' ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				qry = qry + " and  um.department_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				qry = qry + " and s.id = ? ";
				arrSize++;
			}
			qry = qry + " group by um.sbu_code ";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				pValues[i++] = obj.getDepartment_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				pValues[i++] = obj.getSite();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<DataManagement>(DataManagement.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<DataManagement> getDeptFilterListForDM(DataManagement obj) throws Exception {
		List<DataManagement> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT department_code,department_name from [datamanagement_master] um "
					+ "left join site s on um.sbu_code =s.sbu_code "
					+ "left join sbu sb on um.sbu_code =sb.sbu_code "
					+ " where um.sbu_code is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  um.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				qry = qry + " and  um.department_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				qry = qry + " and s.id = ? ";
				arrSize++;
			}
			qry = qry + " group by department_code,department_name order by department_name ";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				pValues[i++] = obj.getDepartment_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				pValues[i++] = obj.getSite();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<DataManagement>(DataManagement.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public List<DataManagement> getSiteFilterListForDM(DataManagement obj) throws Exception {
		List<DataManagement> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "SELECT um.id,site_name from site um "
					+ "left join datamanagement_master s on s.sbu_code = um.sbu_code "
					+ "left join sbu sb on s.sbu_code =sb.sbu_code "
					+ " where site_name is not null ";
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  s.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				qry = qry + " and  s.department_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				qry = qry + " and s.id = ? ";
				arrSize++;
			}
			qry = qry + " group by um.id,site_name ";
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getDepartment_code())) {
				pValues[i++] = obj.getDepartment_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				pValues[i++] = obj.getSite();
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<DataManagement>(DataManagement.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;	}

	public List<DataManagement> getDataManagementList(DataManagement obj, int startIndex, int offset,
			String searchParameter) throws Exception {
		List<DataManagement> objsList = null;
		try {
			int arrSize = 0;
			jdbcTemplate = new JdbcTemplate(dataSource);
			String qry = "";
			if(obj.getSbu_code().equals("BMW")) {
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}else if(obj.getDepartment_code().contains("process")) {
					
					qry = qry + "select s.[id]"
							+ "      ,[total_waste],s.sbu_code"
							+ "      ,[total_incieration]"
							+ "      ,[total_autoclave]"
							+ "      ,[quantity_measure_waste]"
							+ "      ,[quantity_measure_incieration]"
							+ "      ,[quantity_measure_autoclave]"
							+ "      ,[site]"+ "      ,[date],sss.site_name"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[bmw_processing_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
					
				}else if(obj.getDepartment_code().contains("Dist")) {
					
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[total_materials]"
							+ "      ,[total_recylable]"
							+ "      ,[total_bags]"
							+ "      ,[total_glass],[total_plastic]"
							+ "      ,[total_cardboard]"
							+ "      ,[quality_measure_materials]"
							+ "      ,[quality_measure_recylable]"
							+ "      ,[quality_measure_plastics]"
							+ "      ,[quality_measure_bags]"
							+ "      ,[quality_measure_glass]"
							+ "      ,[quality_measure_cardboard]"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,[date],sss.site_name"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[bmw_distribute_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
					
				}
			}else if(obj.getSbu_code().equals("IWM")) {
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}else if(obj.getDepartment_code().contains("Disp")) {
					
					qry = qry + "select s.[id] "
							+ "      ,s.[sbu_code] "
							+ "      ,[disposal_total_waste] "
							+ "      ,[disposal_dlf] "
							+ "      ,[disposal_lat] "
							+ "      ,[disposal_afrf] "
							+ "      ,[disposal_incineration] "
							+ "      ,[disposal_total_waste_measure] "
							+ "      ,[disposal_dlf_measure] "
							+ "      ,[disposal_lat_measure] "
							+ "      ,[disposal_afrf_measure] "
							+ "      ,[disposal_incineration_measure] "
							+ "      ,s.[site] "
							+ "      ,[date],sss.site_name"
							+ "      ,[comments] "
							+ "      ,s.[created_by] "
							+ "      ,s.[modified_date] "
							+ "      ,s.[created_date] "
							+ "      ,s.[modified_by] "
							+ "  FROM [IRIS].[dbo].[iwm_disposal_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
					
				}else if(obj.getDepartment_code().contains("Los")) {
					
					qry = qry + "select s.[id]"
							+ "      ,[stock_total_waste],s.sbu_code"
							+ "      ,[stock_dlf]"
							+ "      ,[stock_lat]"
							+ "      ,[stock_incineration]"
							+ "      ,[stock_afrf]"
							+ "      ,[stock_total_waste_measure]"
							+ "      ,[stock_dlf_measure]"
							+ "      ,[stock_lat_measure]"
							+ "      ,[stock_incineration_measure]"
							+ "      ,[stock_afrf_measure]"
							+ "      ,[site]"
							+ "      ,[date],sss.site_name"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[iwm_leftoverstock_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}
			}else if(obj.getSbu_code().equals("MSW")) {
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}else if(obj.getDepartment_code().contains("process")) {
					
					qry = qry + " select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[total_waste]"
							+ "      ,[total_rdf]"
							+ "      ,[total_compost]"
							+ "      ,[total_inerts]"
							+ "      ,[total_recylables]"
							+ "      ,[quantity_measure_waste]"
							+ "      ,[quantity_measure_rdf]"
							+ "      ,[quantity_measure_compost]"
							+ "      ,[quantity_measure_inerts]"
							+ "      ,[quantity_measure_recylabels]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[msw_processing_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
					
				}else if(obj.getDepartment_code().contains("Dist")) {
					
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[rdf]"
							+ "      ,[compost]"
							+ "      ,[recyclables]"
							+ "      ,[inserts]"
							+ "      ,[vendor_name_rdf]"
							+ "      ,[vendor_name_compost]"
							+ "      ,[vendor_name_recyclables]"
							+ "      ,[vendor_name_inserts]"
							+ "      ,[quantity_measure_rdf_outflow]"
							+ "      ,[quantity_measure_compost_outflow]"
							+ "      ,[quantity_measure_recyclables_outflow]"
							+ "      ,[quantity_measure_inerts_outflow]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[msw_distribute_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}
				
				
			}else if(obj.getSbu_code().equals("RECYCLE-PLASTIC")) {
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}
				
				
			}else if(obj.getSbu_code().equals("RECYCLE-CND")) {
				
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}
				
			}else if(obj.getSbu_code().equals("RECYCLE-CRM")) {
				if(obj.getDepartment_code().contains("CNT")){
					qry = qry + "select s.[id]"
							+ "      ,s.[sbu_code]"
							+ "      ,[quantity]"
							+ "      ,[quantity_measure]"
							+ "      ,[date],sss.site_name"
							+ "      ,[site]"
							+ "      ,[comments]"
							+ "      ,s.[created_by]"
							+ "      ,s.[modified_date]"
							+ "      ,s.[created_date]"
							+ "      ,s.[modified_by]"
							+ "  FROM [IRIS].[dbo].[collect_table] s  "
							+ "left join sbu ss on s.sbu_code = ss.sbu_code "
							+ " left join site sss on s.site = sss.id   "
							+ " left join user_management um on s.created_by = um.id   "
							+ " left join user_management um1 on s.modified_by = um1.id  "
							+ "where s.id is not null  ";
				}
				
				
			}
			
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				qry = qry + " and  s.sbu_code = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				qry = qry + " and  s.date between ? and ? ";
				arrSize++;arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				qry = qry + " and sss.id = ? ";
				arrSize++;
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getIsMobile())) {
				qry = qry + " AND CAST(s.created_date AS DATE) >= DATEADD(DAY, -7, CAST(GETDATE() AS DATE)) ";	
			}
			
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				qry = qry + " ORDER BY s.date asc offset ? rows  fetch next ? rows only";	
				arrSize++;
				arrSize++;
			}
			
			Object[] pValues = new Object[arrSize];
			int i = 0;
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSbu_code())) {
				pValues[i++] = obj.getSbu_code();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getFrom_date()) && !StringUtils.isEmpty(obj.getTo_date())) {
				pValues[i++] = obj.getFrom_date().trim();
				pValues[i++] = obj.getTo_date().trim();
			}
			if(!StringUtils.isEmpty(obj) && !StringUtils.isEmpty(obj.getSite())) {
				pValues[i++] = obj.getSite();
			}
			if(!StringUtils.isEmpty(startIndex) && !StringUtils.isEmpty(offset)) {
				pValues[i++] = startIndex;
				pValues[i++] = offset;
			}
			objsList = jdbcTemplate.query( qry,pValues, new BeanPropertyRowMapper<DataManagement>(DataManagement.class));	
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return objsList;
	}

	public int getTotalRecords(DataManagement obj, String searchParameter) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean updateCollect(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [collect_table] set "
					+ "      quantity= :quantity"
					+ "      ,quantity_measure= :quantity_measure,modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateBmwdistributive(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [bmw_distribute_table] set "
					+ "      total_materials= :total_materials,total_recylable=:total_recylable,total_plastic=:total_plastic,total_bags=:total_bags,total_glass=:total_glass,total_cardboard=:total_cardboard"
					+ "      ,quality_measure_materials= :quality_measure_materials,quality_measure_recylable=:quality_measure_recylable"
					+ ",quality_measure_plastics=:quality_measure_plastics,quality_measure_bags=:quality_measure_bags,quality_measure_glass=:quality_measure_glass,quality_measure_cardboard=:quality_measure_cardboard"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateBmwprocessing(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [bmw_processing_table] set "
					+ "      total_waste= :total_waste,total_incieration=:total_incieration,total_autoclave=:total_autoclave,quantity_measure_waste=:quantity_measure_waste,quantity_measure_incieration=:quantity_measure_incieration,quantity_measure_autoclave=:quantity_measure_autoclave"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateIwmdisposal(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [iwm_disposal_table] set "
					+ "      disposal_total_waste= :disposal_total_waste,disposal_dlf=:disposal_dlf,disposal_lat=:disposal_lat,disposal_afrf=:disposal_afrf,disposal_incineration=:disposal_incineration,disposal_total_waste_measure=:disposal_total_waste_measure"
					+ "      ,disposal_dlf_measure= :disposal_dlf_measure,disposal_lat_measure=:disposal_lat_measure"
					+ ",disposal_afrf_measure=:disposal_afrf_measure,disposal_incineration_measure=:disposal_incineration_measure"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateIwmleftoverstock(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [iwm_leftoverstock_table] set "
					+ "   stock_total_waste= :stock_total_waste,stock_dlf=:stock_dlf,stock_lat=:stock_lat,stock_incineration=:stock_incineration,stock_afrf=:stock_afrf,stock_total_waste_measure=:stock_total_waste_measure"
					+ " ,stock_dlf_measure= :stock_dlf_measure,stock_lat_measure=:stock_lat_measure"
					+ ",stock_incineration_measure=:stock_incineration_measure,stock_afrf_measure=:stock_afrf_measure"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateMswprocessing(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [msw_processing_table] set "
					+ "total_waste= :total_waste, total_rdf=:total_rdf,total_compost=:total_compost"
					+ ",total_inerts= :total_inerts,total_recylables=:total_recylables,quantity_measure_waste=:quantity_measure_waste"
					+ ",quantity_measure_rdf= :quantity_measure_rdf,quantity_measure_compost=:quantity_measure_compost,quantity_measure_inerts=:quantity_measure_inerts,quantity_measure_recylabels=:quantity_measure_recylabels"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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

	public boolean updateMswdistributive(DataManagement obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "UPDATE [msw_distribute_table] set "
					+ "rdf= :rdf,compost=:compost,recyclables=:recyclables"
					+ ",inserts=:inserts,vendor_name_rdf=:vendor_name_rdf,vendor_name_compost=:vendor_name_compost"
					+ ",vendor_name_recyclables=:vendor_name_recyclables,vendor_name_inserts=:vendor_name_inserts,quantity_measure_rdf_outflow=:quantity_measure_rdf_outflow,"
					+ "quantity_measure_compost_outflow=:quantity_measure_compost_outflow,quantity_measure_recyclables_outflow=:quantity_measure_recyclables_outflow,quantity_measure_inerts_outflow=:quantity_measure_inerts_outflow"
					+ ",modified_date= getdate(),modified_by= :modified_by"
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
	
	
	
}
