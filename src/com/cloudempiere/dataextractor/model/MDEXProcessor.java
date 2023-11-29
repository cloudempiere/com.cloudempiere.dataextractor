package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

@org.adempiere.base.Model(table = "DEX_Processor")
public class MDEXProcessor extends X_DEX_Processor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1050790144674225753L;

	public MDEXProcessor(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDEXProcessor(Properties ctx, int DEX_Processor_ID, String trxName) {
		super(ctx, DEX_Processor_ID, trxName);
		// TODO Auto-generated constructor stub
	}


}
