package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.compiere.model.Query;
import org.compiere.util.DB;

@org.adempiere.base.Model(table = "DEX_Table")
public class MDEXTable extends X_DEX_Table {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4012249756312396467L;

	public MDEXTable(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDEXTable(Properties ctx, int DEX_Table_ID, String trxName) {
		super(ctx, DEX_Table_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MDEXColumn> getColumns() {
		return new Query(getCtx(), MDEXColumn.Table_Name, MDEXColumn.COLUMNNAME_DEX_Table_ID+"=?", get_TrxName())
				.setParameters(getDEX_Table_ID())
				.list();
	}

	public int getTotalRows() {
		String sql = "SELECT COUNT(1) FROM "+getAD_Table().getTableName();
		if(getLimitData()>0)
			sql += " LIMIT "+getLimitData();
		
		return DB.getSQLValue(get_TrxName(), sql);
	}


}
