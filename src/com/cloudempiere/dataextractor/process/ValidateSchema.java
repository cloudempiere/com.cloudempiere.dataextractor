package com.cloudempiere.dataextractor.process;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.MTable;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import org.compiere.util.DB;

import com.cloudempiere.dataextractor.model.MDEXColumn;
import com.cloudempiere.dataextractor.model.MDEXSchema;
import com.cloudempiere.dataextractor.model.MDEXTable;


@Process
public class ValidateSchema extends SvrProcess {

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
		
		if(schema.getTables().size()==0)
			throw new AdempiereException("No Table Defined");
		
		List<String> tableNames = new ArrayList<String>();
		for(MDEXTable table: schema.getTables()) {
			if(!table.isActive())
				continue;
				
			if(tableNames.contains(table.getTableName())) {
				throw new AdempiereException("Table " + table.getTableName() + " is duplicate");
			}
			
			
			tableNames.add(table.getTableName());
			
			String sql = "EXPLAIN " + table.getSql(true);
			
			MTable adTable = (MTable) table.getAD_Table();
			if(adTable.getColumns(false).length==0){
				throw new AdempiereException("Table " + adTable.getTableName() + ": no defined columns");
			}

			List<String> columnNames = new ArrayList<String>();
			for(MDEXColumn column : table.getColumns()) {
				if(columnNames.contains(column.getColumnName())) {
					throw new AdempiereException("Column " + column.getColumnName() + " is duplicate");
				}
				
				columnNames.add(column.getColumnName());
			}
			
			PreparedStatement pstmt = null;
			try {
				pstmt = DB.prepareStatement(sql, get_TrxName());
				pstmt.execute();
			} catch (SQLException ex) {
				throw new AdempiereException("table "+ table.getTableName() + " : invalid sql="+sql+". "+ex.getMessage());
			}
			
		}
		
		schema.setIsValid(true);
		schema.saveEx();
		
		return "validated";
	}

}
