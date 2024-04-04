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

import com.resustainability.reisp.common.EncryptDecrypt;
import com.resustainability.reisp.model.Transaction;
import com.resustainability.reisp.model.User;

@Repository
public class IrisTransactionsDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;

	@Autowired
	DataSourceTransactionManager transactionManager;

	public boolean uploadCollectData(Transaction obj) throws Exception{
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			if(StringUtils.isEmpty(obj.getQuantity_measure())) {
				obj.setQuantity_measure("MT");
			}
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [collect_table] (sbu_code,quantity,quantity_measure,date,site,comments,created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:quantity,:quantity_measure,:date,:site,:comments,:created_by,getdate())";
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

	public boolean uploadBMWProcessingData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			if(StringUtils.isEmpty(obj.getQuantity_measure_waste())) {
				obj.setQuantity_measure_waste("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_incieration())) {
				obj.setQuantity_measure_incieration("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_autoclave())) {
				obj.setQuantity_measure_autoclave("MT");
			}
			
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [bmw_processing_table] (sbu_code,date,total_waste,total_incieration,total_autoclave,quantity_measure_waste,quantity_measure_incieration,"
					+ "quantity_measure_autoclave,site,comments,created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:date,:total_waste,:total_incieration,:total_autoclave,:quantity_measure_waste,:quantity_measure_incieration,"
					+ "	:quantity_measure_autoclave,:site,:comments,:created_by,getdate())";
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

	public boolean uploadBMWDistributeData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			if(StringUtils.isEmpty(obj.getQuality_measure_materials())) {
				obj.setQuality_measure_materials("MT");
			}
			if(StringUtils.isEmpty(obj.getQuality_measure_recylable())) {
				obj.setQuality_measure_recylable("MT");
			}
			if(StringUtils.isEmpty(obj.getQuality_measure_plastics())) {
				obj.setQuality_measure_plastics("MT");
			}
			if(StringUtils.isEmpty(obj.getQuality_measure_bags())) {
				obj.setQuality_measure_bags("MT");
			}
			if(StringUtils.isEmpty(obj.getQuality_measure_glass())) {
				obj.setQuality_measure_glass("MT");
			}
			if(StringUtils.isEmpty(obj.getQuality_measure_cardboard())) {
				obj.setQuality_measure_cardboard("MT");
			}
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [bmw_distribute_table] (sbu_code,total_materials,total_plastic,total_recylable,total_bags,total_glass,total_cardboard,quality_measure_materials,"
					+ "quality_measure_recylable,quality_measure_plastics,quality_measure_bags,quality_measure_glass,quality_measure_cardboard,site,comments,date,"
					+ "created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:total_materials,:total_plastic,:total_recylable,:total_bags,:total_glass,:total_cardboard,:quality_measure_materials,"
					+ ":quality_measure_recylable,:quality_measure_plastics,:quality_measure_bags,:quality_measure_glass,:quality_measure_cardboard,:site,:comments,:date,"
					+ ":created_by,getdate())";
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

	public boolean uploadMSWDistributeData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			if(StringUtils.isEmpty(obj.getVendor_name_rdf_outflow())) {
				obj.setVendor_name_rdf_outflow("MT");
			}
			if(StringUtils.isEmpty(obj.getVendor_name_compost_outflow())) {
				obj.setVendor_name_compost_outflow("MT");
			}
			if(StringUtils.isEmpty(obj.getVendor_name_recylables_outflow())) {
				obj.setVendor_name_recylables_outflow("MT");
			}
			if(StringUtils.isEmpty(obj.getVendor_name_inserts_outflow())) {
				obj.setVendor_name_inserts_outflow("MT");
			}
		
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [msw_distribute_table] "
					+ "(sbu_code,rdf,compost,recyclables,inserts,vendor_name_rdf,vendor_name_compost,vendor_name_recyclables,"
					+ "vendor_name_inserts,quantity_measure_rdf_outflow,quantity_measure_compost_outflow,quantity_measure_recyclables_outflow,quantity_measure_inerts_outflow,date,site,comments,created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:rdf,:compost,:recyclables,:inserts,:vendor_name_rdf,:vendor_name_compost,:vendor_name_recyclables,:vendor_name_inserts,:quantity_measure_rdf_outflow,"
					+ ":quantity_measure_compost_outflow,:quantity_measure_recyclables_outflow,:quantity_measure_inerts_outflow,:date,:site,:comments,:created_by,getdate())";
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

	public boolean uploadMSWProcessingData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			if(StringUtils.isEmpty(obj.getQuantity_measure_waste())) {
				obj.setQuantity_measure_waste("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_rdf())) {
				obj.setQuantity_measure_rdf("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_compost())) {
				obj.setQuantity_measure_compost("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_inerts())) {
				obj.setQuantity_measure_inerts("MT");
			}
			if(StringUtils.isEmpty(obj.getQuantity_measure_recylabels())) {
				obj.setQuantity_measure_recylabels("MT");
			}
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [msw_processing_table] (sbu_code,total_waste,total_rdf,total_compost,total_inerts,total_recylables,quantity_measure_waste,"
					+ "quantity_measure_rdf,quantity_measure_compost,quantity_measure_inerts,quantity_measure_recylabels,date,site,comments,created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:total_waste,:total_rdf,:total_compost,:total_inerts,:total_recylables,:quantity_measure_waste,:quantity_measure_rdf,:quantity_measure_compost,"
					+ ":quantity_measure_inerts,:quantity_measure_recylabels,:date,:site,:comments,:created_by,getdate())";
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

	public boolean uploadIWMDisposalData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [iwm_disposal_table] (sbu_code,disposal_total_waste,disposal_dlf,disposal_lat,disposal_afrf,disposal_incineration,disposal_total_waste_measure,"
					+ "disposal_dlf_measure,disposal_lat_measure,disposal_incineration_measure,site,date,comments,created_by,created_date,disposal_afrf_measure) "
					+ "VALUES "
					+ "(:sbu_code,:disposal_total_waste,:disposal_dlf,:disposal_lat,:disposal_afrf,:disposal_incineration,:disposal_total_waste_measure,"
					+ ":disposal_dlf_measure,:disposal_lat_measure,:disposal_incineration_measure,:site,:date,:comments,:created_by,getdate(),:disposal_afrf_measure)";
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

	public boolean uploadIWMLeftoverstockData(Transaction obj) throws Exception {
		int count = 0;
		boolean flag = false;
		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			NamedParameterJdbcTemplate namedParamJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
			String insertQry = "INSERT INTO [iwm_leftoverstock_table] (sbu_code,stock_total_waste,stock_dlf,stock_lat,stock_incineration,stock_afrf,stock_total_waste_measure,"
					+ "stock_dlf_measure,stock_lat_measure,stock_incineration_measure,stock_afrf_measure,site,date,comments,created_by,created_date) "
					+ "VALUES "
					+ "(:sbu_code,:stock_total_waste,:stock_dlf,:stock_lat,:stock_incineration,:stock_afrf,:stock_total_waste_measure"
					+ "	,:stock_dlf_measure,:stock_lat_measure,:stock_incineration_measure,:stock_afrf_measure,:site,:date,:comments,:created_by,getdate())";
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
