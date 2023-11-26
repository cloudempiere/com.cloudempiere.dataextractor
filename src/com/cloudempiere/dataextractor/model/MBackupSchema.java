package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

@org.adempiere.base.Model(table = "AD_BackupSchema")
public class MBackupSchema extends X_AD_BackupSchema {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4949840254864021211L;


	public MBackupSchema(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	

	public MBackupSchema(Properties ctx, int AD_BackupSchema_ID, String trxName) {
		super(ctx, AD_BackupSchema_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MBackupSchemaTable> getTables() {
		return new Query(getCtx(), MBackupSchemaTable.Table_Name, MBackupSchemaTable.COLUMNNAME_AD_BackupSchema_ID+"=?", get_TrxName())
				.setParameters(getAD_BackupSchema_ID())
				.list();
	}


}
