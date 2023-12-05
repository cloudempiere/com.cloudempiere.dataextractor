package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "DEX_Column")
public class MDEXColumn extends X_DEX_Column {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5849351981470632397L;

	public MDEXColumn(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDEXColumn(Properties ctx, int DEX_Column_ID, String trxName) {
		super(ctx, DEX_Column_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	protected boolean afterSave (boolean newRecord, boolean success) {
		MDEXSchema schema = (MDEXSchema) getDEX_Table().getDEX_Schema();
		schema.setIsValid(false);
		schema.saveEx();
		
		return success;
	}


}
