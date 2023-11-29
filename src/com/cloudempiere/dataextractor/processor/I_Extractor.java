package com.cloudempiere.dataextractor.processor;

import java.io.File;
import java.util.Properties;

public interface I_Extractor {

	public void setSchema(Properties ctx, int schema);
	
	public File generate();
	
	
}
