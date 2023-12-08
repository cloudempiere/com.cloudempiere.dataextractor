package com.cloudempiere.dataextractor.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.util.DB;

@org.adempiere.base.Model(table = "DEX_Schema")
public class MDEXSchema extends X_DEX_Schema {

	/**
	 * 
	 */
	private static final long serialVersionUID = 397576519688850168L;

	public MDEXSchema(Properties ctx, ResultSet rs, String trxName) {
		super(ctx, rs, trxName);
		// TODO Auto-generated constructor stub
	}

	public MDEXSchema(Properties ctx, int DEX_Schema_ID, String trxName) {
		super(ctx, DEX_Schema_ID, trxName);
		// TODO Auto-generated constructor stub
	}
	
	public List<MDEXTable> getTables() {
		return new Query(getCtx(), MDEXTable.Table_Name, MDEXTable.COLUMNNAME_DEX_Schema_ID+"=?", get_TrxName())
				.setParameters(getDEX_Schema_ID())
				.list();
	}
	
	protected boolean beforeSave(boolean newRecord)
	{
		int count = DB.getSQLValue(get_TrxName(), "SELECT count(1) from DEX_Schema WHERE AD_Client_ID=? AND value=? AND DEX_Schema_ID<>?", getAD_Client_ID(), getValue(), getDEX_Schema_ID());
		if(count>0)
			throw new AdempiereException("Schema Search Key " + getValue() + " already exists");
		
		count = DB.getSQLValue(get_TrxName(), "SELECT count(1) from DEX_Schema WHERE AD_Client_ID=? AND name=? AND DEX_Schema_ID<>?", getAD_Client_ID(), getName(), getDEX_Schema_ID());
		if(count>0)
			throw new AdempiereException("Schema Name " + getName() + " already exists");
		
		return true;
	}

	

}
