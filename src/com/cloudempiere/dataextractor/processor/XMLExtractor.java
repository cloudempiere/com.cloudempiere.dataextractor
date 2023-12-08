package com.cloudempiere.dataextractor.processor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.adempiere.pipo2.Zipper;
import org.compiere.tools.FileUtil;
import org.compiere.util.DB;

import com.cloudempiere.dataextractor.model.MDEXJobTable;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class XMLExtractor extends BaseExtractor{

	@Override
	public File generate() {
		String folderName = createTmpDirectory().getAbsolutePath() + File.separator + schema.getName() + "_" + schema.getDEX_Schema_ID();
		File folder = new File(folderName);
		if(!folder.exists())
			folder.mkdir();
		
		try {
			for(MDEXJobTable jobTable : job.getTables()) {
    			if(jobTable.isProcessed())
    				continue;
    			
    			MDEXTable table = (MDEXTable) jobTable.getDEX_Table();
    			
				File file =  new File(folder.getAbsolutePath() + File.separator + table.getTableName() + ".xml");
				StringBuffer xml = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
				xml.append("\n<table name=\"" + table.getTableName() + "\">");

				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF8"));
				out.write(xml.toString());
				
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					pstmt = DB.prepareStatement(table.getSql(), null);
					rs = pstmt.executeQuery();
				
				   while(rs.next()) {
					   StringBuffer row = new StringBuffer("\n<row>");
						for(Column column : getColumns(table)) {
							row.append("\n<column name=\"" + column.getName() + "\">" + rs.getString(column.getColumnName()) + "</column>");
						}
						row.append("\n</row>");

						out.write(row.toString());
				   } 
				} catch (SQLException ex) {
		            throw new AdempiereException(ex.getMessage());
				} finally {
					DB.close(rs, pstmt);
				}
				out.write("\n</table>");
				out.close();
				
				jobTable.setProcessed(true);
				jobTable.saveEx();
			}
			
			File zip = new File(folderName + ".zip");
			Zipper.zipFolder(folder, zip, "*");
			FileUtil.deleteFolderRecursive(folder);
			
			return zip;
		
		}catch(IOException ex) {
			log.info(ex.getMessage());
		}
		
		return null;
	}

	

}
