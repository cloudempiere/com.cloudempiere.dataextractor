package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
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
	        	
	        	for(Column column : getColumns(table)) {
	        		String columnName = column.getName();
	        		
	        		if(!columnSql.equals(""))
	        			columnSql += ",";
	        		
	        		String type = "TEXT";
	        		if(column.getType().equals(MDEXColumn.DATATYPE_Number))
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
				   
				
				ResultSet rs = null;
				try {
				   rs = getData(table.getAD_Client_ID(), table.getAD_Table().getTableName(), table.getWhereClause());
				
					ArrayList<String> values = new ArrayList<String>();
				    while(rs.next()) {
				
				    	ArrayList<String> value = new ArrayList<String>();
				    	for(Column column : getColumns(table)) {
				    		value.add(rs.getString(column.getColumnName()));
				    	}
				    	
				    	values.add("('"+ String.join("','", value) +"')");
						
					}
					
					dataSql += String.join(",", values);
				
					stmt.executeUpdate( dataSql );
				} catch (SQLException ex) {
		            throw new AdempiereException(ex.getMessage());
				}
	        }
		} catch ( SQLException e ) {
            throw new AdempiereException(e.getMessage());
		}
		 
        return temp;
	}

}
