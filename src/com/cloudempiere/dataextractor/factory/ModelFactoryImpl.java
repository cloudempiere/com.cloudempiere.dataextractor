package com.cloudempiere.dataextractor.factory;

import org.adempiere.base.AnnotationBasedModelFactory;
import org.adempiere.base.IModelFactory;
import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author zuhriutama
 *
 */
@Component(immediate = true, service = IModelFactory.class, property = {"service.ranking:Integer=1"})
public class ModelFactoryImpl extends AnnotationBasedModelFactory {

	@Override
	protected String[] getPackages() {
		return new String[] {"com.cloudempiere.dataextractor.model"};
	}
	
}
