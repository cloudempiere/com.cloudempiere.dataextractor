package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.util.Properties;

import org.adempiere.base.annotation.Process;
import com.cloudempiere.dataextractor.model.MDEXSchema;


@Process
public class BaseExtractor implements I_Extractor{

	public MDEXSchema schema;
	public Properties m_ctx;
	
	public void setSchema(Properties ctx, int dex_Schema_ID) {
		m_ctx = ctx;
		schema = new MDEXSchema(m_ctx, dex_Schema_ID, null);
	}

	public File generate() {
		return null;
	}

}
