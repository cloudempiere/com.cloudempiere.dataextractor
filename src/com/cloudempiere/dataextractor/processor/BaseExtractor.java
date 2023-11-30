package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.base.annotation.Process;
import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.util.DB;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXSchema;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class BaseExtractor implements I_Extractor{

	public MDEXSchema schema;
	public Properties m_ctx;
	
	public void setSchema(Properties ctx, int dex_Schema_ID) {
		m_ctx = ctx;
		schema = new MDEXSchema(m_ctx, dex_Schema_ID, null);
	}
	
	public ResultSet getData(int AD_Client_ID, String tableName, String whereClause){
		StringBuilder sql = new StringBuilder()
				.append("SELECT * FROM "+tableName);
		
		
		
		if(AD_Client_ID>0) {
			if(whereClause == null)
				whereClause = " WHERE";
			else
				whereClause += " AND";
				
			whereClause += " AD_Client_ID="+AD_Client_ID;
		}else if(whereClause != null){
			whereClause = " WHERE " + whereClause;
		}
		
		if(whereClause != null)
			sql.append(whereClause);
		
		PreparedStatement pstmt = null;
		try {
			pstmt = DB.prepareStatement(sql.toString(), null);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			return null;
		}
	}
	

	public List<Column> getColumns(MDEXTable table) {
		List<Column> columns = new ArrayList<Column>();
		for(MDEXColumn column : table.getColumns()) {
			columns.add(new Column(column.getColumnName(), column.getAD_Column().getColumnName(), column.getDataType()));
		}
		if(columns.size()>0)
			return columns;
		
		MTable adTable = (MTable) table.getAD_Table();
		for(MColumn column : adTable.getColumns(false)) {
			if(column.isVirtualColumn())
				continue;
			
			columns.add(new Column(column.getColumnName(), column.getColumnName(), "S"));
		}
		
		return columns;
	}

	public File generate() {
		return null;
	}
	
	public class Column {
		private String name = "";
		private String columnName = "";
		private String type = "S";
		
		public Column(String name, String columnName, String type) {
			this.columnName = columnName;
			this.name = name;
			this.type = type;
		}
		
		public String getColumnName() {
			return columnName;
		}
		
		public String getName() {
			return name;
		}

		public String getType() {
			return type;
		}
		
	}

}
