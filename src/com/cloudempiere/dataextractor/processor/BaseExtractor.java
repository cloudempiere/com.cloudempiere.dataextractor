package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.util.List;
import java.util.Properties;

import org.adempiere.base.annotation.Process;
import org.compiere.model.PO;
import org.compiere.model.Query;

import com.cloudempiere.dataextractor.model.MDEXSchema;


@Process
public class BaseExtractor implements I_Extractor{

	public MDEXSchema schema;
	public Properties m_ctx;
	
	public void setSchema(Properties ctx, int dex_Schema_ID) {
		m_ctx = ctx;
		schema = new MDEXSchema(m_ctx, dex_Schema_ID, null);
	}
	
	public List<PO> getData(String tableName, String whereClause){
		Query query = new Query(m_ctx, tableName, whereClause, null);
		
		if(schema.getAD_Client_ID()>0) {
			query.setClient_ID();
		}
		
		return query.list();
	}

	public File generate() {
		return null;
	}

}
