package com.cloudempiere.dataextractor.factory;

import org.adempiere.base.AnnotationBasedColumnCalloutFactory;

public class CalloutFactoryImpl extends AnnotationBasedColumnCalloutFactory {

	@Override
	protected String[] getPackages() {
		return new String[] {"com.cloudempiere.dataextractor.callout"};
	}
}
