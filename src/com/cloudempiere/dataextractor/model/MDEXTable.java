package com.cloudempiere.dataextractor.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.adempiere.exceptions.AdempiereException;
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
	
	protected boolean beforeSave(boolean newRecord)
	{
		if(getColumns().size()>0)
			throw new AdempiereException("Columns already defined, please delete first");
		
		return true;
	}

	protected boolean afterSave (boolean newRecord, boolean success) {
		MDEXSchema schema = (MDEXSchema) getDEX_Schema();
		schema.setIsValid(false);
		schema.saveEx();
		
		return success;
	}
	
	public String getSql(){
		return getSql(false);
	}
	
	public String getSql(boolean count){
		StringBuilder sql = new StringBuilder()
		.append("SELECT");
		
		if(count)
			sql.append(" count(1) as total");
		else
			sql.append(" * ");
			
		sql.append(" FROM "+this.getAD_Table().getTableName());
		
		String whereClause = this.getWhereClause();
		if(this.getAD_Client_ID()>0) {
			whereClause += " AND AD_Client_ID="+this.getAD_Client_ID();
		}
		
		if(whereClause != null)
			sql.append(" WHERE " + whereClause);
		
		if(this.getOrderByClause()!=null)
			sql.append(" ORDER BY "+this.getOrderByClause());
		
		if(this.getLimitData()>0)
			sql.append(" LIMIT "+this.getLimitData());
		
		return sql.toString();
	}

	public int getTotalRows() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstmt = DB.prepareStatement(getSql(), get_TrxName());
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt("total");
		}catch(SQLException ex) {
			log.warning("failed count "+ex.getMessage());
		}
		
		return count;
	}


}
