package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.PO;
import org.sqlite.SQLiteDataSource;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class SQLiteExtractor extends BaseExtractor{

	public File generate() {
		SQLiteDataSource ds = null;
		File temp = null;

        try {
        	temp = File.createTempFile("sqlite_"+schema.getName()+"_", ".db");
        			
            ds = new SQLiteDataSource();
    		ds.setUrl("jdbc:sqlite:"+temp.getAbsoluteFile());
        } catch ( Exception e ) {
            return null;
        }

        try {
        
	        for(MDEXTable table : schema.getTables()) {
	        	String columnSql = "";
	        	String columnInsertSql = "";
	        	ArrayList<String> columns = new ArrayList<String>();
	        	
	        	for(MDEXColumn column : table.getColumns()) {
	        		String columnName = column.getColumnName();
	        		
	        		if(!columnSql.equals(""))
	        			columnSql += ",";
	        		
	        		String type = "TEXT";
	        		if(column.getDataType().equals(MDEXColumn.DATATYPE_Number))
	        			type = "NUMERIC";
	        		
	        		columnSql += "`" + columnName + "` " + type + " NULL";
	
	        		if(!columnInsertSql.equals(""))
	        			columnInsertSql += ",";
	        		columnInsertSql += columnName;
	        		
	        		columns.add(columnName);
	        	}
	        	
		        String tableSql = "CREATE TABLE IF NOT EXISTS `"+table.getTableName()+"` ( " +
		        		columnSql +
		                ")";
		        
				String dataSql = "INSERT INTO `"+table.getTableName()+"` ( "+columnInsertSql+" ) VALUES ";
		
				Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				stmt.executeUpdate( tableSql );
				   
			   List<PO> list = getData(table.getAD_Table().getTableName(), table.getWhereClause());
			
				ArrayList<String> values = new ArrayList<String>();
			    for(PO data : list) {
			
			    	ArrayList<String> value = new ArrayList<String>();
			    	for(MDEXColumn column : table.getColumns()) {
			    		value.add(data.get_ValueAsString(column.getAD_Column().getColumnName()));
			    	}
			    	
			    	values.add("('"+ String.join("','", value) +"')");
					
				}
				
				dataSql += String.join(",", values);
			
			   stmt.executeUpdate( dataSql );
	        }
		} catch ( SQLException e ) {
            throw new AdempiereException(e.getMessage());
		}
		 
        return temp;
	}

}
