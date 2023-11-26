package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;

@org.adempiere.base.Model(table = "AD_BackupSchema_Table")
public class MBackupSchemaTable extends X_AD_BackupSchema_Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = 160165239259453133L;

	public MBackupSchemaTable(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MBackupSchemaTable(Properties ctx, int AD_BackupSchema_Table_ID, String trxName) {
		super(ctx, AD_BackupSchema_Table_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MBackupSchemaColumn> getColumns() {
		return new Query(getCtx(), MBackupSchemaColumn.Table_Name, MBackupSchemaColumn.COLUMNNAME_AD_BackupSchema_Table_ID+"=?", get_TrxName())
				.setParameters(getAD_BackupSchema_Table_ID())
				.list();
	}


}
