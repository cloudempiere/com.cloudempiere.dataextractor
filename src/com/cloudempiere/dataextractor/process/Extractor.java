package com.cloudempiere.dataextractor.process;

import java.io.File;
import java.sql.Timestamp;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.model.Query;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;

import com.cloudempiere.dataextractor.model.MDEXJob;
import com.cloudempiere.dataextractor.model.MDEXJobTable;
import com.cloudempiere.dataextractor.model.MDEXProcessor;
import com.cloudempiere.dataextractor.model.MDEXSchema;
import com.cloudempiere.dataextractor.model.MDEXTable;
import com.cloudempiere.dataextractor.processor.BaseExtractor;


@Process
public class Extractor extends SvrProcess {

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
		
		MDEXSchema schema =new MDEXSchema(getCtx(), p_DEX_Schema_ID, get_TrxName());

		if(!schema.isValid())
			throw new AdempiereException("Schema "+schema.getName() + " is not valid, validate it first");

		if(schema.getDEX_Processor_ID()==0)
			throw new AdempiereException("No processor defined for Schema "+schema.getName());
		
		MDEXJob job = new Query(getCtx(), MDEXJob.Table_Name, "DEX_Schema_ID=? AND DEX_Status IN('N','P')", get_TrxName())
				.setParameters(schema.getDEX_Schema_ID())
				.first();
		
		if(job==null) {
			job = new MDEXJob(getCtx(), 0, get_TrxName());
			job.setDEX_Schema_ID(schema.getDEX_Schema_ID());
			job.setStartTime(new Timestamp(System.currentTimeMillis()));
			job.saveEx();
			commitEx();
		}
		
		if(job.getDEX_Status().equals(MDEXJob.DEX_STATUS_Done)) {
			File file = new File(job.getLinkURL());
			if(file.exists())
				processUI.download(file);	
			return "already generated";
		}
		
		for(MDEXTable table : schema.getTables()) {
			if(!table.isActive())
				continue;
			
			MDEXJobTable.checkTable(job, table);
		}
		
		MDEXProcessor processor = (MDEXProcessor) schema.getDEX_Processor();
		
		try{
			Class<?> eclass = Class.forName(processor.getClassname());
			BaseExtractor extractor = (BaseExtractor) eclass.getDeclaredConstructor().newInstance();
			extractor.setJob(job);
			File file = extractor.generate();
			job.setLinkURL(file.getAbsolutePath());
			job.setFileName(file.getName());
			job.setDEX_Status(MDEXJob.DEX_STATUS_Done);
			job.saveEx();
			
			processUI.download(file);
		}catch(Exception ex) {
			throw new AdempiereException(ex.getMessage());
		}
		
		return "success";
	}

}
