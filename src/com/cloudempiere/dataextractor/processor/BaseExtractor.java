package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.base.annotation.Process;
import org.compiere.model.MColumn;
import org.compiere.model.MTable;
import org.compiere.model.PO;
import org.compiere.model.Query;

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
	
	public List<PO> getData(String tableName, String whereClause){
		Query query = new Query(m_ctx, tableName, whereClause, null);
		
		if(schema.getAD_Client_ID()>0) {
			query.setClient_ID();
		}
		
		return query.list();
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
