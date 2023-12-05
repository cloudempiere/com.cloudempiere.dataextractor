package com.cloudempiere.dataextractor.process;

import java.io.File;
import java.sql.Timestamp;

import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
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

	private int p_DEX_Job_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter para : paras)
		{
			String name = para.getParameterName();
			if ("DEX_Job_ID".equals(name))
				p_DEX_Job_ID = para.getParameterAsInt();
			
		}
	}

	@Override
	protected String doIt() throws Exception {
		
		MDEXJob job =new MDEXJob(getCtx(), p_DEX_Job_ID, get_TrxName());
		
		if(job.getDEX_Status().equals(MDEXJob.DEX_STATUS_Done)) {
			File file = new File(job.getLinkURL());
			if(file.exists())
				processUI.download(file);	
			return "already generated";
		}
		
		if(job.getStartTime()==null)
			job.setStartTime(new Timestamp(System.currentTimeMillis()));
		
		MDEXSchema schema = (MDEXSchema) job.getDEX_Schema();
		if(!schema.isValid())
			throw new AdempiereException("Schema "+schema.getName() + " is not valid, validate it first");

		for(MDEXTable table : schema.getTables()) {
			if(!table.isActive())
				continue;
			
			MDEXJobTable.checkTable(job, table);
		}
		
		if(schema.getDEX_Processor_ID()==0)
			throw new AdempiereException("No processor defined for Schema "+schema.getName());
			
		MDEXProcessor processor = (MDEXProcessor) schema.getDEX_Processor();
		
		try{
			Class<?> eclass = Class.forName(processor.getClassname());
			BaseExtractor extractor = (BaseExtractor) eclass.getDeclaredConstructor().newInstance();
			extractor.setJob(job);
			File file = extractor.generate();
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
