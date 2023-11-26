package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

public class MDataBackupLine extends X_AD_Data_BackupLine {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1749276924592581353L;


	public MDataBackupLine(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}
	

	public MDataBackupLine(Properties ctx, int AD_Data_BackupLine_ID, String trxName) {
		super(ctx, AD_Data_BackupLine_ID, trxName);
		// TODO Auto-generated constructor stub
	}


}
