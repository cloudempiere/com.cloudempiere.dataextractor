package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MDataBackup extends X_AD_Data_Backup {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3100942028372971355L;


	public MDataBackup(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	

	public MDataBackup(Properties ctx, int AD_Data_Backup_ID, String trxName) {
		super(ctx, AD_Data_Backup_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public MDataBackupLine[] getLines(String requery) {
		return null;
	}


}
