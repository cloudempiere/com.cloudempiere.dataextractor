package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

@org.adempiere.base.Model(table = "DEX_Job")
public class MDEXJob extends X_DEX_Job {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7353742899501620215L;


	public MDEXJob(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}
	

	public MDEXJob(Properties ctx, int DEX_Job_ID, String trxName) {
		super(ctx, DEX_Job_ID, trxName);
	}
	
	public List<MDEXJobTable> getTables() {
		return new Query(getCtx(), MDEXJobTable.Table_Name, MDEXJobTable.COLUMNNAME_DEX_Job_ID+"=?", get_TrxName())
				.setParameters(getDEX_Job_ID())
				.list();
	}


}
