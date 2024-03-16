package com.cloudempiere.dataextractor.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.pipo2.Zipper;
import org.apache.commons.codec.binary.Hex;
import org.compiere.util.DB;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXJobTable;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class PostgreSQLExtractor extends BaseExtractor{

	@Override
	public File generate() {
		try {
			String fileName = createTmpDirectory().getAbsolutePath() + File.separator + schema.getName() + "_" + schema.getDEX_Schema_ID();
			File folder = new File(fileName);
			if(!folder.exists())
				folder.mkdir();
			
			File file = new File(fileName + File.separator + "backup.sql");

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF8"));
			
			for(MDEXJobTable jobTable : job.getTables()) {
    			if(jobTable.isProcessed())
    				continue;
    			
    			MDEXTable table = (MDEXTable) jobTable.getDEX_Table();
				
				List<Column> columns = getColumns(table);
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					List<String> columnNames = new ArrayList<String>();
					StringBuffer row = new StringBuffer("CREATE TABLE "+table.getTableName()+" (");
					for(int i=0;i<columns.size();i++) {
						Column column = columns.get(i);
						if(i>0)
							row.append(",");
						if(column.getType().equals(MDEXColumn.DATATYPE_Number)) {
							row.append(column.getName() + " numeric(10) NULL");
						}else if(column.getType().equals(MDEXColumn.DATATYPE_Blob)) {
							row.append(column.getName() + " bytea NULL");
						}else
							row.append(column.getName() + " TEXT NULL"); 
						columnNames.add(column.getName());
					}
					row.append(");\n");

					out.write(row.toString());
					
					pstmt = DB.prepareStatement(table.getSql(), null);
					rs = pstmt.executeQuery();
				
				   while(rs.next()) {
					   row = new StringBuffer("INSERT INTO "+table.getTableName()+"("
					   		+ String.join(",", columnNames)
					   		+ ") VALUES(");
						for(int i=0;i<columns.size();i++) {
							Column column = columns.get(i);
							if(i>0)
								row.append(",");
							if(column.getType().equals(MDEXColumn.DATATYPE_Number)) {
								row.append(rs.getInt(column.getColumnName()));
							}else if(column.getType().equals(MDEXColumn.DATATYPE_Blob)) {
							    if(rs.getString(column.getColumnName())!=null) {
									row.append("decode('"+Hex.encodeHexString(rs.getBytes(column.getColumnName()))+"','hex')");
							    }else {
							    	row.append("null");
							    }
								
							}else
								row.append("'"+ rs.getString(column.getColumnName()) + "'");
						}
						row.append(");\n");

						out.write(row.toString());
				   } 
				} catch (SQLException ex) {
		            throw new AdempiereException(ex.getMessage());
				} finally {
					DB.close(rs, pstmt);
				}
				
				jobTable.setProcessed(true);
				jobTable.saveEx();
			}

			out.close();
			
			File zip = new File(fileName + ".zip");
			if(zip.exists())
				zip.delete();
			Zipper.zipFolder(folder, zip, "");
			
			return zip;
		
		}catch(IOException ex) {
			log.info(ex.getMessage());
		}
		
		return null;
	}

	

}
