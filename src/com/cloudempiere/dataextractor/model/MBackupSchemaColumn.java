package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "AD_BackupSchema_Column")
public class MBackupSchemaColumn extends X_AD_BackupSchema_Column {

	/**
	 * 
	 */
	private static final long serialVersionUID = 160165239259453133L;

	public MBackupSchemaColumn(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MBackupSchemaColumn(Properties ctx, int AD_BackupSchema_Column_ID, String trxName) {
		super(ctx, AD_BackupSchema_Column_ID, trxName);
		// TODO Auto-generated constructor stub
	}

	protected boolean beforeSave(boolean newRecord) {
		if(newRecord) {
			setColumnName(getAD_Column().getColumnName());
		}
		
		return true;
	}


}
