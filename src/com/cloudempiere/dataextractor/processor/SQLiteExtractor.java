package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.util.DB;
import org.sqlite.SQLiteDataSource;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class SQLiteExtractor extends BaseExtractor{

	public File generate() {
		SQLiteDataSource ds = null;
		File temp = null;

        try {
    		temp = File.createTempFile("sqlite_"+schema.getName()+ "_", ".db");
        			
            ds = new SQLiteDataSource();
    		ds.setUrl("jdbc:sqlite:"+temp.getAbsoluteFile());
        
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
	        		columnInsertSql += "`" + columnName + "` ";
	        		
	        		columns.add(columnName);
	        	}
	        	
		        String tableSql = "CREATE TABLE IF NOT EXISTS `"+table.getTableName()+"` ( " +
		        		columnSql +
		                ")";
		        
				Connection conn = ds.getConnection();
				Statement tableStmt = conn.createStatement();
				tableStmt.executeUpdate( tableSql );
				DB.close(tableStmt);   

				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = DB.prepareStatement(getSql(table), null);
					rs = pstmt.executeQuery();
				
				   while(rs.next()) {
						String dataSql = "INSERT INTO `"+table.getTableName()+"` ( "+columnInsertSql+" ) VALUES ";

						List<String> value = new ArrayList<String>();
						List<Column> cols = getColumns(table);
				    	for(int i=0; i<cols.size();i++) {
				    		value.add("?");
				    	}

						dataSql += "("+ String.join(",", value) +")";

						PreparedStatement dataStmt = null;
						try {
							dataStmt = DB.prepareStatement(conn, dataSql);
	
							int i = 1;
					    	for(Column column : cols) {
					    		dataStmt.setString(i++, rs.getString(column.getColumnName()));
					    	}
					    	dataStmt.execute();
						} catch (SQLException ex) {
							log.warning(ex.getLocalizedMessage());
						} finally {
							DB.close(dataStmt);
						}
					}
				} catch (SQLException ex) {
		            throw new AdempiereException(ex.getMessage());
				} finally {
					DB.close(rs, pstmt);
				}
	        }
		} catch ( Exception e ) {
            throw new AdempiereException(e.getMessage());
		}
		 
        return temp;
	}

}
