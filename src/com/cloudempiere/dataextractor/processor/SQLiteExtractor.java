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
import com.cloudempiere.dataextractor.model.MDEXJobTable;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class SQLiteExtractor extends BaseExtractor{
	
	public String last_sql = null;

	public File generate() {
		SQLiteDataSource ds = null;
		File temp = null;

        try {
    		temp = new File(createTmpDirectory().getAbsolutePath() + File.separator + "sqlite_"+schema.getName()+ "_" + job.getDEX_Job_ID() + ".db");
        	job.setLinkURL(temp.getAbsolutePath());
        	
            ds = new SQLiteDataSource();
    		ds.setUrl("jdbc:sqlite:"+temp.getAbsoluteFile());
			Connection conn = ds.getConnection();
        
	    
    		for(MDEXJobTable jobTable : job.getTables()) {
    			if(jobTable.isProcessed())
    				continue;
    			
    			MDEXTable table = (MDEXTable) jobTable.getDEX_Table();
    			
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
	        		else if(column.getType().equals(MDEXColumn.DATATYPE_Blob))
		        			type = "BLOB";
	        		
	        		columnSql += "`" + columnName + "` " + type + " NULL";
	
	        		if(!columnInsertSql.equals(""))
	        			columnInsertSql += ",";
	        		columnInsertSql += "`" + columnName + "` ";
	        		
	        		columns.add(columnName);
	        	}
	        	
		        String tableSql = "CREATE TABLE IF NOT EXISTS `"+table.getTableName()+"` ( " +
		        		columnSql +
		                ")";
		        last_sql = tableSql;
		        
				Statement tableStmt = conn.createStatement();
				tableStmt.executeUpdate( tableSql );
				DB.close(tableStmt);   
			
    			String countSql = "SELECT count(1) as total FROM `"+table.getTableName() + "`";
    			last_sql = countSql;
    			
				Statement countStmt = conn.createStatement();
    			ResultSet countRs = countStmt.executeQuery(countSql);
    			int totalRow = 0;
    			if(countRs.next())
    				totalRow = countRs.getInt("total");
    			
    			DB.close(countRs, countStmt);
    			
    			if(jobTable.getTotalRows()==totalRow) {
    				jobTable.setProcessed(true);
    				jobTable.saveEx();
    				continue;
    			}else if(totalRow>0) {
    				String dropSql = "DELETE FROM `"+table.getTableName() + "`";
    				last_sql = dropSql;
    				Statement dropStmt = conn.createStatement();
    				dropStmt.executeUpdate(dropSql);
        			DB.close(dropStmt);
    			}

				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = DB.prepareStatement(table.getSql(), null);
					rs = pstmt.executeQuery();
				
				   while(rs.next()) {
						String dataSql = "INSERT INTO `"+table.getTableName()+"` ( "+columnInsertSql+" ) VALUES ";

						List<String> value = new ArrayList<String>();
						List<Column> cols = getColumns(table);
				    	for(int i=0; i<cols.size();i++) {
				    		value.add("?");
				    	}

						dataSql += "("+ String.join(",", value) +")";
						last_sql = dataSql;

						PreparedStatement dataStmt = null;
						try {
							dataStmt = DB.prepareStatement(conn, dataSql);
	
							int i = 1;
					    	for(Column column : cols) {
					    		if(column.getType().equals(MDEXColumn.DATATYPE_Number))
						    		dataStmt.setDouble(i++, rs.getDouble(column.getColumnName()));
					    		else if(column.getType().equals(MDEXColumn.DATATYPE_Blob))
						    		dataStmt.setBytes(i++, rs.getBytes(column.getColumnName()));
					    		else
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

				jobTable.setProcessed(true);
				jobTable.saveEx();
	        }
		} catch ( Exception e ) {
            throw new AdempiereException(e.getMessage() + " sql="+last_sql);
		}
		 
        return temp;
	}
}
