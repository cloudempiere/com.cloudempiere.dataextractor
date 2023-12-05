package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.Properties;

import org.compiere.model.Query;

@org.adempiere.base.Model(table = "DEX_Job_Table")
public class MDEXJobTable extends X_DEX_Job_Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3752527414112932716L;

	public MDEXJobTable(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
	}

	public MDEXJobTable(Properties ctx, int DEX_Job_Table_ID, String trxName) {
		super(ctx, DEX_Job_Table_ID, trxName);
	}

	public MDEXJobTable(MDEXJob job) {
		super(job.getCtx(), 0, job.get_TrxName());
		setDEX_Job_ID(job.getDEX_Job_ID());
	}

	public static MDEXJobTable checkTable(MDEXJob job, MDEXTable table) {
		MDEXJobTable jobTable = new Query(table.getCtx(), MDEXJobTable.Table_Name, "DEX_Job_ID=? AND DEX_Table_ID=?", table.get_TrxName())
				.setParameters(job.getDEX_Job_ID(), table.getDEX_Table_ID())
				.first();
		
		if(jobTable==null) {
			jobTable = new MDEXJobTable(job);
			jobTable.setDEX_Table_ID(table.getDEX_Table_ID());
		}
		jobTable.setTotalRows(table.getTotalRows());
		jobTable.saveEx();
		
		return jobTable;
	}


}
