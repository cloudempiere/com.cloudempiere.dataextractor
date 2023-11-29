package com.cloudempiere.dataextractor.process;

import java.io.File;
import org.adempiere.base.annotation.Process;
import org.compiere.process.ProcessInfoParameter;
import org.compiere.process.SvrProcess;
import com.cloudempiere.dataextractor.model.MDEXProcessor;
import com.cloudempiere.dataextractor.processor.BaseExtractor;


@Process
public class Extractor extends SvrProcess {

	private int p_DEX_Schema_ID = 0;
	private int p_DEX_Processor_ID = 0;
	
	@Override
	protected void prepare() {
		ProcessInfoParameter[] paras = getParameter();
		for (ProcessInfoParameter para : paras)
		{
			String name = para.getParameterName();
			if ("DEX_Schema_ID".equals(name))
				p_DEX_Schema_ID = para.getParameterAsInt();
			else if ("DEX_Processor_ID".equals(name))
				p_DEX_Processor_ID = para.getParameterAsInt();
			
		}
	}

	@Override
	protected String doIt() throws Exception {
		MDEXProcessor processor = new MDEXProcessor(getCtx(), p_DEX_Processor_ID, get_TrxName());
		
		try{
			Class<?> eclass = Class.forName(processor.getClassname());
			BaseExtractor extractor = (BaseExtractor) eclass.getDeclaredConstructor().newInstance();
			extractor.setSchema(getCtx(), p_DEX_Schema_ID);
			File file = extractor.generate();
			processUI.download(file);
		}catch(Exception ex) {
			
		}
		
		return null;
	}

}
