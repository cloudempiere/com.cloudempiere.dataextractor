package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MColumn;
import org.compiere.model.MSysConfig;
import org.compiere.model.MTable;
import org.compiere.util.CLogger;
import org.compiere.util.DisplayType;
import org.compiere.util.Ini;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXJob;
import com.cloudempiere.dataextractor.model.MDEXSchema;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class BaseExtractor implements I_Extractor{

	public MDEXSchema schema;
	public MDEXJob job;
	public Properties m_ctx;
	protected CLogger log = CLogger.getCLogger (getClass());
	
	public void setSchema(Properties ctx, int dex_Schema_ID) {
		m_ctx = ctx;
		schema = new MDEXSchema(m_ctx, dex_Schema_ID, null);
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
			
			String type = MDEXColumn.DATATYPE_String;
			if(DisplayType.isID(column.getAD_Reference_ID()) || DisplayType.isNumeric(column.getAD_Reference_ID()))
				type = MDEXColumn.DATATYPE_Number;
			
			columns.add(new Column(column.getColumnName(), column.getColumnName(), type));
		}
		
		return columns;
	}
	
	public File createTmpDirectory(){
		//

		String path = MSysConfig.getValue("BACKUPDATA_PATH", Ini.getAdempiereHome()+ File.separator + "backups", job.getAD_Client_ID(), job.getAD_Org_ID());
		
		File dir = new File(path);
		dir.mkdir();
		dir.setWritable(true, false);
		
		if(!dir.exists())
			throw new AdempiereException("Failed to create directory for Data Backup");
		
		return dir;
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

	public void setJob(MDEXJob job) {
		this.job = job;
		this.schema = (MDEXSchema) job.getDEX_Schema();
	}

}
