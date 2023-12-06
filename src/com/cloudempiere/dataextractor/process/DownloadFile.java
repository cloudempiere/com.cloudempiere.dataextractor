package com.cloudempiere.dataextractor.process;

import java.io.File;
import org.adempiere.base.annotation.Process;
import org.adempiere.exceptions.AdempiereException;
import org.compiere.process.SvrProcess;
import com.cloudempiere.dataextractor.model.MDEXJob;


@Process
public class DownloadFile extends SvrProcess {
	
	@Override
	protected void prepare() {
		//
	}

	@Override
	protected String doIt() throws Exception {
		MDEXJob job = new MDEXJob(getCtx(), getRecord_ID(), get_TrxName());
		
		if(!job.getDEX_Status().equals(MDEXJob.DEX_STATUS_Done))
			throw new AdempiereException("Job is not done yet");
		
		File file = new File(job.getLinkURL());
		if(!file.exists())
			throw new AdempiereException("Extracted file doesnt exists");
		
		processUI.download(file);
		
		return "done";
	}

}
