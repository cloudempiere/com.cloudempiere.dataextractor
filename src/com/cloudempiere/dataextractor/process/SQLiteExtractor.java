package com.cloudempiere.dataextractor.process;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.PO;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.sqlite.SQLiteDataSource;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXSchema;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class SQLiteExtractor extends SvrProcess {

	private int p_DEX_Schema_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter para : paras)
		{
			String name = para.getParameterName();
			if ("DEX_Schema_ID".equals(name))
				p_DEX_Schema_ID = para.getParameterAsInt();
			
		}
	}

	@Override
	protected String doIt() throws Exception {
		MDEXSchema schema = new MDEXSchema(getCtx(), p_DEX_Schema_ID, get_TrxName());
		
		SQLiteDataSource ds = null;
		File temp = null;

        try {
        	temp = File.createTempFile("sqlite_"+schema.getName()+"_", ".db");
        			
            ds = new SQLiteDataSource();
    		ds.setUrl("jdbc:sqlite:"+temp.getAbsoluteFile());
        } catch ( Exception e ) {
            return e.getMessage();
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
				   
			   List<PO> list = new Query(getCtx(), table.getAD_Table().getTableName(), table.getWhereClause(), get_TrxName())
					   .list();
			
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

		processUI.download(temp);
        
		 
        return "success";
	}

}
